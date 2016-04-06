/**
 * Created by Sean on 05/04/2016.
 */
App.factory('ManagerService', ['$http', '$q', function($http, $q){

    return {

        getAllManagers: function() {
            return $http.get('http://localhost:8081/jersey/managers/getAllManagers/')
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while fetching managers');
                        return $q.reject(errResponse);
                    }
                );
        },
    };

}]);