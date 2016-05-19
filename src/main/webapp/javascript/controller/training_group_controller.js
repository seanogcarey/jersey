/**
 * Created by Sean on 21/04/2016.
 */

'use strict';

var app = angular.module('app',[]);

app.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/player/:playerId', {

        templateUrl : "trainingGroupView.html",
        controller: "ChartCtrl"
    }).when('/', {

        templateUrl : "trainingGroupView.html",
        controller: "Page1Ctrl"

    }).otherwise({

        template: '<div> This page does not exist </div>'

    });
}])

app.controller('Page1Ctrl', function($scope) {
    $scope.page = 'Page1';

    console.log($scope.page);


});


app.controller('ChartCtrl', function($scope,$http,$routeParams) {


    $http.get('http://localhost:8081/jersey/players/getPlayer/' + $routeParams.playerId).
    success(function(data) {

        $scope.players = data;

        var teamId;
        var dataParsed = data.map.player.myArrayList;

        for (var i=0;i<dataParsed.length;i++) {

            teamId = dataParsed[i].map.teamId;

        }

        $http.get('http://localhost:8081/jersey/teams/getTeam/' + teamId).
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



        $scope.trainingGroups = data;

        var dataParsed = data.map.trainingGroup.myArrayList;
        var speedGroup;
        var strengthGroup;
        var fitnessGroup;


        for (var i=0;i<dataParsed.length;i++) {

            speedGroup = dataParsed[i].map.speedGroup;
            strengthGroup = dataParsed[i].map.strengthGroup;
            fitnessGroup = dataParsed[i].map.fitnessGroup;

            if(dataParsed[i].map.speedGroup=="NULL"){
                $scope.enterFitnessTestMessage = true;
            }
        }


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


        var groupChart = document.getElementById("groupChart").getContext("2d");

        new Chart(groupChart).Bar(barData);


    });




});