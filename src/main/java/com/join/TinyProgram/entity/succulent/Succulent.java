package com.join.TinyProgram.entity.succulent;

import java.util.Objects;

/**
 * author dongml
 * time 6/5/2020
 * description
 */
public class Succulent {
    private Integer plantid;

    private String imgUrl;

    private String pname;

    private String alias;

    private String classification;

    private String intro;

    private String feature;

    private String habits;

    private String florescence;

    public Succulent() {
    }

    public String getFlorescence() {
        return florescence;
    }

    public void setFlorescence(String florescence) {
        this.florescence = florescence;
    }

    public Integer getPlantid() {
        return plantid;
    }

    public void setPlantid(Integer plantid) {
        this.plantid = plantid;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getHabits() {
        return habits;
    }

    public void setHabits(String habits) {
        this.habits = habits;
    }


}
