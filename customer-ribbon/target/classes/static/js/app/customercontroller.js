'use strict'
var module = angular.module('products.controllers', []);
module.controller("customercontroller", ["$scope", "customereservice",
    function($scope, customerservice) {
        $scope.userDto = {
            userId: null,
            userName: null,
            skillDtos: []
        };
        $scope.skills = [];
        customerservice.getProductById(1).then(function(value) {
            console.log(value.data);
        }, function(reason) {
            console.log("error occured");
        }, function(value) {
            console.log("no callback");
        });
        $scope.getProducts = function() {
            $scope.product.products = $scope.products.map(product => {
                return {
                    id: id,
                    productName: productName,
                    productBand: productBand,
                    price: price
                };
            });
            ProductService.getProducts($scope.products).then(function() {
                console.log("works");
                UserService.getAllUsers().then(function(value) {
                    $scope.products = value.data;
                }, function(reason) {
                    console.log("error occured");
                }, function(value) {
                    console.log("no callback");
                });
                $scope.skills = [];
                $scope.products = {
                    id: null,
                    productName: null,
                    products: []
                };
            }, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });
        }
    }
]);
