<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sullivan.website.admin.servlets.donneesservlet" %>
<%@ page import="com.sullivan.website.admin.classes.donnees" %>
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
<html lang="fr"  ng-app="sullivan-app">
    <head>
        <title>Admin donnees</title>
        <meta charset="utf-8" />
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
            <h1>Quel est le type de la donnée?</h1>
            <div class="boutonsadd">
                <form  ng-submit="troisparam()">
                    <input type="submit" value="Experience/Formation" />
                </form>
                <form  ng-submit="unparam()" >
                    <input type="submit" value="Autres" />
                </form>
            </div>
            <form  ng-submit="adddonneetroisparam()" ng-show="showtroisparam" >
                <p>
                    <label>La date : <input type="text" ng-model="date" /></label>
                </p>
                <p>
                    <label>La description : <textarea ng-model="description" style="width: 200px; height: 100px;"></textarea></label>
                </p>
                <p>
                    <label>Le lieu : <input type="text" ng-model="lieu" /></label>
                </p>
                <p>
                <label><input type="radio" name="type" ng-model="type" value="experience">experience</label><br>
                <label><input type="radio" name="type" ng-model="type" value="formation">formation</label><br>
                </p>

                <p>
                    <input type="submit" />
                </p>
            </form>

            <form  ng-submit="adddonneeunparam()" ng-show="showunparam">
                <p>
                    <label>La description : <textarea ng-model="description" style="width: 200px; height: 100px;"></textarea></label>
                </p>
                <p>
                    <label><input type="radio" name="type" ng-model="type" value="centreinteret">Centre d'interet</label><br>
                    <label><input type="radio" name="type" ng-model="type" value="competence">Competence</label><br>
                    <label><input type="radio" name="type" ng-model="type" value="description">Description</label><br>
                </p>

                <p>
                    <input type="submit" />
                </p>
            </form>
            <div id="divadd" ng-show="divadd">
                <p ng-show="divaddresult&&!divaddresultwait" style="color:green;">L'ajout à bien été effectuée !</p>
                <p ng-show="!divaddresult&&!divaddresultwait" style="color:red;">Une erreur s'est produite !</p>
                <p ng-show="divaddresultwait" style="color:orange;">L'ajout est en cours... ...</p>
            </div>
            <br>



            <h1>Data :</h1>
            <form  ng-submit="getExperiences()">
                <input type="submit" value="Experiences" />
            </form>
            <form  ng-submit="getFormations()" >
                <input type="submit" value="Formations" />
            </form>
            <form  ng-submit="getCentresinteret()">
                <input type="submit" value="Centres d'interet" />
            </form>
            <form  ng-submit="getCompetences()" >
                <input type="submit" value="Competences" />
            </form>
            <form  ng-submit="getDescriptions()">
                <input type="submit" value="Descriptions" />
            </form>

            <p ng-show="resultwait">Recherche en cours... ...</p>

            <div id="result" ng-show="showresult">
                <div ng-show="showresulttroisparam">
                    <div class="resulttab">
                        <div class="caseresult">Id</div>
                        <div class="caseresult">Date</div>
                        <div class="caseresult">Description</div>
                        <div class="caseresult">Lieu</div>
                    </div>
                    <br>
                    <div class="resulttab" ng-repeat="objet in result">
                        <div class="caseresult">{{objet.id}}</div>
                        <div class="caseresult">{{objet.date}}</div>
                        <div class="caseresult">{{objet.description}}</div>
                        <div class="caseresult">{{objet.lieu}}</div>
                    </div>
                </div>
                <div ng-show="showresultunparam">
                    <div class="resulttab">
                        <div class="caseresult">Id</div>
                        <div class="caseresult">Contenu</div>
                    </div>
                    <br>
                    <div class="resulttab" ng-repeat="objet in result">
                        <div class="caseresult">{{objet.id}}</div>
                        <div class="caseresult">{{objet.description}}</div>
                    </div>
                </div>
            </div>
            <form  ng-submit="clean()">
                    <input type="submit" value="Clean" />
                </form>
            </div>

        </div>
    </body>
</html>