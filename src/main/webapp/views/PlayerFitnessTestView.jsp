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
    <title>Fintess Player Team</title>
    <script data-require="angular.js@1.0.x" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js" data-semver="1.0.8"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="/javascript/controller/player_fitness_test_controller.js"></script>
    <script src="../javascript/externalJavascriptResources/Chart.js"></script>

    <link rel="icon" href="http://getbootstrap.com/favicon.ico">


    <script type="text/ng-template" id="playerFitnessTest.html">

        <br>
        <br>
        <h2>Fitness Test</h2>

        <div class="panel-heading"><span class="lead"></span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Player Name</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in players.map.player.myArrayList">
                    <td>{{a.map.firstName}} {{a.map.lastName}}</td>
                </tr>
                </tbody>
            </table>
        </div>


        <br>
        <div class="alert alert-danger"  aria-label="close" ng-show="playerBurnoutDanger">
            <strong>Possible Player Burnout Warning! </strong>
        </div>

        <div class="panel-heading"><span class="lead">Test Scores: </span></div>
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


        <h2>Update Fitness Test</h2>


        <form class="form-inline" ng-submit="updateFitnessTest()">
            <!--<div class="form-group" ng-repeat="a in attendanceTables.map.attendanceTable.myArrayList"></div>-->

            <div class="form-group">


                <br>
                <br>

                <br><label for="insertKmRun"> 1 KM Run Score (1=low 2=medium 3=high) </label>
                <select id="insertKmRun" ng-model="kmRunStatus">
                    <option value="1">1 (greater than 04.10 minutes)</option>
                    <option value="2">2 (between 04.10 and 03.45)</option>
                    <option value="3">3 (less than 03.45)</option>
                </select><br>
                <br>
                <br>

                <br><label for="insertAgility"> Agility Score (1=low 2=medium 3=high) </label>
                <select id="insertAgility" ng-model="agilityStatus">
                    <option value="1">1 (greater than 04.10 minutes)</option>
                    <option value="2">2 (between 04.10 and 03.45)</option>
                    <option value="3">3 (less than 03.45)</option>
                </select><br>
                <br>
                <br>

                <br><label for="insertSprint">Sprint Score </label>
                <select id="insertSprint" ng-model="sprintStatus">
                    <option value="1">1 (greater than 04.10 minutes)</option>
                    <option value="2">2 (between 04.10 and 03.45)</option>
                    <option value="3">3 (less than 03.45)</option>
                </select><br>
                <br>
                <br>

                <br><label for="insertPushUps">Push Ups Score </label>
                <select id="insertPushUps" ng-model="pushUpsStatus">
                    <option value="1">1 (greater than 04.10 minutes)</option>
                    <option value="2">2 (between 04.10 and 03.45)</option>
                    <option value="3">3 (less than 03.45)</option>
                </select><br>
                <br>
                <br>

                <br><label for="insertChinUps">Chin Ups Score </label>
                <select id="insertChinUps" ng-model="chinUpsStatus">
                    <option value="1">1 (greater than 04.10 minutes)</option>
                    <option value="2">2 (between 04.10 and 03.45)</option>
                    <option value="3">3 (less than 03.45)</option>
                </select><br>
                <br>
                <br>

                <br><label for="insertWorkLifestyle">Work/Lifestyle Activity (1-5)</label>
                <select id="insertWorkLifestyle" ng-model="workLifestyleStatus">
                    <option value="1">1 (greater than 04.10 minutes)</option>
                    <option value="2">2 (between 04.10 and 03.45)</option>
                    <option value="3">3 (less than 03.45)</option>
                    <option value="4">4 (less than 03.45)</option>
                    <option value="5">5 (less than 03.45)</option>
                </select><br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <button type="submit" class="btn btn-primary">Enter</button>

            </div>

        </form>

        <!-- line chart canvas element -->
        <canvas id="buyers" width="600" height="400"></canvas>

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
