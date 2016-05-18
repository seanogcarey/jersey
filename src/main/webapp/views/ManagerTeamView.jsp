<!doctype html>
<html ng-app="MyApp">
<head>

    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.js"></script>
    <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-1.3.2.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0rc1/angular-route.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" href="/icons/notes.png">
    <script src="/javascript/controller/manager_team_controller.js"></script>





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
            <h2>Schedule Overview: {{a.map.teamName}}</h2>
        </div>

        <button class="btn btn-default" ng-click="addWeek()">Add Week <span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>

        <div ng-show="showAddWeekForm">

        <br>
        <form class="form-inline" ng-submit="createWeek()">


            <div class="form-group">

                <label for="inputWeekNumber">Week Number</label>
                <input type="number" class="form-control" ng-model="weekNum" id="inputWeekNumber" placeholder="Week Number">


                <br>
                <br>

                <div class="col-md-6">

                    <p class="input-group">
                        <label for="inputStartDate">Start Date: </label>
                        <input type="text" class="form-control" id="inputStartDate" uib-datepicker-popup="{{format}}" ng-model="dt" is-open="popup1.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" />
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-default" ng-click="open1()"><i class="glyphicon glyphicon-calendar"></i></button>
                        </span>

                        <label for="inputEndDate">End Date: </label>
                        <input type="text" class="form-control" id="inputEndDate" uib-datepicker-popup="{{format}}" ng-model="dt2" is-open="popup2.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" />

                        <span class="input-group-btn">
                            <button type="button" class="btn btn-default" ng-click="open2()"><i class="glyphicon glyphicon-calendar"></i></button>
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
            <strong>Success! </strong> Week created
        </div>

        </div>



        <div class="panel-heading"><span class="lead">Weeks: </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th></th>
                    <th>
                        Week Number:
                    </th>
                    <th>
                        Start Date:
                    </th>
                    <th>
                        End Date:
                    </th>
                    <th>

                    </th>
                    <th>

                    </th>

                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in weeks.map.week.myArrayList">
                    <td></td>
                    <td>{{a.map.weekNum}}</td>
                    <td>{{a.map.startDateString}}</td>
                    <td>{{a.map.endDateString}}</td>
                    <td><a href="/views/AttendanceWeekViewView.jsp#/week/{{a.map.weekId}}"><button class="btn btn-default">Attendance Sheet</button></a></td>
                    <td><a href="http://localhost:8081/views/ManagerSessionView.jsp#/week/{{a.map.weekId}}"><button class="btn btn-default">Week {{a.map.weekNum}} Session Overview</button></a></td>

                </tr>
                </tbody>
            </table>
        </div>
        </div>


        <!--

        <div class="panel-heading"><span class="lead">Players </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Player Name</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in teams.map.player.myArrayList">
                    <td>{{a.map.firstName}} {{a.map.lastName}}</td>
                </tr>
                </tbody>
            </table>
        </div>

      -->

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




</body>

</html>
