angular
	.module("tracking system")
	.service("systemService", systemService);

function systemService($http) {
	var vm = this;
	var URL = "http://localhost:8080";
	
	vm.login = function(login, password) {
		var loginDTO = {'login' : login,
				'password' : password};
		
		var data = $http.post(URL+"/login/tryLogin", loginDTO)
			.then(function(response) {
				if(response.data === -1) { // there is no account with that email- register
					vm.register(loginDTO);
					return 1;
				} else {
					return response.data;
				}			
			});
		
		return data;
	}
	
	vm.register = function(registerDTO) {
		var data = $http.post(URL+"/login/register", registerDTO)
			.then(function() {
				return 1;
			});
		
		return data;
	}
	
	vm.getUsersForAccount = function(login) {
		var data = $http.post(URL+"/user/getAllUsers", login)
			.then(function(response) {
				return response.data;
			});
		
		return data;
	}
	
	vm.getUserDetails = function(userId) {
		var data = $http.post(URL+"/user/getUserDetails", userId)
			.then(function(response) {
				return response.data;
			});
		
		return data;
	}
	
	vm.addUserRestriction = function(restrictionName, firstLocation, secondLocation, userId) {
		var restrictionDTO = {'name' : restrictionName,
				'firstCorner' : firstLocation,
				'secondCorner' : secondLocation};
		
		var data = $http.post(URL+"/user/saveRestriction?userId="+userId, restrictionDTO)
			.then(function() {
				return;
			});
		
		return data;
	}
	
	vm.deleteUserRestriction = function(user, index) {
		var data = $http.post(URL+"/user/deleteRestriction?index="+index, user)
			.then(function() {
				return;
			});
		
		return data;
	}
}