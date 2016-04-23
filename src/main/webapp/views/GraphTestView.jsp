<%--
  Created by IntelliJ IDEA.
  User: Sean
  Date: 21/04/2016
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="app">

<head>
    <script data-require="angular.js@1.2.23" data-semver="1.2.23" src="https://code.angularjs.org/1.2.23/angular.js"></script>
    <script src="/javascript/externalJavascriptResources/Chart.js"></script>
    <link rel="stylesheet" href="style.css" />
    <script src="/javascript/controller/graph_controller.js"></script>
</head>

<body ng-controller="ChartCtrl">
<h1>{{hello}}</h1>
<a>Projects</a>
<br>
<canvas id="myPieChart" width="200" height="200"></canvas>

<canvas id="buyers" width="600" height="400"></canvas>
</body>

</html>