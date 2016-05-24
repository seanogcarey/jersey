/**
 * Created by Sean on 20/04/2016.
 */


'use strict';

var App = angular.module('myApp',[])

App.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/session/:sessionId/week/:weekId/player/:playerId', {

        templateUrl : "attendanceTableView.html",
        controller: "SessionCtrl"
    }).when('/', {

        templateUrl : "attendanceTableView.html",
        controller: "Page1Ctrl"

    }).otherwise({

        template: '<div> This page does not exist </div>'

    });
}])

App.controller('Page1Ctrl', function($scope) {
    $scope.page = 'Page1';
    console.log($scope.page);


});

App.controller('SessionCtrl', function($scope, $routeParams,$http,$route) {

    var teamId;

    $http.get('http://localhost:8081/jersey/players/getPlayer/' + $routeParams.playerId).
    success(function(data) {
        $scope.players = data;

        var dataParsed = data.map.player.myArrayList;
        console.log(dataParsed);
        for (var i=0;i<dataParsed.length;i++) {
            console.log("The TeamId is " + dataParsed[i].map.teamId);
            teamId = dataParsed[i].map.teamId;
        }
        $http.get('http://localhost:8081/jersey/teams/getTeam/' + teamId).

        success(function(data) {
            $scope.teams = data;

        });

    });

    $http.get('http://localhost:8081/jersey/week/getWeek/' + $routeParams.weekId).
    success(function(data) {
        $scope.weeks = data;

    });

    $http.get('http://localhost:8081/jersey/session/getSessionById/' + $routeParams.sessionId).
    success(function(data) {

        $scope.sessions = data;

    });


    $http.get('http://localhost:8081/jersey/attendanceTable/getAttendanceTableBySessionIdPlayerId/sessionId/'+ $routeParams.sessionId + '/playerId/' + $routeParams.playerId).
    success(function(data) {
        var dataParsed = data.map.attendanceTable.myArrayList;
        var attendanceId;
        console.log(dataParsed);
        for (var i=0;i<dataParsed.length;i++) {
            console.log("The SessionId is " + dataParsed[i].map.attendanceId);
            attendanceId = dataParsed[i].map.attendanceId;
        }
        if (attendanceId==null){
            console.log("Creating an initialised attendance ");

            //post: Create with initialised data
            var presentStatus = "False"
            var reasonOfAbsenceStatus = "EMPTY"

            console.log("Creating new data!");
            $http.post("http://localhost:8081/jersey/attendanceTable/createAttendanceTable/weekId/" + $routeParams.weekId + "/playerId/" + $routeParams.playerId +
                        "/sessionId/" + $routeParams.sessionId +"/present/" + presentStatus + "/reasonOfAbsence/" + reasonOfAbsenceStatus).
            success(function() {

                $http.get('http://localhost:8081/jersey/attendanceTable/getAttendanceTableBySessionIdPlayerId/sessionId/'+ $routeParams.sessionId + '/playerId/' + $routeParams.playerId).
                success(function(newData) {
                    $scope.attendanceTables = newData;
                });
            });
        }
        else{

                 console.log("Getting data we have already");
                $scope.attendanceTables = data;
        }


    });




    $scope.updateAttendance= function() {
        var presentData = $scope.presentStatus;
        var reasonOfAbsenceData =  $scope.reasonOfAbsence;

        if($scope.reasonOfAbsence==null){
            reasonOfAbsenceData="EMPTY";
        }

        var attendanceAverageTrainingCount=0;


        $http.put("http://localhost:8081/jersey/attendanceTable/updateAttendanceTable/playerId/" + $routeParams.playerId + "/sessionId/" + $routeParams.sessionId
            +"/present/" + presentData + "/reasonOfAbsence/" + reasonOfAbsenceData).success(function(){

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
                            else if (kmRunScore == 2 ){

                                fitnessGroup = "Medium";

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

                        }); //end of get fitness



                    });//end of update fitness



                }); //end of get attendance







            })

        });



    }



});

