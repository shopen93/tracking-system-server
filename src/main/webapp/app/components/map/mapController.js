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
		if(markersArray.length < 2) {
			var marker = new google.maps.Marker({
				position: location, 
			    map: map
			});
			
			markersArray.push(marker);
		}	
	}
	
	function deleteMarkers() {
		for (var i = 0; i < markersArray.length; i++ ) {
			markersArray[i].setMap(null);
		}
		
		markersArray = [];
	}
	
	vm.addPlace = function() {
		if(markersArray.length !== 2 || vm.name === undefined) {
			vm.makersError = true;
			return;
		}
		
		systemService.addUserRestriction(vm.name, markersArray[0].getPosition().lat() + ";" + markersArray[0].getPosition().lng()
				,secondMarker = markersArray[1].getPosition().lat() + ";" + markersArray[1].getPosition().lng(), $rootScope.user.id);
		$location.path("/details");
	}
	
	vm.close = function() {
		vm.makersError = false;
	}
	
	initMap();
}