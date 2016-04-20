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



    <script type="text/ng-template" id="attendanceTableView.html">


        <br>
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
                    <td ng-repeat="a in weeks.map.week.myArrayList">  {{a.map.weekId }}</td>
                    <td ng-repeat="a in players.map.player.myArrayList">{{a.map.firstName}} {{a.map.lastName}}</td>
                    <td ng-repeat="a in teams.map.team.myArrayList">  {{a.map.teamName }}</td>
                </tr>
                </tbody>
            </table>
        </div>
        </div>


        <div ng-repeat="b in sessions.map.session.myArrayList">
        <div class="panel-heading"ng-repeat="a in weeks.map.week.myArrayList"><span class="lead">Attendance Table for {{b.map.sessionType}},  Week {{a.map.weekId }} Date: </span></div>
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

        <h2>Update Attendance</h2>


        <form class="form-inline" ng-submit="updateAttendance()">
            <!--<div class="form-group" ng-repeat="a in attendanceTables.map.attendanceTable.myArrayList"></div>-->

                <label for="insertPresentStatus">Present Status </label>
                <input type="text" class="form-control" ng-model="presentStatus" id="insertPresentStatus" placeholder="Present status">
                <label for="insertReasonOfAbsence">Reason of Absence (If Present is false)</label>
                <input type="text" class="form-control" ng-model="reasonOfAbsence" id="insertReasonOfAbsence" value="NULL" placeholder="NULL">

            <button type="submit" class="btn btn-primary">Enter</button>
        </form>
        <div class="alert alert-success"  aria-label="close" ng-show="submissionSuccess">
            <strong>Success! </strong> Club created
        </div>

    </script>


</head>

<body ng-controller="Page1Ctrl">
<p ng-view>Hello from {{page}}!</p>



</body>

</html>


