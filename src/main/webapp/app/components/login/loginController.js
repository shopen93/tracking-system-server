angular
	.module("tracking system")
	.controller("LoginController", loginController);

function loginController($rootScope, $location, systemService) {
	var vm = this;
	
	vm.invalidEmail = false;
	vm.invalidPassword = false;
	
	vm.onLogin = function() {
		systemService.login(vm.login, vm.password).then(function(errorCode) {
			if(errorCode === 0) {
				vm.setData();
			} else if(errorCode === 1) {
				vm.setData();
				$rootScope.showRegisterInfo = true;
			} else {
				vm.invalidPassword = true;
			}
		});	
	}
	
	vm.setData = function() {
		$rootScope.login = vm.login;
		$rootScope.logged = true;
		$location.path("/main");
	}
}