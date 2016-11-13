package com.sullivan.website.users.classes;

import org.json.simple.JSONObject;

/**
 * Created by Sullivan on 13/11/2016.
 */
public class user {
    private String id;
    private String date;
    private String name;
    private String mail;

    public user(String id, String date, String name, String mail) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public JSONObject toJson(){
        JSONObject map = new JSONObject();
        map.put("id",this.id);
        map.put("date",this.date);
        map.put("name",this.name);
        map.put("mail",this.mail);
        return map;
    }
}
