<%--
  Created by IntelliJ IDEA.
  User: Sean
  Date: 15/04/2016
  Time: 17:44
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
    <script src="/javascript/controller/attendance_week_view_controller.js"></script>
    <link rel="icon" href="/icons/notes.png">



    <script type="text/ng-template" id="attendanceWeekViewView.html">



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
                        <li ng-repeat="a in weeks.map.week.myArrayList"><a href="/views/AttendanceWeekViewView.jsp#/week/{{a.map.weekId}}">Attendance Sheet</a></li>
                        <li ng-repeat="a in weeks.map.week.myArrayList"><a href="/views/ManagerSessionView.jsp#/week/{{a.map.weekId}}">Session Overview</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <br>
        <br>
        <br>

        <div ng-repeat="a in weeks.map.week.myArrayList">
        <h3><span class="glyphicon glyphicon-book" aria-hidden="true"></span> Attendance Sheet : Week {{a.map.weekNum}}</h3>
        </div>

        <div class="col-md-6">

        <h4><b>Total Training Count</b></h4>

        <div ng-repeat="a in attendanceWeekViews.map.attendanceWeekView.myArrayList">
            <br>
            <p>Name and Total Training Count:</p>
            <div ng-repeat="b in a.myArrayList">
                {{b.map.firstName}} {{b.map.lastName}} {{b.map.numOfSessions}}
                <br>
            </div>

        </div>

        <br>

        <h4><b>Training Count With Team</b></h4>

        <div ng-repeat="a in attendanceWeekViews.map.attendanceWeekView.myArrayList">
            <br>
            <p>Name and Total Training Count With Team :</p>
            <div ng-repeat="b in a.myArrayList">
                {{b.map.firstName}} {{b.map.lastName}} {{b.map.numOfSessionsWithTeam}}
                <br>
            </div>

        </div>

        </div>

    </script>


</head>

<body ng-controller="Page1Ctrl">
<p ng-view>Hello from {{page}}!</p>



</body>

</html>
