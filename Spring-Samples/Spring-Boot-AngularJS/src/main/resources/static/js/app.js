var app = angular.module('springBootAngularJS', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/users',{
            templateUrl: '/views/usuarios.html',
            controller: 'usersController'
        })
        .when('/roles',{
            templateUrl: '/views/regras.html',
            controller: 'rolesController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});