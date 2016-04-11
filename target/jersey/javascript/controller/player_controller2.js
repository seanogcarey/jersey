/**
 * Created by Sean on 09/04/2016.
 */

var App = angular.module('myApp',['ngRoute']);

App.config(['$routeProvider' , function($routeProvider ) {


    $routeProvider.when('/page2/:playerId', {

        templateUrl : "page2.html",
        controller: "PageCtrl"

    }).when('/page1', {

        templateUrl : "page1.html",
        controller: "SingleCtrl"


    }).otherwise({

        template: '<div> This page does not exist </div>'

    });
}])

App.controller('playerCtrl', function($scope, $http) {

    $http.get('http://localhost:8081/jersey/players/getAllPlayers/').
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.players = data;
    });
});

App.controller('SingleCtrl', function($scope, $http) {

    $http.get('http://localhost:8081/jersey/players/getAllPlayers/').
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
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
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.player = data;
        console.log(data);
    });

});