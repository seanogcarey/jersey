<%--
  Created by IntelliJ IDEA.
  User: Sean
  Date: 09/04/2016
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Team View</title>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-route.js"></script>
    <script src="../javascript/controller/player_controller2.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">


    <script type="text/ng-template" id="page1.html">

        <h1>Page 1</h1> <b>markup</b>
        <div ng-controller="MainCtrl">
            <p> This should show JSON PAGE1 -> {{players}}</p>

            <tr>
                {{players.map.player.myArrayList}}
                <th>First Name</th>
                <th>Last Name</th>
                <th>Team Id</th>
                <th>Player Single View</th>
                <th width="20%"></th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="a in players.map.player.myArrayList">
                <td><span ng-bind="a.map.firstName"></span></td>
                <td><span ng-bind="a.map.lastName"></span></td>
                <td><span ng-bind="a.map.teamId"></span></td>
                <td><a href="/views/PlayerView.jsp#/page2/{{a.map.playerId}}">Link</a></td>

            </tr>
            </tbody>
        </div>

    </script>

    <script type="text/ng-template" id="page2.html">

        <h2>Page 2</h2> here we go

    </script>

</head>
<body>

<a href="#/page1">page1</a> <a href="#/page2">page2</a>

<h2>Players:</h2>
<div ng-app="myApp" ng-controller="playerCtrl">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        {{players.map.player.myArrayList}}
        <div class="panel-heading"><span class="lead">List of Players </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Team Id</th>
                    <th>Single View</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>

                <tr ng-repeat="a in players.map.player.myArrayList">
                    <td>{{a.map.firstName}}</td>
                    <td>{{a.map.lastName}}</td>
                    <td>{{a.map.teamId}}</td>
                    <td><a href="/views/PlayerView.jsp#/page2/{{a.map.playerId}}">Single View Link</a></td>
                </tr>
                </tbody>
                </tbody>
            </table>
        </div>
    </div>
</div>


</body>
</html>