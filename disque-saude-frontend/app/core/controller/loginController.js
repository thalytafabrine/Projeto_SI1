app.controller("loginCtrl", function($scope, loginApi, $location, $rootScope){

    $rootScope.logado = false;

    $scope.login = function(email, senha ){
        loginApi.login(email, senha).then(function success(response) {
                
                
                $location.path("/");
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