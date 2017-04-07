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
			.otherwise({
				redirectTo: "main"
			});
	});