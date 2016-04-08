/**
 * Created by Sean on 06/04/2016.
 */


'use strict';

var App = angular.module('myApp',[]);

App.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/:teamId', {

        templateUrl : "page2.html",
        controller: "PageCtrl"

    }).when('/', {

        templateUrl : "page1.html"

    }).otherwise({

        template: '<div> This page does not exist </div>'

    });
}])

App.controller('MainCtrl', function($scope, $routeParams) {
    $scope.name = 'World';
    $scope.model ={
        message: $routeParams.message
    }
});

App.controller('PageCtrl', function($scope, $routeParams,$http) {
    $scope.name = 'Earth';
    console.log($routeParams.teamId);
    $scope.model ={
        message: $routeParams.message
    }
    $http.get('http://localhost:8081/jersey/teams/getTeam/' + $routeParams.teamId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.teams = data;
        console.log(data);
    });

});
