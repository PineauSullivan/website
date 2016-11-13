(function() {

    var app = angular.module('sullivan-app', []);

    app.controller('madonnee_dynamique', ['$scope','$window', '$http', '$interval',
        function($scope, $window,$http,$interval) {
            $scope.result="";
            $scope.resultwait=false;
            $scope.resultok=false;
            $scope.getusers = function(){
                $scope.resultwait=true;
                $scope.resultok=false;
                var promise = $http.get('/admin/users');
                promise.success(function(data) {
                    $scope.result=data;
                    $scope.resultwait=false;
                    $scope.resultok=true;
                });
            };

        }

    ]);


})();