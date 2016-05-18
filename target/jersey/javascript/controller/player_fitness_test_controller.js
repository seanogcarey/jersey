/**
 * Created by Sean on 22/04/2016.
 */


'use strict';

var App = angular.module('myApp',[])

App.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/player/:playerId', {

        templateUrl : "playerFitnessTest.html",
        controller: "PlayerFitnessCtrl"

    }).when('/', {

        templateUrl : "teamFitnessTest.html",
        controller: "Page1Ctrl"

    }).otherwise({

        template: '<div> This page does not exist </div>'

    });
}])

App.controller('Page1Ctrl', function($scope) {
    $scope.page = 'Page1';
    //console.log($routeParams.teamId);
    //$http.get('http://localhost:8081/jersey/teams/getTeam/' + $routeParams.teamId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    //success(function(data) {
    //$scope.page = data;
    console.log($scope.page);
    //});

});


App.controller('PlayerFitnessCtrl', function($scope, $routeParams,$http,$route) {

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

    $http.get('http://localhost:8081/jersey/fitnessTest/getFitnessTestByPlayerId/' + $routeParams.playerId).
    success(function(data) {
        $scope.fitnessTests = data;

        var playerBurnoutDanger = false;
        var playerBurnoutSafe = false;
        var playerBurnoutWarning = false;

        var dataParsed = data.map.fitnessTest.myArrayList;
        var playerBurnout = 0;

        for (var i=0;i<dataParsed.length;i++) {
            playerBurnout = dataParsed[i].map.weeklyAverageTrainingCount;
        }

        if (playerBurnout >= 5){

            $scope.playerBurnoutDanger=true;
        }

        if (playerBurnout == 4){

            $scope.playerBurnoutWarning=true;

        }

        if (playerBurnout < 4 ){

            $scope.playerBurnoutSafe=true;
        }

        // line chart data
        var buyerData = {
            labels : ["Fitness","Speed","Strength"],
            datasets : [
                {
                    fillColor : "rgba(172,194,132,0.4)",
                    strokeColor : "#ACC26D",
                    pointColor : "#fff",
                    pointStrokeColor : "#9DB86D",
                    data : [3,3,1]
                }
            ]
        }
        // get line chart canvas
        var buyers = document.getElementById('buyers').getContext('2d');


    });

    $scope.updateFitnessTest= function() {


        var kmRunData = $scope.kmRunStatus;
        var agilityData = $scope.agilityStatus;
        var sprintData = $scope.sprintStatus;
        var pushUpsData = $scope.pushUpsStatus;
        var chinUpsData = $scope.chinUpsStatus;
        var workLifestyleData = $scope.workLifestyleStatus;


        var attendanceAverageTrainingCount=0;

        var presentData = $scope.presentStatus;
        var reasonOfAbsenceData =  $scope.reasonOfAbsence;
        console.log("KM RUN:" + kmRunData);
        console.log(reasonOfAbsenceData);

        $http.get('http://localhost:8081/jersey/attendanceWeekView/getAttendanceWeekViewByPlayerId/' + $routeParams.playerId).
        success(function(data) {

            var dataParsed = data.map.attendanceWeekView.myArrayList;
            var sum = 0;

            for (var i=0;i<dataParsed.length;i++) {
                console.log("The number of sessions is " + dataParsed[i].map.numOfSessions);
                sum = sum + dataParsed[i].map.numOfSessions;
            }
            attendanceAverageTrainingCount= sum/dataParsed.length;
            console.log("AVERAGE : " + attendanceAverageTrainingCount);



            $http.put("http://localhost:8081/jersey/fitnessTest/updateFitnessTest/playerId/"+$routeParams.playerId + "/chinUps/"+chinUpsData+"/pushUps/"+pushUpsData+"/sprint/"+sprintData+"/kmRun/"+kmRunData+"/agility/"+agilityData+"/workLifestyle/"+workLifestyleData+"/weeklyAverageTrainingCount/"+ attendanceAverageTrainingCount).success(function(){
                $scope.submissionSuccess=true;

                $http.get('http://localhost:8081/jersey/fitnessTest/getFitnessTestByPlayerId/' + $routeParams.playerId).
                success(function(newData) {
                    //$scope.fitnessTests = data;


                    var kmRunScore;
                    var agilityScore;
                    var pushUpsScore;
                    var chinUpsScore;
                    var sprintScore;

                    var workLifestyleScore;


                    var dataParsed2 = newData.map.fitnessTest.myArrayList;

                    for (var i=0;i<dataParsed2.length;i++) {

                        //console.log("Sprint Score = " + dataParsed2[i].map.sprint);
                        kmRunScore = dataParsed2[i].map.kmRun;
                        agilityScore = dataParsed2[i].map.agility;
                        pushUpsScore = dataParsed2[i].map.pushUps;
                        chinUpsScore = dataParsed2[i].map.chinUps;
                        sprintScore = dataParsed2[i].map.sprint;
                        workLifestyleScore = dataParsed2[i].map.workLifestyle;

                    }

                    var fitnessGroup = "NULL";
                    var strengthGroup = "NULL";
                    var speedGroup = "NULL";

                    //fitness group:

                    if (kmRunScore == 3 || attendanceAverageTrainingCount == 5)
                    {
                        fitnessGroup = "High";
                    }
                    else if (kmRunScore==2 && workLifestyleScore == 5){

                        fitnessGroup = "High";
                    }
                    else if (kmRunScore == 2 && (attendanceAverageTrainingCount < 5 && attendanceAverageTrainingCount > 2 )){

                        fitnessGroup = "Medium";
                    }
                    else if (kmRunScore==1 || attendanceAverageTrainingCount ==1){

                        fitnessGroup = "Low;"
                    }
                    else if (attendanceAverageTrainingCount <= 2 && workLifestyleScore < 3 ){

                        fitnessGroup = "Low;"
                    }


                    //Speed Group

                    if(sprintScore ==3 || agilityScore == 3){

                        speedGroup = "High";
                    }
                    else if (sprintScore==2 && agilityScore ==2){

                        speedGroup = "Medium";
                    }
                    else if (sprintScore == 1 || agilityScore ==1){

                        speedGroup = "Low"
                    }

                    //Strength

                    if(pushUpsScore ==3 || chinUpsScore == 3){

                        strengthGroup = "High";
                    }
                    else if (pushUpsScore==2 && chinUpsScore ==2){

                        strengthGroup = "Medium";
                    }
                    else if (pushUpsScore == 1 || chinUpsScore ==1){

                        strengthGroup = "Low"
                    }


                    $http.put("http://localhost:8081/jersey/trainingGroups/updateTrainingGroupByPlayerId/playerId/"+$routeParams.playerId+"/fitnessGroup/"+speedGroup+"/strengthGroup/"+strengthGroup+"/speedGroup/"+speedGroup).
                    success(function() {

                        $route.reload();

                    })

                });



            });

        });



    }




});

