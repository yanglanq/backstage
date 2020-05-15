package com.join.TinyProgram.entity.user;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 21:28 2020/5/9
 */
public class User {

    private int id;
    private String username;
    private String diary;
    private String sex;
    private String headUrl;
    private String path;
    private int status;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDiary() {
        return diary;
    }

    public void setDiary(String diary) {
        this.diary = diary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", diary='" + diary + '\'' +
                ", sex='" + sex + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", path='" + path + '\'' +
                ", status=" + status +
                ", password='" + password + '\'' +
                '}';
    }
}
