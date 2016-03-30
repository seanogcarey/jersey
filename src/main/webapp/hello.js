/**
 * Created by Sean on 08/03/2016.
 */
angular.module('myApp', []).controller('personCtrl', function($scope, $http) {
    $scope.firstName = "John",
        $scope.lastName = "Doe",
        $http.get('http://localhost:8081/jersey/claims/getAllClaims').
        success(function(data) {
            $scope.claims = data;
        });
    $scope.fullName = function() {
        return $scope.firstName + " " + $scope.lastName;
    }
});