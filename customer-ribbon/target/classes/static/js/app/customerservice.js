'use strict'
angular.module('products.products', []).factory('customerservice', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = {};
    service.getProductById = function(userId) {
        var url = CONSTANTS.getProductByIdUrl + userId;
        return $http.get(url);
    }
    service.getProducts = function() {
        return $http.get(CONSTANTS.getProducts);
    }
    return service;
}]);