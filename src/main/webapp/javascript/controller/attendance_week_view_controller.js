/**
 * Created by Sean on 15/04/2016.
 */



'use strict';

var App = angular.module('myApp',[])

App.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/week/:weekId', {

        templateUrl : "attendanceWeekViewView.html",
        controller: "AttendanceWeekViewCtrl"

    }).when('/', {

        templateUrl : "attendanceWeekViewView.html",
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

App.controller('AttendanceWeekViewCtrl', function($scope, $routeParams,$http) {

    $http.get('http://localhost:8081/jersey/attendanceWeekView/getAttendanceWeekViewByWeekId/' + $routeParams.weekId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.attendanceWeekViews = data;
        console.log(data);

        /*
        var dataParsed = data.map.attendanceWeekView.myArrayList;
        console.log(dataParsed);
        for (var i=0;i<dataParsed.length;i++) {
            console.log("The player id is " + dataParsed[i].map.playerId);
        }
        */

    });

    $http.get('http://localhost:8081/jersey/week/getWeek/' + $routeParams.weekId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.weeks = data;
    });


    $http.get('http://localhost:8081/jersey/week/getWeek/' + $routeParams.weekId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.weeks = data;
    });



});

