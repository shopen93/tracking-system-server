angular
	.module("tracking system")
	.controller("LoginController", loginController);

function loginController($http, $rootScope, $location) {
	var vm = this;
	
	vm.invalidEmail = false;
	vm.invalidPassword = false;
	
	vm.onLogin = function() {
		var loginData = {'login' : vm.login, 'password' : vm.password};
		$http.post("http://localhost:8080/login/tryLogin", loginData)
			.success(function(data) {
				if(data === 0) {
					vm.setData();
				} else if(data === 99) {
					vm.invalidPassword = true;
				} else if(data === -1) {
					$http.post("http://localhost:8080/login/register", loginData)
						.success(function(data) {
							$rootScope.showRegisterInfo = true;
							vm.setData();
						});
				}
			});
	}
	
	vm.setData = function() {
		$rootScope.login = vm.login;
		$rootScope.logged = true;
		$location.path("/main");
	}
}