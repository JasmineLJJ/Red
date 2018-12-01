package com.red.domain;

/**
 * Created by Liujunjie on 11/2/18.
 */
public enum PropertyType {
    TOWNHOUST("Townhouse"),
    SINGLE("Single Family Residential"),
    CONDO("Condo/Co-op"),
    OTHER("Other");

    private String typeName;
    PropertyType(String typeName) {
        this.typeName = typeName;
    }
    public String toString() {
        return name();
    }

    public static PropertyType getPropertyTypeFromName(String name) {
        PropertyType[] types = values();
        for (PropertyType type : types) {
            if (type.typeName.toLowerCase().equals(name.toLowerCase())) {
                return type;
            }
        }
        return PropertyType.OTHER;
    }
}
