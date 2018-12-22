package com.red.domain.entity;

import com.red.domain.TradingStatus;

import java.util.Date;

/**
 * Created by Liujunjie on 11/2/18.
 */
public class TradingHistoryDO {
    private Long id;
    private Integer price;
    private Integer pricePerSqFt;   // TODO(junjieliu): add column to table.
    private Date createdDate;
    private String MSL;
    private TradingStatus status; // listed, price changed, sold.
    private UnitDO unitDo;

    public String debugString(String prefix) {
        return prefix + "{id: " + id + ",\n"
                + prefix + " price: " + price + ",\n"
                + prefix + " price per sq. ft.: " + pricePerSqFt + ",\n"
                + prefix + " createdDate: " + createdDate.toString() + ",\n"
                + prefix + " MSL: " + MSL + ",\n"
                + prefix + " status: " + status.toString() + "\n"
                + prefix + "}\n";
    }

    public String debugString() {
        return debugString("");
    }

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

    public Integer getPricePerSqFt() {
        return pricePerSqFt;
    }

    public void setPricePerSqFt(Integer price) {
        this.pricePerSqFt = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public TradingStatus getStatus() {
        return status;
    }

    public void setStatus(TradingStatus status) {
        this.status = status;
    }

    public String getMSL() {
        return MSL;
    }

    public void setMSL(String MSL) {
        this.MSL = MSL;
    }

    public UnitDO getUnitDo() {
        return unitDo;
    }

    public void setUnitDo(UnitDO unitDo) {
        this.unitDo = unitDo;
    }
}
