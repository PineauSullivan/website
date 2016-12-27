package com.sullivan.website.admin.classes;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by Sullivan on 12/11/2016.
 */

public abstract class donnees {
    private String id;
    private String date;
    private String description;
    private String lieu;
    private String type;
    private int number;

    public donnees(String date, String description, String lieu, String id, int number) {
        this.date = date;
        this.description = description;
        this.lieu = lieu;
        this.id = id;
        this.number=number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String get(){
        return "Date : "+ this.date+", Description "+this.description+", Lieu : "+this.lieu+", Type : "+this.type;
    }

    public JSONObject toJson(){
        JSONObject map = new JSONObject();
        map.put("id",this.id);
        map.put("date",this.date);
        map.put("description",this.description);
        map.put("lieu",this.lieu);
        map.put("number",this.number);
        return map;
    }
}
