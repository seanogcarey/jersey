<%--
  Created by IntelliJ IDEA.
  User: Sean
  Date: 05/04/2016
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Team View</title>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="../javascript/app.js"></script>
    <script src="../javascript/service/manager_service.js"></script>
    <script src="../javascript/controller/manager_controller.js"></script>


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>

<h2>Teams:</h2>
<div ng-app="myApp" ng-controller="ManagerController">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Managers </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Club ID</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in managers.map.manager.myArrayList">
                    <td><span ng-bind="a.map.teamId"></span></td>
                    <td><span ng-bind="a.map.teamName"></span></td>
                    <td><span ng-bind="a.map.clubId"></span></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>


</body>
</html>