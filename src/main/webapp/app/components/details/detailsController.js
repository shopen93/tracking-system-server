angular
	.module("tracking system")
	.controller("DetailsController", detailsController);

function detailsController($http, $rootScope, $location) {
	var vm = this;
	var map;
	
	vm.userName = $rootScope.userName;
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
	
	function initMap() {
		map = new google.maps.Map(document.getElementById('map'), {
			center: {lat: -34.397, lng: 150.644},
			zoom: 8
		});
		
		google.maps.event.addListener(map, 'click', function(event) {
		    placeMarker(event.latLng);
		});
	}

	function placeMarker(location) {
	  var marker = new google.maps.Marker({
	      position: location, 
	      map: map
	  });

	  map.setCenter(location);
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
	
	initMap();
}

