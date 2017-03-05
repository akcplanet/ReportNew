'use strict';
/** Registering of modules */
var sdsReportAutoApp = angular.module('sdsReportAutoApp', [ 'ngRoute', 'reportcontroller',
	'ngTouch', 'ui.grid', 'ngGrid', 'ngFlash', 'ngAnimate',
	'reportservice', 'ngSanitize', 'outreachconstant',
	'mainfilter', 'maindirective', 'nvd3', 'columnUtils', 'ngLoadingSpinner', 'ngFileUpload' ]);

sdsReportAutoApp.config([ '$routeProvider', '$resourceProvider', 'FlashProvider', '$compileProvider', function($routeProvider, $resourceProvider, FlashProvider, $compileProvider) {
	$routeProvider.when('/', {
		templateUrl : '/resources/templates/report/historical-report-template.html',
		controller : 'reportCtrl'
	}).when('/ownership', {
		templateUrl : '/resources/templates/report/ownership-report-template.html',
		controller : 'reportCtrl'
	}).when('/snapshot', {
		templateUrl : '/resources/templates/report/snapshot-report-template.html',
		controller : 'reportCtrl'
	}).when('/useraccess', {
		templateUrl : '/resources/templates/report/useraccess-report-template.html',
		controller : 'reportCtrl'
	}).otherwise({
		redirectTo : '/'
	});


	$resourceProvider.defaults.stripTrailingSlashes = false;
	/** Retrieves or overrides the default regular expression that is used for whitelisting of safe urls during a[href] sanitization */
	$compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|ftp|mailto|tel|file|blob):/);
}
]);

sdsReportAutoApp.run([ '$rootScope', function($rootScope) {
	$rootScope.$on('$routeChangeSuccess', function(event, current, previous) {
		$rootScope.title = current.$$route.title;
	});
} ]);


sdsReportAutoApp.controller('activeCtrl', function($rootScope, $scope, $location) {
	$scope.isActive = function(route) {
		if (route != null) {
			return route === $location.path();
		}
	}
});