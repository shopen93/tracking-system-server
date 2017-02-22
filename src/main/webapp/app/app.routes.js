angular
	.module("tracking system")
	.config(function($routeProvider){
		$routeProvider
			.when("/main", {
				templateUrl: "app/components/main/main.html",
				controller: "MainController as mainController"
			})
			.otherwise({
				redirectTo: "main"
			});
	});