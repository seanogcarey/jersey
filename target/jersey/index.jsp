<html>
<head>
    <title>Manager App</title>
    <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.0-beta.17/angular.min.js"></script>
</head>
<body>
    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="rest/myresource">Jersey resource</a>
    <p><a href="rest/UserService/users">Users Resource</a> </p>
    <p><a href="rest/claims/getAll">Claims Resource</a> </p>
    <p><a href="rest/claims/getOne">One Claim</a> </p>

    <h2>Angular stuff!</h2>
    <div ng-app="myApp" ng-controller="personCtrl">

        First Name: <input type="text" ng-model="firstName"><br>
        Last Name: <input type="text" ng-model="lastName"><br>
        <br>
        Full Name: {{firstName + " " + lastName}}


        <p>The ID is {{claim.claimId}}</p>
        <p>The reference is {{claim.claimReference}}</p>
    </div>
</body>
</html>
<script src="personController.js"></script>
<script src="hello.js"></script>