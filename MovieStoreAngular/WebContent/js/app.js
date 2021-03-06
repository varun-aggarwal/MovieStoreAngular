(function () {
	var app = angular.module('movieStore', ['store-products','address']);

	app.controller('StoreController',['$http','$location', function ($http,$location) {
		var store = this;
		store.title = "Angular Chapter 4 - 5"
		store.products = movies;
		store.user = [];
		var currURL = $location.absUrl();
		$http.get(currURL+'store/user')
		    .success(function(data) {
		    	store.user = data;
		    });
		
	}]);

	app.directive("navigation", function () {
		return {
			restrict : "E",
			templateUrl : "navigation.html",
			transclude: true,
		    controller : function ($scope) {
		    	this.plus_minus_image = "plus.png";
				this.notCollapsed = false;
				this.toggleImage = function () {
					this.user = $scope.store.user;
					if (this.plus_minus_image == "plus.png") {
						this.plus_minus_image = "minus.png";
						this.notCollapsed = true;
					} else if (this.plus_minus_image == "minus.png") {
						this.plus_minus_image = "plus.png";
						this.notCollapsed = false;
					}
				};

			},
			controllerAs : "accCtrl"
		};
	});

	var movies = [{
			name : 'Kung Fu Panda',
			description : "In the Valley of Peace, Po the Panda finds himself chosen as the Dragon Warrior despite the fact that he is obese and a complete novice at martial arts.",
			rating : 4,
			price : 39.50,
			color : '#CCC',
			images : [
				"images/Kung-Fu-Panda-1.jpg",
				"images/Kung-Fu-Panda-2.jpg",
				"images/Kung-Fu-Panda-3.jpg"
			],
			reviews : [{
					stars : 5,
					body : "Love the Panda, mu kids enjoy this a lot. Now in 3D!!",
					author : "joey@qualogy.com",
					createdOn : 1397490980837
				}, {
					stars : 4,
					body : "Love, love, love this movie! It has a great message, and the animation and voice acting are top-notch. One of my favorite animated films from the past 10 years.",
					author : "Ravi@qualogy.com",
					createdOn : 1397490980837
				}
			]
		}, {
			name : 'How to train your Dragon',
			description : "A hapless young Viking who aspires to hunt dragons becomes the unlikely friend of a young dragon himself, and learns there may be more to the creatures than he assumed.",
			rating : 4,
			price : 49.90,
			color : '#EEE',
			images : [
				"images/HTTYD-1.jpg",
				"images/HTTYD-2.jpg",
				"images/HTTYD-3.jpg",
			],
			reviews : [{
					stars : 5,
					body : "What a great movie!",
					author : "Binu@qualogy.com",
					createdOn : 1397490980837
				}, {
					stars : 5,
					body : "I loved the pictures, the pace, the voices of the actors, the message, and everything else.",
					author : "Xiachen@qualogy.com",
					createdOn : 1397490980837
				}
			]
		}, {
			name : 'WALL-E',
			description : "In the distant future, a small waste collecting robot inadvertently embarks on a space journey that will ultimately decide the fate of mankind.",
			rating : 5,
			price : 69.90,
			color : '#000',
			images : [
				"images/wall-e-1.jpg",
				"images/wall-e-2.jpg",
				"images/wall-e-3.jpg"
			],
			reviews : [{
					stars : 5,
					body : "I am floored. I didn't think it was possible for Pixar to surpass Toy Story, but it has. A sophisticated treat for adults and teens, a cuddly romance for the juice-box set, this comedic science fiction thriller romance (really!) takes the company to a new, more mature level. Filled with artistry, depth, meaning and a lot of humor, WALL-E is a masterpiece. Where Cars was a kid's movie with added adult themes, this is an adult movie with added value for children.",
					author : "william@qualogy.com",
					createdOn : 1397490980837
				}, {
					stars : 5,
					body : "Loved the movie. It shipped quickly and was brand new.",
					author : "Martijn@qualogy.com",
					createdOn : 1397490980837
				}, {
					stars : 3,
					body : "This one is fun, but not as good as originally advertised. Kids will enjoy it.",
					author : "Arno@example.org",
					createdOn : 1397490980837
				}
			]
		}
	];
})();
