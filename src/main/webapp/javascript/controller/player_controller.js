/**
 * Created by Sean on 06/04/2016.
 */


'use strict';

var App = angular.module('myApp',[])

App.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/player/:playerId', {

        templateUrl : "playerView.html",
        controller: "PlayerCtrl"
    }).when('/', {

        templateUrl : "playerView.html",
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

App.controller('PlayerCtrl', function($scope, $routeParams,$http) {

    var teamId;

    $http.get('http://localhost:8081/jersey/players/getPlayer/' + $routeParams.playerId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.players = data;


        var dataParsed = data.map.player.myArrayList;
        console.log(dataParsed);
        for (var i=0;i<dataParsed.length;i++) {
            console.log("The TeamId is " + dataParsed[i].map.teamId);
            teamId = dataParsed[i].map.teamId;
        }

        $http.get('http://localhost:8081/jersey/teams/getTeam/' + teamId).
        //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
        success(function(data) {
            $scope.teams = data;

        });

        $http.get('http://localhost:8081/jersey/week/getWeekByTeamId/' + teamId).
        //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
        success(function(data) {
            $scope.weeks = data;

        });

        $http.get('http://localhost:8081/jersey/week/getWeekByTeamId/' + teamId).
        //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
        success(function(data) {
            $scope.sessions = data;

        });

    });

    /*
    $http.get('http://localhost:8081/jersey/teams/getTeam/' + teamId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.teams = data;

    });
    */

    $http.get('http://localhost:8081/jersey/fitnessTest/getFitnessTestByPlayerId/' + $routeParams.playerId).
    success(function(data) {

        $scope.fitnessTests = data;

        var playerBurnoutDanger = false;
        var playerBurnoutSafe = false;
        var playerBurnoutWarning = false;

        var dataParsed = data.map.fitnessTest.myArrayList;
        var playerBurnout = 0;

        for (var i = 0; i < dataParsed.length; i++) {
            playerBurnout = dataParsed[i].map.weeklyAverageTrainingCount;
        }

        if (playerBurnout >= 5) {

            $scope.playerBurnoutDanger = true;
        }

        if (playerBurnout == 4) {

            $scope.playerBurnoutWarning = true;

        }

        if (playerBurnout < 4) {

            $scope.playerBurnoutSafe = true;
        }
    });



    $http.get('http://localhost:8081/jersey/attendanceWeekView/getAttendanceWeekViewByPlayerId/' + $routeParams.playerId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.attendanceWeekViews = data;
        console.log(data);
        var json = data;

        var dataParsed = data.map.attendanceWeekView.myArrayList;
        console.log(dataParsed);
        for (var i=0;i<dataParsed.length;i++) {
            console.log("The weekID is " + dataParsed[i].map.weekId);
        }

        /*
            ///////////////////////////// average
         var sum = 0;
         for (var i=0;i<dataParsed.length;i++) {
         console.log("The weekID is " + dataParsed[i].map.weekId);
         sum = sum + dataParsed[i].map.weekId;
         }

         var average = sum/dataParsed.length;
         console.log("AVERAGE : " + average);

        /////////////////////////////////////////////////////////
        console.log("before for loop");
        console.log("data length :" + json.length);

        var dataArray = {"d":[{"id":28,"class":"Sweden"}, {"id":56,"class":"USA"}, {"id":89,"class":"England"}]};

        var parsedJSON = dataArray.d;
        for (var i=0;i<parsedJSON.length;i++) {
            console.log((parsedJSON[i].id));
        }

        for(var i = 0; i < json.length; i++) {
            var obj = json[i];

            console.log("in for loop now");
            console.log(json);
        }
        */



    });


});

