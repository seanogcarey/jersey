<%--
  Created by IntelliJ IDEA.
  User: Sean
  Date: 25/04/2016
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html ng-app="MyApp">
<head>

    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.js"></script>
    <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-1.3.2.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0rc1/angular-route.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" href="/icons/notes.png">
    <!--
     <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.13.2.js"></script>
   <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.8/angular.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0rc1/angular-route.min.js"></script>
   <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.10.0.js"></script>
   <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
pls-0.13.2.js"></script>


   <link href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

   -->
    <script src="/javascript/controller/manager_session_controller.js"></script>


    <script type="text/ng-template" id="sessionView.html">


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
                        <li ng-repeat="a in weeks.map.week.myArrayList"><a href="/views/AttendanceWeekViewView.jsp#/week/{{a.map.weekId}}">Attendance Sheet</a></li>
                        <li ng-repeat="a in weeks.map.week.myArrayList"><a href="/views/ManagerSessionView.jsp#/week/{{a.map.weekId}}">Session Overview</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <br>
        <br>
        <br>

        <div ng-repeat="a in weeks.map.week.myArrayList">
            <h2>Week {{a.map.weekNum}} Session Overview</h2>
        </div>
        <div ng-repeat="a in teams.map.team.myArrayList">
            <h4>Team: {{a.map.teamName}} Session Overview</h4>
        </div>


        <br>
        <br>

        <button class="btn btn-default" ng-click="addSession()">Add Session <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span></button>

        <div ng-show="showAddSessionForm">

            <br>
            <div class="form-inline" ng-submit="createWeek()">




        <form class="form-inline" ng-submit="createSession()">


            <div class="form-group">
                <div class="col-md-6">

                <br><label for="insertSessionType">Select Session Type</label>
                <select id="insertSessionType" ng-model="sessionTypeStatus" class="form-control">
                    <option value="Training">Training</option>
                    <option value="Match">Match</option>
                </select>
                </div>
                <br>
                <br>
                <br>
                <br>
                <br>

                <div class="col-md-6">

                    <p class="input-group">
                        <label for="inputStartDate">Session Date</label>
                        <input type="text" class="form-control" id="inputStartDate" uib-datepicker-popup="{{format}}" ng-model="dt" is-open="popup1.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" />
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-default" ng-click="open1()"><i class="glyphicon glyphicon-calendar"></i></button>
                        </span>
                    </p>

                </div>
            </div>



            <hr/>
            <button type="button" class="btn btn-sm btn-info" ng-click="today()">Today</button>
            <button type="button" class="btn btn-sm btn-danger" ng-click="clear()">Clear</button>

            <br>
            <br>
            <button type="submit" class="btn btn-primary">Enter</button>
        </form>
        <div class="alert alert-success"  aria-label="close" ng-show="submissionSuccess">
            <strong>Success! </strong> Session created
        </div>
            </div>



        </div>

        <div class="panel-heading"><span class="lead">Sessions: </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>
                        Session Type:
                    </th>
                    <th>
                        Date:
                    </th>

                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in sessions.map.session.myArrayList">
                    <td>{{a.map.sessionType}}</td>
                    <td>{{a.map.sessionDateString}}</td>
                </tr>
                </tbody>
            </table>
        </div>
        </div>


    </script>




</head>
<body ng-controller="Page1Ctrl">

<style>
    .full button span {
        background-color: limegreen;
        border-radius: 32px;
        color: black;
    }
    .partially button span {
        background-color: orange;
        border-radius: 32px;
        color: black;
    }
</style>


<p ng-view>Hello from {{page}}!</p>


<!--
<div class="col-md-6">
    <p class="input-group">
        <input type="text" class="form-control" uib-datepicker-popup="{{format}}" ng-model="dt" is-open="popup1.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" />
  <span class="input-group-btn">
    <button type="button" class="btn btn-default" ng-click="open1()"><i class="glyphicon glyphicon-calendar"></i></button>
  </span>
    </p>
</div>

<div class="col-md-6">
    <p class="input-group">
        <input type="text" class="form-control" uib-datepicker-popup ng-model="dt" is-open="popup2.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" />
  <span class="input-group-btn">
    <button type="button" class="btn btn-default" ng-click="open2()"><i class="glyphicon glyphicon-calendar"></i></button>
  </span>
    </p>
</div>
</div>
<div class="row">
<div class="col-md-6">
    <label>Format: <span class="muted-text">(manual alternate <em>{{altInputFormats[0]}}</em>)</span></label> <select class="form-control" ng-model="format" ng-options="f for f in formats"><option></option></select>
</div>
</div>

-->


</body>

</html>

