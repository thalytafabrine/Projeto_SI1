app.controller("queixaCtrl", function ($scope, queixaApi, $http, toastr, $location, $routeParams) {

    $scope.registrarQueixa = function (complaint, tipo) {
        complaint.type = tipo;
        queixaApi.registrarQueixa(complaint).then(function success(response) {
                toastr.success("Queixa adicionada com sucesso!");
                $location.path('/createdcomplaint/' + response.data.id);
            }, function error(error) {
                console.log(error);
                console.log("Problemas ao tentar adicionar queixa.");
            });
    }

    $scope.registraQueixaTipo = function() {
        if($scope.tipo == "ALIMENTAR"){
            $location.path("/registrarQueixaAlimentar");
        }else if($scope.tipo == "ANIMAL"){
            $location.path("/registrarQueixaAnimal");
        }
        console.log($scope.tipo);
    }

    $scope.complaint;

    $scope.procurarQueixa = function (id) {
        queixaApi.procurarQueixa(id).then(function successCallback(response) {
            $scope.complaint = response.data;
        }, function errorCallback(error) {
            $scope.complaint = null;
            console.log(error);
        });
    }

    $scope.situation = "";

    var getSituacaoGeralQueixas = function () {
        queixaApi.getSituacaoGeralQueixas().then(function success(response) {
                console.log(response.data);

                if(response.data == "RUIM"){
                    $scope.situation = {
                        status: "RUIM",
                        color: "label-danger"
                    };

                } else if(response.data == "REGULAR"){

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

    $scope.queixas = "";

    var getQueixas = function () {
        queixaApi.getQueixas().then(function success(response) {
                $scope.queixas = response.data;
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
        queixaApi.adicionaComentarioNaQueixa(id, comentario).then(function sucess(response) {
            console.log(response.data)
        }); 
    }

    $scope.voltar = function () {
        $location.path("/");

    }

    $scope.voltarMenuAdm = function () {
        $location.path("/administrador")
    }

});