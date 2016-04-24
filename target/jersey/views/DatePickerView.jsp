<!doctype html>
<html ng-app="MyApp">
<head>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular-animate.js"></script>
    <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-1.3.2.js"></script>
    <script src="/javascript/controller/date_picker_controller.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

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

<div ng-controller="DatepickerPopupDemoCtrl">



        <br>
        <form class="form-inline" ng-submit="createClub()">


            <div class="form-group">
                <label for="inputClubName">Club Name</label>
                <input type="text" class="form-control" ng-model="clubName" id="inputClubName" placeholder="Club Name">
                <label for="inputClubEmail">Email</label>
                <input type="text" class="form-control" ng-model="email" id="inputClubEmail" placeholder="Email">

                <div class="col-md-6">
                    <p class="input-group">
                        <label for="inputClubDate">Date: </label>
                        <input type="text" class="form-control" id="inputClubDate" uib-datepicker-popup="{{format}}" ng-model="dt" is-open="popup1.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" />
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
            <strong>Success! </strong> Club created
        </div>


</div>


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
