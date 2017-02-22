angular
	.module("tracking system")
	.config(function($translateProvider){
		$translateProvider.useStaticFilesLoader({
			prefix: "app/assets/locales/",
			suffix: ".json"
		});
		$translateProvider.preferredLanguage("pl");
		$translateProvider.determinePreferredLanguage();
		$translateProvider.useSanitizeValueStrategy("escapeParameters");
	})

	.controller("LanguageController", LanguageController);

function LanguageController($translate){
	var vm = this;
	
	vm.changeLanguage = function(key){
		$translate.use(key);
	};
}