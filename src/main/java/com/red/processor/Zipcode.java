package com.red.processor;

import com.red.domain.County;
import com.red.domain.State;

/**
 * Created by Liujunjie on 2018/11/4.
 */
public enum Zipcode {
    STANDFORD94305("94305", County.STANDFORD, State.CA),
    PALOALTO94304("94304", County.PALO_ALTO, State.CA),
    PALOALTO94301("94301", County.PALO_ALTO, State.CA),
    PALOALTO94303("94303", County.PALO_ALTO, State.CA),
    PALOALTO94306("94306", County.PALO_ALTO, State.CA),
    MOUNTAINVIEW94035("94035", County.MOUNTAIN_VIEW, State.CA),
    MOUNTAINVIEW94039("94039", County.MOUNTAIN_VIEW, State.CA),
    MOUNTAINVIEW94040("94040", County.MOUNTAIN_VIEW, State.CA),
    MOUNTAINVIEW94041("94041", County.MOUNTAIN_VIEW, State.CA),
    MOUNTAINVIEW94042("94042", County.MOUNTAIN_VIEW, State.CA),
    MOUNTAINVIEW94043("94043", County.MOUNTAIN_VIEW, State.CA),
    SUNNYVALE94085("94085", County.SUNNYVALE, State.CA),
    SUNNYVALE94086("94086", County.SUNNYVALE, State.CA),
    SUNNYVALE94087("94087", County.SUNNYVALE, State.CA),
    SUNNYVALE94088("94088", County.SUNNYVALE, State.CA),
    SUNNYVALE94089("94089", County.SUNNYVALE, State.CA),
    CUPERTINO95014("95014", County.CUPERTINO, State.CA),
    CUPERTINO95015("95015", County.CUPERTINO, State.CA),
    MILPITAS95035("95035", County.MILPITAS, State.CA),
    SANTACLARA95050("95050", County.SANTA_CLARA, State.CA),
    SANTACLARA95051("95051", County.SANTA_CLARA, State.CA),
    SANTACLARA95052("95052", County.SANTA_CLARA, State.CA),
    SANTACLARA95053("95053", County.SANTA_CLARA, State.CA),
    SANTACLARA95054("95054", County.SANTA_CLARA, State.CA),
    SANTACLARA95055("95055", County.SANTA_CLARA, State.CA),
    SANTACLARA95056("95056", County.SANTA_CLARA, State.CA),
    SANJOSE95134("95134", County.SAN_JOSE, State.CA),
    SANJOSE95131("95131", County.SAN_JOSE, State.CA),
    SANJOSE95133("95133", County.SAN_JOSE, State.CA),
    SANJOSE95112("95112", County.SAN_JOSE, State.CA);

    private String zipcode;
    private County county;
    private State state;

    Zipcode(String zipcode, County county, State state) {
        this.zipcode = zipcode;
        this.county = county;
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public County getCounty() {
        return county;
    }

    public State getState() {
        return state;
    }
}
