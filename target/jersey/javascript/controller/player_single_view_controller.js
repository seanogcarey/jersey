/**
 * Created by Sean on 09/04/2016.
 */

var App = angular.module('myApp',['ngRoute']);

App.config(['$routeProvider' , function($routeProvider ) {


    $routeProvider.when('/', {templateUrl: 'views/PlayerSingleView.jsp'})
        .when('/single/:playerId', {

        templateUrl : "test.html",
        controller: "playerSingleCtrl"

    })
}])

    App.controller('playerSingleCtrl', function($scope,$routeParams ,$http) {

    $http.get('http://localhost:8081/jersey/players/getPlayer/' + $routeParams.playerId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.players = data;
    });

});
