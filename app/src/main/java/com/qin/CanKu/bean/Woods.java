package com.qin.CanKu.bean;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

public class Woods extends BmobObject implements Serializable {
    private Integer wood_num;
    private String name;
    private String wood_id;
    private String wood_loaction;

    public Integer getWood_num() {
        return wood_num;
    }

    public void setWood_num(Integer wood_num) {
        this.wood_num = wood_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWood_id() {
        return wood_id;
    }

    public void setWood_id(String wood_id) {
        this.wood_id = wood_id;
    }

    public String getWood_loaction() {
        return wood_loaction;
    }

    public void setWood_loaction(String wood_loaction) {
        this.wood_loaction = wood_loaction;
    }
}
