package com.red.domain.entity;

import com.red.domain.UnitStatus;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Liujunjie on 2018/11/8.
 */
public class TradingHistoryDTO {
    private TradingHistoryDO tradingHistoryDO;

    public Long getId() {
        return tradingHistoryDO.getId();
    }

    public void setId(Long id) {
        tradingHistoryDO.setId(id);
    }

    public Integer getPrice() {
        return tradingHistoryDO.getPrice();
    }

    public void setPrice(Integer price) {
        tradingHistoryDO.setPrice(price);
    }

    public Date getCreatedDate() {
        return tradingHistoryDO.getCreatedDate();
    }

    public void setCreatedDate(Date createdDate) {
        tradingHistoryDO.setCreatedDate(createdDate);
    }

    public UnitStatus getStatus() {
        return tradingHistoryDO.getStatus();
    }

    public void setStatus(UnitStatus status) {
        tradingHistoryDO.setStatus(status);
    }

    public String getMSL() {
        return tradingHistoryDO.getMSL();
    }

    public void setMSL(String MSL) {
        tradingHistoryDO.setMSL(MSL);
    }
}
