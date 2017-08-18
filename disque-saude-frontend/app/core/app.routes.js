app.config(function ($routeProvider) {
    $routeProvider.when("/",{
        templateUrl: "view/search.html"
    }).when("/complaint/register", {
        templateUrl: "view/registerComplaint.html",
        controller : "complaintCtrl",
    }).when("/searchcomplaint", {
        templateUrl : "view/search_complaint.html",
        controller: "complaintCtrl"
    }).when("/createdcomplaint/:id", {
        templateUrl : "view/successPage.html",
        controller : "complaintCtrl"
    }).when("/generalSituationComplaints", {
        templateUrl : "view/generalSituationComplaints.html",
        controller : "complaintCtrl"
    }).when("/search_health_unit", {
        templateUrl: "view/searchHealthUnit.html",
        controller : "healthUnitCtrl",
    }).when("/searchaverage",{
        templateUrl : "view/search_average_per_patient.html",
        controller: "healthUnitCtrl"
    }).when("/login", {
        templateUrl:"view/login.html",
        controller: "loginCtrl"
    }).otherwise({
        redirectTo: '/'
    });
});
