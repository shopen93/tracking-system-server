angular
	.module("tracking system")
	.controller("DetailsController", detailsController);

function detailsController($rootScope, $location, systemService) {
	var vm = this;
	
	vm.begin = 0;
	vm.paginationSize = 3;
	
	vm.showMap = function(index) {
		var coords = vm.user.coords[index];
		var path = "http://maps.google.com/maps?q="+coords.latitude+","+coords.longitude
		var win = window.open(path, "_blank");
		win.focus();
	}
	
	vm.next = function() {
		if(vm.user.coords.length > vm.begin + vm.paginationSize) {
			vm.begin += vm.paginationSize;
		}
	}
	
	vm.back = function() {
		vm.begin -= vm.paginationSize;
		if(vm.begin < 0) {
			vm.begin = 0;
		}
	}
	
	vm.toMap = function() {
		$location.path("/map");
	}
	
	vm.deleteRestriction = function(index) {
		systemService.deleteUserRestriction(vm.user, index).then(function() {
			vm.updateData(); // time to update data
		});	
	}
	
	vm.updateData = function() {
		systemService.getUserDetails($rootScope.user.id).then(function(data) {
			vm.user = data;
			$rootScope.user = vm.user; // update data in rootScope
		});
	}
	
	vm.updateData();
}

