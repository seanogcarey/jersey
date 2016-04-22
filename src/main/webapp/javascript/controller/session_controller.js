/**
 * Created by Sean on 20/04/2016.
 */


'use strict';

var App = angular.module('myApp',[])

App.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/session/:sessionId/week/:weekId/player/:playerId', {

        templateUrl : "attendanceTableView.html",
        controller: "SessionCtrl"
    }).when('/', {

        templateUrl : "attendanceTableView.html",
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

App.controller('SessionCtrl', function($scope, $routeParams,$http,$route) {

    var teamId;

    $http.get('http://localhost:8081/jersey/players/getPlayer/' + $routeParams.playerId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.players = data;

    });

    $http.get('http://localhost:8081/jersey/week/getWeek/' + $routeParams.weekId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.weeks = data;

    });

    $http.get('http://localhost:8081/jersey/players/getPlayer/' + $routeParams.playerId).
    success(function(data) {
        $scope.players = data;
    });

    $http.get('http://localhost:8081/jersey/session/getSessionById/' + $routeParams.sessionId).
    success(function(data) {
        $scope.sessions = data;
        console.log(data);
    });


    $http.get('http://localhost:8081/jersey/attendanceTable/getAttendanceTableBySessionIdPlayerId/sessionId/'+ $routeParams.sessionId + '/playerId/' + $routeParams.playerId).
    success(function(data) {
        //$scope.extraSessions = data;
        var dataParsed = data.map.attendanceTable.myArrayList;
        var attendanceId;
        console.log(dataParsed);
        for (var i=0;i<dataParsed.length;i++) {
            console.log("The SessionId is " + dataParsed[i].map.attendanceId);
            attendanceId = dataParsed[i].map.attendanceId;
        }
        if (attendanceId==null){
            console.log("Creating an initialised attendance ");

            //post: Create with initialised data
            var presentStatus = "False"
            var reasonOfAbsenceStatus = "NULL"
            console.log("Creating new data!");
            //http://localhost:8081/jersey/attendanceTable/createAttendanceTable/weekId/1/playerId/3/sessionId/1/present/False/reasonOfAbsence/College Training
            $http.post("http://localhost:8081/jersey/attendanceTable/createAttendanceTable/weekId/" + $routeParams.weekId + "/playerId/" + $routeParams.playerId +
                        "/sessionId/" + $routeParams.sessionId +"/present/" + presentStatus + "/reasonOfAbsence/" + reasonOfAbsenceStatus).
            success(function() {

                $http.get('http://localhost:8081/jersey/attendanceTable/getAttendanceTableBySessionIdPlayerId/sessionId/'+ $routeParams.sessionId + '/playerId/' + $routeParams.playerId).
                success(function(newData) {
                    $scope.attendanceTables = newData;
                });
            });
        }
        else{

                 console.log("Getting data we have already");
                $scope.attendanceTables = data;
        }


    });




    $scope.updateAttendance= function() {
        var presentData = $scope.presentStatus;
        var reasonOfAbsenceData =  $scope.reasonOfAbsence;
        console.log(presentData);
        console.log(reasonOfAbsenceData);

        $http.put("http://localhost:8081/jersey/attendanceTable/updateAttendanceTable/playerId/" + $routeParams.playerId + "/sessionId/" + $routeParams.sessionId
            +"/present/" + presentData + "/reasonOfAbsence/" + reasonOfAbsenceData).success(function(){
            $scope.submissionSuccess=true;

            $http.put("http://localhost:8081/jersey/attendanceWeekView/updateAttendanceWeekView/weekId/" + $routeParams.weekId + "/playerId/" + $routeParams.playerId).
            success(function() {
                $route.reload();

            })

        });



    }



});

