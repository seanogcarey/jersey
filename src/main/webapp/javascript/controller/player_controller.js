/**
 * Created by Sean on 11/04/2016.
 */
/**
 * Created by Sean on 11/04/2016.
 */
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

    /*
    $http.get('http://localhost:8081/jersey/teams/getTeam/' + $routeParams.teamId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.teams = data;
    });
    */
    $http.get('http://localhost:8081/jersey/players/getPlayer/' + $routeParams.playerId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.players = data;
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


        console.log("before for loop");
        console.log("data length :" + json.length);

        var dataArray = {"d":[{"id":28,"class":"Sweden"}, {"id":56,"class":"USA"}, {"id":89,"class":"England"}]};

        var parsedJSON = dataArray.d;
        for (var i=0;i<parsedJSON.length;i++) {
            console.log((parsedJSON[i].id));
        }
        /*
        for(var i = 0; i < json.length; i++) {
            var obj = json[i];

            console.log("in for loop now");
            console.log(json);
        }
        */



    });


});

