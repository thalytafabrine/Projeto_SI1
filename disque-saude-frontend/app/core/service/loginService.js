app.service("loginApi", function($http, config){

    var _logarAdministrador = function(administrador){
        return $http.post(config.baseUrl + "/login/", JSON.stringify(administrador));
    }

    return {
        logarAdministrador : _logarAdministrador
    }

});