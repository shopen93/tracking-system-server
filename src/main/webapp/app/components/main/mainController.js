angular
	.module("tracking system")
	.controller("MainController", mainController);

function mainController($rootScope, $location, systemService){
	var vm = this;
	
	vm.close = function() {
		$rootScope.showRegisterInfo = false;
	}
	
	vm.goToDetails = function(index) {
		$rootScope.user = vm.users[index];
		$location.path("/details");
	}
	
	if($rootScope.login !== undefined) {
		systemService.getUsersForAccount($rootScope.login).then(function(data) {
			vm.users = data;
		});	
	}	
}