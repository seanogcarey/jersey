/**
 * Created by Sean on 06/04/2016.
 */

'use strict';

var App = angular.module('myApp',['ui.router']);

App.config(function($stateProvider, $urlRouterProvider){

    // For any unmatched url, send to /route1
    $urlRouterProvider.otherwise("/")

    $stateProvider
        .state('route1', {
            url: "/route1",
            templateUrl: "route1.jsp"
        })
        .state('route1.list', {
            url: "/list",
            templateUrl: "route1.list.jsp",
            controller: function($scope){
                $scope.items = ["A", "List", "Of", "Items"];
            }
        })
        /*
        .state('route1.map', {
            url: "/map/:country/:county/:city",
            templateUrl: "route1.map.jsp",
            controller: function($scope,$routeParams){
                $scope.items = [$routeParams.country, $routeParams.county, $routeParams.city];
            }
        })

        */
        .state('route2', {
            url: "/route2",
            templateUrl: "route2.jsp"
        })
        .state('route2.list', {
            url: "/list",
            templateUrl: "route2.list.jsp",
            controller: function($scope){
                $scope.things = ["A", "Set", "Of", "Things"];
            }
        })
})