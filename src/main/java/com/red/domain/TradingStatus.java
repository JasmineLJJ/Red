package com.red.domain;

/**
 * Created by xgzhu on 2018/12/18.
 */
public enum TradingStatus {
    Unknown,
    Listed,
    NewPrice,
    Sold;

    public String toString() {
        return name();
    }

    public static TradingStatus of(String status) {
        if (status.toLowerCase().contains("listed")) {
            return Listed;
        }
        else if (status.toLowerCase().contains("price changed")) {
            return NewPrice;
        }
        else if (status.toLowerCase().contains("sold")) {
            return Sold;
        }
        return Unknown;
    }
}
