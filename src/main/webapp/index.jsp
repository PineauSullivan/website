<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@page import="java.util.*"%>

<%

    String nomUser = (String) request.getAttribute("nomUser");
    boolean connexion;
    boolean admin = false;
    String url;
    if (request.getAttribute("nomUser") == null){
        connexion = false;
        url = (String) request.getAttribute("urlCo");
    }else{
        connexion = true;
        url = (String) request.getAttribute("urlDeco");
        admin = (boolean) request.getAttribute("admin");

    }
%>
<!DOCTYPE html>
<html lang="fr"  ng-app="sullivan-app">
<head>
    <title>Sullivan PINEAU</title>
    <meta charset="utf-8" />
    <link href="style.css" rel="stylesheet" />
    <meta name="description" content="Acueil du site de Sullivan">
    <meta name="keywords" content="HTML,CSS,JavaScript,Angular,GoogleAppEngine">
    <meta name="author" content="Sullivan PINEAU">
    <link rel="icon" href="favicon.ico">
    <script type="text/javascript" src="https://code.angularjs.org/1.5.8/angular.js" data-require="angular.js@1.5.x" data-semver="1.5.8"></script>
    <script type="text/javascript" src="app.js"></script>
</head>

<body ng-controller="madonnee_dynamique as mydonnee_dynamique">
<div class="left">
  <img>
  <div id="photomoi"><img src="moi.png" ALT="Ma photo"> </div>
  <div id="prenom_nom">Sullivan PINEAU</div>
  <div id="information">
      <div class="wait" ng-show="infoswait">
          <img class="loader" src="ajax-loader.svg" alt="loader" height="80" width="80">
      </div>
     <div class="info" ng-repeat="info in infos">
        <p>{{info.description}}</p>
     </div>
  </div>
  <div id="listlink">
    <a href="https://github.com/PineauSullivan"><img src="github.png" ALT="Logo github"></a>
    <a href="https://www.linkedin.com/in/sullivanpineau"><img src="linkedin.png" ALT="Logo linkedin"></a>
    <a href="mailto:pineau.sullivan@gmail.com"><img src="email.png" ALT="Logo email"></a>
  </div>
    <%if(admin){%>
        <div class="link_right"><a class="connexion" href="/admin/">Administrer</a></div>
        <div class="link_right"><a class="connexion" href="<% out.println(url); %>">Se déconnecter</a></div>
    <%}else if(connexion){%>
        <div class="link_right">Vous êtes bien connecté mais vous n'êtes pas un administrateur.</div>
        <div class="link_right"><a class="connexion" href="<% out.println(url); %>">Se déconnecter</a></div>
    <%}else{%>
        <div class="link_right"><a class="connexion" href="<% out.println(url); %>">Se connecter</a></div>
    <%}%>
</div>

<div class="right">
    <div class="theme">
        <div class="title">
            <h1>Formations</h1>
        </div>
        <div class="wait" ng-show="formationswait">
            <img class="loader" src="ajax-loader.svg" alt="loader" height="80" width="80">
        </div>
        <div ng-show="formationsok">
            <div class="article" ng-repeat="formation in formations">
                <div class="date_article">
                    <p>{{formation.date}}</p>
                </div>
                <div class="description_article">
                    <p>{{formation.description}}</p>
                </div>
                <div class="description_article">
                    <p>{{formation.lieu}}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="theme">
        <div class="title">
            <h1>Exp&eacute;riences</h1>
        </div>
        <div class="wait" ng-show="experienceswait">
            <img class="loader" src="ajax-loader.svg" alt="loader" height="80" width="80">
        </div>
        <div ng-show="experiencesok">
            <div class="article" ng-repeat="experience in experiences">
                <div class="date_article">
                    <p>{{experience.date}}</p>
                </div>
                <div class="description_article">
                    <p>{{experience.description}}</p>
                </div>
                <div class="description_article">
                    <p>{{experience.lieu}}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="theme">
        <div class="title">
            <h1>Compétences</h1>
        </div>
        <div class="wait" ng-show="competenceswait">
            <img class="loader" src="ajax-loader.svg" alt="loader" height="80" width="80">
        </div>
        <div ng-show="competencesok">
            <div class="article_secondaire" ng-repeat="competence in competences">
                <div class="description_article">
                    <p>{{competence.description}}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="theme">
        <div class="title">
            <h1>Centres d'int&eacute;r&ecirc;t</h1>
        </div>
        <div class="wait" ng-show="centresinteretwait">
            <img class="loader" src="ajax-loader.svg" alt="loader" height="80" width="80">
        </div>
        <div ng-show="centresinteretok">
            <div class="article_secondaire" ng-repeat="centreinteret in centresinteret">
                <div class="description_article">
                    <p>{{centreinteret.description}}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="theme">
        <div class="title">
            <h1>Description</h1>
        </div>
        <div class="wait" ng-show="descriptionswait">
            <img class="loader" src="ajax-loader.svg" alt="loader" height="80" width="80">
        </div>
        <div ng-show="descriptionsok">
            <div class="article_secondaire" ng-repeat="description in descriptions">
                <div class="description_article">
                    <p>{{description.description}}</p>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

