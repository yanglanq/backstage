package com.join.TinyProgram.entity;

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

    private String purpose;

    private String soil;

    private String beam;

    private String humidity;

    private String dormancy;

    private String Reproduction;

    public String getReproduction() {
        return Reproduction;
    }

    public void setReproduction(String reproduction) {
        Reproduction = reproduction;
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

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getBeam() {
        return beam;
    }

    public void setBeam(String beam) {
        this.beam = beam;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getDormancy() {
        return dormancy;
    }

    public void setDormancy(String dormancy) {
        this.dormancy = dormancy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Succulent)) return false;
        Succulent succulent = (Succulent) o;
        return plantid.equals(succulent.plantid) &&
                imgUrl.equals(succulent.imgUrl) &&
                pname.equals(succulent.pname) &&
                alias.equals(succulent.alias) &&
                classification.equals(succulent.classification) &&
                intro.equals(succulent.intro) &&
                feature.equals(succulent.feature) &&
                habits.equals(succulent.habits) &&
                purpose.equals(succulent.purpose) &&
                soil.equals(succulent.soil) &&
                beam.equals(succulent.beam) &&
                humidity.equals(succulent.humidity) &&
                dormancy.equals(succulent.dormancy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plantid, imgUrl, pname, alias, classification, intro, feature, habits, purpose, soil, beam, humidity, dormancy);
    }

    @Override
    public String toString() {
        return "Succulent{" +
                "plantid=" + plantid +
                ", imgUrl='" + imgUrl + '\'' +
                ", pname='" + pname + '\'' +
                ", alias='" + alias + '\'' +
                ", classification='" + classification + '\'' +
                ", intro='" + intro + '\'' +
                ", feature='" + feature + '\'' +
                ", habits='" + habits + '\'' +
                ", purpose='" + purpose + '\'' +
                ", soil='" + soil + '\'' +
                ", beam='" + beam + '\'' +
                ", humidity='" + humidity + '\'' +
                ", dormancy='" + dormancy + '\'' +
                '}';
    }
}
