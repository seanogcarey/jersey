<html>
<head>
    <title>Manager App</title>
    <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.0-beta.17/angular.min.js"></script>
    <link rel="icon" href="jersey/football-icon.png" type="image/x-icon" />

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<body>
    <h2>Manager RESTful Web Application!</h2>
    <p><a href="jersey/myresource">Jersey resource</a>
    <p><a href="jersey/UserService/users">Users Resource</a> </p>
    <p><a href="jersey/claims/getAllClaims">Claims Resource</a> </p>
    <p><a href="jersey/claims/getClaim/1">One Claim</a> </p>

    <h2>Angular Example:</h2>
    <div ng-app="myApp" ng-controller="personCtrl">

        First Name: <input type="text" ng-model="firstName"><br>
        Last Name: <input type="text" ng-model="lastName"><br>
        <br>
        Full Name: {{firstName + " " + lastName}}

        <div ng-repeat="a in claims.map.claim.myArrayList">
            <p><a href="jersey/claims/getClaim/{{a.map.claimId}}">Claim Link</a></p>
            <p>The ID is {{a.map.claimId}}
            </p>
            <p>The reference is {{a.map.claimReference}}</p>
        </div>
        <p>The ID is {{a.map.claimId}}
        </p>
        <p>The reference is {{a.map.claimReference}}</p>
        </div>
    </div>

</body>
</html>
<script src="hello.js"></script>