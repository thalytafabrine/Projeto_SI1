app.controller("unidadeDeSaudeCtrl", function ($scope, unidadeApi, $http) {

    $scope.unidades = [];

    $scope.procuraUS = function (bairro) {
        unidadeApi.procuraUS(bairro).then(function success(response) {
            $scope.unidades = [];
            $scope.unidades.push(response.data);
            console.log("Foram encontradas Unidades de saúde");
            console.log(response.data);
        }, function failed(error) {
            console.log("Erro na busca de unidades");
            console.log(error.data.errorMessage);
        });
    }

    $scope.media = null;

    $scope.pesquisaMediaMedicoPorPaciente = function (id) {
        unidadeApi.pesquisaMediaMedicoPorPaciente(id).then(function successCallback(response) {
            $scope.media = response.data.obj;
        }, function errorCallback(error) {
            console.log("Unidade Não Encontrada");
        });
    }

    $scope.adicionarUnidadeDeSaude = function (unidade) {
        unidadeApi.adicionarUnidadeDeSaude(unidade).then(function response(success) {
            console.log(response.data);
        });
    }
});