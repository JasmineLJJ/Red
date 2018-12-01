package com.red.domain.entity;

import com.red.domain.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Liujunjie on 11/2/18.
 */
public class UnitDO {
    private Long id;
    private String MLS;
    private int HOA;
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    private County county;
    private int yearBuilt;
    private int yearRenovated;
    private PropertyStyle style;
    private int lotSize;
    private int finishedSize;
    private String street;
    private String streetAddition;
    private int unitNumber;
    private State state;
    private String zipcode;
    private UnitStatus status;
    private int beds;
    private Float bath;
    private int garage;
    private Boolean gym;
    private Boolean swimmingPool;
    private Integer estimatedPrice;
    private Integer latestListingPrice;
    private Integer soldPrice;
    private Date soldDate;
    private Date unitCreatedDate;
    private Date createdDate;
    private Date lastUpdatedDate;
    private String redUrl;
    private Boolean detailed;
    private Set<TradingHistoryDO> tradingHistoryDOs;
    private Set<SchoolDO> schoolDOs;
    private int pricePerSF;
    private int streetNumber;
    private String address;


    public void addTradingHistory(TradingHistoryDO tradingHistoryDO) {
        if (tradingHistoryDOs == null) {
            tradingHistoryDOs = new HashSet<TradingHistoryDO>();
        }
        tradingHistoryDOs.add(tradingHistoryDO);
    }

    public void addSchool(SchoolDO schoolDO) {
        if (schoolDOs == null) {
            schoolDOs = new HashSet<SchoolDO>();
        }
        schoolDOs.add(schoolDO);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMLS() {
        return MLS;
    }

    public void setMLS(String MLS) {
        this.MLS = MLS;
    }

    public int getHOA() {
        return HOA;
    }

    public void setHOA(int HOA) {
        this.HOA = HOA;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public int getYearRenovated() {
        return yearRenovated;
    }

    public void setYearRenovated(int yearRenovated) {
        this.yearRenovated = yearRenovated;
    }

    public PropertyStyle getStyle() {
        return style;
    }

    public void setStyle(PropertyStyle style) {
        this.style = style;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetAddition() {
        return streetAddition;
    }

    public void setStreetAddition(String streetAddition) {
        this.streetAddition = streetAddition;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public UnitStatus getStatus() {
        return status;
    }

    public void setStatus(UnitStatus status) {
        this.status = status;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public Float getBath() {
        return bath;
    }

    public void setBath(Float bath) {
        this.bath = bath;
    }

    public int getGarage() {
        return garage;
    }

    public void setGarage(int garage) {
        this.garage = garage;
    }

    public Boolean getGym() {
        return gym;
    }

    public void setGym(Boolean gym) {
        this.gym = gym;
    }

    public Boolean getSwimmingPool() {
        return swimmingPool;
    }

    public void setSwimmingPool(Boolean swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    public int getFinishedSize() {
        return finishedSize;
    }

    public void setFinishedSize(int finishedSize) {
        this.finishedSize = finishedSize;
    }

    public Integer getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(Integer estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public Integer getLatestListingPrice() {
        return latestListingPrice;
    }

    public void setLatestListingPrice(Integer latestListingPrice) {
        this.latestListingPrice = latestListingPrice;
    }

    public Integer getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(Integer soldPrice) {
        this.soldPrice = soldPrice;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Date getUnitCreatedDate() {
        return unitCreatedDate;
    }

    public void setUnitCreatedDate(Date unitCreatedDate) {
        this.unitCreatedDate = unitCreatedDate;
    }

    public String getRedUrl() {
        return redUrl;
    }

    public void setRedUrl(String redUrl) {
        this.redUrl = redUrl;
    }

    public Boolean getDetailed() {
        return detailed;
    }

    public void setDetailed(Boolean detailed) {
        this.detailed = detailed;
    }

    public Set<TradingHistoryDO> getTradingHistoryDOs() {
        return tradingHistoryDOs;
    }

    public void setTradingHistoryDOs(Set<TradingHistoryDO> tradingHistoryDOs) {
        this.tradingHistoryDOs = tradingHistoryDOs;
    }

    public Set<SchoolDO> getSchoolDTOs() {
        return schoolDOs;
    }

    public void setSchoolDTOs(Set<SchoolDO> schoolDTOs) {
        this.schoolDOs = schoolDTOs;
    }

    public int getPricePerSF() {
        return pricePerSF;
    }

    public void setPricePerSF(int pricePerSF) {
        this.pricePerSF = pricePerSF;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
