app.service("unidadeApi", function ($http, config) {

	var _adicionarUnidadeDeSaude = function (unidade) {
		return $http.post(config.baseUrl + "/unidade/", unidade);
	}

	var _procuraUS = function (bairro) {
		return $http.get(config.baseUrl + "/unidade/busca?bairro=" + bairro);
	}

	var _pesquisaMediaMedicoPorPaciente = function (id) {
		return $http.get(config.baseUrl + "/unidade/geral/medicos/" + id);
	}

	return {
		adicionarUnidadeDeSaude : _adicionarUnidadeDeSaude,
		procuraUS : _procuraUS,
		pesquisaMediaMedicoPorPaciente : _pesquisaMediaMedicoPorPaciente
	}
});