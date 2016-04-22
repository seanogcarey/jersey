/**
 * Created by Sean on 11/04/2016.
 */
/**
 * Created by Sean on 11/04/2016.
 */
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
    //console.log($routeParams.teamId);
    //$http.get('http://localhost:8081/jersey/teams/getTeam/' + $routeParams.teamId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    //success(function(data) {
    //$scope.page = data;
    console.log($scope.page);
    //});

});

App.controller('TeamCtrl', function($scope, $routeParams,$http,$route) {


    $http.get('http://localhost:8081/jersey/clubs/getClub/' + $routeParams.clubId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.clubs = data;
    });
    $http.get('http://localhost:8081/jersey/teams/getTeam/' + $routeParams.teamId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.teams = data;
    });
    $http.get('http://localhost:8081/jersey/week/getWeekByTeamId/' + $routeParams.teamId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.weeks = data;
    });
    $http.get('http://localhost:8081/jersey/managers/getManagerByTeamId/' + $routeParams.teamId).
    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
    success(function(data) {
        $scope.managers = data;
    });

    $scope.createPlayer = function() {
        var firstNameData = $scope.firstName;
        var secondNameData = $scope.secondName;
        var playerId;
        var fitnessId;

        $http.post("http://localhost:8081/jersey/players/createPlayer/teamId/" + $routeParams.teamId + "/FirstName/"+ firstNameData+"/SecondName/"+secondNameData).success(function() {
            //$route.reload();
            $scope.submissionSuccess=true;
            //$route.reload();

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
                    //$http.get('http://139.59.160.201:8080/jersey/claims/getAllClaims').
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

