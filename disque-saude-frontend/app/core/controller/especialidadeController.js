app.controller("especialidadeCtrl", function ($scope, $http, especialideApi, $location, unidadeApi) {
    
    $scope.adicionaEspecialidade = function(especialidade){
        especialideApi.addEspecialidade(especialidade).then(function success(response){
            console.log(response.data)
        },function error(error){

        })
    }
});