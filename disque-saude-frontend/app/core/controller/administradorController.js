app.controller("administradorCtrl", function ($scope, adminApi, $location) { 

	$scope.getSituacaoGeralQueixas = function() {
		$location.path("/situacaoGeralQueixas");
	}

	$scope.gerenciarQueixas = function() {
		$location.path("/queixa/listar");
	}

	$scope.voltar = function() {
		$location.path("/");
	}

	$scope.adicionarUS = function() {
		$location.path("/adicionarUnidadeDeSaude");
	}

	$scope.adicionarEspecialidade = function() {
		$location.path("/adicionarEspecialidade");
	}

	$scope.pesquisaMediaMedicoPorPaciente = function() {
		$location.path("/searchaverage");
	}

	$scope.modificaStatusPrefeitura = function (novoStatus) {
        adminApi.modificaStatusPrefeitura(novoStatus).then(function sucess(response){
            console.log(response.data)
        });
    }
});


