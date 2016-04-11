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
    <title>View</title>
    <script data-require="angular.js@1.0.x" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js" data-semver="1.0.8"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="/javascript/controller/view_controller.js"></script>


    <script type="text/ng-template" id="page1.html">

        <h1>Page 1</h1> <b>here is the page 1</b>
        <p>Does this say anything ? {{page}} </p>

    </script>

    <script type="text/ng-template" id="team.html">

        <h2>Team Page</h2> <b>here is the team page</b>
        <p> Hello team {{team}} </p>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Club ID</th>
                <th>View team</th>
                <th width="20%"></th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="a in teams.map.team.myArrayList">
                <td><span ng-bind="a.map.teamId"></span></td>
                <td><span ng-bind="a.map.teamName"></span></td>
                <td><span ng-bind="a.map.clubId"></span></td>
                <td><a href="/jersey/teams/getTeam/{{a.map.teamId}}">Link</a></td>
            </tr>
            </tbody>
        </table>


    </script>

</head>

<body ng-controller="Page1Ctrl">
<p ng-view>Hello from {{page}}!</p>
<a href="#/page1">page1</a> <a href="#/team/">team</a>

<!--
<div ng-controller="Page1Ctrl"> <p>Hello from {{page}} !</p> </div>

<div ng-controller="TeamCtrl"> <p>Hello from {{team}} !</p>
-->


</div>
</body>

</html>
