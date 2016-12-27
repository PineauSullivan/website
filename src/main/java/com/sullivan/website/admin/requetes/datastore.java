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
    public static boolean addexperience(String date, String description, String lieu, int number) {
        boolean result = false;
        try {
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            Entity experience = new Entity("experiences");
            experience.setProperty("date", date);
            experience.setProperty("description", description);
            experience.setProperty("lieu", lieu);
            experience.setProperty("number", number);
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
            int number = ((Long) result.getProperty("number")).intValue();
            String id = result.getKey().toString();
            id = id.substring("experiences".length()+1,id.length()-1);
            experience experience = new experience(date, description, lieu, id, number);
            list_experiences.add(experience);
        }

        List<experience> list_experiences_final = new ArrayList<experience>();
        while(list_experiences.size()!=0){
            int min = list_experiences.get(0).getNumber();
            int it = 0;
            for(int i=0; i<list_experiences.size();++i){
                if(list_experiences.get(i).getNumber()>min){
                    it=i;
                    min=list_experiences.get(i).getNumber();
                }
            }
            list_experiences_final.add(list_experiences.get(it));
            list_experiences.remove(it);
        }
        return list_experiences_final;
    }

    public static boolean addformation(String date, String description, String lieu, int number) {
        boolean result = false;
        try {
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            Entity formation = new Entity("formations");
            formation.setProperty("date", date);
            formation.setProperty("description", description);
            formation.setProperty("lieu", lieu);
            formation.setProperty("number", number);

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
            int number = ((Long) result.getProperty("number")).intValue();
            id = id.substring("formations".length()+1,id.length()-1);
            formation formation = new formation(date, description, lieu, id, number);
            list_formations.add(formation);
        }
        List<formation> list_formation_final = new ArrayList<formation>();
        while(list_formations.size()!=0){
            int min = list_formations.get(0).getNumber();
            int it = 0;
            for(int i=0; i<list_formations.size();++i){
                if(list_formations.get(i).getNumber()>min){
                    it=i;
                    min=list_formations.get(i).getNumber();
                }
            }
            list_formation_final.add(list_formations.get(it));
            list_formations.remove(it);
        }
        return list_formation_final;
    }

    public static boolean addcompetence(String description, int number) {
        boolean result = false;
        try {
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            Entity formation = new Entity("competences");
            formation.setProperty("description", description);
            formation.setProperty("number",number);
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
            int number = ((Long) result.getProperty("number")).intValue();
            id = id.substring("competences".length()+1,id.length()-1);
            competence competence = new competence(description,id,number);
            list_competences.add(competence);
        }
        List<competence> list_competence_final = new ArrayList<competence>();
        while(list_competences.size()!=0){
            int min = list_competences.get(0).getNumber();
            int it = 0;
            for(int i=0; i<list_competences.size();++i){
                if(list_competences.get(i).getNumber()>min){
                    it=i;
                    min=list_competences.get(i).getNumber();
                }
            }
            list_competence_final.add(list_competences.get(it));
            list_competences.remove(it);
        }
        return list_competence_final;
    }

    public static boolean addcentreinteret(String description, int number) {
        boolean result = false;
        try {
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            Entity formation = new Entity("centresinteret");
            formation.setProperty("description", description);
            formation.setProperty("number", number);
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
            int number = ((Long) result.getProperty("number")).intValue();
            id = id.substring("centresinteret".length()+1,id.length()-1);
            centreinteret centreinteret = new centreinteret(description,id, number);
            list_centreinteret.add(centreinteret);
        }
        List<centreinteret> list_centreinteret_final = new ArrayList<centreinteret>();
        while(list_centreinteret.size()!=0){
            int min = list_centreinteret.get(0).getNumber();
            int it = 0;
            for(int i=0; i<list_centreinteret.size();++i){
                if(list_centreinteret.get(i).getNumber()>min){
                    it=i;
                    min=list_centreinteret.get(i).getNumber();
                }
            }
            list_centreinteret_final.add(list_centreinteret.get(it));
            list_centreinteret.remove(it);
        }
        return list_centreinteret_final;
    }

    public static boolean adddescription(String description, int number) {
        boolean result = false;
        try {

            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            Entity formation = new Entity("descriptions");
            formation.setProperty("description", description);
            formation.setProperty("number", number);
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
            int number = ((Long) result.getProperty("number")).intValue();
            id = id.substring("descriptions".length()+1,id.length()-1);
            description descriptiond = new description(description,id,number);
            list_description.add(descriptiond);
        }
        List<description> list_description_final = new ArrayList<description>();
        while(list_description.size()!=0){
            int min = list_description.get(0).getNumber();
            int it = 0;
            for(int i=0; i<list_description.size();++i){
                if(list_description.get(i).getNumber()>min){
                    it=i;
                    min=list_description.get(i).getNumber();
                }
            }
            list_description_final.add(list_description.get(it));
            list_description.remove(it);
        }
        return list_description_final;
    }


    public static boolean addinfo(String detail, int number) {
        boolean result = false;
        try {

            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            Entity formation = new Entity("infos");
            formation.setProperty("detail", detail);
            formation.setProperty("number", number);
            datastore.put(formation);
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<info> getinfos() {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        List<info> list_info = new ArrayList<info>();
        Query q = new Query("infos");
        List<Entity> results = datastore.prepare(q).asList(FetchOptions.Builder.withDefaults());
        for (Entity result : results) {
            String detail = (String) result.getProperty("detail");
            String id = result.getKey().toString();
            int number = ((Long) result.getProperty("number")).intValue();
            id = id.substring("infos".length()+1,id.length()-1);
            info infod = new info(id,detail,number);
            list_info.add(infod);
        }
        List<info> list_info_final = new ArrayList<info>();
        while(list_info.size()!=0){
            int min = list_info.get(0).getNumber();
            int it = 0;
            for(int i=0; i<list_info.size();++i){
                if(list_info.get(i).getNumber()>min){
                    it=i;
                    min=list_info.get(i).getNumber();
                }
            }
            list_info_final.add(list_info.get(it));
            list_info.remove(it);
        }
        return list_info_final;
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