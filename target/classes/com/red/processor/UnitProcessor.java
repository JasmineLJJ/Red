package com.red.processor;

import com.mysql.jdbc.StringUtils;
import com.red.common.CSVContentUtils;
import com.red.common.RemoteConnection;
import com.red.domain.entity.UnitDO;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Liujunjie on 2018/11/28.
 */
public class UnitProcessor {
    private final static String AMP_ENCODED = "&amp;";
    private final static String AMP = "&";
    private RemoteConnection remoteConnection;

    public void crawlOpenUnitsFromZipcode() throws IOException {
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
}
