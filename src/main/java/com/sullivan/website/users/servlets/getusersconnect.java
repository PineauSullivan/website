package com.sullivan.website.users.servlets;

/**
 * Created by Sullivan on 13/11/2016.
 */

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.sullivan.website.admin.requetes.datastore;
import com.sullivan.website.users.classes.user;
import org.json.simple.JSONArray;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class getusersconnect extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        UserService userService = UserServiceFactory.getUserService();

        String idUser = null;
        boolean admin = false;
        if (userService.getCurrentUser() != null){
            idUser = userService.getCurrentUser().getUserId();
            admin=(datastore.isadmin(idUser));
            if(admin){
                JSONArray listdonneesjson = new JSONArray();
                List<user> objects = datastore.getusers();
                for(user object:objects)
                    listdonneesjson.add(object.toJson());
                resp.setContentType("application/json;charset=UTF-8");
                try (PrintWriter out = resp.getWriter()) {
                    out.println(listdonneesjson);
                }
            }
        }
    }
}
