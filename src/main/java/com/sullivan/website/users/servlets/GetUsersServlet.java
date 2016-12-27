package com.sullivan.website.users.servlets;


import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.sullivan.website.admin.requetes.datastore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUsersServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        UserService userService = UserServiceFactory.getUserService();

        String nomUser = null;
        String idUser = null;
        boolean admin = false;
        if (userService.getCurrentUser() != null){
            nomUser = userService.getCurrentUser().getNickname();
            idUser = userService.getCurrentUser().getUserId();
            String mail = userService.getCurrentUser().getEmail();
            admin=(userService.isUserAdmin());
            if(!admin)
                datastore.adddatausers(idUser,nomUser,mail);
        }


        req.setAttribute( "nomUser", nomUser );
        req.setAttribute("urlCo", userService.createLoginURL("/"));
        req.setAttribute("urlDeco", userService.createLogoutURL("/"));
        req.setAttribute("idUser", idUser);
        req.setAttribute("admin", admin);



        try {
            this.getServletContext().getRequestDispatcher( req.getPathInfo() + "index.jsp" ).forward( req, resp );
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
