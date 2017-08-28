app.controller("loginCtrl", function($scope, loginApi, $location, $rootScope){

    $rootScope.logado = false;

    $scope.login = function(administrador) {
        loginApi.logarAdministrador(administrador).then(function success(response) {
                console.log("Usuário logado com sucesso");
                alert("Seja bem vindo ao sistema do Disque Saude!")
                $location.path("/administrador");
                $rootScope.logado = true;
            }, function error(error) {
                console.log(error);
                console.log("Erro ao realizar login");
                $rootScope.logado = false;
            });
        
    }

    $scope.voltar = function () {
        $location.path("/");

    }
});