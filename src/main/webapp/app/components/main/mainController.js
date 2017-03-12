angular
	.module("tracking system")
	.controller("MainController", mainController);

function mainController($http){
	var vm = this;
	
	$http.post("http://localhost:8080/user/getDataForUser", "Mateusz")
		.success(function(data) {
			vm.coordinates = data.coords;
		});
	
	vm.showMap = function(index) {
		var coords = vm.coordinates.splice(index, 1).pop();
		var path = "http://maps.google.com/maps?q="+coords.latitude+","+coords.longitude
		window.location = path;
	}
	
}