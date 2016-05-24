/**
 * Created by Sean on 15/04/2016.
 */


'use strict';

var App = angular.module('myApp',[])

App.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/week/:weekId/player/:playerId', {

        templateUrl : "weekPlayerView.html",
        controller: "WeekPlayerCtrl"
    }).when('/', {

        templateUrl : "weekPlayerView.html",
        controller: "Page1Ctrl"

    }).otherwise({

        template: '<div> This page does not exist </div>'

    });
}])

App.controller('Page1Ctrl', function($scope) {
    $scope.page = 'Page1';

    console.log($scope.page);


});

App.controller('WeekPlayerCtrl', function($scope, $routeParams,$http,$route) {

    var teamId;

    $scope.submissionSuccess = false;


    $http.get('http://localhost:8081/jersey/players/getPlayer/' + $routeParams.playerId).

    success(function(data) {
        $scope.players = data;


        var dataParsed = data.map.player.myArrayList;
        console.log(dataParsed);
        for (var i=0;i<dataParsed.length;i++) {

            teamId = dataParsed[i].map.teamId;

        }

        $http.get('http://localhost:8081/jersey/teams/getTeam/' + teamId).
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

        for (var i = 0; i < dataParsed.length; i++) {
            playerBurnout = dataParsed[i].map.weeklyAverageTrainingCount;
        }

        if (playerBurnout >= 5) {

            $scope.playerBurnoutDanger = true;
        }

        if (playerBurnout >= 4 && playerBurnout < 5) {

            $scope.playerBurnoutWarning = true;

        }

        if (playerBurnout < 4) {

            $scope.playerBurnoutSafe = true;
        }
    });

    $http.get('http://localhost:8081/jersey/week/getWeek/' + $routeParams.weekId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.weeks = data;

    });

    $http.get('http://localhost:8081/jersey/session/getSessionByWeekId/' + $routeParams.weekId).
    success(function(data) {
        $scope.sessions = data;
    });


    $http.get('http://localhost:8081/jersey/extraSession/getExtraSessionByWeekIdPlayerId/weekId/' + $routeParams.weekId + '/playerId/' + $routeParams.playerId).
    success(function(data) {

        var dataParsed = data.map.extraSession.myArrayList;
        var extraSessionId;
        console.log(dataParsed);
        for (var i=0;i<dataParsed.length;i++) {
            console.log("The ExtraSessionId is " + dataParsed[i].map.extraSessionId);
            extraSessionId = dataParsed[i].map.extraSessionId;
        }
        if (extraSessionId==null){
            console.log("Creating an initialised extra session ");

            //post: Create extra session data with initialised data
            var initialisedData = "EMPTY"
            $http.post("http://localhost:8081/jersey/extraSession/createExtraSession/weekId/" + $routeParams.weekId + "/playerId/" + $routeParams.playerId + "/sessionType1/" + initialisedData+ "/sessionType2/" + initialisedData+ "/sessionType3/" + initialisedData+ "/sessionType4/" + initialisedData+ "/sessionType5/" + initialisedData+ "/sessionType6/" + initialisedData+ "/sessionType7/" + initialisedData).
            success(function() {

                $http.get('http://localhost:8081/jersey/extraSession/getExtraSessionByWeekIdPlayerId/weekId/' + $routeParams.weekId + '/playerId/' + $routeParams.playerId).
                success(function(newData) {
                    $scope.extraSessions = newData;
                });
            });
        }
        else{

                $scope.extraSessions = data;


        }


    });



    $scope.createExtraSession = function() {

        var session1Data = $scope.session1Type;
        var session2Data = $scope.session2Type;
        var session3Data = $scope.session3Type;
        var session4Data = $scope.session4Type;
        var session5Data = $scope.session5Type;
        var session6Data = $scope.session6Type;
        var session7Data = $scope.session7Type;

        if ($scope.session1Type==null){
            session1Data="EMPTY"
        }
        if ($scope.session2Type==null){
            session2Data="EMPTY"
        }
        if ($scope.session3Type==null){
            session3Data="EMPTY"
        }
        if ($scope.session4Type==null){
            session4Data="EMPTY"
        }
        if ($scope.session5Type==null){
            session5Data="EMPTY"
        }
        if ($scope.session6Type==null){
            session6Data="EMPTY"
        }
        if ($scope.session7Type==null){
            session7Data="EMPTY"
        }


        var attendanceAverageTrainingCount=0;

        $http.put("http://localhost:8081/jersey/extraSession/updateExtraSession/weekId/" + $routeParams.weekId + "/playerId/" + $routeParams.playerId + "/sessionType1/" + session1Data+"/sessionType2/"+session2Data+"/sessionType3/"+session3Data+"/sessionType4/"+session4Data+"/sessionType5/"+session5Data+"/sessionType6/"+session6Data+"/sessionType7/"+session7Data).success(function() {
            $scope.submissionSuccess=true;

            $http.put("http://localhost:8081/jersey/attendanceWeekView/updateAttendanceWeekView/weekId/" + $routeParams.weekId + "/playerId/" + $routeParams.playerId).
            success(function() {



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

                $http.put("http://localhost:8081/jersey/fitnessTest/updateFitnessTestAttendanceCount/playerId/"+$routeParams.playerId + "/weeklyAverageTrainingCount/"+ attendanceAverageTrainingCount).success(function() {
                    $scope.submissionSuccess = true;



                    $http.get('http://localhost:8081/jersey/fitnessTest/getFitnessTestByPlayerId/' + $routeParams.playerId).
                    success(function(newData) {

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
                        else if (kmRunScore == 2 ){

                            fitnessGroup = "Medium";

                        }
                        else if (kmRunScore == 2 && (attendanceAverageTrainingCount < 5 && attendanceAverageTrainingCount > 2 )){

                            fitnessGroup = "Medium";
                        }
                        else if (kmRunScore==1 || attendanceAverageTrainingCount == 1){

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

                    }); //end of get fitness



                });//end of update fitness



            }); //end of get attendance



        }); //end of update attendance




        })
    }


    var numOfSessionsWithTeamData;
    var numOfSessionsData;
    var numOfSessionsOutsideTeamData;


    $http.get('http://localhost:8081/jersey/attendanceWeekView/getAttendanceWeekViewByWeekIdPlayerId/weekId/' + $routeParams.weekId + '/playerId/' + $routeParams.playerId).
    success(function(data) {
        $scope.attendanceWeekViews = data;

        var dataParsed = data.map.attendanceWeekView.myArrayList;
        console.log(dataParsed);

        for (var i=0;i<dataParsed.length;i++) {

            numOfSessionsWithTeamData = dataParsed[i].map.numOfSessionsWithTeam;
            numOfSessionsData=   dataParsed[i].map.numOfSessions;
        }


        numOfSessionsOutsideTeamData = numOfSessionsData - numOfSessionsWithTeamData;
        $scope.numOfSessionsOutsideTeam = numOfSessionsOutsideTeamData;

        var barData = {
            labels : ["Overall Attendance Count","With Team","Outside Team"],
            datasets : [
                {

                    fillColor : "#316f66",
                    strokeColor : "#316f66",
                    data : [numOfSessionsData , , ]

                },
                {
                    fillColor : "#48A497",
                    strokeColor : "#48A497",
                    data : [ ,numOfSessionsWithTeamData, ]
                },
                {
                    fillColor : "rgba(73,188,170,0.4)",
                    strokeColor : "rgba(72,174,209,0.4)",
                    data : [ , , numOfSessionsOutsideTeamData]
                }
            ]
        }

        Chart.defaults.global.scaleOverride = true;
        Chart.defaults.global.scaleSteps = 7;
        Chart.defaults.global.scaleStartValue = 0;
        Chart.defaults.global.scaleStepWidth = 1;



        var attendanceChart = document.getElementById("attendanceChart").getContext("2d");

        new Chart(attendanceChart).Bar(barData);



    });



});

