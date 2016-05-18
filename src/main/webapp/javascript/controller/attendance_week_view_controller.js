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

    console.log($scope.page);

});

App.controller('AttendanceWeekViewCtrl', function($scope, $routeParams,$http) {

    $http.get('http://localhost:8081/jersey/attendanceWeekView/getAttendanceWeekViewByWeekId/' + $routeParams.weekId).
    success(function(data) {

        $scope.attendanceWeekViews = data;


    });

    $http.get('http://localhost:8081/jersey/week/getWeek/' + $routeParams.weekId).

    success(function(data) {
        $scope.weeks = data;


        var teamId;

        var dataParsed = data.map.week.myArrayList;
        console.log(dataParsed);
        for (var i=0;i<dataParsed.length;i++) {
            teamId = dataParsed[i].map.teamId;
        }

        $http.get('http://localhost:8081/jersey/teams/getTeam/' + teamId).

        success(function(data) {
            $scope.teams = data;

        });


    });




});

