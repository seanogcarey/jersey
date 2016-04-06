/**
 * Created by Sean on 05/04/2016.
 */
'use strict';

App.controller('ManagerController', ['$scope', 'ManagerService', function($scope, ManagerService) {
    var self = this;

    self.getAllManagers = function(){
        ManagerService.getAllManagers()
            .then(
                function(data) {
                    self.managers = data;
                },
                function(errResponse){
                    console.error('Error while fetching Managers');
                }
            );
    };

}]);