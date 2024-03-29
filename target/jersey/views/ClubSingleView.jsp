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
    <link rel="icon" href="/icons/notes.png">



    <script type="text/ng-template" id="clubSingleView.html">


        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->


                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><span><img src="http://localhost:8081/icons/notes.png"></span></li>
                        <li><a href="/index.jsp">Home</a></li>
                        <li><a href="/views/ClubView.jsp#/club/">All Clubs</a></li>
                        <li  ng-repeat="a in clubs.map.club.myArrayList"><a href="/views/ClubSingleView.jsp#/club/{{a.map.clubId}}">Club</a></li>
                    </ul>
                </div>
            </div>
        </nav>

    <br>
    <br>
    <br>
    <div ng-repeat="a in clubs.map.club.myArrayList">
    <h2><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> Club View: {{a.map.clubName}}</h2>
    </div>
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
                    <th></th>

                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in teams.map.team.myArrayList"  onclick="location.href='/views/TeamView.jsp#/club/{{a.map.clubId}}/team/{{a.map.teamId}}'">
                    <td><a href="/views/TeamView.jsp#/club/{{a.map.clubId}}/team/{{a.map.teamId}}">{{a.map.teamName}}</a></td>
                    <td><a href="/views/TeamView.jsp#/club/{{a.map.clubId}}/team/{{a.map.teamId}}"><button class="btn btn-default"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> Go to Team </button></a></td>
                </tr>
                </tbody>
            </table>
        </div>
        <br>

        <div class="col-md-6">

    <button class="btn btn-default" ng-click="addTeam()">Add Team <span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>

    <div ng-show="showAddTeamForm">

        <h3>Create Team</h3>
        <br>
        <form class="form-inline" ng-submit="createTeam()">

            <div class="form-group">
                <label for="inputTeamName">Team Name</label>
                <input type="text" class="form-control" ng-model="teamName" id="inputTeamName" placeholder="Club Name">

            </div>
            <br>
            <br>
            <button type="submit" class="btn btn-primary">Submit Team <span class="glyphicon glyphicon-save" aria-hidden="true"></span></button>
        </form>

        <div class="alert alert-success"  aria-label="close" ng-show="submissionSuccess">
            <strong>Success! </strong> Team created
        </div>


    </div>
        </div>

    </script>


</head>

<body ng-controller="Page1Ctrl">
<p ng-view>Hello from {{page}}!</p>




</body>

</html>
