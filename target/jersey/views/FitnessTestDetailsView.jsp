<%--
  Created by IntelliJ IDEA.
  User: Sean
  Date: 18/05/2016
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>

<head>
    <meta charset="utf-8" />
    <title>Fintess Player Team</title>
    <script data-require="angular.js@1.0.x" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js" data-semver="1.0.8"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="icon" href="/icons/notes.png">


    <script>
        function goBack() {
            window.history.back();
        }
    </script>

</head>

<body>


<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">



        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" ng-repeat="a in teams.map.team.myArrayList">
            <ul class="nav navbar-nav">
                <li><span><img src="http://localhost:8081/icons/notes.png"></span></li>
                <li><a href="/index.jsp">Home</a></li>
                <li><a href="/views/ClubView.jsp#/club/">All Clubs</a></li>
            </ul>
        </div>
    </div>
</nav>

<br>
<br>
<br>



<div ng-repeat="a in teams.map.team.myArrayList">
    <h2><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> Fitness Test Details</h2>
</div>
<br>

<button class="btn btn-default" onclick="goBack()"><span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span> Return</button>
<br>
<br>

<br>
<div class="col-md-6">
<p>Fitness tests generally take place at the start of the season and then again mid-season with the expectation of improvement.</p>


    <br>
    <h3>KM Run</h3>
    <p>A timed 1 KM run</p>
    <p><b>Greater than 04:10 Minutes: </b> Score of 1. Needs major improvement. Imagine this will automatically go down over a period of consistent training.</p>
    <p><b>Between 03:45 and 04:10 Minutes: </b>Score of 2. Better but similar to above.</p>
    <p><b>Less than 03:45 Minutes: </b>Score of 3. Great time, keep the it up.</p>

    <br>
    <h3>Agility</h3>
    <p>(505 Agility) Markers are set up 5 and 15 meters from a line marked on the ground. The athlete runs from the 15 meter marker towards the line (run in distance to build up speed) and through the 5 m markers, turns on the line and runs back through the 5 m markers. The time is recorded from when the athletes first runs through the 5 meter marker, and stopped when they return through these markers (that is, the time taken to cover the 5 m up and back distance - 10 m total). The best of two trails is recorded.</p>
    <p><b>Greater than 07:793 Seconds: </b> Score of 1. Machanics of turning usually let these people down, which is crucial in Sport and must be improved on with short snappy agility drills.</p>
    <p><b>Between 02:612 and 07:793 Seconds: </b>Score of 2. Average enough, again similar to above where usually it was the turn that let people down.</p>
    <p><b>Less than 02:612 Seconds: </b>Score of 3. Very good mechanics and turning at the cone as well as acceleration on the turn</p>


    <br>
    <h3>Speed</h3>
    <p>(Sprint) 10 m timed sprint.</p>
    <p><b>Greater than 02:00 Seconds: </b> Score of 1.  Anything over 2 seconds is too slow. You need to be strong before you can be powerful, also reducing body weight and maintaining strength will aid this.</p>
    <p><b>Between 02:00 and 01:907 Seconds: </b>Score of 2. Good but still needs to be improved on the aspects of the above line.</p>
    <p><b>Less than 01:907 Seconds: </b>Score of 3. Very good, keep it up.</p>

    <br>
    <h3>Push Ups</h3>
    <p>As many push you can do without rest. Use a partner to count(Only full push ups count ie: chest touching partners thumb).</p>
    <p><b>Less than 30 pushups</b> Score of 1.  Very poor. Increase this by doing 3 sets of ten morning and evening.</p>
    <p><b>Between 29 and 44 pushups : </b>Score of 2. Quite a good score but can be improved .</p>
    <p><b>Greater than 44 pushups: </b>Score of 3. Brilliant score, keep it up(make sure they're good quality pushups).</p>

    <br>
    <h3>Chin Ups</h3>
    <p>(Using a bar) As many chin ups you can do with rest. One chin up is counted when the your chin is over the bar.</p>
    <p><b>Less than 6 chin ups </b> Score of 1. Needs serious work. Firstly body weight could be an issue, so reducing body weight will make it easier to pull yourself to the bar and also increase strength training to become stronger.</p>
    <p><b>6 or 7 chin ups : </b>Score of 2. Good score. To achieve the target, increase the practise of chin ups, decrease body weight and increase strength training.</p>
    <p><b>Greater than 7 chin ups: </b>Score of 3. Brilliant score, keep up the good work.</p>

    <br>
    <h3>Work/Lifestyle Activity</h3>
    <p> <b>(Rate from 1-5)</b> Your personal rating of the exercise you get through from your day to day lifestyle. For example a low score would be driving to work every day and sitting in an office from 9 to 5. A high score could possibly be cycling to work, working with manual hard labour.</p>


    <br>
    <h5>Credit: JG ELITE Gym Athlone</h5>

</div>



</div>
</body>

</html>
