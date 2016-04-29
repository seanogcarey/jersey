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
    <link rel="icon" href="/icons/notes.png">



    <script type="text/ng-template" id="playerView.html">


        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" ng-repeat="a in teams.map.team.myArrayList">
                    <ul class="nav navbar-nav">
                        <li><span><img src="http://localhost:8081/icons/notes.png"></span></li>
                        <li><a href="/index.jsp">Home</a></li>
                        <li><a href="/views/ClubView.jsp#/club/">All Clubs</a></li>
                        <li><a href="/views/ClubSingleView.jsp#/club/{{a.map.clubId}}">Club</a></li>
                        <li><a href="/views/TeamView.jsp#/club/{{a.map.clubId}}/team/{{a.map.teamId}}">Team</a></li>
                        <li><a href="/views/ManagerTeamView.jsp#/team/{{a.map.teamId}}">Team Schedule</a></li>
                        <li ng-repeat="b in players.map.player.myArrayList"><a href="/views/PlayerView.jsp#/player/{{b.map.playerId}}">Player</a></li>
                        <li ng-repeat="b in players.map.player.myArrayList"><a href="/views/PlayerFitnessTestView.jsp#/player/{{b.map.playerId}}">Fitness Test</a></li>
                        <li ng-repeat="b in players.map.player.myArrayList"><a href="/views/GraphTestView.jsp#/player/{{b.map.playerId}}">Training Groups</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <br>
        <br>
        <br>
        <h2 ng-repeat="a in players.map.player.myArrayList">Player Overview: {{a.map.firstName}} {{a.map.lastName}}</h2>


        <br>
        <br>

        <div class="panel-heading"></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Player Name : </th>
                    <th>Team : </th>
                    <th>Phone Number : </th>
                    <th>Email : </th>
                    <th></th>
                    <th></th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td ng-repeat="a in players.map.player.myArrayList">{{a.map.firstName}} {{a.map.lastName}}</td>
                    <td ng-repeat="a in teams.map.team.myArrayList">  {{a.map.teamName }}</td>
                    <td ng-repeat="a in players.map.player.myArrayList">{{a.map.phoneNumber}}</td>
                    <td ng-repeat="a in players.map.player.myArrayList">{{a.map.email}}</td>
                    <td ng-repeat="a in players.map.player.myArrayList"><a href="/views/PlayerFitnessTestView.jsp#/player/{{a.map.playerId}}"><button class="btn btn-default">Fitness Test</button></a></td>
                    <td ng-repeat="a in players.map.player.myArrayList"><a href="/views/GraphTestView.jsp#/player/{{a.map.playerId}}"><button class="btn btn-default">Training Group</button></a></td>

                </tr>
                </tbody>
            </table>
        </div>
        </div>

        <br>
        <div class="alert alert-danger"  aria-label="close" ng-show="playerBurnoutDanger">
            <strong>Player Burnout Danger! </strong> ( Player is experiencing burnout, please cut down on sessions per week )
        </div>

        <div class="alert alert-warning"  aria-label="close" ng-show="playerBurnoutWarning">
            <strong>Possible Player Burnout Warning! </strong> ( Player may be experiencing burnout, may require sessions to be cut down)
        </div>

        <div class="alert alert-success"  aria-label="close" ng-show="playerBurnoutSafe">
            <strong>Player is not experiencing burnout </strong> ( Player is fine to train )
        </div>


        <div class="panel-heading"><span class="lead"></span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Week Record: </th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="b in weeks.map.week.myArrayList">
                    <td ng-repeat="a in players.map.player.myArrayList">
                         <a href="/views/WeekPlayerView.jsp#/week/{{b.map.weekId}}/player/{{a.map.playerId}}"><button class="btn btn-default">Week {{b.map.weekNum}} Record</button></a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        </div>


<!--
        <b>Week: </b>
        <br>
        <div ng-repeat="b in weeks.map.week.myArrayList">
            <div ng-repeat="a in players.map.player.myArrayList">
                     <p> Week {{b.map.weekNum}} </p> <p><a href="/views/WeekPlayerView.jsp#/week/{{b.map.weekId}}/player/{{a.map.playerId}}">Week {{b.map.weekNum}} Record</a></p>
            </div>
        </div>


        <div ng-repeat="a in attendanceWeekViews.map.attendanceWeekView.myArrayList">
            Week {{a.map.weekNum}}: Number of training sessions  = {{a.map.numOfSessions}}
        </div>
-->


    </script>


</head>

<body ng-controller="Page1Ctrl">
<p ng-view>Hello from {{page}}!</p>



</body>

</html>
