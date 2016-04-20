/**
 * Created by Sean on 15/04/2016.
 */


'use strict';

var App = angular.module('myApp',[])

App.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/week/:weekId/player/:playerId', {

        templateUrl : "weekPlayerView.html",
        controller: "WeekPlayerCtrl"
    }).when('/', {

        templateUrl : "weekPlayerView.html",
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

App.controller('WeekPlayerCtrl', function($scope, $routeParams,$http,$route) {

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


    });

    $http.get('http://localhost:8081/jersey/week/getWeek/' + $routeParams.weekId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.weeks = data;

    });
    /*
    $http.get('http://localhost:8081/jersey/players/getPlayer/' + $routeParams.playerId).
    success(function(data) {
        $scope.players = data;
    });

    $http.get('http://localhost:8081/jersey/attendanceWeekView/getAttendanceWeekViewByPlayerId/' + $routeParams.playerId).
    success(function(data) {
        $scope.attendanceWeekViews = data;
    });
*/

    $http.get('http://localhost:8081/jersey/session/getSessionByWeekId/' + $routeParams.weekId).
    success(function(data) {
        $scope.sessions = data;
    });

    $http.get('http://localhost:8081/jersey/extraSession/getExtraSessionByWeekIdPlayerId/weekId/' + $routeParams.weekId + '/playerId/' + $routeParams.playerId).
    success(function(data) {
        //$scope.extraSessions = data;
        var dataParsed = data.map.extraSession.myArrayList;
        var extraSessionId;
        console.log(dataParsed);
        for (var i=0;i<dataParsed.length;i++) {
            console.log("The ExtraSessionId is " + dataParsed[i].map.extraSessionId);
            extraSessionId = dataParsed[i].map.extraSessionId;
        }
        if (extraSessionId==null){
            console.log("Creating an initialised extra session ");

            //post: Create extra session data with initialised data
            var initialisedData = "EMPTY"
            $http.post("http://localhost:8081/jersey/extraSession/createSession/weekId/" + $routeParams.weekId + "/playerId/" + $routeParams.playerId + "/sessionType1/" + initialisedData).
            success(function() {

                $http.get('http://localhost:8081/jersey/extraSession/getExtraSessionByWeekIdPlayerId/weekId/' + $routeParams.weekId + '/playerId/' + $routeParams.playerId).
                success(function(newData) {
                    $scope.extraSessions = newData;
                });
            });
        }
        else{

                $scope.extraSessions = data;


        }
        /*
        $http.get('http://localhost:8081/jersey/extraSession/getExtraSessionByWeekIdPlayerId/weekId/' + $routeParams.weekId + '/playerId/' + $routeParams.playerId).
        success(function(newData) {
            $scope.extraSessions = newData;
        });
        */

        console.log("Extra Session ID: " + extraSessionId);

    });

    /*
    $http.get('http://localhost:8081/jersey/extraSession/getExtraSessionByWeekIdPlayerId/weekId/' + $routeParams.weekId + '/playerId/' + $routeParams.playerId).
    success(function(newData) {
        $scope.extraSessions = newData;
    });
    */


    $scope.createExtraSession = function() {
        var postData = $scope.text
        //updateExtraSession/weekId/{weekId}/playerId/{playerId}/sessionType1/{sessionType1}
        $http.put("http://localhost:8081/jersey/extraSession/updateExtraSession/weekId/" + $routeParams.weekId + "/playerId/" + $routeParams.playerId + "/sessionType1/" + postData).success(function() {
            $scope.submissionSuccess=true;

            $http.put("http://localhost:8081/jersey/attendanceWeekView/updateAttendanceWeekView/weekId/" + $routeParams.weekId + "/playerId/" + $routeParams.playerId).
            success(function() {
                $route.reload();

            });

            //$route.reload();

        })
    }

    $http.get('http://localhost:8081/jersey/attendanceWeekView/getAttendanceWeekViewByWeekIdPlayerId/weekId/' + $routeParams.weekId + '/playerId/' + $routeParams.playerId).
    success(function(data) {
        $scope.attendanceWeekViews = data;

    });


});

