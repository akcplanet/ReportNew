
function fileModel($parse) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function() {
				scope.$apply(function() {
					modelSetter(scope, element[0].files[0]);
				});
			});
		}
	};
}
;



function reportController($scope, $filter, $http, Flash, HistoricalReportService, OwnershipReportService, SnapshotReportlService, UserAccessReportlService) {
	$scope.exportHistoricalData = function() {

		$scope.historicalreport.startdate = ($scope.historicalreport.startdate != null) ? $filter('date')(new Date($scope.historicalreport.startdate), 'yyyy-MM-dd') : null,
		$scope.historicalreport.enddate = ($scope.historicalreport.enddate != null) ? $filter('date')(new Date($scope.historicalreport.enddate), 'yyyy-MM-dd') : null
		var historicalDTO = $scope.historicalreport;
		console.log(historicalDTO)

		HistoricalReportService._report(historicalDTO).success(function(data, status, headers, config) {
			var blob = new Blob([ data ], {
				type : "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
			});
			/* var objectUrl = URL.createObjectURL(blob);
			 window.open(objectUrl);*/
			saveAs(blob, "Historical_Report.xlsx");
			$scope.historicalreport.startdate = null;
			$scope.historicalreport.enddate = null;
		}).error(function(data, status, headers, config) {});
	}

	$scope.exportOwnershipData = function() {

		$scope.report.eventDateFrom = ($scope.report.eventDateFrom != null) ? $filter('date')(new Date($scope.report.eventDateFrom), 'yyyy-MM-dd') : null,
		$scope.report.eventDateTo = ($scope.report.eventDateTo != null) ? $filter('date')(new Date($scope.report.eventDateTo), 'yyyy-MM-dd') : null
		var ownershipDTO = $scope.report;
		console.log(ownershipDTO)
		OwnershipReportService._report(ownershipDTO).success(function(data, status, headers, config) {
			var blob = new Blob([ data ], {
				type : "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
			});
			/* var objectUrl = URL.createObjectURL(blob);
			 window.open(objectUrl);*/
			saveAs(blob, "OwnershipDTO_Report.xlsx");
			$scope.report.eventDateFrom = null;
			$scope.report.eventDateTo = null;
		}).error(function(data, status, headers, config) {});
	}

	$scope.exportSnapshotData = function() {

		$scope.report.eventDateFrom = ($scope.report.eventDateFrom != null) ? $filter('date')(new Date($scope.report.eventDateFrom), 'yyyy-MM-dd') : null,
		$scope.report.eventDateTo = ($scope.report.eventDateTo != null) ? $filter('date')(new Date($scope.report.eventDateTo), 'yyyy-MM-dd') : null
		var snapshotDTO = $scope.report;
		console.log(snapshotDTO)
		SnapshotReportlService._report(snapshotDTO).success(function(data, status, headers, config) {
			var blob = new Blob([ data ], {
				type : "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
			});
			/* var objectUrl = URL.createObjectURL(blob);
			 window.open(objectUrl);*/
			saveAs(blob, "Snapshot_Report.xlsx");
			$scope.report.eventDateFrom = null;
			$scope.report.eventDateTo = null;
		}).error(function(data, status, headers, config) {});
	}

	$scope.exportUserAccessData = function() {

		$scope.report.eventDateFrom = ($scope.report.eventDateFrom != null) ? $filter('date')(new Date($scope.report.eventDateFrom), 'yyyy-MM-dd') : null,
		$scope.report.eventDateTo = ($scope.report.eventDateTo != null) ? $filter('date')(new Date($scope.report.eventDateTo), 'yyyy-MM-dd') : null
		var userAccessDTO = $scope.report;
		console.log(userAccessDTO)
		UserAccessReportlService._report(userAccessDTO).success(function(data, status, headers, config) {
			var blob = new Blob([ data ], {
				type : "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
			});
			/* var objectUrl = URL.createObjectURL(blob);
			 window.open(objectUrl);*/
			saveAs(blob, "UserAccess_Report.xlsx");
			$scope.report.eventDateFrom = null;
			$scope.report.eventDateTo = null;
		}).error(function(data, status, headers, config) {});
	}
	$scope.resetData= function(){
		$scope.historicalreport=null;
	}

}



angular.module('reportcontroller', [])
	.directive('fileModel', fileModel)
	.controller('reportCtrl', reportController);