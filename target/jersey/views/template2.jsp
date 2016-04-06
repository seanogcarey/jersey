<%--
  Created by IntelliJ IDEA.
  User: Sean
  Date: 06/04/2016
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp">

<head>
    <title>AngularJS: UI-Router Quick Start</title>
    <!-- Bootstrap CSS -->
    <link href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container">

<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">Quick Start</a>
        <ul class="nav">
            <li><a href="#/route1">Route 1</a></li>
            <li><a href="#/route2">Route 2</a></li>
        </ul>
    </div>
</div>

<div class="row">
    <div class="span12">
        <div class="well" ui-view></div>
    </div>
</div>

<!-- Angular -->
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
<!-- Bootstrap -->
<!-- UI-Router -->
<script src="//angular-ui.github.io/ui-router/release/angular-ui-router.js"></script>
<script src="/javascript/template2.js"></script>

</body>
