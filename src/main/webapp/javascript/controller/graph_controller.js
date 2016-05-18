/**
 * Created by Sean on 21/04/2016.
 */

'use strict';

var app = angular.module('app',[]);

app.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/player/:playerId', {

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


    $http.get('http://localhost:8081/jersey/players/getPlayer/' + $routeParams.playerId).
    success(function(data) {
        $scope.players = data;

        var teamId;
        var dataParsed = data.map.player.myArrayList;
        console.log(dataParsed);
        for (var i=0;i<dataParsed.length;i++) {
            console.log("The TeamId is " + dataParsed[i].map.teamId);
            teamId = dataParsed[i].map.teamId;
        }

        $http.get('http://localhost:8081/jersey/teams/getTeam/' + teamId).
        //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
        success(function(data) {
            $scope.teams = data;

        });


    });


    var fitnessValue;
    var speedValue;
    var strengthValue;


    $http.get('http://localhost:8081/jersey/fitnessTest/getFitnessTestByPlayerId/' + $routeParams.playerId).
    success(function(data) {

        $scope.fitnessTests = data;

        var playerBurnoutDanger = false;
        var playerBurnoutSafe = false;
        var playerBurnoutWarning = false;

        var dataParsed = data.map.fitnessTest.myArrayList;
        var playerBurnout = 0;

        for (var i = 0; i < dataParsed.length; i++) {
            playerBurnout = dataParsed[i].map.weeklyAverageTrainingCount;
        }

        if (playerBurnout >= 5) {

            $scope.playerBurnoutDanger = true;
        }

        if (playerBurnout == 4) {

            $scope.playerBurnoutWarning = true;

        }

        if (playerBurnout < 4) {

            $scope.playerBurnoutSafe = true;
        }
    });



    $http.get('http://localhost:8081/jersey/trainingGroups/getTrainingGroupByPlayerId/'+ $routeParams.playerId).
    success(function(data) {

        console.log($routeParams.playerId);
        $scope.trainingGroups = data;

        var dataParsed = data.map.trainingGroup.myArrayList;
        var speedGroup;
        var strengthGroup;
        var fitnessGroup;

        console.log(dataParsed);
        for (var i=0;i<dataParsed.length;i++) {
            speedGroup = dataParsed[i].map.speedGroup;
            strengthGroup = dataParsed[i].map.strengthGroup;
            fitnessGroup = dataParsed[i].map.fitnessGroup;
            if(dataParsed[i].map.speedGroup=="NULL"){
                $scope.enterFitnessTestMessage = true;
            }
        }


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


/*
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

   */

        //------------


        var barData = {
            labels : ["Speed Group","Strength Group","Fitness Group"],
            datasets : [
                {

                    fillColor : "#316f66",
                    strokeColor : "#316f66",
                    data : [speedValue , , ]

                },
                {
                    fillColor : "#48A497",
                    strokeColor : "#48A497",
                    data : [ ,strengthValue, ]
                },
                {
                    fillColor : "rgba(73,188,170,0.4)",
                    strokeColor : "rgba(72,174,209,0.4)",
                    data : [ , , fitnessValue]
                }
            ]
        }

        Chart.defaults.global.scaleOverride = true;
        Chart.defaults.global.scaleSteps = 3;
        Chart.defaults.global.scaleStartValue = 0;
        Chart.defaults.global.scaleStepWidth = 1;



        // get line chart canvas
        //var buyers = document.getElementById('buyers').getContext('2d');

        var income = document.getElementById("income").getContext("2d");

        new Chart(income).Bar(barData);



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