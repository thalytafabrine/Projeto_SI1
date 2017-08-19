app.service("cadastroApi", function($http, config){
	
	var _salvarAdministrador = function(administrador) {
		return $http.post(config.baseUrl + "/cadastro/", JSON.stringify(administrador));
	}

	return {
		salvarAdministrador: _salvarAdministrador
	}
})