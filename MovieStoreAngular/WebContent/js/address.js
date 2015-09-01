(function() {
	var app = angular.module('address',[]);
	app.directive("address", function () {
		return {
			restrict : "E",
			templateUrl : "address.html",
			controller : function ($http,$location) {
				this.addAddress = function (user) {
					user.addresses.push(this.address);
					var currURL = $location.absUrl();
					var addressObj = '{addressName :"'+ this.address.addressName +'", street :"'+ this.address.street+'", postcode :"'+ this.address.postcode+'"}';
					console.log(addressObj);
					$http.post(currURL+'store/user/address',angular.toJson(this.address),{

						headers : {
							'Content-Type' : 'application/json'
						},
						transformRequest : angular.identity})
					    .success(function(data) {
					    	console.log(data);
					    });
					this.address = {};
				};
			},
			controllerAs : "addressCtrl"
		};
	});
	
})();