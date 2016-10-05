app.controller('usersController', function($scope) {
	$scope.headingTitle = "User List";
	$http.get('token').success(function(token) {
		$http({
			url : 'http://localhost:8080/api/hello',
			method : 'GET',
			headers : {
				'X-Auth-Token' : token.token
			}
		}).success(function(data) {
			$scope.greeting = data;
		});
	});
});

app.controller('rolesController', function($scope) {
	$scope.headingTitle = "Roles List";
});