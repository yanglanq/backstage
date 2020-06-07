package com.join.TinyProgram.entity.user;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 21:28 2020/5/9
 */
public class User {

    private int id;
    private String openid;
    private String username;
    private String sex;
    private String headUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", headUrl='" + headUrl + '\'' +
                '}';
    }
}
