<%--
  Created by IntelliJ IDEA.
  User: Sean
  Date: 20/04/2016
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp">

<head>
    <meta charset="utf-8" />
    <title>Session View</title>
    <script data-require="angular.js@1.0.x" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js" data-semver="1.0.8"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="/javascript/controller/session_controller.js"></script>
    <link rel="icon" href="/icons/notes.png">



    <script type="text/ng-template" id="attendanceTableView.html">

        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" ng-repeat="a in teams.map.team.myArrayList">
                    <ul class="nav navbar-nav">
                        <li><span><img src="http://localhost:8081/icons/notes.png"></span></li>
                        <li><a href="/index.jsp">Home</a></li>
                        <li><a href="/views/ClubView.jsp#/club/">All Clubs</a></li>
                        <li><a href="/views/ClubSingleView.jsp#/club/{{a.map.clubId}}">Club</a></li>
                        <li><a href="/views/TeamView.jsp#/club/{{a.map.clubId}}/team/{{a.map.teamId}}">Team</a></li>
                        <li ng-repeat="b in players.map.player.myArrayList"><a href="/views/PlayerView.jsp#/player/{{b.map.playerId}}">Player</a></li>
                        <li ng-repeat="b in players.map.player.myArrayList"><a href="/views/PlayerFitnessTestView.jsp#/player/{{b.map.playerId}}">Fitness Test</a></li>
                        <li ng-repeat="b in players.map.player.myArrayList"><a href="/views/TrainingGroupView.jsp#/player/{{b.map.playerId}}">Training Groups</a></li>
                    </ul>
                </div>
            </div>
        </nav>


        <br>
        <br>
        <br>
        <div ng-repeat="a in sessions.map.session.myArrayList">
            <h2><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Attendance Record: {{a.map.sessionType}}  {{a.map.sessionDateString}}</h2>
        </div>
        <div ng-repeat="a in players.map.player.myArrayList">
            <h4>Player: {{a.map.firstName}} {{a.map.lastName}}</h4>
        </div>
        <br>

        <div ng-repeat="c in weeks.map.week.myArrayList"><button class="btn btn-default" ng-repeat="b in players.map.player.myArrayList"><a href="WeekPlayerView.jsp#/week/{{c.map.weekId}}/player/{{b.map.playerId}}"><span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span> Back to Week {{c.map.weekNum}} Record</a></button></div>


        <br>
        <div class="panel-heading"></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Week :</th>
                    <th>Player Name :</th>
                    <th>Team : </th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td ng-repeat="a in weeks.map.week.myArrayList">  {{a.map.weekNum }}</td>
                    <td ng-repeat="a in players.map.player.myArrayList">{{a.map.firstName}} {{a.map.lastName}}</td>
                    <td ng-repeat="a in teams.map.team.myArrayList">  {{a.map.teamName }}</td>
                </tr>
                </tbody>
            </table>
        </div>
        </div>


        <div ng-repeat="b in sessions.map.session.myArrayList">
        <div class="panel-heading"ng-repeat="a in weeks.map.week.myArrayList"><span class="lead">Attendance Table for {{b.map.sessionType}},  Week {{a.map.weekNum }} Date: {{b.map.sessionDateString}}</span></div>
        </div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Present Status</th>
                    <th>Reason for absence</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in attendanceTables.map.attendanceTable.myArrayList">
                    <td>  {{a.map.present}}</td>
                    <td> {{a.map.reasonOfAbsence}} </td>
                </tr>
                </tbody>
            </table>
        </div>

        <h3>Update Attendance</h3>

        <div class="col-md-6">


        <form class="form-inline" ng-submit="updateAttendance()">

                <label for="insertPresentStatus">Present Status </label>
                <select id="insertPresentStatus" ng-model="presentStatus" class="form-control">
                <option value="True">True</option>
                <option value="False">False</option>
                </select><br>
                <br>
                <label for="insertReasonOfAbsence">Reason of Absence (If Present is false)</label>
                <select id="insertReasonOfAbsence" ng-model="reasonOfAbsence" class="form-control">
                    <option value="EMPTY">EMPTY</option>
                    <option value="College Training">College Training</option>
                    <option value="School Training">School Training</option>
                    <option value="College,School Match">College,School Match</option>
                    <option value="County Training">County Training</option>
                    <option value="County Match">County Match</option>
                    <option value="Other Club Training">Other Club Training</option>
                    <option value="Other Club Match">Other Club Match</option>
                    <option value="No mode of transport">No mode of transport</option>
                    <option value="Work Commitments">Work Commitments</option>
                    <option value="Study Commitments">Study Commitments</option>
                    <option value="None of the above">None of the above</option>
                </select><br>
            <br>

            <button type="submit" class="btn btn-primary">Submit <span class="glyphicon glyphicon-save" aria-hidden="true"></span></button>
        </form>
        <div class="alert alert-success"  aria-label="close" ng-show="submissionSuccess">
            <strong>Success! </strong> Club created
        </div>

        </div>

    </script>


</head>

<body ng-controller="Page1Ctrl">
<p ng-view>Hello from {{page}}!</p>



</body>

</html>


