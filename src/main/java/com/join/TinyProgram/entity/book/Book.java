package com.join.TinyProgram.entity.book;

import java.util.Date;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 0:06 2020/6/3
 */
public class Book {
    private int id;
    private int uid;
    private String name;
    private Date date;
    private String headUrl;
    private String path;
    private Date water;
    private String plant;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getWater() {
        return water;
    }

    public void setWater(Date water) {
        this.water = water;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", headUrl='" + headUrl + '\'' +
                ", path='" + path + '\'' +
                ", water=" + water +
                ", plant='" + plant + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
