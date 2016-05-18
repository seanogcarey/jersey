/**
 * Created by Sean on 06/04/2016.
 */


'use strict';

var App = angular.module('myApp',[])

App.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/club/:clubId/team/:teamId', {

        templateUrl : "teamView.html",
        controller: "TeamCtrl"
    }).when('/', {

        templateUrl : "teamView.html",
        controller: "Page1Ctrl"

    }).otherwise({

        template: '<div> This page does not exist </div>'

    });
}])

App.controller('Page1Ctrl', function($scope) {
    $scope.page = 'Page1';

    console.log($scope.page);


});

App.controller('TeamCtrl', function($scope, $routeParams,$http,$route) {

    $http.get('http://localhost:8081/jersey/clubs/getClub/' + $routeParams.clubId).
    success(function(data) {

        $scope.clubs = data;

    });
    $http.get('http://localhost:8081/jersey/teams/getTeam/' + $routeParams.teamId).
    success(function(data) {

        $scope.teams = data;

    });
    $http.get('http://localhost:8081/jersey/week/getWeekByTeamId/' + $routeParams.teamId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {

        $scope.weeks = data;

    });
    $http.get('http://localhost:8081/jersey/managers/getManagerByTeamId/' + $routeParams.teamId).
    success(function(data) {

        $scope.managers = data;

    });

    $scope.addManager = function() {

        $scope.showAddManagerForm = true;
    }

    $scope.addPlayer = function() {

        $scope.showAddPlayerForm = true;
    }

    $scope.createManager = function() {

        var firstNameManagerData = $scope.firstNameManager;
        var secondNameManagerData = $scope.secondNameManager;
        var phoneNumberManagerData = $scope.phoneNumberManager;
        var emailManagerData = $scope.emailManager;

        var playerId;
        var fitnessId;

        $http.post("http://localhost:8081/jersey/managers/createManager/teamId/" + $routeParams.teamId + "/FirstName/" + firstNameManagerData + "/SecondName/" + secondNameManagerData + "/phoneNumber/" + phoneNumberManagerData + "/email/" + emailManagerData).success(function () {

            $scope.submissionSuccessManager = true;
            $route.reload();

        });

    }

    $scope.createPlayer = function() {

        var firstNameData = $scope.firstName;
        var secondNameData = $scope.secondName;
        var phoneNumberData = $scope.phoneNumber;
        var emailData = $scope.email;

        var playerId;
        var fitnessId;

        $http.post("http://localhost:8081/jersey/players/createPlayer/teamId/" + $routeParams.teamId + "/FirstName/"+ firstNameData+"/SecondName/"+secondNameData+"/phoneNumber/"+phoneNumberData+"/email/"+emailData).success(function() {

            $scope.submissionSuccess=true;


            $http.get('http://localhost:8081/jersey/teams/getTeam/' + $routeParams.teamId).
            //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
            success(function(data) {
                var dataParsed = data.map.player.myArrayList;
                var max =0;

                for (var i=0;i<dataParsed.length;i++) {
                    if(dataParsed[i].map.playerId > max){
                        max = dataParsed[i].map.playerId
                    }
                }
                playerId = max;

                var initialisedValue = 0;
                //initialise all to zero
                $http.post("http://localhost:8081/jersey/fitnessTest/createFitnessTest/playerId/"+ playerId +"/chinUps/0/pushUps/0/sprint/0/kmRun/0/agility/0/workLifestyle/0/weeklyAverageTrainingCount/0").success(function() {

                    $http.get('http://localhost:8081/jersey/fitnessTest/getFitnessTestByPlayerId/' + playerId).
                    success(function(dataFitness) {

                        var dataParsed2 = dataFitness.map.fitnessTest.myArrayList;
                        for (var i=0;i<dataParsed2.length;i++) {
                            console.log("The FitnessId is " + dataParsed2[i].map.fitnessId);
                            fitnessId = dataParsed2[i].map.fitnessId;
                        }

                        $http.post("http://localhost:8081/jersey/trainingGroups/createTrainingGroup/playerId/"+playerId+"/fitnessId/"+fitnessId+"/fitnessGroup/NULL/strengthGroup/NULL/speedGroup/NULL" ).success(function() {

                            console.log("CREATED TRAINING GROUP");
                            $route.reload();

                        })


                    });


                })



            });


            $route.reload();
        })
    }


});

