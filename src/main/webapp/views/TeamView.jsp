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
    <title>Team</title>
    <script data-require="angular.js@1.0.x" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js" data-semver="1.0.8"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="/javascript/controller/team_controller.js"></script>
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">



    <script type="text/ng-template" id="teamView.html">

        <br>
        <br>

        <div class="panel-heading"></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Team Name</th>
                    <th>Club Name</th>
                    <th>Sport</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td ng-repeat="a in teams.map.team.myArrayList"><span ng-bind="a.map.teamName"></span></td>
                    <td ng-repeat="a in clubs.map.club.myArrayList"><span ng-bind="a.map.clubName"></span></td>
                    <td ng-repeat="a in clubs.map.club.myArrayList"><span ng-bind="a.map.clubSport"></span></td>
                </tr>
                </tbody>
            </table>
        </div>
        </div>



        <div class="panel-heading"><span class="lead"></span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>
                        Players
                    </th>

                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in teams.map.player.myArrayList">
                    <td><a href="/views/PlayerView.jsp#/player/{{a.map.playerId}}">{{a.map.firstName}} {{a.map.lastName}}</a></td>
                </tr>
                </tbody>
            </table>
        </div>
        </div>

        <p>Weeks View:</p>
        <div ng-repeat="a in weeks.map.week.myArrayList">
            <p>Week <span ng-bind="a.map.weekId"></span></p><p><a href="/views/AttendanceWeekViewView.jsp#/week/{{a.map.weekId}}">Attendance Sheet</a></p>
        </div>

    </script>


</head>

<body ng-controller="Page1Ctrl">
<p ng-view>Hello from {{page}}!</p>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">



        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/index.jsp">Home</a></li>
                <li><a href="/views/ClubView.jsp#/club/">Clubs</a></li>
            </ul>
        </div>
    </div>
</nav>


</div>
</body>

</html>
