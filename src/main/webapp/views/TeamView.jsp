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
                    <td ng-repeat="a in clubs.map.club.myArrayList"><span ng-bind="a.map.sport"></span></td>
                </tr>
                </tbody>
            </table>
        </div>
        </div>

        <div ng-repeat="a in teams.map.team.myArrayList">

            <p><a href="/views/TeamFitnessTestView.jsp#/team/{{a.map.teamId}}">Fitness Test</a></p>
        </div>

        <div class="panel-heading"><span class="lead"></span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>
                        Managers
                    </th>

                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in managers.map.manager.myArrayList">
                    <td><a href="/views/ManagerView.jsp#/manager/{{a.map.managerId}}">{{a.map.firstName}} {{a.map.lastName}}</a></td>
                </tr>
                </tbody>
            </table>
        </div>
        </div>


        <h3>Add Player</h3>


        <form class="form-inline" ng-submit="createPlayer()">
            <div class="form-group">
                <label for="inputFirstName">First Name</label>
                <input type="text" class="form-control" ng-model="firstName" id="inputFirstName" placeholder="First Name">
                <label for="inputSecondName">Second Name</label>
                <input type="text" class="form-control" ng-model="secondName" id="inputSecondName" placeholder="Second Name">
            </div>
            <!--
            <div class="form-group">
                <label for="exampleInputEmail2">Email</label>
                <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
            </div>
            -->
            <button type="submit" class="btn btn-primary">Enter</button>
        </form>
        <div class="alert alert-success"  aria-label="close" ng-show="submissionSuccess">
            <strong>Success! </strong> Player Added
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
