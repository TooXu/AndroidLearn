package com.example.xzr.litepallearn;

/**
 * Created by xzr on 2019/1/7.
 */

public class Catagory {
    private int id ;
    private String CatagoryName;
    private int catagoryCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatagoryName() {
        return CatagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        CatagoryName = catagoryName;
    }

    public int getCatagoryCode() {
        return catagoryCode;
    }

    public void setCatagoryCode(int catagoryCode) {
        this.catagoryCode = catagoryCode;
    }
}
