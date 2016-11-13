/**
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sullivan.website.admin.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.List;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.sullivan.website.admin.classes.*;
import com.sullivan.website.admin.requetes.datastore;
import org.json.simple.JSONArray;


@SuppressWarnings("serial")
public class donneesservlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws IOException {
    try {

      JSONArray listdonneesjson = new JSONArray();
      String type = req.getParameter("type").toString();
      if (type.equals("experiences")) {
        List<experience> objects = datastore.getexperiences();
        for(experience object:objects)
          listdonneesjson.add(object.toJson());
      }else if(type.equals("formations")){
        List<formation> objects = datastore.getformations();
        for(formation object:objects)
          listdonneesjson.add(object.toJson());
      }else if(type.equals("centresinteret"))
      {
        List<centreinteret> objects = datastore.getcentresinteret();
        for(centreinteret object:objects)
          listdonneesjson.add(object.toJson());
      }else if(type.equals("competences")){
        List<competence> objects = datastore.getcompetences();
        for(competence object:objects)
          listdonneesjson.add(object.toJson());
      }else if(type.equals("descriptions"))
      {
        List<description> objects = datastore.getdescriptions();
        for(description object:objects)
          listdonneesjson.add(object.toJson());
      }

      resp.setContentType("application/json;charset=UTF-8");
      try (PrintWriter out = resp.getWriter()) {
        out.println(listdonneesjson);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws IOException {
    resp.getWriter().println("Appel post donnees ");
    UserService userService = UserServiceFactory.getUserService();

    String idUser = null;
    boolean admin = false;
    if (userService.getCurrentUser() != null){
      idUser = userService.getCurrentUser().getUserId();
      admin=(datastore.isadmin(idUser));
    }

    boolean result = false;
    if(admin) {
      try {
        boolean test_contenu = false;
        String type = req.getParameter("type").toString();

        if (type.equals("experience") || type.equals("formation"))
          test_contenu = (req.getParameter("date").toString() != "") &&
                  (req.getParameter("description").toString() != "") &&
                  (req.getParameter("lieu").toString() != "");
        else if (type.equals("centreinteret") || type.equals("competence") || type.equals("description"))
          test_contenu = (req.getParameter("description").toString() != "");

        if (test_contenu) {
          if (type.equals("experience"))
            result = datastore.addexperience(req.getParameter("date"), req.getParameter("description"), req.getParameter("lieu"));
          else if (type.equals("formation"))
            result = datastore.addformation(req.getParameter("date"), req.getParameter("description"), req.getParameter("lieu"));
          else if (type.equals("centreinteret"))
            result = datastore.addcentreinteret(req.getParameter("description"));
          else if (type.equals("competence"))
            result = datastore.addcompetence(req.getParameter("description"));
          else if (type.equals("description"))
            result = datastore.adddescription(req.getParameter("description"));
          else
            resp.getWriter().println("Type invalide -> " + type);
        } else
          resp.getWriter().println("données invalide !");

        if (result)
          resp.getWriter().println("Ajout " + req.getParameter("type") + " fait");

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
 }
}