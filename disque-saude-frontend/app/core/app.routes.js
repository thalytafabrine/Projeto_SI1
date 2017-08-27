app.config(function ($routeProvider) {
    $routeProvider.when("/",{
        templateUrl: "view/pesquisa.html"
    }).when("/registrarQueixa", {
        templateUrl: "view/registrarQueixa.html",
        controller : "queixaCtrl",
    }).when("/registrarQueixaAlimentar", {
        templateUrl: "view/registrarQueixaAlimentar.html",
        controller : "queixaCtrl",
    }).when("/registrarQueixaAnimal", {
        templateUrl: "view/registrarQueixaAnimal.html",
        controller : "queixaCtrl",
    }).when("/searchcomplaint", {
        templateUrl : "view/pesquisaQueixa.html",
        controller: "queixaCtrl"
    }).when("/createdcomplaint/:id", {
        templateUrl : "view/paginaDeSucesso.html",
        controller : "queixaCtrl"
    }).when("/generalSituationComplaints", {
        templateUrl : "view/situacaoGeralQueixas.html",
        controller : "queixaCtrl"
    }).when("/search_health_unit", {
        templateUrl: "view/pesquisaUnidadeDeSaude.html",
        controller : "unidadeDeSaudeCtrl",
    }).when("/searchaverage",{
        templateUrl : "view/pesquisaMediaPorPaciente.html",
        controller: "unidadeDeSaudeCtrl"
    }).when("/login", {
        templateUrl:"view/login.html",
        controller: "loginCtrl"
    }).when("/cadastro", {
        templateUrl: "view/cadastro.html",
        controller: "cadastroCtrl"
    }).when("/administrador", {
        templateUrl: "view/administrador.html",
        controller: "administradorCtrl"
    }).when("/mudarStatusDaQueixa", {
        templateUrl: "view/modificarStatusDaQueixa.html",
        controller: "queixaCtrl"
    }).when("/adicionarUnidadeDeSaude", {
        templateUrl: "view/adicionarUnidadeDeSaude.html",
        controller: "unidadeDeSaudeCtrl"
    }).otherwise({
        redirectTo: '/'
    });
});
