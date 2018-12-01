package com.red.domain.entity;

import com.red.domain.UnitStatus;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Liujunjie on 11/2/18.
 */
public class TradingHistoryDO {
    private Long id;
    private Integer price;
    private Date createdDate;
    private String MSL;
    private UnitStatus status; // closed transaction, pending transaction
//    private Long unitId;
    private UnitDO unitDo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UnitStatus getStatus() {
        return status;
    }

    public void setStatus(UnitStatus status) {
        this.status = status;
    }

    public String getMSL() {
        return MSL;
    }

    public void setMSL(String MSL) {
        this.MSL = MSL;
    }

//    public Long getUnitId() {
//        return unitId;
//    }
//
//    public void setUnitId(Long unitId) {
//        this.unitId = unitId;
//    }

    public UnitDO getUnitDo() {
        return unitDo;
    }

    public void setUnitDo(UnitDO unitDo) {
        this.unitDo = unitDo;
    }
}
