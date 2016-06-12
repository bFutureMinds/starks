var app = angular.module('app', ["ngRoute"]);

app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.when('/login', {
            templateUrl: 'partials/login.html',
            controller: 'LoginController',
            controllerAs: 'vm'
        }).when('/offer', {
            templateUrl: 'partials/offer.html',
            controller: 'OfferController',
            controllerAs: 'vm'
        }).otherwise({
            templateUrl: 'partials/home.html',
            controller: 'FrontController',
            controllerAs: 'vm'
        });
    }
]);

(function () {
    'use strict';
    angular
        .module('app')
        .controller('LoginController', LoginController);
    LoginController.$inject = ['$rootScope', '$location', '$http'];
    function LoginController($rootScope, $location, $http) {
        var vm = this;
        vm.login = login;
        function login() {
            $rootScope.isLoggedIn = true;
            $rootScope.email = vm.email;
            $http.get('http://localhost:8080/recommend/' + $rootScope.email)
                .success(function (res) {
                    $rootScope.offer = res;
                    $location.path('offer');
                })
                .error(function (res) {
                    console.log("error occurred " + res)
                });

        }
    }
})();

(function () {
    'use strict';
    angular
        .module('app')
        .controller('FrontController', FrontController);
    FrontController.$inject = ['$rootScope'];
    function FrontController($rootScope) {
        $rootScope.isLoggedIn = false;
    }
})();

(function () {
    'use strict';
    angular
        .module('app')
        .controller('OfferController', OfferController);
    OfferController.$inject = ['$rootScope'];
    function OfferController($rootScope) {
        var vm = this;
        vm.loadOfferImage = loadOfferImage;
        var map = {
            "Arrival5XT": "5x rewards point on all travel spends",
            "Arrival5XR": "5x rewards point on all retail shops",
            "Carnival5XDE":"5X rewards point on Dining and Entertainment spends"
        };
        vm.text = text;

        function text(key) {
            return map[key]
        }

        function loadOfferImage() {
            var offerCard = $rootScope.offer.offer;
            if (offerCard.indexOf('Arrival') >= 0) {
                vm.offerImage = 'img/Arrival.png';
                return;
            }
            if (offerCard.indexOf('Carnival') >= 0) {
                vm.offerImage = 'img/rewards.png';
                return;
            }
            if (offerCard.offer.indexOf('JetBlue') >= 0) {
                vm.offerImage = 'img/jetblue.jpg';
                return;
            }
            if (offerCard.offer.indexOf('Apple') >= 0) {
                vm.offerImage = 'img/apple.png';
            }
        }

        loadOfferImage();

    }
})();