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

    <!-- the resources:
    <script src="/javascript/externalJavascriptResources/angular.min.js"></script>
    <script src="/javascript/externalJavascriptResources/angular.js"></script>
    <link rel="stylesheet" href="/style/css/bootstrap.min.css">
    -->

    <script src="/javascript/controller/club_controller.js"></script>
    <link rel="icon" href="/icons/notes.png">


    <script type="text/ng-template" id="club.html">

        <br>
        <br>
        <br>
        <h2>All Clubs</h2>

        <br>

        <div class="col-md-6">


        <button class="btn btn-default" ng-click="addClub()">Add Club <span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>


        <div ng-show="showAddClubForm">
        <h3>Create Club</h3>


        <br>
        <form class="form-inline" ng-submit="createClub()">

            <div class="form-group">
                <label for="inputClubName">Club Name</label>
                <input type="text" class="form-control" ng-model="clubName" id="inputClubName" placeholder="Club Name">

                <br>
                <br>

                <label for="inputClubEmail">Email</label>
                <input type="text" class="form-control" ng-model="email" id="inputClubEmail" placeholder="Email">

                <br>
                <br>

                <label for="inputClubAddress">Address</label>
                <input type="text" class="form-control" ng-model="address" id="inputClubAddress" placeholder="Address">

                <br>
                <br>

                <label for="inputClubSport">Sport</label>
                <input type="text" class="form-control" ng-model="sport" id="inputClubSport" placeholder="Sport">

                <br>
                <br>

                <label for="inputClubContactNumber">Contact Number</label>
                <input type="number" class="form-control" ng-model="clubContactNumber" id="inputClubContactNumber" placeholder="Contact Number">
            </div>
            <br>
            <br>
            <button type="submit" class="btn btn-primary">Submit Club <span class="glyphicon glyphicon-save" aria-hidden="true"></span></button>
        </form>

        </div>


        <div class="alert alert-success"  aria-label="close" ng-show="submissionSuccess">
            <strong>Success! </strong> Club created
        </div>

        </div>

        <br>
        <div class="panel-heading"><span class="lead"></span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Name</th>
                    <th></th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in clubs.map.club.myArrayList" onclick="location.href='http://localhost:8081/views/ClubSingleView.jsp#/club/{{a.map.clubId}}'">
                    <td><a href="/views/ClubSingleView.jsp#/club/{{a.map.clubId}}">{{a.map.clubName}}</a></td>
                    <td><a href="/views/ClubSingleView.jsp#/club/{{a.map.clubId}}"><button  class="btn btn-default"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> Go to Club </button></a></td>
                </tr>
                </tbody>
            </table>
        </div>



    </script>

    <script type="text/ng-template" id="clubSingleView.html">

        <h2>{{a.map.clubName}}</h2>

        <div class="panel-heading"><span class="lead">List of Players </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Team Name</th>
                    <th></th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in teams.map.team.myArrayList">
                    <td><a href="/views/ClubView.jsp#/club/{{a.map.clubId}}">{{a.map.teamName}}</a></td>
                    <td><a href="/views/ClubView.jsp#/club/{{a.map.clubId}}">Go to Team</a></td>
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

                <li><span><img src="http://localhost:8081/icons/notes.png"></span></li>
                <li><a href="/index.jsp">Home</a></li>
                <li><a href="#/club/">All Clubs</a></li>
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
