angular
	.module("tracking system", ["ngRoute",
	                 "ngResource",
	                 "ngAnimate",
	                 "ngCookies",
	                 "pascalprecht.translate",
	                 "ui.bootstrap"])

	.controller("IndexController", indexController);

function indexController(){
	var vm = this;	
}