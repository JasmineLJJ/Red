package com.red.domain;

/**
 * Created by Liujunjie on 11/2/18.
 */
public enum County {
    SUNNYVALE("SUNNYVALE"),
    SANTA_CLARA("SANTA CLARA"),
    SAN_JOSE("SAN JOSE"),
    MOUNTAIN_VIEW("MOUNTAIN VIEW"),
    MILPITAS("MILPITAS"),
    STANDFORD("STANDFORD"),
    PALO_ALTO("PALO ALTO"),
    CUPERTINO("CUPERTINO");

    private String cityName;

    County(String cityName) {
        this.cityName = cityName;
    }

    public String toString() {
        return name();
    }

    public static County getCityFromName(String cityName) {
        County[] types = values();
        for (County city : types) {
            if (city.cityName.toLowerCase().equals(cityName.toLowerCase())) {
                return city;
            }
        }
        return null;
    }
}
