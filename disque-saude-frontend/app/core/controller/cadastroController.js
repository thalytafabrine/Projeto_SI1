app.controller("cadastroCtrl", function($scope,loginApi, $location, $rootScope ) {

	$rootScope.cadastrado= false;

	$scope.cadastrar = function(nome, email, senha) {
		loginApi.cadastrar(nome, email, senha).then(function success(response) {
			$location.path("/");
			$scope.cadastrado = true;
		}, function error(error) {
                console.log(error);
                console.log("Erro ao cadastrar");
                $rootScope.logado = false;
        });
	}

	$scope.voltar = function () {
        $location.path("/");

    }
})