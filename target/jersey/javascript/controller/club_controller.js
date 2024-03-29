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

    console.log($scope.page);

});

App.controller('ClubCtrl', function($scope, $routeParams,$http,$route) {


    $scope.newName = "";
    console.log($routeParams.teamId);
    $http.get('http://localhost:8081/jersey/clubs/getClub/' + $routeParams.clubId).
    success(function(data) {

        $scope.clubs = data;


    });


    $scope.addClub = function() {

        $scope.showAddClubForm = true;

    }

    $scope.createClub = function() {

        var nameData = $scope.clubName;
        var emailData = $scope.email;
        var addressData =  $scope.address;
        var sportData = $scope.sport;
        var clubContactNumberData = $scope.clubContactNumber;


        $http.post("http://localhost:8081/jersey/clubs/createClub/" + nameData + "/email/" + emailData + "/address/"+ addressData+ "/sport/" + sportData + "/clubContactNumber/" + clubContactNumberData ).success(function() {

            $scope.submissionSuccess=true;
            $route.reload();

        })
    }

});

App.controller('ClubSingleCtrl', function($scope, $routeParams,$http) {

    $http.get('http://localhost:8081/jersey/clubs/getClub/' + $routeParams.clubId).
    success(function(data) {

        $scope.clubs = data;

    });
    $http.get('http://localhost:8081/jersey/teams/getTeamByClub/' + $routeParams.clubId).
    success(function(data) {

        $scope.teams = data;

    });

});

