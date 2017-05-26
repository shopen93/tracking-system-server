angular
	.module("tracking system")
	.controller("MapController", mapController);

function mapController($rootScope, $location, systemService){
	var vm = this;
	vm.makersError = false;
	
	var map;
	var markersArray = [];
	
	function initMap() {
		map = new google.maps.Map(document.getElementById('map'), {
			center: {lat: 51.7522977, lng: 19.4564768},
			zoom: 12
		});
		
		google.maps.event.addListener(map, 'click', function(event) {
		    placeMarker(event.latLng);
		});
		
		google.maps.event.addListener(map, 'rightclick', function(event) {
		    deleteMarkers();
		});
	}

	function placeMarker(location) {
		var marker = new google.maps.Marker({
			position: location, 
		    map: map
		});
		
		markersArray.push(marker);	
	}
	
	function deleteMarkers() {
		for (var i = 0; i < markersArray.length; i++ ) {
			markersArray[i].setMap(null);
		}
		
		markersArray = [];
	}
	
	vm.addPlace = function() {
		if(markersArray.length < 2 || vm.name === undefined) {
			vm.makersError = true;
			return;
		}
		
		var x = markersArray[0].getPosition().lng();
		var y = markersArray[0].getPosition().lat();
		
		for(var i = 1; i < markersArray.length; i++) {
			x = x + ';' + markersArray[i].getPosition().lng();
			y = y + ';' + markersArray[i].getPosition().lat();
		}
		
		systemService.addUserRestriction(vm.name, x, y, $rootScope.user.id);
		$location.path("/details");
	}
	
	vm.close = function() {
		vm.makersError = false;
	}
	
	initMap();
}