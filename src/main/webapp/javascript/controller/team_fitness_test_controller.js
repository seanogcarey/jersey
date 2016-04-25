/**
 * Created by Sean on 22/04/2016.
 */


'use strict';

var App = angular.module('myApp',[])

App.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/team/:teamId', {

        templateUrl : "teamFitnessTest.html",
        controller: "TeamFitnessCtrl"

    }).when('/', {

        templateUrl : "teamFitnessTest.html",
        controller: "Page1Ctrl"

    }).otherwise({

        template: '<div> This page does not exist </div>'

    });
}])

App.controller('Page1Ctrl', function($scope) {
    $scope.page = 'Page1';
    //console.log($routeParams.teamId);
    //$http.get('http://localhost:8081/jersey/teams/getTeam/' + $routeParams.teamId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    //success(function(data) {
    //$scope.page = data;
    console.log($scope.page);
    //});

});


App.controller('TeamFitnessCtrl', function($scope, $routeParams,$http) {

    $http.get('http://localhost:8081/jersey/teams/getTeam/' + $routeParams.teamId).
    success(function(data) {
        $scope.teams = data;
        console.log(data);
    });
});

