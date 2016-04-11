/**
 * Created by Sean on 09/04/2016.
 */
/**
 * Created by Sean on 06/04/2016.
 */


'use strict';

var App = angular.module('myApp',['ngRoute']);

App.config(['$routeProvider' , function($routeProvider ) {


    $routeProvider.when('/page2/:playerId', {

        templateUrl : "page2.html",
        controller: "PageCtrl"

    }).when('/page1', {

        templateUrl : "page1.html",
        controller: "MainCtrl"

    }).when('/', {

            templateUrl : "page1.html",
            controller: "MainCtrl"

    }).otherwise({

        template: '<div> This page does not exist </div>'

    });
}])

App.controller('MainCtrl', function($scope, $routeParams,$http) {

    $http.get('http://localhost:8081/jersey/players/getPlayer/' + $routeParams.playerId).
    success(function(data) {
        $scope.players = data;
        console.log(data);
    });

});

App.controller('PageCtrl', function($scope, $routeParams,$http) {
    $scope.name = 'Earth';
    console.log($routeParams.playerId);
    $scope.model ={
        message: $routeParams.message
    }
    $http.get('http://localhost:8081/jersey/players/getPlayer/' + $routeParams.playerId).
    success(function(data) {
        $scope.player = data;
        console.log(data);
    });

});
