package com.sullivan.website.admin.classes;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import org.json.simple.JSONObject;

/**
 * Created by Sullivan on 12/11/2016.
 */
public abstract class divers {
    private String id;
    private String contenu;
    private String type;
    private String activate="true";

    public divers(String contenu, String type, String id) {
        this.contenu = contenu;
        this.type = type;
        this.id = id;

    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActivate() {
        return activate;
    }

    public void setActivate(String activate) {
        this.activate = activate;
    }

    public JSONObject toJson(){
        JSONObject map = new JSONObject();
        map.put("id",this.id);
        map.put("description",this.contenu);
        return map;
    }
}
