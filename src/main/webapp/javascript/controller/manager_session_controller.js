/**
 * Created by Sean on 25/04/2016.
 */
var App = angular.module('MyApp', ['ui.bootstrap','ngAnimate','ngRoute']);


App.config(['$routeProvider' , function($routeProvider ) {
    $routeProvider.when('/week/:weekId', {

        templateUrl : "sessionView.html",
        controller: "DatepickerPopupDemoCtrl"

    }).when('/', {

        templateUrl : "sessionView.html",
        controller: "Page1Ctrl"

    }).otherwise({

        template: '<div> This page does not exist </div>'

    });
}])


App.controller('Page1Ctrl', function($scope) {
    $scope.page = 'Page1';

    console.log($scope.page);

});

App.controller('DatepickerPopupDemoCtrl', function ($scope,$http, $animate,$route,$routeParams) {
    $scope.today = function() {

        $scope.dt = new Date();

        //check if $animate is enabled
        //console.log( $animate.enabled() );

    };

    $scope.today();

    $scope.clear = function() {
        $scope.dt = null;
    };

    $scope.inlineOptions = {

        customClass: getDayClass,
        minDate: new Date(),
        showWeeks: true
    };

    $scope.dateOptions = {

        formatYear: 'yy',
        maxDate: new Date(2020, 5, 22),
        minDate: new Date(),
        startingDay: 1
    };

    $scope.toggleMin = function() {

        $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
        $scope.dateOptions.minDate = $scope.inlineOptions.minDate;

    };

    $scope.toggleMin();

    $scope.open1 = function() {

        $scope.popup1.opened = true;

    };

    $scope.setDate = function(year, month, day) {

        $scope.dt = new Date(year, month, day);
    };

    $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    $scope.format = $scope.formats[0];
    $scope.altInputFormats = ['M!/d!/yyyy'];

    $scope.popup1 = {
        opened: false
    };

    $scope.popup2 = {
        opened: false
    };

    var tomorrow = new Date();
    tomorrow.setDate(tomorrow.getDate() + 1);
    var afterTomorrow = new Date();
    afterTomorrow.setDate(tomorrow.getDate() + 1);
    $scope.events = [
        {
            date: tomorrow,
            status: 'full'
        },
        {
            date: afterTomorrow,
            status: 'partially'
        }
    ];

    function getDayClass(data) {
        var date = data.date,
            mode = data.mode;
        if (mode === 'day') {
            var dayToCheck = new Date(date).setHours(0,0,0,0);

            for (var i = 0; i < $scope.events.length; i++) {
                var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

                if (dayToCheck === currentDay) {
                    return $scope.events[i].status;
                }
            }
        }

        return '';
    }

    $http.get('http://localhost:8081/jersey/session/getSessionByWeekId/' + $routeParams.weekId).
    success(function(data) {
        $scope.sessions = data;
    });


    $http.get('http://localhost:8081/jersey/week/getWeek/' + $routeParams.weekId).
    success(function(data) {

        $scope.weeks = data;

        var teamId;

        var dataParsed = data.map.week.myArrayList;
        console.log(dataParsed);
        for (var i=0;i<dataParsed.length;i++) {
            teamId = dataParsed[i].map.teamId;
        }

        $http.get('http://localhost:8081/jersey/teams/getTeam/' + teamId).
        success(function(data) {

            $scope.teams = data;

        });


    });


    $scope.addSession = function() {

        $scope.showAddSessionForm = true;

    }


    $scope.createSession = function() {


        var sessionTypeData = $scope.sessionTypeStatus;
        var startDay=$scope.dt.getDate();
        var startMonth=$scope.dt.getMonth() +1;
        if ($scope.dt.getMonth() == 12){

            //Note: this is a quick fix for date issue (gives 1 month behind)
            startMonth == 1;
        }

        var startYear=$scope.dt.getFullYear();

        var startDateData = startDay + "." + startMonth + "." + startYear;
        console.log(startDateData);

        $http.post("http://localhost:8081/jersey/session/createSession/weekId/"+$routeParams.weekId+"/sessionType/"+sessionTypeData+"/sessionDateString/"+startDateData).success(function() {

            $scope.submissionSuccess = true;

        })
        $route.reload();
    }




});