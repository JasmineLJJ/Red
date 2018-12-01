package com.red.common;

import com.red.domain.County;
import com.red.domain.PropertyType;
import com.red.domain.State;
import com.red.domain.entity.UnitDO;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Liujunjie on 2018/11/28.
 */
public class CSVContentUtils {
    private static final String NEW_LINE = "\n";
    private static final String COMMA = ",";

    private static final String PROPERTY_TYPE = "PROPERTY TYPE";
    private static final String ADDRESS = "ADDRESS";
    private static final String CITY = "CITY";
    private static final String STATE = "STATE";
    private static final String ZIP = "ZIP";
    private static final String PRICE = "PRICE";
    private static final String BEDS = "BEDS";
    private static final String BATHS = "BATHS";
    private static final String SQUARE_FEET = "SQUARE FEET";
    private static final String LOT_SIZE = "LOT SIZE";
    private static final String YEAR_BUILT = "YEAR BUILT";
    private static final String DAYS_ON_MARKET = "DAYS ON MARKET";
    private static final String PRICE_SQUARE_FEET = "$/SQUARE FEET";
    private static final String HOA_PER_MONTH = "$/SQUARE FEET";
    private static final String URL= "URL (SEE http://www.redfin.com/buy-a-home/comparative-market-analysis FOR INFO ON PRICING)";
    private static final String MLS = "MLS#";
    private static final String LATITUDE = "LATITUDE";
    private static final String LONGITUDE = "LONGITUDE";

    public static UnitDO populateUnitDO(String[] content, String[] header) {
        UnitDO unitDO = new UnitDO();
        for (int i = 0; i < header.length; i++) {
            if (content[i] == null || content[i].length() == 0) {
                continue;
            }
            if (PROPERTY_TYPE.equals(header[i])) {
                unitDO.setPropertyType(PropertyType.getPropertyTypeFromName(content[i]));
            } else if (ADDRESS.equals(header[i])) {
                unitDO.setAddress(content[i]);
//                String[] address = content[i].split(" ");
//                unitDO.setStreetNumber(Integer.parseInt(address[0]));
//                unitDO.setStreet(address[1]);
//                if (address.length > 2 && address[2].charAt(0) == '#') {
//                    unitDO.setUnitNumber(Integer.parseInt(address[2].substring(1)));
//                }
            } else if (CITY.equals(header[i])) {
                unitDO.setCounty(County.getCityFromName(content[i]));
            } else if (STATE.equals(header[i])) {
                unitDO.setState(State.CA);
            } else if (ZIP.equals(header[i])) {
                unitDO.setZipcode(content[i]);
            } else if (PRICE.equals(header[i])) {
                unitDO.setLatestListingPrice(Integer.parseInt(content[i]));
            } else if (BEDS.equals(header[i])) {
                unitDO.setBeds(Integer.parseInt(content[i]));
            } else if (BATHS.equals(header[i])) {
                unitDO.setBath(Float.parseFloat(content[i]));
            } else if (SQUARE_FEET.equals(header[i])) {
                unitDO.setFinishedSize(Integer.parseInt(content[i]));
            } else if (LOT_SIZE.equals(header[i])) {
                unitDO.setLotSize(Integer.parseInt(content[i]));
            } else if (YEAR_BUILT.equals(header[i])) {
                unitDO.setYearBuilt(Integer.parseInt(content[i]));
            } else if (DAYS_ON_MARKET.equals(header[i])) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.add(Calendar.DATE, -1 * Integer.parseInt(content[i]));
                unitDO.setUnitCreatedDate(cal.getTime());
            } else if (PRICE_SQUARE_FEET.equals(header[i])) {
                unitDO.setPricePerSF(Integer.parseInt(content[i]));
            } else if (HOA_PER_MONTH.equals(header[i])) {
                unitDO.setHOA(Integer.parseInt(content[i]));
            } else if (URL.equals(header[i])) {
                unitDO.setRedUrl(content[i]);
            } else if (MLS.equals(header[i])) {
                unitDO.setMLS(content[i]);
            } else if (LONGITUDE.equals(header[i])) {
                unitDO.setLongitude(new BigDecimal(content[i]));
            } else if (LATITUDE.equals(header[i])) {
                unitDO.setLatitude(new BigDecimal(content[i]));
            }
        }
        return unitDO;
    }

    public static List<String[]> parseCSVContent (String content) {
        List<String[]> list = new LinkedList<String[]>();
        String[] rows = content.split(NEW_LINE);
        if (rows == null) {
            return list;
        }
        for (int i = 0; i < rows.length; i++) {
            list.add(rows[i].split(COMMA));
        }
        return list;
    }


}
