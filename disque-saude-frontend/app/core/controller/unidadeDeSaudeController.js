app.controller("unidadeDeSaudeCtrl", function ($scope, $http) {

    $scope.unidades = [];

    $scope.procuraHU = function (neighborhood) {
        $http.get("http://localhost:5000/SpringBootRestApi/unidade/busca?bairro=" + neighborhood)
            .then(function success(response) {
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

    $scope.pesquisaMediaPorPaciente = function (id) {
        $http.get("http://localhost:5000/SpringBootRestApi/unidade/geral/medicos/" + id).then(function successCallback(response) {
            $scope.media = response.data.obj;
        }, function errorCallback(error) {
            console.log("Unidade Não Encontrada");
        });
    }

});