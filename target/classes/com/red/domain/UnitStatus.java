package com.red.domain;

/**
 * Created by Liujunjie on 11/2/18.
 */
public enum UnitStatus {
    Open,
    Return,
    Pending,
    Closed;

    public String toString() {
        return name();
    }
}
