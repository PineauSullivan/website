<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="fr">
<%

    String nomUser = (String) request.getAttribute("nomUser");
    String idUser = (String) request.getAttribute("idUser");
    boolean admin = (boolean) request.getAttribute("admin");
    boolean connexion;
    String url;
    if (request.getAttribute("nomUser") == null){
        connexion = false;
        url = (String) request.getAttribute("urlCo");
        response.sendRedirect("/");
    }else{
        connexion = true;
        url = (String) request.getAttribute("urlDeco");
    }
%>
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <link href="/style.css" rel="stylesheet" />
    <link href="/admin/style.css" rel="stylesheet" />
</head>
<body>
    <div class="left">
        <h1>Administration</h1>
        <h1><a href="/">Retour</a></h1>
    </div>

    <div class="right" id="rightadmin">
        <h1><a href="/admin/users/">Voir la listes des personnes qui se sont connectées</a></h1></br>
        <h1><a href="/admin/donnees/">Ajouter des données</a></h1>
    </div>
</body>
</html>