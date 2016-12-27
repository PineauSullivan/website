package com.sullivan.website.admin.classes;

import org.json.simple.JSONObject;

/**
 * Created by sullivan on 27/12/16.
 */
public class info {
    private String id;
    private String detail;
    private int number;

    public info(String id, String detail, int number) {
        this.id = id;
        this.detail = detail;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public JSONObject toJson(){
        JSONObject map = new JSONObject();
        map.put("id",this.id);
        map.put("description",this.detail);
        map.put("number",this.number);
        return map;
    }
}
