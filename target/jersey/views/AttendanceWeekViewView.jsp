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



    <script type="text/ng-template" id="attendanceWeekViewView.html">


        <br>
        <br>
        <div ng-repeat="a in weeks.map.week.myArrayList">
        <h3>Week {{a.map.weekId}} Training Count:</h3>
        </div>

        <div ng-repeat="a in attendanceWeekViews.map.attendanceWeekView.myArrayList">
            <br>
            <p><b>Name and Total Training Count:</b></p>
            <div ng-repeat="b in a.myArrayList">
                {{b.map.firstName}} {{b.map.lastName}} {{b.map.numOfSessions}}
                <br>
            </div>

        </div>

        <!-- NOTE: Have another Div to show the attendance from just the team -->
    </script>


</head>

<body ng-controller="Page1Ctrl">
<p ng-view>Hello from {{page}}!</p>



</body>

</html>
