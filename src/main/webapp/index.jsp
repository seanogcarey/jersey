<html>
<head>
    <title>Smart Bainisteoir Home</title>
    <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.0-beta.17/angular.min.js"></script>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <link rel="icon" href="/icons/notes.png">
    <script src="index.js"></script>

</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <li><span><img src="icons/notes.png"></span></li>
                <li><a href="/index.jsp">Home</a></li>
                <li><a href="views/ClubView.jsp#/club/">All Clubs</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
</div>


    <br>
    <br>
    <br>
    <h2>Welcome to Smart Bainisteoir! </h2>

    <br>
    <p>The smart manager web application to meet your club and team needs.</p>
    <!--
    <p><a href="jersey/managers/getAllManagers">Managers</a> </p>
    <p><a href="jersey/players/getAllPlayers">Players</a> </p>
    <p><a href="jersey/players/getPlayer/1">Single Player View</a></p>
    <p><a href="views/TeamView.jsp">Team View</a></p>
    <p><a href="views/PlayerView.jsp">Player View</a></p>
    <p><a href="views/PlayerSingleView.jsp">Player Single View</a></p>
    <p><a href="views/ManagerView.jsp">Manager View</a></p>
    <p><a href="views/sample.jsp">Sample View</a> </p>
    <p><a href="views/View.jsp">View</a></p>
    <p><a href="views/GraphTestView.jsp">Graph Test</a></p>
    -->

<!--
    <p><a href="views/ClubView.jsp#/club/">Enter site</a></p>
-->

    <br>
    <button type="button" class="btn btn-default btn-lg" onclick="location.href='http://localhost:8081/views/ClubView.jsp#/club/'">
        <span class="glyphicon glyphicon-circle-arrow-right" aria-hidden="true"></span> Enter Site to begin
    </button>



</body>
</html>
