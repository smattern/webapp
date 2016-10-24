var taskManagerModule = angular.module('taskManagerApp', []);

taskManagerModule.controller('taskManagerController', function ($scope,$http, ) {

    $scope.employees = {};
    $scope.employee = {};

    // get all employees
    $http.defaults.headers.post["Content-Type"] = "application/json";
    $scope.load = function() {
            $http({method: "GET", url: "http://localhost:8080/all"}).
                        then(function(response) {
                            // success callback
                            $scope.employees = response.data;

                            console.log($scope.employees);
                            console.log($scope.status);
                        }, function(response) {
                            // failure call back
                            $scope.employees = response.data || 'Request failed';
                            $scope.status = response.status;

                            console.log($scope.data);
                            console.log($scope.status);
                      });
          };

    $scope.load();

    // save a new employee
    $scope.save = function(employee) {
        console.log("--> New Employee");
        console.log($scope.employee);

        $http.post("http://localhost:8080/add", $scope.employee)
           .then(
               function(response){
                 // success callback
                 console.log(response.data);

                 $scope.load();
               },
               function(response){
                 // failure callback
               }
            );
         };
 });