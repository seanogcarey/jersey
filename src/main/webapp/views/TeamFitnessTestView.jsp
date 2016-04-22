<%--
  Created by IntelliJ IDEA.
  User: Sean
  Date: 22/04/2016
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp">

<head>
    <meta charset="utf-8" />
    <title>Fintess Player Team</title>
    <script data-require="angular.js@1.0.x" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js" data-semver="1.0.8"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="/javascript/controller/team_fitness_test_controller.js"></script>
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">


    <script type="text/ng-template" id="teamFitnessTest.html">

        <h2>Fitness Test</h2>

        <div ng-repeat="a in teams.map.team.myArrayList">
            <p>{{a.map.teamName}}</p>
        </div>

        <div class="panel-heading"><span class="lead">Players </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Player Name</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in teams.map.player.myArrayList">
                    <td>{{a.map.firstName}} {{a.map.lastName}}</td>
                </tr>
                </tbody>
            </table>
        </div>



    </script>


</head>

<body ng-controller="Page1Ctrl">
<p ng-view>Hello from {{page}}!</p>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <li><a href="/index.jsp">Home</a></li>
                <li><a href="#/club/">Club</a></li>

            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


</div>
</body>

</html>
