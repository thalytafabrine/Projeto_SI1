app.service("unidadeApi", function ($http, config) {

	var _adicionarUnidadeDeSaude = function (unidade) {
		return $http.post(config.baseUrl + "/unidade/", unidade);
	}

	return {
		adicionarUnidadeDeSaude : _adicionarUnidadeDeSaude
	}
});