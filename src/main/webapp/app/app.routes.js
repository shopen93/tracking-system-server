angular
	.module("tracking system")
	.config(function($routeProvider){
		$routeProvider
			.when("/main", {
				templateUrl: "app/components/main/main.html",
				controller: "MainController as mainController"
			})
			.when("/login", {
				templateUrl: "app/components/login/login.html",
				controller: "LoginController as loginController"
			})
			.when("/details", {
				templateUrl: "app/components/details/details.html",
				controller: "DetailsController as detailsController"
			})
			.when("/map", {
				templateUrl: "app/components/map/map.html",
				controller: "MapController as mapController"
			})
			.otherwise({
				redirectTo: "main"
			});
	});