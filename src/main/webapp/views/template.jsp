<%--
  Created by IntelliJ IDEA.
  User: Sean
  Date: 06/04/2016
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp">

<head>
    <meta charset="utf-8" />
    <title>AngularJS Plunker</title>
    <script data-require="angular.js@1.0.x" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js" data-semver="1.0.8"></script>
    <script src="/javascript/template.js"></script>


    <script type="text/ng-template" id="page1.html">

        <h1>Page 1</h1> <b>markup</b>

    </script>

    <script type="text/ng-template" id="page2.html">

        <h2>Page 2</h2> here we go

    </script>

</head>

<body ng-controller="MainCtrl">
<p ng-view>Hello {{name}}!</p>
<a href="#/page1">page1</a> <a href="#/page2">page2</a>

<div ng-controller="Page2Ctrl"> Hello {{name}} !</div>
</body>

</html>
