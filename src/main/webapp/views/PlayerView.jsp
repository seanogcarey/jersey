<%--
  Created by IntelliJ IDEA.
  User: Sean
  Date: 09/04/2016
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp">

<head>
    <meta charset="utf-8" />
    <title>AngularJS Plunker</title>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-route.js"></script>
    <script src="/javascript/controller/player_controller.js"></script>


    <script type="text/ng-template" id="page1.html">

        <h1>Page 1</h1> <b>markup</b>
        <div ng-controller="MainCtrl">
            <p> Hello from Page 1</p>


            </div>

    </script>

    <script type="text/ng-template" id="page2.html">

        <h2>Page 2</h2> here we go

    </script>

</head>

<body ng-app="myApp" ng-controller="MainCtrl">
<p ng-view>Hello {{players.map.player.myArrayList}} !</p>
<a href="#/page1">page1</a> <a href="#/page2">page2</a>

<div ng-controller="PageCtrl"> Hello {{name}} !</div>
<div ng-controller="MainCtrl">
    <p> This should show JSON ->{{players.map.player.myArrayList}} </p>

    <tr>

        <th>First Name</th>
        <th>Last Name</th>
        <th>Team Id</th>
        <th width="20%"></th>
    </tr>
    </thead>
    <tbody>
    <tr ng-repeat="a in players.map.player.myArrayList">
        <td>{{a.map.firstName}}</td>
        <td>{{a.map.lastName}}</td>
        <td>{{a.map.teamId}}</td>
    </tr>
    </tbody>
</div>
</body>

</html>
