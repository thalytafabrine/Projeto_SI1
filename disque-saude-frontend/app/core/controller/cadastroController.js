app.controller("cadastroCtrl", function($scope, cadastroApi, $location) {

	$scope.cadastro = function(administrador) {
		cadastroApi.salvarAdministrador(administrador).then(function success(response) {
			console.log("Cadastro realizado com sucesso");
			alert("Cadastro realizado com sucesso");
			$location.path("/login");
			$scope.cadastrado = true;
		}, function error(error) {
                console.log(error);
                console.log("Erro ao cadastrar");
        });
	}

	$scope.voltar = function () {
        $location.path("/");

    }
})