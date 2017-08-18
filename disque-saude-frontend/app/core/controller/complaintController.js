app.controller("complaintCtrl", function ($scope, $http, toastr, $location, $routeParams) {

    $scope.registerComplaint = function (complaint) {
        $http.post("http://localhost:5000/SpringBootRestApi/queixa/", JSON.stringify(complaint))
            .then(function success(response) {
                toastr.success("Queixa adicionada com sucesso!");
                $location.path('/createdcomplaint/' + response.data.id);
            }, function error(error) {
                console.log(error);
                console.log("Problemas ao tentar adicionar queixa.");
            });
    }

    $scope.complaint;

    $scope.searchComplaint = function (id) {
        $http.get("http://localhost:5000/SpringBootRestApi/queixa/" + id).then(function successCallback(response) {
            $scope.complaint = response.data;
        }, function errorCallback(error) {
            $scope.complaint = null;
            console.log(error);
        });
    }

    $scope.situation = "";

    // verificar se o http.get esta correto
    var getGeneralSituationComplaints = function (neighborhood) {
        $http.get("http://localhost:5000/SpringBootRestApi/queixa/geral/situacao")
            .then(function success(response) {
                console.log(response.data.obj);

                if(response.data.obj == 0){
                    $scope.situation = {
                        status: "RUIM",
                        color: "label-danger"
                    };

                } else if(response.data.obj == 1){

                    $scope.situation = {
                        status: "REGULAR",
                        color: "label-primary"
                    };
                } else {
                    $scope.situation = "";
                    $scope.situation = {
                        status: "BOM",
                        color: "label-success"
                    };
                    
                }
            }, function failed(error) {
                console.log("Erro na busca de unidades");
                console.log(error.data.errorMessage);
            });
    }

    getGeneralSituationComplaints();

    $scope.responseComplaintId = "";
    var showMessage = function () {
        $scope.responseComplaintId = $routeParams.id;
    }

    showMessage();

    $scope.complaints = "";

    var getComplaints = function () {
        $http.get("http://localhost:5000/SpringBootRestApi/queixa/")
            .then(function success(response) {
                $scope.complaints = response.data;
                console.log(response.data);
            })

    };

    getComplaints();

});