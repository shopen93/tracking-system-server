angular
	.module("tracking system")
	.controller("MainController", mainController);

function mainController($http, $rootScope){
	var vm = this;
	
	vm.close = function() {
		$rootScope.showRegisterInfo = false;
	}
	
	$http.post("http://localhost:8080/user/getAllUsers", $rootScope.user)
		.success(function(data) {
			vm.users = data;
		});
	
	/*vm.showMap = function(index) {
		var coords = vm.coordinates.splice(index, 1).pop();
		var path = "http://maps.google.com/maps?q="+coords.latitude+","+coords.longitude
		window.location = path;
	}*/
	
}