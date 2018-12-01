package com.red.domain.entity;

import com.red.domain.SchoolLevel;

import java.math.BigDecimal;

/**
 * Created by Liujunjie on 2018/11/4.
 */
public class SchoolDO {
    private Long id;
    private String schoolName;
    private Float greatSchoolRating;
    private Float parentRating;
    private SchoolLevel level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Float getGreatSchoolRating() {
        return greatSchoolRating;
    }

    public void setGreatSchoolRating(Float greatSchoolRating) {
        this.greatSchoolRating = greatSchoolRating;
    }

    public Float getParentRating() {
        return parentRating;
    }

    public void setParentRating(Float parentRating) {
        this.parentRating = parentRating;
    }

    public SchoolLevel getLevel() {
        return level;
    }

    public void setLevel(SchoolLevel level) {
        this.level = level;
    }
}
