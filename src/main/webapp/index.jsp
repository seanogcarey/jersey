<html>
<head>
    <title>Manager App</title>
    <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.0-beta.17/angular.min.js"></script>
    <link rel="icon" href="jersey/football-icon.png" type="image/x-icon" />
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
        <p>The ID is {{a.map.claimId}}
        </p>
        <p>The reference is {{a.map.claimReference}}</p>
        </div>
    </div>

</body>
</html>
<script src="hello.js"></script>