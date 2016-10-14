package com.vb.ormlite.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2016/10/13 0013.
 */
@DatabaseTable(tableName = "table_testc")
public class TestBeanC {
    @DatabaseField(columnName = "_id", id = true)
    private int _id;
    @DatabaseField(columnName = "title")
    private String title;
    @DatabaseField(columnName = "img")
    private String img;
    @DatabaseField(columnName = "time")
    private String time;
    @DatabaseField(columnName = "tmp0")
    private int tmp0;   //预留字段int
    @DatabaseField(columnName = "tmp1")
    private String tmp1;    //预留字段String
    @DatabaseField(columnName = "tmp2")
    private String tmp2;    //预留字段String

    public TestBeanC() {
    }

    public TestBeanC(int _id, String title, String img, String time) {
        this._id = _id;
        this.title = title;
        this.img = img;
        this.time = time;
    }

    public TestBeanC(int _id, String title, String img, String time, int tmp0, String tmp1, String tmp2) {
        this._id = _id;
        this.title = title;
        this.img = img;
        this.time = time;
        this.tmp0 = tmp0;
        this.tmp1 = tmp1;
        this.tmp2 = tmp2;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTmp0() {
        return tmp0;
    }

    public void setTmp0(int tmp0) {
        this.tmp0 = tmp0;
    }

    public String getTmp1() {
        return tmp1;
    }

    public void setTmp1(String tmp1) {
        this.tmp1 = tmp1;
    }

    public String getTmp2() {
        return tmp2;
    }

    public void setTmp2(String tmp2) {
        this.tmp2 = tmp2;
    }
}