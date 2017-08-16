app.controller("loginCtrl", function ($scope, $http, $state) {

	$scope.login = function(email, senha) {


		$scope.profile = [];
		
	    var url = "/usuario/login";
	    var data = {
	    		email: email,
	    		senha:senha
		};

	    $http.post(url, data).then(function (response) {
		    
		}, function (response) {
		});
	    }
	};

}