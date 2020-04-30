package com.join.TinyProgram.entity;

/**
 * author dongml
 * time 29/4/2020
 * description
 */
public class Msg {

    private Integer id;
    private String msg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "id=" + id +
                ", Msg='" + msg + '\'' +
                '}';
    }
}
