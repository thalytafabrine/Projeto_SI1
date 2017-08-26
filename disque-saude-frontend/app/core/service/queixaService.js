app.service("queixaApi", function ($http, config) {

	var _modificaStatusDaQueixa = function(id, status){
        return $http.post(config.baseUrl + "/statusQueixa/" + id, status);
    }

    var _adicionaComentarioNaQueixa = function(queixa) {
    	return $http.post(config.baseUrl + "/comentarioQueixa/" + queixa);
    }

    var _getSituacaoGeralQueixas = function () {
    	return $http.get(config.baseUrl + "/geral/situacao/");
    }

     return {
        modificaStatusDaQueixa : _modificaStatusDaQueixa,
        adicionaComentarioNaQueixa : _adicionaComentarioNaQueixa,
        getSituacaoGeralQueixas : _getSituacaoGeralQueixas
    }
});