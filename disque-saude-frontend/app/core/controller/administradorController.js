app.controller("administradorCtrl", function ($scope, adminApi, $location) { 

	$scope.getSituacaoGeralQueixas = function() {
		$location.path("/situacaoGeralQueixas");
	}

	$scope.gerenciarQueixas = function() {
		$location.path("/queixas");
	}

	$scope.voltar = function() {
		$location.path("/");
	}

	$scope.modificaStatusPrefeitura = function (statusAModificar) {
        adminApi.modificaStatusPrefeitura(novoStatus).then(function sucess(response){
            console.log(response.data)
        });
    }
});


