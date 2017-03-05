var reportservice = angular.module('reportservice', [ 'ngResource', 'ngRoute' ]);




reportservice.factory('HistoricalReportService', function($http) {
	return {
		_report : function(t) {
			return $http({
				url : '/report/historicalreport',
				method : "POST",
				data : t,
				headers : {
					'Content-type' : 'application/json'
				},
				responseType : 'arraybuffer'
			})
		}
	}
});

reportservice.factory('OwnershipReportService', function($http) {
	return {
		_report : function(t) {
			return $http({
				url : '/report/ownershipreport',
				method : "POST",
				data : t,
				headers : {
					'Content-type' : 'application/json'
				},
				responseType : 'arraybuffer'
			})
		}
	}
});


reportservice.factory('SnapshotReportlService', function($http) {
	return {
		_report : function(t) {
			return $http({
				url : '/report/snapshotreport',
				method : "POST",
				data : t,
				headers : {
					'Content-type' : 'application/json'
				},
				responseType : 'arraybuffer'
			})
		}
	}
});


reportservice.factory('UserAccessReportlService', function($http) {
	return {
		_report : function(t) {
			return $http({
				url : '/report/useraccessreport',
				method : "POST",
				data : t,
				headers : {
					'Content-type' : 'application/json'
				},
				responseType : 'arraybuffer'
			})
		}
	}
});







// Not using 



reportservice.factory('xlsUploadService', [ '$resource', function($resource) {
	return $resource('/report/upload', {}, {
		_upload : {
			method : 'POST',
			params : {},
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined,
				enctype : 'multipart/form-data'
			},
			responseType : 'arraybuffer'
		}
	}
	);
} ]);

reportservice.factory('downloadService', [ '$q', '$timeout', '$window', function($q, $timeout, $window) {
	return {
		download : function(id) {
			var defer = $q.defer();
			$timeout(function() {
				$window.location = '/report/view?id=' + id;
			}, 1000)
				.then(function() {
					defer.resolve('success');
				}, function() {
					defer.reject('error');
				});
			return defer.promise;
		}
	};
}
]);