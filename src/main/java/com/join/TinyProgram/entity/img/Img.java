package com.join.TinyProgram.entity.img;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 17:03 2020/6/3
 */
public class Img {
    private int id;
    private int did;
    private String picUrl;
    private String path;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Img(int did,String picUrl,String path){
        this.did=did;
        this.path=path;
        this.picUrl=picUrl;
    }

    public Img(){

    }
    @Override
    public String toString() {
        return "Img{" +
                "id=" + id +
                ", did=" + did +
                ", picUrl='" + picUrl + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
