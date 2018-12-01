package com.red.domain.entity;

import com.red.domain.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Liujunjie on 2018/11/8.
 */
public class UnitDTO {
    private UnitDO unitDO;
    private Set<TradingHistoryDTO> tradingHistoryDOs;
    private Set<SchoolDTO> schoolDTOs;

    public Long getId() {
        return unitDO.getId();
    }

    public void setId(Long id) {
        unitDO.setId(id);
    }

    public String getMLS() {
        return unitDO.getMLS();
    }

    public void setMLS(String MLS) {
        unitDO.setMLS(MLS);
    }

    public int getHOA() {
        return unitDO.getHOA();
    }

    public void setHOA(int HOA) {
        unitDO.setHOA(HOA);
    }

    public PropertyType getPropertyType() {
        return unitDO.getPropertyType();
    }

    public void setPropertyType(PropertyType propertyType) {
        unitDO.getPropertyType();
    }

    public County getCounty() {
        return unitDO.getCounty();
    }

    public void setCounty(County county) {
        unitDO.setCounty(county);
    }

    public int getYearBuilt() {
        return unitDO.getYearBuilt();
    }

    public void setYearBuilt(int yearBuilt) {
        unitDO.setYearBuilt(yearBuilt);
    }

    public int getYearRenovated() {
        return unitDO.getYearRenovated();
    }

    public void setYearRenovated(int yearRenovated) {
        unitDO.setYearRenovated(yearRenovated);
    }

    public PropertyStyle getStyle() {
        return unitDO.getStyle();
    }

    public void setStyle(PropertyStyle style) {
        unitDO.setStyle(style);
    }

    public int getLotSize() {
        return unitDO.getLotSize();
    }

    public void setLotSize(int lotSize) {
        unitDO.setLotSize(lotSize);
    }

    public String getStreet() {
        return unitDO.getStreet();
    }

    public void setStreet(String street) {
        unitDO.setStreet(street);
    }

    public String getStreetAddition() {
        return unitDO.getStreetAddition();
    }

    public void setStreetAddition(String streetAddition) {
        unitDO.setStreetAddition(streetAddition);
    }

    public int getUnitNumber() {
        return unitDO.getUnitNumber();
    }

    public void setUnitNumber(int unitNumber) {
        unitDO.setUnitNumber(unitNumber);
    }

    public State getState() {
        return unitDO.getState();
    }

    public void setState(State state) {
        unitDO.setState(state);
    }

    public String getZipcode() {
        return unitDO.getZipcode();
    }

    public void setZipcode(String zipcode) {
        unitDO.setZipcode(zipcode);
    }

    public UnitStatus getStatus() {
        return unitDO.getStatus();
    }

    public void setStatus(UnitStatus status) {
        unitDO.setStatus(status);
    }

    public int getBeds() {
        return unitDO.getBeds();
    }

    public void setBeds(int beds) {
        unitDO.setBeds(beds);
    }

    public int getBath() {
        return unitDO.getBath();
    }

    public void setBath(int bath) {
        unitDO.setBath(bath);
    }

    public int getGarage() {
        return unitDO.getGarage();
    }

    public void setGarage(int garage) {
        unitDO.setGarage(garage);
    }

    public Boolean getGym() {
        return unitDO.getGym();
    }

    public void setGym(Boolean gym) {
        unitDO.setGym(gym);
    }

    public Boolean getSwimmingPool() {
        return unitDO.getSwimmingPool();
    }

    public void setSwimmingPool(Boolean swimmingPool) {
        unitDO.setSwimmingPool(swimmingPool);
    }

    public int getFinishedSize() {
        return unitDO.getFinishedSize();
    }

    public void setFinishedSize(int finishedSize) {
        unitDO.setFinishedSize(finishedSize);
    }

    public Integer getEstimatedPrice() {
        return unitDO.getEstimatedPrice();
    }

    public void setEstimatedPrice(Integer estimatedPrice) {
        unitDO.setEstimatedPrice(estimatedPrice);
    }

    public Integer getLatestListingPrice() {
        return unitDO.getLatestListingPrice();
    }

    public void setLatestListingPrice(Integer latestListingPrice) {
        unitDO.setLatestListingPrice(latestListingPrice);
    }

    public Integer getSoldPrice() {
        return unitDO.getSoldPrice();
    }

    public void setSoldPrice(Integer soldPrice) {
        unitDO.setSoldPrice(soldPrice);
    }

    public Date getSoldDate() {
        return unitDO.getSoldDate();
    }

    public void setSoldDate(Date soldDate) {
        unitDO.setSoldDate(soldDate);
    }

    public Date getCreatedDate() {
        return unitDO.getCreatedDate();
    }

    public void setCreatedDate(Date createdDate) {
        unitDO.getCreatedDate();
    }

    public Date getLastUpdatedDate() {
        return unitDO.getLastUpdatedDate();
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        unitDO.setLastUpdatedDate(lastUpdatedDate);
    }

    public Set<TradingHistoryDTO> getTradingHistoryDOs() {
        return tradingHistoryDOs;
    }

    public void setTradingHistoryDTOs(Set<TradingHistoryDTO> tradingHistoryDOs) {
        this.tradingHistoryDOs = tradingHistoryDOs;
    }

    public Set<SchoolDTO> getSchoolDTOs() {
        return schoolDTOs;
    }

    public void setSchoolDTOs(Set<SchoolDTO> schoolDTOs) {
        this.schoolDTOs = schoolDTOs;
    }

    public Date getUnitCreatedDate() {
        return unitDO.getUnitCreatedDate();
    }

    public void setUnitCreatedDate(Date unitCreatedDate) {
        unitDO.setUnitCreatedDate(unitCreatedDate);
    }

    public String getRedUrl() {
        return unitDO.getRedUrl();
    }

    public void setRedUrl(String redUrl) {
        unitDO.setRedUrl(redUrl);
    }

    public Boolean getDetailed() {
        return unitDO.getDetailed();
    }

    public void setDetailed(Boolean detailed) {
        unitDO.setDetailed(detailed);
    }

    public void setUnitDO(UnitDO unitDO) {
        this.unitDO = unitDO;
    }
}
