/**
 * Created by Sean on 05/04/2016.
 */

'use strict';

App.factory('Club', ['$http', '$q', function($http, $q){

    return {

        getAllClubs: function() {
            return $http.get('http://localhost:8081/jersey/clubs/getAllClubs/')
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while fetching clubs');
                        return $q.reject(errResponse);
                    }
                );
        },

        createUser: function(clubName){
            return $http.post('http://localhost:8081/jersey/clubs/createClub', clubName)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while creating club');
                        return $q.reject(errResponse);
                    }
                );
        },

        /*
        updateUser: function(user, id){
            return $http.put('http://localhost:8080/Spring4MVCAngularJSExample/user/'+id, user)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while updating user');
                        return $q.reject(errResponse);
                    }
                );
        },

        deleteUser: function(id){
            return $http.delete('http://localhost:8080/Spring4MVCAngularJSExample/user/'+id)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while deleting user');
                        return $q.reject(errResponse);
                    }
                );
        }
        */

    };

}]);