app.service("adminApi", function ($http, config) {

    var _modificaStatusPrefeitura = function (statusAModificar){
		return $http.put(config.baseUrl + "/situacaoPrefeitura/", novoStatus);
    }

    return {
        modificaStatusPrefeitura : _modificaStatusPrefeitura
    }
});