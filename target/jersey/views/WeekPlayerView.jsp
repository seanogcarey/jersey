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
    <title>Player Week Record</title>
    <script data-require="angular.js@1.0.x" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js" data-semver="1.0.8"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="/javascript/controller/week_player_controller.js"></script>
    <script src="/javascript/externalJavascriptResources/Chart.js"></script>
    <script src="http://bebraw.github.io/Chart.js.legend/src/legend.js"></script>
    <link rel="icon" href="/icons/notes.png">



    <script type="text/ng-template" id="weekPlayerView.html">

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
                        <li ng-repeat="b in players.map.player.myArrayList"><a href="/views/GraphTestView.jsp#/player/{{b.map.playerId}}">Training Groups</a></li>
                    </ul>
                </div>
            </div>
        </nav>


        <br>
        <br>
        <br>
        <div ng-repeat="a in weeks.map.week.myArrayList">
            <h2>Week Record: Week {{a.map.weekNum}}</h2>
        </div>
        <div ng-repeat="a in players.map.player.myArrayList">
            <h4>Player: {{a.map.firstName}} {{a.map.lastName}}</h4>
        </div>



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
                    <td ng-repeat="a in weeks.map.week.myArrayList">  {{a.map.weekNum }}</td>
                    <td ng-repeat="a in players.map.player.myArrayList">{{a.map.firstName}} {{a.map.lastName}}</td>
                    <td ng-repeat="a in teams.map.team.myArrayList">  {{a.map.teamName }}</td>
                </tr>
                </tbody>
            </table>
        </div>
        </div>

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


        <div class="panel-heading"ng-repeat="a in weeks.map.week.myArrayList"><span class="lead"> Overall Attendance for  Week {{a.map.weekNum }} </span></div>
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
                    <th></th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>

                <tr ng-repeat="a in sessions.map.session.myArrayList">
                    <td ng-repeat="b in players.map.player.myArrayList"><a href="/views/SessionView.jsp#/session/{{a.map.sessionId}}/week/{{a.map.weekId}}/player/{{b.map.playerId}}">{{a.map.sessionType}}</a></td>
                    <td ng-repeat="b in players.map.player.myArrayList"><a href="/views/SessionView.jsp#/session/{{a.map.sessionId}}/week/{{a.map.weekId}}/player/{{b.map.playerId}}">{{a.map.sessionDate}}</a></td>
                    <td ng-repeat="b in players.map.player.myArrayList"><a href="/views/SessionView.jsp#/session/{{a.map.sessionId}}/week/{{a.map.weekId}}/player/{{b.map.playerId}}"><button class="btn btn-default">Attendance Record</button></a></td>
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

                <option value="EMPTY">EMPTY</option>
                <option value="Fitness Workout">Fitness Workout</option>
                <option value="College Training">College Training</option>
                <option value="School Training">School Training</option>
                <option value="College,School Match">College,School Match</option>
                <option value="County Training">County Training</option>
                <option value="County Match">County Match</option>
                <option value="Other Club Training">Other Club Training</option>
                <option value="Other Club Match">Other Club Match</option>
                <option value="Other Team(within this club) Match,Training">Other Team(within this club) Match/Training</option>

            </select>
                <br>
                <br>
                <br><label for="insertSessionType2">Sesson Type 2</label>
                <select id="insertSessionType2" ng-model="session2Type" class="form-control" placeholder="SessionType2" >

                    <option value="EMPTY">EMPTY</option>
                    <option value="Fitness Workout">Fitness Workout</option>
                    <option value="College Training">College Training</option>
                    <option value="School Training">School Training</option>
                    <option value="College,School Match">College,School Match</option>
                    <option value="County Training">County Training</option>
                    <option value="County Match">County Match</option>
                    <option value="Other Club Training">Other Club Training</option>
                    <option value="Other Club Match">Other Club Match</option>
                    <option value="Other Team(within this club) Match,Training">Other Team(within this club) Match/Training</option>

                </select>
                <br>
                <br>
                <br><label for="insertSessionType3">Sesson Type 3</label>
                <select id="insertSessionType3" ng-model="session3Type" class="form-control" placeholder="SessionType3" >

                    <option value="EMPTY">EMPTY</option>
                    <option value="Fitness Workout">Fitness Workout</option>
                    <option value="College Training">College Training</option>
                    <option value="School Training">School Training</option>
                    <option value="College,School Match">College,School Match</option>
                    <option value="County Training">County Training</option>
                    <option value="County Match">County Match</option>
                    <option value="Other Club Training">Other Club Training</option>
                    <option value="Other Club Match">Other Club Match</option>
                    <option value="Other Team(within this club) Match,Training">Other Team(within this club) Match/Training</option>

                </select>
                <br>
                <br>
                <br><label for="insertSessionType4">Sesson Type 4</label>
                <select id="insertSessionType4" ng-model="session4Type" class="form-control" placeholder="SessionType4" >

                    <option value="EMPTY">EMPTY</option>
                    <option value="Fitness Workout">Fitness Workout</option>
                    <option value="College Training">College Training</option>
                    <option value="School Training">School Training</option>
                    <option value="College,School Match">College,School Match</option>
                    <option value="County Training">County Training</option>
                    <option value="County Match">County Match</option>
                    <option value="Other Club Training">Other Club Training</option>
                    <option value="Other Club Match">Other Club Match</option>
                    <option value="Other Team(within this club) Match,Training">Other Team(within this club) Match/Training</option>

                </select>
                <br>
                <br>
                <br><label for="insertSessionType5">Sesson Type 5</label>
                <select id="insertSessionType5" ng-model="session5Type" class="form-control" placeholder="SessionType5" >

                    <option value="EMPTY">EMPTY</option>
                    <option value="Fitness Workout">Fitness Workout</option>
                    <option value="College Training">College Training</option>
                    <option value="School Training">School Training</option>
                    <option value="College,School Match">College,School Match</option>
                    <option value="County Training">County Training</option>
                    <option value="County Match">County Match</option>
                    <option value="Other Club Training">Other Club Training</option>
                    <option value="Other Club Match">Other Club Match</option>
                    <option value="Other Team(within this club) Match,Training">Other Team(within this club) Match/Training</option>

                </select>
                <br>
                <br>
                <br>
                <label for="insertSessionType6">Sesson Type 6</label>
                <select id="insertSessionType6" ng-model="session6Type" class="form-control" placeholder="SessionType6" >

                    <option value="EMPTY">EMPTY</option>
                    <option value="Fitness Workout">Fitness Workout</option>
                    <option value="College Training">College Training</option>
                    <option value="School Training">School Training</option>
                    <option value="College,School Match">College,School Match</option>
                    <option value="County Training">County Training</option>
                    <option value="County Match">County Match</option>
                    <option value="Other Club Training">Other Club Training</option>
                    <option value="Other Club Match">Other Club Match</option>
                    <option value="Other Team(within this club) Match,Training">Other Team(within this club) Match/Training</option>

                </select>
                <br>
                <br>
                <br><label for="insertSessionType7">Sesson Type 7</label>
                <select id="insertSessionType7" ng-model="session7Type" class="form-control" placeholder="SessionType7" >

                    <option value="EMPTY">EMPTY</option>
                    <option value="Fitness Workout">Fitness Workout</option>
                    <option value="College Training">College Training</option>
                    <option value="School Training">School Training</option>
                    <option value="College,School Match">College,School Match</option>
                    <option value="County Training">County Training</option>
                    <option value="County Match">County Match</option>
                    <option value="Other Club Training">Other Club Training</option>
                    <option value="Other Club Match">Other Club Match</option>
                    <option value="Other Team(within this club) Match,Training">Other Team(within this club) Match/Training</option>

                </select>


            </div>

            <br>
            <br>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        <div class="alert alert-success"  aria-label="close" ng-show="submissionSuccess">
            <strong>Success! </strong> Club created
        </div>

    </script>


</head>

<body ng-controller="Page1Ctrl">
<p ng-view>Hello from {{page}}!</p>



</body>

</html>

