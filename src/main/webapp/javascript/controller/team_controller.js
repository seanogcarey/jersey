/**
 * Created by Sean on 05/04/2016.
 */
angular.module('myApp', []).controller('teamCtrl', function($scope, $http) {

        $http.get('http://localhost:8081/jersey/teams/getAllTeams/').
        //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
        success(function(data) {
            $scope.teams = data;
        });

    /*
    $scope.fullName = function() {
        return $scope.firstName + " " + $scope.lastName;
    }

    $http.get('http://localhost:8081/jersey/teams/getTeam/1').success(function(isValid) {

        if (isValid) {
            alert('submitting data');
        }
    });
    */
});

