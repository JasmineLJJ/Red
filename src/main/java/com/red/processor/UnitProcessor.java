package com.red.processor;

import com.mysql.jdbc.StringUtils;
import com.red.common.CSVContentUtils;
import com.red.common.RemoteConnection;
import com.red.domain.County;
import com.red.domain.SchoolLevel;
import com.red.domain.TradingStatus;
import com.red.domain.entity.SchoolDO;
import com.red.domain.entity.TradingHistoryDO;
import com.red.domain.entity.UnitDO;
import com.red.service.CrawlingHistoryService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Liujunjie on 2018/11/28.
 */
public class UnitProcessor {
    private final static String AMP_ENCODED = "&amp;";
    private final static String AMP = "&";
    private RemoteConnection remoteConnection;
    private boolean getDetailedUnitInformation = true;
    private CrawlingHistoryService crawlingHistoryService;

    public void crawlOpenUnitsFromZipcode() throws IOException {
//        crawlingHistoryService.getCrawlingHistorySequenceValue();

        Zipcode[] zipcodes = Zipcode.values();
        for (Zipcode zipcode : zipcodes) {
            String path = remoteConnection.fetchCSVFilePathFromZipcode(zipcode.getZipcode());
            if (StringUtils.isEmptyOrWhitespaceOnly(path)) {
                System.err.println("ERROR: no csv file for zipcode: " + zipcode.getZipcode());
            }
            String cSVContent = remoteConnection.fetchCSVFileFromURL(path.replaceAll(AMP_ENCODED, AMP));
            List<String[]> csvLists = CSVContentUtils.parseCSVContent(cSVContent);
            String[] header = csvLists.remove(0);
            List<UnitDO> unitDOs = convertToUnitObject(csvLists, header);
            if (getDetailedUnitInformation) {
                getDetailedInformation(unitDOs);
            }
        }
    }

    public void getDetailedInformation(List<UnitDO> unitDOs) {
        for (UnitDO unit : unitDOs) {
            try {
                Document doc = Jsoup.connect(unit.getRedUrl()).get();

                // Unit basic info.
                UnitDO unitDO = new UnitDO();

                Elements keyDetails = doc.getElementsByClass("keyDetail font-size-base");
                for (Element keyDetail : keyDetails) {
                    // Community and Property Type can be parsed, too.
                    String title = keyDetail.children().first().text();
                    String content = keyDetail.children().get(1).text();
                    if (title.contains("HOA Dues")) {
                        unitDO.setHOA(parseMoneyStringToInteger(content));
                    } else if (title.contains("County")) {
                        unitDO.setCounty(County.getCityFromName(content));
                    } else if (title.contains("MLS")) {
                        unitDO.setMLS(content);
                    } else if (title.contains("Built")) {
                        unitDO.setYearBuilt(Integer.parseInt(content));
                    } else if (title.contains("Lot Size")) {
                        unitDO.setLotSize(Integer.valueOf(content.split(" ")[0]));
                    }
                }

                // Get estimatedPrice.
                String estimatedPrice = doc.select("span:contains(Redfin Estimate:)").first().text();
                unitDO.setEstimatedPrice(parseMoneyStringToInteger(estimatedPrice));

                // Get schools.
                Elements schools = doc.getElementsByClass("schools-table-row");
                for (Element schoolData : schools) {
                    if (!schoolData.hasAttr("data-rf-test-name")) {
                        continue;
                    }
                    SchoolDO schoolDO = new SchoolDO();
                    String schoolName = schoolData.child(0).child(0).child(0).text();
                    String schoolMeta = schoolData.child(0).child(0).child(1).text();
                    Float greatSchoolRating = 1.0f * Integer.parseInt(
                            schoolData.child(0).child(0).child(2).text().split(":")[1].substring(1).split("/")[0]);
                    Float parentRating = 0f;
                    for (Element star : schoolData.child(0).child(0).child(3).children()) {
                        if (!star.hasClass("empty")) {
                            parentRating += 2.0f;
                        }
                    }
                    schoolDO.setSchoolName(schoolName);
                    schoolDO.setLevel(SchoolLevel.parseFromMeta(schoolMeta));
                    schoolDO.setGreatSchoolRating(greatSchoolRating);
                    schoolDO.setParentRating(parentRating);
                    unitDO.addSchool(schoolDO);
                }

                // Get trading histories.
                Element histories = doc.getElementById("property-history-transition-node")
                        .child(0).child(0).child(0).child(0).child(0).child(1);
                for (Element history : histories.children()) {
                    Elements historyElements = history.children();
                    TradingHistoryDO tradingHistory = new TradingHistoryDO();
                    try {
                        tradingHistory.setCreatedDate(new SimpleDateFormat("MMM dd,yyyy").parse(historyElements.get(0).text()));
                    } catch (ParseException e) {
                        System.out.println("cannot parse date: " + historyElements.get(0).text());
                    }
                    tradingHistory.setStatus(TradingStatus.of(historyElements.get(1).child(0).text()));
                    String potentialMSL = historyElements.get(1).child(2).child(0).text();
                    int indexMS = potentialMSL.indexOf("#ML");
                    if (indexMS >= 0) {
                        tradingHistory.setMSL(potentialMSL.substring(indexMS));
                    }
                    tradingHistory.setPrice(parseMoneyStringToInteger(historyElements.get(2).text()));
                    unitDO.addTradingHistory(tradingHistory);
                }

                System.out.println(unitDO.debugString());

            } catch (IOException e) {
                System.out.println("Xiaoguang Test Log: Jsoup fetch failed.");
            }
        }
    }

    private List<UnitDO> convertToUnitObject(List<String[]> csvList, String[] header) {
        List<UnitDO> list = new LinkedList<UnitDO>();
        if (csvList == null) {
            return list;
        }
        for (String[] columns : csvList) {
            list.add(CSVContentUtils.populateUnitDO(columns, header));
        }
        return list;
    }

    public void setRemoteConnection(RemoteConnection remoteConnection) {
        this.remoteConnection = remoteConnection;
    }

    public CrawlingHistoryService getCrawlingHistoryService() {
        return crawlingHistoryService;
    }

    public void setCrawlingHistoryService(CrawlingHistoryService crawlingHistoryService) {
        this.crawlingHistoryService = crawlingHistoryService;
    }

    public Integer parseMoneyStringToInteger(String money) {
        return Integer.valueOf(money.replaceAll("[^\\d.]+", ""));
    }
}
