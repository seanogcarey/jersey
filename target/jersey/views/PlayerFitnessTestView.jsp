<%--
  Created by IntelliJ IDEA.
  User: Sean
  Date: 22/04/2016
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp">

<head>
    <meta charset="utf-8" />
    <title>Fitness Player Team</title>
    <script data-require="angular.js@1.0.x" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js" data-semver="1.0.8"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="/javascript/controller/player_fitness_test_controller.js"></script>
    <script src="../javascript/externalJavascriptResources/Chart.js"></script>

    <link rel="icon" href="/icons/notes.png">


    <script type="text/ng-template" id="playerFitnessTest.html">


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
                        <li ng-repeat="b in players.map.player.myArrayList"><a href="/views/PlayerView.jsp#/player/{{b.map.playerId}}">Player</a></li>
                        <li ng-repeat="b in players.map.player.myArrayList"><a href="/views/PlayerFitnessTestView.jsp#/player/{{b.map.playerId}}">Fitness Test</a></li>
                        <li ng-repeat="b in players.map.player.myArrayList"><a href="/views/TrainingGroupView.jsp#/player/{{b.map.playerId}}">Training Groups</a></li>
                    </ul>
                </div>
            </div>
        </nav>



        <br>
        <br>
        <br>
        <h2  ng-repeat="a in players.map.player.myArrayList"><span class="glyphicon glyphicon-stats" aria-hidden="true"></span> Fitness Test: {{a.map.firstName}} {{a.map.lastName}}</h2>

        <br>
        <div class="alert alert-danger"  aria-label="close" ng-show="playerBurnoutDanger">
            <strong><span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span> Player Burnout Danger! </strong> ( Player is experiencing burnout, please cut down on sessions per week )
        </div>

        <div class="alert alert-warning"  aria-label="close" ng-show="playerBurnoutWarning">
            <strong><span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span> Possible Player Burnout Warning! </strong> ( Player may be experiencing burnout, may require sessions to be cut down)
        </div>

        <div class="alert alert-success"  aria-label="close" ng-show="playerBurnoutSafe">
            <strong><span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Player is not experiencing burnout </strong> ( Player is fine to train )
        </div>


        <br>

        <a href="/views/FitnessTestDetailsView.jsp#"><button title="Info on the fitness test" class="btn btn-default">Fitness Test Details <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span></button></a>
        <br>

        <br>

        <div class="panel-heading"><span class="lead">Test Scores: </span></div>
        <br>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>1 KM Run</th>
                    <th>Agility</th>
                    <th>Sprint</th>
                    <th>Push Ups</th>
                    <th>Chin Ups</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in fitnessTests.map.fitnessTest.myArrayList">
                    <td>{{a.map.kmRun}}</td>
                    <td>{{a.map.agility}}</td>
                    <td>{{a.map.sprint}}</td>
                    <td>{{a.map.pushUps}}</td>
                    <td>{{a.map.chinUps}}</td>
                </tr>
                </tbody>
            </table>
        </div>


        <div class="panel-heading"><span class="lead">Other Scores</span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Work/Lifestyle Activity (Rate: 1-5)</th>
                    <th>Average Training Count</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in fitnessTests.map.fitnessTest.myArrayList">
                    <td>{{a.map.workLifestyle}}</td>
                    <td>{{a.map.weeklyAverageTrainingCount}}</td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="col-md-6">



        <h2>Update Fitness Test</h2>
        <!--<h5> ( 1 = low, 2 = medium, 3 = high)</h5>-->


        <form class="form-inline" ng-submit="updateFitnessTest()">

            <div class="form-group">


                <br>
                <br>

                <br><label for="insertKmRun"> 1 KM Run Score </label>
                <select id="insertKmRun" ng-model="kmRunStatus" class="form-control">
                    <option value="1">1 (greater than 04:10 minutes)</option>
                    <option value="2">2 (between 03:45 and 04:10 minutes)</option>
                    <option value="3">3 (less than 03:45 minutes)</option>
                </select><br>
                <br>
                <br>

                <br><label for="insertAgility"> Agility Score</label>
                <select id="insertAgility" ng-model="agilityStatus" class="form-control">
                    <option value="1">1 (greater than 02:793 seconds)</option>
                    <option value="2">2 (between 02:612 and 02:793 seconds)</option>
                    <option value="3">3 (less than 02:612 seconds)</option>
                </select><br>
                <br>
                <br>

                <br><label for="insertSprint">Speed Score</label>
                <select id="insertSprint" ng-model="sprintStatus" class="form-control">
                    <option value="1">1 (greater than 02:00 seconds)</option>
                    <option value="2">2 (between 01:907 and 02:00 seconds)</option>
                    <option value="3">3 (less than 01:907 seconds)</option>
                </select><br>
                <br>
                <br>

                <br><label for="insertPushUps">Push Ups Score</label>
                <select id="insertPushUps" ng-model="pushUpsStatus" class="form-control">
                    <option value="1">1 (less than 30 push ups)</option>
                    <option value="2">2 (between 29 and 44 push ups)</option>
                    <option value="3">3 (greater than 44 push ups)</option>
                </select><br>
                <br>
                <br>

                <br><label for="insertChinUps">Chin Ups Score</label>
                <select id="insertChinUps" ng-model="chinUpsStatus" class="form-control">
                    <option value="1">1 (less than 6 chin ups)</option>
                    <option value="2">2 (6 or 7 chin ups)</option>
                    <option value="3">3 (greater than 7 chin ups)</option>
                </select><br>
                <br>
                <br>

                <br><label for="insertWorkLifestyle">Work/Lifestyle Activity (Rate from 1-5)</label>
                <select id="insertWorkLifestyle" ng-model="workLifestyleStatus" class="form-control">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select><br>
                <br>
                <br>
                <br>
                <button type="submit" class="btn btn-primary">Update Fitness Test <span class="glyphicon glyphicon-save" aria-hidden="true"></span></button>

            </div>

        </form>

        </div>

    </script>



</head>

<body ng-controller="Page1Ctrl">
<p ng-view>Hello from {{page}}!</p>




</div>
</body>

</html>
