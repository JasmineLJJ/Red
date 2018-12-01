package com.red.domain.entity;

import java.math.BigDecimal;

/**
 * Created by Liujunjie on 2018/11/4.
 */
public class UnitSchools {
    private Long UnitId;
    private Long SchoolId;
    private BigDecimal Distance;

    public Long getUnitId() {
        return UnitId;
    }

    public void setUnitId(Long unitId) {
        UnitId = unitId;
    }

    public Long getSchoolId() {
        return SchoolId;
    }

    public void setSchoolId(Long schoolId) {
        SchoolId = schoolId;
    }

    public BigDecimal getDistance() {
        return Distance;
    }

    public void setDistance(BigDecimal distance) {
        Distance = distance;
    }
}
