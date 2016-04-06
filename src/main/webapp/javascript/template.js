/**
 * Created by Sean on 06/04/2016.
 */


'use strict';

var App = angular.module('myApp',[]);

App.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/page1', {

        templateUrl : "page1.html"

    }).when('/page2', {

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

App.controller('Page2Ctrl', function($scope, $routeParams) {
    $scope.name = 'Earth';
    $scope.model ={
        message: $routeParams.message
    }
});
