package com.red.domain;

/**
 * Created by Liujunjie on 2018/11/4.
 */
public enum SchoolLevel {
    UNKNOWN,
    ELEMENTARY,
    MIDDLE,
    HIGH;

    public String toString() {
        return name();
    }

    public static SchoolLevel parseFromMeta(String meta) {
        if (!meta.contains(" to ")) {
            return UNKNOWN;
        }
        if (meta.contains("K")) {
            return ELEMENTARY;
        } else if (meta.contains("12")) {
            return HIGH;
        } else {
            return MIDDLE;
        }
    }
}
