<%--
  Created by IntelliJ IDEA.
  User: Sean
  Date: 15/04/2016
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp">

<head>
    <meta charset="utf-8" />
    <title>Player</title>
    <script data-require="angular.js@1.0.x" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js" data-semver="1.0.8"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="/javascript/controller/week_player_controller.js"></script>
    <script src="/javascript/externalJavascriptResources/Chart.js"></script>
    <script src="http://bebraw.github.io/Chart.js.legend/src/legend.js"></script>
    <link rel="icon" href="http://getbootstrap.com/favicon.ico" />



    <script type="text/ng-template" id="weekPlayerView.html">


        <br>
        <br>

        <div class="panel-heading"></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Week :</th>
                    <th>Player Name :</th>
                    <th>Team : </th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td ng-repeat="a in weeks.map.week.myArrayList">  {{a.map.weekId }}</td>
                    <td ng-repeat="a in players.map.player.myArrayList">{{a.map.firstName}} {{a.map.lastName}}</td>
                    <td ng-repeat="a in teams.map.team.myArrayList">  {{a.map.teamName }}</td>
                </tr>
                </tbody>
            </table>
        </div>
        </div>


        <div class="panel-heading"ng-repeat="a in weeks.map.week.myArrayList"><span class="lead"> Overall Attendance for  Week {{a.map.weekId }} </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Number of overall training sessions:</th>
                    <th>Sessions with this team:</th>
                    <th>Sessions outside team:</th>

                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in attendanceWeekViews.map.attendanceWeekView.myArrayList">
                    <td>  {{a.map.numOfSessions }}</td>
                    <td> {{a.map.numOfSessionsWithTeam}}</td>
                    <td> {{numOfSessionsOutsideTeam}}</td>
                </tr>
                </tbody>
            </table>
        </div>

        <h3>Chart representation:</h3>
        <br>
        <canvas id="income" width="600" height="400"></canvas>
        <br>

        <div class="panel-heading"><span class="lead">Sessions</span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Session Type</th>
                    <th>Session Date</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>

                <tr ng-repeat="a in sessions.map.session.myArrayList">
                    <td ng-repeat="b in players.map.player.myArrayList"><a href="/views/SessionView.jsp#/session/{{a.map.sessionId}}/week/{{a.map.weekId}}/player/{{b.map.playerId}}">{{a.map.sessionType}}</a></td>
                    <td ng-repeat="b in players.map.player.myArrayList"><a href="/views/SessionView.jsp#/session/{{a.map.sessionId}}/week/{{a.map.weekId}}/player/{{b.map.playerId}}">{{a.map.sessionDate}}</a></td>
                </tr>
                </tbody>

            </table>
        </div>


        <div class="panel-heading"><span class="lead">Extra Sessions (with another team)</span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Extra Session 1</th>
                    <th>Extra Session 2</th>
                    <th>Extra Session 3</th>
                    <th>Extra Session 4</th>
                    <th>Extra Session 5</th>
                    <th>Extra Session 6</th>
                    <th>Extra Session 7</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>

                <tr ng-repeat="a in extraSessions.map.extraSession.myArrayList">
                    <td>{{a.map.sessionType1}}</td>
                    <td>{{a.map.sessionType2}}</td>
                    <td>{{a.map.sessionType3}}</td>
                    <td>{{a.map.sessionType4}}</td>
                    <td>{{a.map.sessionType5}}</td>
                    <td>{{a.map.sessionType6}}</td>
                    <td>{{a.map.sessionType7}}</td>
                </tr>
                </tbody>
                </tbody>
            </table>
        </div>

        <h2>Update Extra Sessions</h2>


        <form class="form-inline" ng-submit="createExtraSession()">
            <div class="form-group">


            <br>
            <br>

            <br><label for="insertSessionType1">Sesson Type 1</label>
            <select id="insertSessionType1" ng-model="session1Type" class="form-control" placeholder="SessionType1" >

                <option value="Fitness Workout">Fitness Workout</option>
                <option value="College Training">College Training</option>
                <option value="School Training">School Training</option>
                <option value="College,School Match">College,School Match</option>
                <option value="County Training">County Training</option>
                <option value="County Match">County Match</option>
                <option value="Other Club Training">Other Club Training</option>
                <option value="Other Club Match">Other Club Match</option>
                <option value="Other Team(within this club) Match,Training">Other Team(within this club) Match/Training</option>

            </select><br>
            <br>
            <br>

            </div>

            <button type="submit" class="btn btn-primary">Enter</button>
        </form>
        <div class="alert alert-success"  aria-label="close" ng-show="submissionSuccess">
            <strong>Success! </strong> Club created
        </div>

<!--

        <h2>Update Extra Sessions</h2>


        <form class="form-inline" ng-submit="createExtraSession()">
            <div class="form-group">
                <label for="exampleInputName2">Sesson Type 1</label>
                <input type="text" class="form-control" ng-model="text" id="exampleInputName2" placeholder="SessionType1">
            </div>
            <!--
            <div class="form-group">
                <label for="exampleInputEmail2">Email</label>
                <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
            </div>
            -->
        <!--
            <button type="submit" class="btn btn-primary">Enter</button>
        </form>
        <div class="alert alert-success"  aria-label="close" ng-show="submissionSuccess">
            <strong>Success! </strong> Club created
        </div>
        -->

    </script>


</head>

<body ng-controller="Page1Ctrl">
<p ng-view>Hello from {{page}}!</p>



</body>

</html>

