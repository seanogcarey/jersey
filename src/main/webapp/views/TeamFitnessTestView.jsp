<%--
  Created by IntelliJ IDEA.
  User: Sean
  Date: 22/04/2016
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp">

<head>
    <meta charset="utf-8" />
    <title>Fitness Test Team</title>
    <script data-require="angular.js@1.0.x" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js" data-semver="1.0.8"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="/javascript/controller/team_fitness_test_controller.js"></script>
    <link rel="icon" href="/icons/notes.png">

    <script type="text/ng-template" id="teamFitnessTest.html">



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
                    </ul>
                </div>
            </div>
        </nav>

        <br>
        <br>
        <br>

        <div ng-repeat="a in teams.map.team.myArrayList">
            <h2><span class="glyphicon glyphicon-stats" aria-hidden="true"></span> Fitness Tests: {{a.map.teamName}}</h2>
        </div>
        <br>

        <a href="/views/FitnessTestDetailsView.jsp#"><button title="Info on the fitness test" class="btn btn-default">Fitness Test Details <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span></button></a>
        <br>

        <div class="panel-heading"><span class="lead">Players </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Player Name</th>
                    <th>Fitness Test</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in teams.map.player.myArrayList">
                    <td>{{a.map.firstName}} {{a.map.lastName}}</td>
                    <td><a href="/views/PlayerFitnessTestView.jsp#/player/{{a.map.playerId}}"><button class="btn btn-default"><span class="glyphicon glyphicon-stats" aria-hidden="true"></span> Go to Fitness Test</button></a></td>
                </tr>
                </tbody>
            </table>
        </div>



    </script>


</head>

<body ng-controller="Page1Ctrl">
<p ng-view>Hello from {{page}}!</p>


</div>
</body>

</html>
