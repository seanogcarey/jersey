<%--
  Created by IntelliJ IDEA.
  User: Sean
  Date: 11/04/2016
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp">

<head>
    <meta charset="utf-8" />
    <title>Player</title>
    <script data-require="angular.js@1.0.x" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js" data-semver="1.0.8"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="/javascript/controller/player_controller.js"></script>



    <script type="text/ng-template" id="playerView.html">


        <br>
        <br>

        <div class="panel-heading"></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Player Name : {{players.map.player.myArrayList[1] }}</th>
                    <th>Team : </th>
                    <th>Fitness Test: </th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td ng-repeat="a in players.map.player.myArrayList">{{a.map.firstName}} {{a.map.lastName}}</td>
                    <td ng-repeat="a in teams.map.team.myArrayList">  {{a.map.teamName }}</td>
                    <td ng-repeat="a in players.map.player.myArrayList"><a href="/views/PlayerFitnessTestView.jsp#/player/{{a.map.playerId}}">Go to Test info</a></td>
                </tr>
                </tbody>
            </table>
        </div>
        </div>


        <b>Week: </b>
        <br>
        <div ng-repeat="b in weeks.map.week.myArrayList">
            <div ng-repeat="a in players.map.player.myArrayList">
                     <p> Week {{b.map.weekId}} </p> <p><a href="/views/WeekPlayerView.jsp#/week/{{b.map.weekId}}/player/{{a.map.playerId}}">Week {{b.map.weekId}} Record</a></p>
            </div>
        </div>


        <div ng-repeat="a in attendanceWeekViews.map.attendanceWeekView.myArrayList">
            Week {{a.map.weekId}}: Number of training sessions  = {{a.map.numOfSessions}}
        </div>

    </script>


</head>

<body ng-controller="Page1Ctrl">
<p ng-view>Hello from {{page}}!</p>



</body>

</html>
