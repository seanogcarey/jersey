/**
 * Created by Sean on 05/04/2016.
 */

'use strict';

App.controller('ClubController', ['$scope', 'ClubService', function($scope, ClubService) {
    var self = this;
    self.club={clubId:null,clubName:'',address:'',email:''};
    self.clubs=[];

    self.fetchAllClubs = function(){
        ClubService.fetchAllClubs()
            .then(
                function(data) {
                    self.clubs = data;
                },
                function(errResponse){
                    console.error('Error while fetching Currencies');
                }
            );
    };

    self.createClub = function(club){
        ClubService.createClub(club)
            .then(
                self.fetchAllClubs(),
                function(errResponse){
                    console.error('Error while creating User.');
                }
            );
    };
/*
    self.updateUser = function(user, id){
        UserService.updateUser(user, id)
            .then(
                self.fetchAllUsers,
                function(errResponse){
                    console.error('Error while updating User.');
                }
            );
    };

    self.deleteUser = function(id){
        UserService.deleteUser(id)
            .then(
                self.fetchAllUsers,
                function(errResponse){
                    console.error('Error while deleting User.');
                }
            );
    };
    */

    self.fetchAllClubs();

    self.submit = function() {
        if(self.club.clubId===null){
            console.log('Saving New Club', self.club);
            self.createUser(self.club);
        }else{
            //self.updateUser(self.club, self.club.id);
            //console.log('Club updated with id ', self.club.id);
            console.log('Club not made');
        }
        self.reset();
    };

    /*
    self.edit = function(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].id === id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    };
    */

    /*
    self.remove = function(id){
        console.log('id to be deleted', id);
        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
            self.reset();
        }
        self.deleteUser(id);
    };

    */
    self.reset = function(){
        self.club={clubId:null,clubName:'',address:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    };

}]);