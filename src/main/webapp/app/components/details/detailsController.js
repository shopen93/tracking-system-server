angular
	.module("tracking system")
	.controller("DetailsController", detailsController);

function detailsController($http, $rootScope, $location) {
	var vm = this;
	
	vm.userName = $rootScope.userName;
	
	vm.showMap = function(index) {
		var coords = vm.user.coords.splice(index, 1).pop();
		var path = "http://maps.google.com/maps?q="+coords.latitude+","+coords.longitude
		window.location = path;
	}
	
	$http.post("http://localhost:8080/user/getAllUsers", $rootScope.login)
		.success(function(data) {
			var users = data;
			for(var i = 0; i < users.length; i++) {
				var user = users[i];
				if(user.name === vm.userName) {
					vm.user = user;
					break;
				}
			}
		});
}