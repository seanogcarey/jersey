/**
 * Created by Sean on 21/04/2016.
 */

'use strict';

var app = angular.module('app',[]);

app.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/team/:teamId', {

        templateUrl : "graphView.html",
        controller: "ChartCtrl"
    }).when('/', {

        templateUrl : "graphView.html",
        controller: "Page1Ctrl"

    }).otherwise({

        template: '<div> This page does not exist </div>'

    });
}])

app.controller('Page1Ctrl', function($scope) {
    $scope.page = 'Page1';
    //console.log($routeParams.teamId);
    //$http.get('http://localhost:8081/jersey/teams/getTeam/' + $routeParams.teamId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    //success(function(data) {
    //$scope.page = data;
    console.log($scope.page);
    //});

});


app.controller('ChartCtrl', function($scope,$http,$routeParams) {



    console.log("Does this work:" + $routeParams.teamId);
    var fitnessValue;
    var speedValue;
    var strengthValue;


    $http.get('http://localhost:8081/jersey/trainingGroups/getTrainingGroup/2').
    success(function(data) {
        //$scope.trainingGroup = data;

        var dataParsed = data.map.trainingGroup.myArrayList;
        var speedGroup;
        var strengthGroup;
        var fitnessGroup;

        console.log(dataParsed);
        for (var i=0;i<dataParsed.length;i++) {
            speedGroup = dataParsed[i].map.speedGroup;
            strengthGroup = dataParsed[i].map.strengthGroup;
            fitnessGroup = dataParsed[i].map.fitnessGroup;
        }

        var username = "Agent006";

        if(username == "Agent006")
            console.log("Welcome special agent 007");
        else
            console.log("Access Denied!");


        console.log("finess Group:" + fitnessGroup);
        //speed Group:
        if (speedGroup=="High"){
            speedValue=3;
        }
        if (speedGroup=="Medium"){
            speedValue=2;
        }
        if (speedGroup=="Low"){
            speedValue =1;
        }

        //strength Group
        if (strengthGroup=="High"){
            strengthValue=3;
        }
        if (strengthGroup=="Medium"){
            strengthValue=2;
        }
        if (strengthGroup=="Low"){
            strengthValue =1;
        }

        //fitness Group
        if (fitnessGroup=="High"){
            fitnessValue=3;
        }
        if (fitnessGroup=="Medium"){
            fitnessValue=2;
        }
        if (fitnessGroup=="Low"){
            fitnessValue =1;
        }

        $scope.hello = "Hello, World";


        var buyerData = {
            labels : ["","Fitness","Speed","Strength"],
            datasets : [
                {
                    fillColor : "rgba(172,194,132,0.4)",
                    strokeColor : "#ACC26D",
                    pointColor : "#fff",
                    pointStrokeColor : "#9DB86D",
                    data : [0,fitnessValue,speedValue,strengthValue,3]
                }
            ]
        }
        // get line chart canvas
        var buyers = document.getElementById('buyers').getContext('2d');
        // draw line chart

        new Chart(buyers).Line(buyerData);


    });


    /*

    $scope.canvas = document.getElementById("myPieChart");
    $scope.ctx = $scope.canvas.getContext("2d");
    $scope.data = [{
        value: 300,
        color: "#F7464A",
        highlight: "#FF5A5E",
        label: "Red"
    }, {
        value: 50,
        color: "#46BFBD",
        highlight: "#5AD3D1",
        label: "Green"
    }, {
        value: 100,
        color: "#FDB45C",
        highlight: "#FFC870",
        label: "Yellow"
    }];
    $scope.myPieChart = new Chart($scope.ctx).Pie($scope.data,{});
    $scope.chartClick = function (event) {
        console.log('chartClick');
        console.log($scope.myPieChart.getSegmentsAtEvent(event));
    }
    $scope.canvas.onclick = $scope.chartClick;
    */




});