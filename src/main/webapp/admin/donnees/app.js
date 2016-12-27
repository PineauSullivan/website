(function() {

    var app = angular.module('sullivan-app', []);

    app.controller('madonnee_dynamique', ['$scope','$window', '$http', '$interval',
        function($scope, $window,$http,$interval) {

            $scope.data = "Vide ";
            $scope.date="";
            $scope.description="";
            $scope.lieu="";
            $scope.type="";
            $scope.result = "hummm";
            $scope.number = 0;

            $scope.nbparam=0;
            $scope.showunparam=false;
            $scope.showtroisparam=false;

            $scope.showresultunparam=false;
            $scope.showresulttroisparam=false;

            $scope.divadd=false;
            $scope.divaddresult=false;
            $scope.divaddresultwait=false;
            $scope.unparam =function() {
                $scope.divadd=false;
                if ($scope.showunparam) {
                    $scope.showunparam = false;
                    $scope.showtroisparam = false;
                } else {
                    $scope.showunparam = true;
                    $scope.showtroisparam = false;
                }
            };
            $scope.troisparam =function() {
                $scope.divadd=false;

                if ($scope.showtroisparam) {
                    $scope.showunparam = false;
                    $scope.showtroisparam = false;
                } else {
                    $scope.showunparam = false;
                    $scope.showtroisparam = true;
                }
            };
            $scope.adddonneetroisparam =function() {
                $scope.divadd=true;
                $scope.divaddresult=false;
                $scope.divaddresultwait=true;
                $http({
                    url: '/admin/donnees?type=' + $scope.type +
                    '&date=' + $scope.date+
                    '&description=' + $scope.description+
                    '&number=' + $scope.number+
                    '&lieu=' + $scope.lieu ,
                    method: "POST"
                }).then(function(response) {
                        $scope.type="";
                        $scope.date="";
                        $scope.description="";
                        $scope.lieu="";
                        $scope.number=0;
                        $scope.divaddresult=true;
                        $scope.divaddresultwait=false;
                        $scope.showunparam=false;
                        $scope.showtroisparam=false;
                    },
                    function(response) {
                        $scope.divaddresult=true;
                        $scope.divaddresultwait=false;
                    });
            };

            $scope.adddonneeunparam =function() {
                $scope.divadd=true;
                $scope.divaddresult=false;
                $scope.divaddresultwait=true;
                $http({
                    url: '/admin/donnees?type=' + $scope.type +
                    '&description=' + $scope.description+
                    '&number=' + $scope.number,
                    method: "POST"
                }).then(function(response) {
                        $scope.type="";
                        $scope.date="";
                        $scope.description="";
                        $scope.lieu="";
                        $scope.number=0;
                        $scope.divaddresult=true;
                        $scope.divaddresultwait=false;
                        $scope.showunparam=false;
                        $scope.showtroisparam=false;
                    },
                    function(response) {
                        $scope.divaddresult=true;
                        $scope.divaddresultwait=false;
                    });
            };
            $scope.result="";
            $scope.showresult=false;
            $scope.resultwait=false;
            $scope.getExperiences = function(){
                $scope.showresultunparam=false;
                $scope.showresulttroisparam=false;
                $scope.resultwait=true;
                var promise = $http.get('/admin/donnees?type=experiences');
                promise.success(function(data) {
                    $scope.result = data;
                    $scope.showresulttroisparam=true;
                    $scope.resultwait=false;
                    $scope.showresult=true;
                });
            };

            $scope.getFormations = function(){
                $scope.resultwait=true;
                $scope.showresultunparam=false;
                $scope.showresulttroisparam=false;
                var promise = $http.get('/admin/donnees?type=formations');
                promise.success(function(data) {
                    $scope.result = data;
                    $scope.showresulttroisparam=true;
                    $scope.resultwait=false;
                    $scope.showresult=true;
                });
            };
            $scope.getCentresinteret = function(){
                $scope.resultwait=true;
                $scope.showresultunparam=false;
                $scope.showresulttroisparam=false;
                var promise = $http.get('/admin/donnees?type=centresinteret');
                promise.success(function(data) {
                    $scope.result = data;
                    $scope.showresultunparam=true;
                    $scope.resultwait=false;
                    $scope.showresult=true;
                });
            };
            $scope.getCompetences = function(){
                $scope.showresultunparam=false;
                $scope.showresulttroisparam=false;
                $scope.resultwait=true;
                var promise = $http.get('/admin/donnees?type=competences');
                promise.success(function(data) {
                    $scope.showresultunparam=true;
                    $scope.resultwait=false;
                    $scope.result = data;
                    $scope.showresult=true;
                });
            };
            $scope.getDescriptions = function(){
                $scope.resultwait=true;
                $scope.showresultunparam=false;
                $scope.showresulttroisparam=false;
                var promise = $http.get('/admin/donnees?type=descriptions');
                promise.success(function(data) {
                    $scope.result = data;
                    $scope.showresultunparam=true;
                    $scope.resultwait=false;
                    $scope.showresult=true;
                });
            };

            $scope.getInfos = function(){
                $scope.resultwait=true;
                $scope.showresultunparam=false;
                $scope.showresulttroisparam=false;
                var promise = $http.get('/admin/donnees?type=infos');
                promise.success(function(data) {
                    $scope.result = data;
                    $scope.showresultunparam=true;
                    $scope.resultwait=false;
                    $scope.showresult=true;
                });
            };

            $scope.clean = function(){
                $scope.showresult=false;
                $scope.resultwait=false;
                $scope.showresultunparam=false;
                $scope.showresulttroisparam=false;
            };
        }

    ]);


})();