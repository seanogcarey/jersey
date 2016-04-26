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
    <link rel="icon" href="http://getbootstrap.com/favicon.ico" />

    <script type="text/ng-template" id="graphView.html">


        <h3>Info:</h3>
        <p><b>Low:   </b>Means more work needs to be done</p>
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