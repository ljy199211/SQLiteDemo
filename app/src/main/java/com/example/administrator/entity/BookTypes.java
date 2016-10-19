package com.example.administrator.entity;

/**
 * Created by Administrator on 2016/10/12.
 */

public class BookTypes {
    private int _id;
    private String type;
    private int gender;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public BookTypes(int _id, String type, int gender) {

        this._id = _id;
        this.type = type;
        this.gender = gender;
    }

    public BookTypes(String type, int gender) {
        this.type = type;
        this.gender = gender;
    }
}
