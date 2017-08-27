app.service("unidadeApi", function ($http, config) {

	var _adicionaUnidadeDeSaude = function (unidade) {
		return $http.post(config.baseUrl + "/unidade/", unidade);
	}

	return {
		adicionaUnidadeDeSaude : _adicionaUnidadeDeSaude
	}
});