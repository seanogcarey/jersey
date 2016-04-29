<!doctype html>
<html ng-app="MyApp">
<head>

    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.js"></script>
    <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-1.3.2.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0rc1/angular-route.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
       <!--
        <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.13.2.js"></script>
      <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.8/angular.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0rc1/angular-route.min.js"></script>
      <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.10.0.js"></script>
      <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
 pls-0.13.2.js"></script>


      <link href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

      -->
    <script src="/javascript/controller/manager_team_controller.js"></script>





    <script type="text/ng-template" id="teamView.html">



        <div ng-repeat="a in teams.map.team.myArrayList">
            <p><b>{{a.map.teamName}}</b></p>
        </div>

        <br>
        <form class="form-inline" ng-submit="createWeek()">


            <div class="form-group">

                <label for="inputWeekNumber">Week Number</label>
                <input type="text" class="form-control" ng-model="weekNum" id="inputWeekNumber" placeholder="Week Number">


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


        <div class="panel-heading"><span class="lead">Weeks: </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
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
                        Attendance Record:
                    </th>
                    <th>
                        Sessions
                    </th>

                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="a in weeks.map.week.myArrayList">
                    <td>{{a.map.weekNum}}</td>
                    <td>{{a.map.startDateString}}</td>
                    <td>{{a.map.endDateString}}</td>
                    <td><a href="/views/AttendanceWeekViewView.jsp#/week/{{a.map.weekId}}">Attendance Sheet</a></td>
                    <td><a href="http://localhost:8081/views/ManagerSessionView.jsp#/week/{{a.map.weekId}}">Week {{a.map.weekNum}} Sessions </a></td>

                </tr>
                </tbody>
            </table>
        </div>
        </div>



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
