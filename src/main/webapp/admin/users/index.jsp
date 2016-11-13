<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="fr"  ng-app="sullivan-app">
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
    <title>Admin users</title>
    <script type="text/javascript" src="https://code.angularjs.org/1.5.8/angular.js" data-require="angular.js@1.5.x" data-semver="1.5.8"></script>
    <script type="text/javascript" src="app.js"></script>
    <link href="/style.css" rel="stylesheet" />
    <link href="/admin/style.css" rel="stylesheet" />
</head>
<body ng-controller="madonnee_dynamique as mydonnee_dynamique">

    <div class="left">
        <h1>Administration</h1>
        <h1><a href="/admin/">Retour</a></h1>
    </div>

    <div class="right" id="rightadmin">
            <form  ng-submit="getusers()">
            <input type="submit" value="Voir tous les utilisateurs qui se sont connectés !" />
        </form>
        <p ng-show="resultwait">La demande est en cours... ...</p>
        <div id="result" ng-show="resultok">
                <div class="resulttab">
                    <div class="caseresult">Id</div>
                    <div class="caseresult">Date</div>
                    <div class="caseresult">Name</div>
                    <div class="caseresult">Mail</div>
                </div>
                <br>
                <div class="resulttab" ng-repeat="objet in result">
                    <div class="caseresult">{{objet.id}}</div>
                    <div class="caseresult">{{objet.date}}</div>
                    <div class="caseresult">{{objet.name}}</div>
                    <div class="caseresult">{{objet.mail}}</div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>