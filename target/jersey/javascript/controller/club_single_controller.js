/**
 * Created by Sean on 06/04/2016.
 */


'use strict';

var App = angular.module('myApp',[])

App.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/club/:clubId', {

        templateUrl : "clubSingleView.html",
        controller: "ClubSingleCtrl"
    }).when('/', {

        templateUrl : "club.html",
        controller: "Page1Ctrl"

    }).otherwise({

        template: '<div> This page does not exist </div>'

    });
}])

App.controller('Page1Ctrl', function($scope) {
    $scope.page = 'Page1';

    console.log($scope.page);


});

App.controller('ClubSingleCtrl', function($scope, $routeParams,$http,$route) {

    $http.get('http://localhost:8081/jersey/clubs/getClub/' + $routeParams.clubId).

    success(function(data) {

        $scope.clubs = data;


    });
    $http.get('http://localhost:8081/jersey/teams/getTeamByClub/' + $routeParams.clubId).
    success(function(data) {

        $scope.teams = data;

    });

    $scope.addTeam = function() {

        $scope.showAddTeamForm = true;

    }


    $scope.createTeam = function() {

        var nameData = $scope.teamName;

        $http.post("http://localhost:8081/jersey/teams/createTeam/clubId/"+$routeParams.clubId+"/teamName/"+nameData).success(function() {

            $scope.submissionSuccess=true;
            $route.reload();

        })
    }


});

