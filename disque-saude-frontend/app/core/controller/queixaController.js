app.controller("queixaCtrl", function ($scope, queixaApi, $http, toastr, $location, $routeParams) {

    $scope.registrarQueixa = function (complaint) {
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

    $scope.procurarQueixa = function (id) {
        $http.get("http://localhost:5000/SpringBootRestApi/queixa/" + id).then(function successCallback(response) {
            $scope.complaint = response.data;
        }, function errorCallback(error) {
            $scope.complaint = null;
            console.log(error);
        });
    }

    $scope.situation = "";

    var getSituacaoGeralQueixas = function (neighborhood) {
        queixaApi.getSituacaoGeralQueixas().then(function success(response) {
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

    getSituacaoGeralQueixas();

    $scope.respostaQueixaId = "";
    var showMessage = function () {
        $scope.respostaQueixaId = $routeParams.id;
    }

    showMessage();

    $scope.complaints = "";

    var getQueixas = function () {
        $http.get("http://localhost:5000/SpringBootRestApi/queixa/")
            .then(function success(response) {
                $scope.complaints = response.data;
                console.log(response.data);
            })

    }

    getQueixas();

    $scope.newQueixa = {
        status : null
    };

    $scope.modificarStatusDaQueixa = function (id) {
        var queixaASerModificada = new Object();
        queixaASerModificada.id = id;
        queixaApi.modificarStatusDaQueixa(id, $scope.newQueixa.status).then(function sucess(response) {
            console.log(response.data)
        });
    }

    $scope.adicionaComentarioNaQueixa = function (id, comentario) {
        var queixaComComentario = new Object();
        queixaComComentario.comentario = comentario;
        queixaComComentario.id = id;
        queixaApi.adicionaComentarioNaQueixa(queixaComComentario).then(function sucess(response) {
            console.log(response.data)
        }); 
    }
});