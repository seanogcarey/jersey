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
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="/javascript/controller/graph_controller.js"></script>
    <link rel="icon" href="/icons/notes.png">

    <script type="text/ng-template" id="graphView.html">




        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" ng-repeat="a in teams.map.team.myArrayList">
                    <ul class="nav navbar-nav">
                        <li><span><img src="http://localhost:8081/icons/notes.png"></span></li>
                        <li><a href="/index.jsp">Home</a></li>
                        <li><a href="/views/ClubView.jsp#/club/">All Clubs</a></li>
                        <li><a href="/views/ClubSingleView.jsp#/club/{{a.map.clubId}}">Club</a></li>
                        <li><a href="/views/TeamView.jsp#/club/{{a.map.clubId}}/team/{{a.map.teamId}}">Team</a></li>
                        <li ng-repeat="b in players.map.player.myArrayList"><a href="/views/PlayerView.jsp#/player/{{b.map.playerId}}">Player</a></li>
                        <li ng-repeat="b in players.map.player.myArrayList"><a href="/views/PlayerFitnessTestView.jsp#/player/{{b.map.playerId}}">Fitness Test</a></li>
                        <li ng-repeat="b in players.map.player.myArrayList"><a href="/views/GraphTestView.jsp#/player/{{b.map.playerId}}">Training Groups</a></li>

                    </ul>
                </div>
            </div>
        </nav>



        <br>
        <br>
        <h2  ng-repeat="a in players.map.player.myArrayList">Training Group: {{a.map.firstName}} {{a.map.lastName}}</h2>


        <br>
        <div class="alert alert-danger"  aria-label="close" ng-show="playerBurnoutDanger">
            <strong>Player Burnout Danger! </strong> ( Player is experiencing burnout, please cut down on sessions per week )
        </div>

        <div class="alert alert-warning"  aria-label="close" ng-show="playerBurnoutWarning">
            <strong>Possible Player Burnout Warning! </strong> ( Player may be experiencing burnout, may require sessions to be cut down)
        </div>

        <div class="alert alert-success"  aria-label="close" ng-show="playerBurnoutSafe">
            <strong>Player is not experiencing burnout </strong> ( Player is fine to train )
        </div>


        <div class="panel-heading"><span class="lead">Info:  </span></div>
        <p><b>Low:   </b>More work needs to be done</p>
        <p><b>Medium:</b>Good but room for improvement</p>
        <p><b>High:  </b>Very Good, keep it up</p>

        <div class="panel-heading"><span class="lead">Training Groups:  </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>
                        Fitness Group:
                    </th>
                    <th>
                        Speed Group:
                    </th>
                    <th>
                        Strength Group:
                    </th>

                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in trainingGroups.map.trainingGroup.myArrayList">
                    <td>{{a.map.fitnessGroup}} Group</td>
                    <td>{{a.map.speedGroup}} Group</td>
                    <td>{{a.map.strengthGroup}} Group</td>
                </tr>
                </tbody>
            </table>
        </div>
        </div>



        <h3>Chart representation:</h3>
        <br>
        <canvas id="buyers" width="600" height="400"></canvas>
        <br>

    </script>
</head>

<body ng-controller="Page1Ctrl">
<h1>{{hello}}</h1>


<p ng-view>Hello from {{page}}!</p>

</body>

</html>