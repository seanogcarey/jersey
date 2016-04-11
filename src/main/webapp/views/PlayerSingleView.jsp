<%--
  Created by IntelliJ IDEA.
  User: Sean
  Date: 09/04/2016
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Team View</title>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-route.js"></script>
    <script src="../javascript/controller/player_single_view_controller.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">


    <script type="text/ng-template" id="test.html">

        <h1>TEST</h1> <b>markup</b>
            <p> Hello from TEST</p>


        </div>

    </script>

</head>
<body>


<h2>Single Player</h2>
<div ng-app="myApp" ng-controller="playerSingleCtrl">
    <div class="panel panel-default">
        <!-- Default panel contents -->

        <div class="panel-heading"><span class="lead">Info</span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
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
                </tbody>
            </table>
        </div>
    </div>
</div>


</body>
</html>