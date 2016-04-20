/**
 * Created by Sean on 11/04/2016.
 */
/**
 * Created by Sean on 06/04/2016.
 */


'use strict';

var App = angular.module('myApp',[])

App.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/club/:clubId', {

        templateUrl : "club.html",
        controller: "ClubCtrl"

    }).when('/club/', {

        templateUrl : "club.html",
        controller: "ClubCtrl",

    }).when('/', {

        templateUrl : "club.html",
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

App.controller('ClubCtrl', function($scope, $routeParams,$http,$route) {


    $scope.newName = "";
    console.log($routeParams.teamId);
    $http.get('http://localhost:8081/jersey/clubs/getClub/' + $routeParams.clubId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.clubs = data;
        console.log(data);
    });
    $scope.createClub = function() {
        var nameData = $scope.clubName;
        var emailData = $scope.email;
        $http.post("http://localhost:8081/jersey/clubs/createClub/" + nameData + "/email/" + emailData ).success(function() {
            //$route.reload();
            $scope.submissionSuccess=true;
            $route.reload();

        })
    }

});

App.controller('ClubSingleCtrl', function($scope, $routeParams,$http) {

    console.log($routeParams.teamId);
    $http.get('http://localhost:8081/jersey/clubs/getClub/' + $routeParams.clubId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.clubs = data;
        console.log(data);
    });
    $http.get('http://localhost:8081/jersey/teams/getTeamByClub/' + $routeParams.clubId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.teams = data;
    });

});

