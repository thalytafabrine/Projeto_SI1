app.service("especialideApi", function ($http, config) {

    var _addEspecialidade = function(especialidade){
        return $http.post(config.baseUrl + "/especialidade/", especialidade);
    }

    return{
        addEspecialidade: _addEspecialidade
    }
});