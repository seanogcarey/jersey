/**
 * Created by Sean on 05/04/2016.
 */

'use strict';

var App = angular.module('myApp',[]);

App.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/page1', {

        templateUrl : "page1.html"

    }).when('/page2', {

        templateUrl : "page2.html"

    }).when('/', {

            templateUrl : "page1.html"

    }).otherwise({

        template: '<div> This page does not exist </div>'

    });
}])

App.controller('MainCtrl', function($scope) {
    $scope.name = 'World';
});
