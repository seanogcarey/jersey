/**
 * Created by Sean on 22/04/2016.
 */


'use strict';

var App = angular.module('myApp',[])

App.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/player/:playerId', {

        templateUrl : "playerFitnessTest.html",
        controller: "PlayerFitnessCtrl"

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


App.controller('PlayerFitnessCtrl', function($scope, $routeParams,$http) {

    $http.get('http://localhost:8081/jersey/players/getPlayer/' + $routeParams.playerId).
    success(function(data) {
        $scope.players = data;
    });

    $http.get('http://localhost:8081/jersey/fitnessTest/getFitnessTestByPlayerId/' + $routeParams.playerId).
    success(function(data) {
        $scope.fitnessTests = data;
    });

    $scope.updateFitnessTest= function() {


        var kmRunData = $scope.kmRunStatus;
        var agilityData = $scope.agilityStatus;
        var sprintData = $scope.sprintStatus;
        var pushUpsData = $scope.pushUpsStatus;
        var chinUpsData = $scope.chinUpsStatus;
        var workLifestyleData = $scope.workLifestyleStatus;


        var attendanceAverageTrainingCount=0;

        var presentData = $scope.presentStatus;
        var reasonOfAbsenceData =  $scope.reasonOfAbsence;
        console.log("KM RUN:" + kmRunData);
        console.log(reasonOfAbsenceData);

        $http.get('http://localhost:8081/jersey/attendanceWeekView/getAttendanceWeekViewByPlayerId/' + $routeParams.playerId).
        success(function(data) {
            $scope.attendanceWeekViews = data;
        });

        $http.put("http://localhost:8081/jersey/fitnessTest/updateFitnessTest/playerId/"+$routeParams.playerId + "/chinUps/"+chinUpsData+"/pushUps/"+pushUpsData+"/sprint/"+sprintData+"/kmRun/"+kmRunData+"/agility/"+agilityData+"/workLifestyle/"+workLifestyleData+"/weeklyAverageTrainingCount/"+ attendanceAverageTrainingCount).success(function(){
            $scope.submissionSuccess=true;
            $http.put("http://localhost:8081/jersey/attendanceWeekView/updateAttendanceWeekView/weekId/" + $routeParams.weekId + "/playerId/" + $routeParams.playerId).
            success(function() {
                $route.reload();

            })

        });

    }




});

