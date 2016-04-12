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
    <title>Club</title>
    <script data-require="angular.js@1.0.x" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js" data-semver="1.0.8"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="/javascript/controller/club_single_controller.js"></script>
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">



    <script type="text/ng-template" id="clubSingleView.html">

<br>
<br>

        <div class="panel-heading"></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Sport</th>
                    <th>Address</th>
                    <th>Contact Number</th>
                    <th>Email</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in clubs.map.club.myArrayList">
                    <td><span ng-bind="a.map.clubName"></span></td>
                    <td><span ng-bind="a.map.sport"></span></td>
                    <td><span ng-bind="a.map.address"></span></td>
                    <td><span ng-bind="a.map.clubContactNumber"></span></td>
                    <td><span ng-bind="a.map.email"></span></td>
                </tr>
                </tbody>
            </table>
        </div>
        </div>



        <div class="panel-heading"><span class="lead">Team List </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th><div ng-repeat="a in clubs.map.club.myArrayList">
                        {{a.map.clubName}} Teams:
                    </div></th>

                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in teams.map.team.myArrayList">
                    <td><a href="/views/TeamView.jsp#/club/{{a.map.clubId}}/team/{{a.map.teamId}}">{{a.map.teamName}}</a></td>
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


        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/index.jsp">Home</a></li>
                <li><a href="/views/ClubView.jsp#/club/">Clubs</a></li>
            </ul>
        </div>
    </div>
</nav>


</div>
</body>

</html>
