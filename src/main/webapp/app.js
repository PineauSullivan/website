(function() {

    var app = angular.module('sullivan-app', []);

    app.controller('madonnee_dynamique', ['$scope','$window', '$http', '$interval',
        function($scope, $window,$http,$interval) {

            $scope.experiences ="";
            $scope.formations ="";
            $scope.centresinteret ="";
            $scope.competences ="";
            $scope.descriptions ="";

            $scope.experienceswait= true;
            $scope.formationswait = true;
            $scope.centresinteretwait = true;
            $scope.competenceswait = true;
            $scope.descriptionswait = true;

            $scope.experiencesok= false;
            $scope.formationsok = false;
            $scope.centresinteretok = false;
            $scope.competencesok = false;
            $scope.descriptionsok = false;

            var promiseexperiences = $http.get('/admin/donnees?type=experiences');
            promiseexperiences.success(function(data) {
                $scope.experiences = data;
                $scope.experienceswait= false;
                $scope.experiencesok= true;
            });

            var promiseformations = $http.get('/admin/donnees?type=formations');
            promiseformations.success(function(data) {
                $scope.formations = data;
                $scope.formationswait= false;
                $scope.formationsok= true;
            });

            var promisecentresinteret = $http.get('/admin/donnees?type=centresinteret');
            promisecentresinteret.success(function(data) {
                $scope.centresinteret = data;
                $scope.centresinteretwait= false;
                $scope.centresinteretok= true;
            });

            var promisecompetences = $http.get('/admin/donnees?type=competences');
            promisecompetences.success(function(data) {
                $scope.competences = data;
                $scope.competenceswait= false;
                $scope.competencesok = true;
            });

            var promisedescriptions = $http.get('/admin/donnees?type=descriptions');
            promisedescriptions.success(function(data) {
                $scope.descriptions = data;
                $scope.descriptionswait= false;
                $scope.descriptionsok= true;
            });

        }

    ]);


})();