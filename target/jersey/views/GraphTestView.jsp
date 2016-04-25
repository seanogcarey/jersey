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
    <script data-require="angular.js@1.0.x" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js" data-semver="1.0.8"></script>
    <script data-require="angular.js@1.2.23" data-semver="1.2.23" src="https://code.angularjs.org/1.2.23/angular.js"></script>
    <script src="/javascript/externalJavascriptResources/Chart.js"></script>

    <script src="/javascript/controller/graph_controller.js"></script>
    <link rel="icon" href="http://getbootstrap.com/favicon.ico" />

    <script type="text/ng-template" id="graphView.html">

        <canvas id="buyers" width="600" height="400"></canvas>
        <br>
        <canvas id="myPieChart" width="200" height="200"></canvas>


        <p> You are on the right page {{hello}}</p>
    </script>
</head>

<body ng-controller="Page1Ctrl">
<h1>{{hello}}</h1>
<a>Projects</a>

<p ng-view>Hello from {{page}}!</p>

</body>

</html>