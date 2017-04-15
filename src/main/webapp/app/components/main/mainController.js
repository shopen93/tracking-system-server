angular
	.module("tracking system")
	.controller("MainController", mainController);

function mainController($http, $rootScope, $location){
	var vm = this;
	
	vm.close = function() {
		$rootScope.showRegisterInfo = false;
	}
	
	vm.goToDetails = function(userName) {
		$rootScope.userName = userName;
		$location.path("/details");
	}
	
	$http.post("http://localhost:8080/user/getAllUsers", $rootScope.login)
		.success(function(data) {
			vm.users = data;
		});
	
}