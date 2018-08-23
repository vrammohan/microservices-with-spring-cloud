'use strict'
var demoApp = angular.module('products', ['ui.bootstrap', 'products.controllers',
    'products.services'
]);
demoApp.constant("CONSTANTS", {
    getAllProducts: "/products",
    getProduct: "/product/"{id},
});