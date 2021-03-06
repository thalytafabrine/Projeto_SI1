app.service("queixaApi", function ($http, config) {

	var _modificaStatusDaQueixa = function(id, status){
        return $http.put(config.baseUrl + "/statusQueixa/" + id, status);
    }

    var _adicionaComentarioNaQueixa = function(id, comentario) {
    	return $http.put(config.baseUrl + "/comentarioQueixa/"+ id, comentario); //verificar
    }

    var _getSituacaoGeralQueixas = function () {
    	return $http.get(config.baseUrl + "/geral/situacao/");
    }

    var _registrarQueixa = function (complaint) {
        return $http.post(config.baseUrl + "/queixa/", JSON.stringify(complaint));
    }

    var _procurarQueixa = function (id) {
        return $http.get(config.baseUrl + "/queixa/" + id);
    }

    var _getQueixas = function () {
        return $http.get(config.baseUrl + "/queixa/listar");
    }

     return {
        modificarStatusDaQueixa : _modificaStatusDaQueixa,
        adicionaComentarioNaQueixa : _adicionaComentarioNaQueixa,
        getSituacaoGeralQueixas : _getSituacaoGeralQueixas,
        registrarQueixa : _registrarQueixa,
        procurarQueixa : _procurarQueixa,
        getQueixas : _getQueixas
    }
});