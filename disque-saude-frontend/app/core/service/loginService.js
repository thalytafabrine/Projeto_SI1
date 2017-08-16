app.service("loginApi", function($http, config){

    var _login = function(email, senha){
        return $http.post(config.baseUrl + "/login/");
    }

    return {
        login : _login
    }

});