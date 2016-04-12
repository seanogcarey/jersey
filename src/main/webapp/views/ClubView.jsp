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
    <script src="/javascript/controller/club_controller.js"></script>
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">


    <script type="text/ng-template" id="club.html">

        <h2>Clubs</h2>

        <div class="panel-heading"><span class="lead">List of Clubs </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Name</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in clubs.map.club.myArrayList">
                    <td><a href="/views/ClubSingleView.jsp#/club/{{a.map.clubId}}">{{a.map.clubName}}</a></td>
                </tr>
                </tbody>
            </table>
        </div>
        </div>

        <h2>Create Club</h2>


        <form class="form-inline" ng-submit="createClub()">
            <div class="form-group">
                <label for="exampleInputName2">Club Name</label>
                <input type="text" class="form-control" ng-model="text" id="exampleInputName2" placeholder="Club Name">
            </div>
            <!--
            <div class="form-group">
                <label for="exampleInputEmail2">Email</label>
                <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
            </div>
            -->
            <button type="submit" class="btn btn-primary">Enter</button>
        </form>
        <div class="alert alert-success"  aria-label="close" ng-show="submissionSuccess">
            <strong>Success! </strong> Club created
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
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in teams.map.team.myArrayList">
                    <td><a href="/views/ClubView.jsp#/club/{{a.map.clubId}}">{{a.map.teamName}}</a></td>
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

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <li><a href="/index.jsp">Home</a></li>
                <li><a href="#/club/">Club</a></li>
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
