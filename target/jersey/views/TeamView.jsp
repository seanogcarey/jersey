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
    <title>Team</title>
    <script data-require="angular.js@1.0.x" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js" data-semver="1.0.8"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="/javascript/controller/team_controller.js"></script>
    <link rel="icon" href="/icons/notes.png">



    <script type="text/ng-template" id="teamView.html">


        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">



                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" ng-repeat="a in teams.map.team.myArrayList">
                    <ul class="nav navbar-nav">
                        <li><span><img src="http://localhost:8081/icons/notes.png"></span></li>
                        <li><a href="/index.jsp">Home</a></li>
                        <li><a href="/views/ClubView.jsp#/club/">All Clubs</a></li>
                        <li><a href="/views/ClubSingleView.jsp#/club/{{a.map.clubId}}">Club</a></li>
                        <li><a href="/views/TeamView.jsp#/club/{{a.map.clubId}}/team/{{a.map.teamId}}">Team</a></li>
                        <li><a href="/views/ManagerTeamView.jsp#/team/{{a.map.teamId}}">Team Schedule</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <br>
        <br>
        <br>
        <div ng-repeat="a in teams.map.team.myArrayList">
            <h2><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> Team View: {{a.map.teamName}}</h2>
        </div>
        <br>

        <div class="panel-heading"></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Team Name</th>
                    <th>Club Name</th>
                    <th>Sport</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td ng-repeat="a in teams.map.team.myArrayList"><span ng-bind="a.map.teamName"></span></td>
                    <td ng-repeat="a in clubs.map.club.myArrayList"><span ng-bind="a.map.clubName"></span></td>
                    <td ng-repeat="a in clubs.map.club.myArrayList"><span ng-bind="a.map.sport"></span></td>
                </tr>
                </tbody>
            </table>
        </div>
        </div>

        <br>
        <div ng-repeat="a in teams.map.team.myArrayList">

            <a href="/views/ManagerTeamView.jsp#/team/{{a.map.teamId}}"><button class="btn btn-default"><span class="glyphicon glyphicon-time" aria-hidden="true"></span> Schedule Overview</button></a>
            <br>
            <br>
            <a href="/views/TeamFitnessTestView.jsp#/team/{{a.map.teamId}}"><button class="btn btn-default"><span class="glyphicon glyphicon-stats" aria-hidden="true"></span> Fitness Tests</button></a>

        </div>
        <br>


        <div class="panel-heading"><span class="lead">Managers</span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Manager Name</th>
                    <th>Phone Number</th>
                    <th>Email</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in managers.map.manager.myArrayList">
                    <!--<td><a href="/views/ManagerView.jsp#/manager/{{a.map.managerId}}">{{a.map.firstName}} {{a.map.lastName}}</a></td>-->
                    <td>{{a.map.firstName}} {{a.map.lastName}}</td>
                    <td>{{a.map.phoneNumber}}</td>
                    <td>{{a.map.email}}</td>
                </tr>
                </tbody>
            </table>
        </div>
        </div>

        <div class="col-md-6">
        <button class="btn btn-default" ng-click="addManager()">Add Manager <span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>

        <div ng-show="showAddManagerForm">

        <h3>Add Manager</h3>


        <form class="form-inline" ng-submit="createManager()">
            <div class="form-group">
                <label for="inputFirstNameManager">First Name</label>
                <input type="text" class="form-control" ng-model="firstNameManager" id="inputFirstNameManager" placeholder="First Name">

                <br>
                <br>

                <label for="inputSecondNameManager">Second Name</label>
                <input type="text" class="form-control" ng-model="secondNameManager" id="inputSecondNameManager" placeholder="Second Name">

                <br>
                <br>

                <label for="inputPhoneNumberManager">Phone Number</label>
                <input type="number" class="form-control" ng-model="phoneNumberManager" id="inputPhoneNumberManager" placeholder="Phone Number">

                <br>
                <br>

                <label for="inputEmailManager">Email</label>
                <input type="text" class="form-control" ng-model="emailManager" id="inputEmailManager" placeholder="Email">

            </div>
            <br>
            <br>
            <button type="submit" class="btn btn-primary">Submit <span class="glyphicon glyphicon-save" aria-hidden="true"></span></button>
        </form>

       </div>

        <div class="alert alert-success"  aria-label="close" ng-show="submissionSuccessManager">
            <strong>Success! </strong> Manager Added
        </div>
        </div>
        <br>
        <br>
        <br>

        <div class="panel-heading"><span class="lead">Players</span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>
                        Player Name
                    </th>

                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in teams.map.player.myArrayList" onclick="location.href='/views/PlayerView.jsp#/player/{{a.map.playerId}}'">
                    <td><a href="/views/PlayerView.jsp#/player/{{a.map.playerId}}">{{a.map.firstName}} {{a.map.lastName}}</a></td>
                    <td><a href="/views/PlayerView.jsp#/player/{{a.map.playerId}}"><button class="btn btn-default"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Player Overview</button></a></td>
                    <td><a href="/views/PlayerFitnessTestView.jsp#/player/{{a.map.playerId}}"><button class="btn btn-default"><span class="glyphicon glyphicon-stats" aria-hidden="true"></span> Fitness Test</button></a></td>
                    <td><a href="/views/TrainingGroupView.jsp#/player/{{a.map.playerId}}"><button class="btn btn-default"><span class="glyphicon glyphicon-scale" aria-hidden="true"></span> Training Group</button></a></td>
                </tr>
                </tbody>
            </table>
        </div>
        </div>


        <div class="col-md-6">

        <button class="btn btn-default" ng-click="addPlayer()">Add Player <span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>

        <div ng-show="showAddPlayerForm">

        <h3>Add Player</h3>


        <form class="form-inline" ng-submit="createPlayer()">
            <div class="form-group">
                <label for="inputFirstName">First Name</label>
                <input type="text" class="form-control" ng-model="firstName" id="inputFirstName" placeholder="First Name">

                <br>
                <br>

                <label for="inputSecondName">Second Name</label>
                <input type="text" class="form-control" ng-model="secondName" id="inputSecondName" placeholder="Second Name">

                <br>
                <br>

                <label for="inputPhoneNumber">Phone Number</label>
                <input type="number" class="form-control" ng-model="phoneNumber" id="inputPhoneNumber" placeholder="Phone Number">


                <br>
                <br>

                <label for="inputEmail">Email</label>
                <input type="text" class="form-control" ng-model="email" id="inputEmail" placeholder="Email">

            </div>
            <br>
            <br>
            <button type="submit" class="btn btn-primary">Submit <span class="glyphicon glyphicon-save" aria-hidden="true"></span></button>
        </form>


        </div>
        <br>

        <div class="alert alert-success"  aria-label="close" ng-show="submissionSuccess">
            <strong>Success! </strong> Player Added
        </div>

        </div>

    </script>


</head>

<body ng-controller="Page1Ctrl">
<p ng-view>Hello from {{page}}!</p>



</div>
</body>

</html>
