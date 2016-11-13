package com.sullivan.website.admin.requetes;

/**
 * Created by Sullivan on 12/11/2016.
 */

import com.google.appengine.api.datastore.*;
import com.sullivan.website.admin.classes.*;
import com.sullivan.website.users.classes.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class datastore {
    public static boolean addexperience(String date, String description, String lieu) {
        boolean result = false;
        try {
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            Entity experience = new Entity("experiences");
            experience.setProperty("date", date);
            experience.setProperty("description", description);
            experience.setProperty("lieu", lieu);

            datastore.put(experience);
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<experience> getexperiences() {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        List<experience> list_experiences = new ArrayList<experience>();
        Query q = new Query("experiences");
        List<Entity> results = datastore.prepare(q).asList(FetchOptions.Builder.withDefaults());
        for (Entity result : results) {
            String date = (String) result.getProperty("date");
            String description = (String) result.getProperty("description");
            String lieu = (String) result.getProperty("lieu");
            String id = result.getKey().toString();
            id = id.substring("experiences".length()+1,id.length()-1);
            experience experience = new experience(date, description, lieu, id);
            list_experiences.add(experience);
        }
        return list_experiences;
    }

    public static boolean addformation(String date, String description, String lieu) {
        boolean result = false;
        try {
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            Entity formation = new Entity("formations");
            formation.setProperty("date", date);
            formation.setProperty("description", description);
            formation.setProperty("lieu", lieu);

            datastore.put(formation);
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<formation> getformations() {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        List<formation> list_formations = new ArrayList<formation>();
        Query q = new Query("formations");
        List<Entity> results = datastore.prepare(q).asList(FetchOptions.Builder.withDefaults());
        for (Entity result : results) {
            String date = (String) result.getProperty("date");
            String description = (String) result.getProperty("description");
            String lieu = (String) result.getProperty("lieu");
            String id = result.getKey().toString();
            id = id.substring("formations".length()+1,id.length()-1);
            formation formation = new formation(date, description, lieu, id);
            list_formations.add(formation);
        }
        return list_formations;
    }

    public static boolean addcompetence(String description) {
        boolean result = false;
        try {
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            Entity formation = new Entity("competences");
            formation.setProperty("description", description);
            datastore.put(formation);
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<competence> getcompetences() {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        List<competence> list_competences = new ArrayList<competence>();
        Query q = new Query("competences");
        List<Entity> results = datastore.prepare(q).asList(FetchOptions.Builder.withDefaults());
        for (Entity result : results) {
            String description = (String) result.getProperty("description");
            String id = result.getKey().toString();
            id = id.substring("competences".length()+1,id.length()-1);
            competence competence = new competence(description,id);
            list_competences.add(competence);
        }
        return list_competences;
    }

    public static boolean addcentreinteret(String description) {
        boolean result = false;
        try {
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            Entity formation = new Entity("centresinteret");
            formation.setProperty("description", description);

            datastore.put(formation);
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<centreinteret> getcentresinteret() {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        List<centreinteret> list_centreinteret = new ArrayList<centreinteret>();
        Query q = new Query("centresinteret");
        List<Entity> results = datastore.prepare(q).asList(FetchOptions.Builder.withDefaults());
        for (Entity result : results) {
            String description = (String) result.getProperty("description");
            String id = result.getKey().toString();
            id = id.substring("centresinteret".length()+1,id.length()-1);
            centreinteret centreinteret = new centreinteret(description,id);
            list_centreinteret.add(centreinteret);
        }
        return list_centreinteret;
    }

    public static boolean adddescription(String description) {
        boolean result = false;
        try {

            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            Entity formation = new Entity("descriptions");
            formation.setProperty("description", description);
            datastore.put(formation);
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<description> getdescriptions() {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        List<description> list_description = new ArrayList<description>();
        Query q = new Query("descriptions");
        List<Entity> results = datastore.prepare(q).asList(FetchOptions.Builder.withDefaults());
        for (Entity result : results) {
            String description = (String) result.getProperty("description");
            String id = result.getKey().toString();
            id = id.substring("descriptions".length()+1,id.length()-1);
            description descriptiond = new description(description,id);
            list_description.add(descriptiond);
        }
        return list_description;
    }

    public static String addadmin(String id) {
        DatastoreService datastore;
        Key cle_date;
        Entity e;
        datastore = DatastoreServiceFactory.getDatastoreService();
        e = new Entity("admin", id);
        e.setProperty("admin", true);
        datastore.put(e);
        return (id);
    }

    public static boolean isadmin(String id) {
        boolean isadmin = false;
        DatastoreService datastore;
        datastore = DatastoreServiceFactory.getDatastoreService();
        Key cle_admin = KeyFactory.createKey("admin",id);
        try{
            Entity admin_trouve = datastore.get(cle_admin);
            isadmin = (boolean) admin_trouve.getProperty("admin");
        } catch (Exception e){}

        return isadmin;
    }

    public static void adddatausers(String id, String user_name, String mail) {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Entity user = new Entity("users",id);
        Date date = new Date();
        user.setProperty("name", user_name);
        user.setProperty("mail", mail);
        user.setProperty("date", date);
        datastore.put(user);
    }


    public static List<user> getusers() {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        List<user> list_user = new ArrayList<user>();
        Query q = new Query("users");
        List<Entity> results = datastore.prepare(q).asList(FetchOptions.Builder.withDefaults());
        for (Entity result : results) {
            String date = result.getProperty("date").toString();
            String mail = (String) result.getProperty("mail");
            String name = (String) result.getProperty("name");
            String id = result.getKey().toString();
            id = id.substring("users".length()+2,id.length()-2);
            user user = new user(id, date, name, mail);
            list_user.add(user);
        }
        return list_user;
    }
}