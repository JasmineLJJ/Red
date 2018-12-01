package com.red.domain.entity;

import com.red.domain.SchoolLevel;

import java.math.BigDecimal;

/**
 * Created by Liujunjie on 2018/11/8.
 */
public class SchoolDTO {
    private SchoolDO schoolDO;

    public Long getId() {
        return schoolDO.getId();
    }

    public void setId(Long id) {
        schoolDO.getId();
    }

    public String getSchoolName() {
        return schoolDO.getSchoolName();
    }

    public void setSchoolName(String schoolName) {
        schoolDO.setSchoolName(schoolName);
    }

    public Float getGreatSchoolRating() {
        return schoolDO.getGreatSchoolRating();
    }

    public void setGreatSchoolRating(Float greatSchoolRating) {
        schoolDO.setGreatSchoolRating(greatSchoolRating);
    }

    public Float getParentRating() {
        return schoolDO.getParentRating();
    }

    public void setParentRating(Float parentRating) {
        schoolDO.setParentRating(parentRating);
    }

    public SchoolLevel getLevel() {
        return schoolDO.getLevel();
    }

    public void setLevel(SchoolLevel level) {
        schoolDO.setLevel(level);
    }
}
