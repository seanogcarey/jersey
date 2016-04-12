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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="/javascript/controller/view_controller.js"></script>
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">


    <script type="text/ng-template" id="page1.html">

        <b>here is the page 1</b>
        <p>Does this say anything ? {{page}} </p>

    </script>

    <script type="text/ng-template" id="team.html">

        <h2>Team View</h2>

        <div class="panel-heading"><span class="lead">List of Teams </span></div>
        <div class="tablecontainer">
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
                <td><a href="/views/View.jsp#/team/{{a.map.teamId}}">Single View</a></td>
            </tr>
            </tbody>
        </table>
        </div>
        </div>


    </script>

</head>

<body ng-controller="Page1Ctrl">
<p ng-view>Hello from {{page}}!</p>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar">icon bar</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><img alt="Notepad icon" src="/icons/notes.png"></a> <!-- credit: Freepik in education -->
        </div>


        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">Link</a></li>
                <li><a href="#/team/">Team</a></li>
                <!--
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
                -->
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


</div>
</body>

</html>
