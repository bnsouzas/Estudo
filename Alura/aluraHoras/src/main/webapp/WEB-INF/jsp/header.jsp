<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
	<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet" />
    <link href="<c:url value='/css/site.css'/>" rel="stylesheet" />
	<title>Alura Horas</title>
</head>
<body>
	<nav>
		<ul class="nav nav-tabs">
			<li><a href="${linkTo[IndexController].index()}">Home</a></li>
			<li><a href="${linkTo[HoraLancadaController].lista()}">Horas Lançadas</a></li>
			<li><a href="${linkTo[UsuarioController].lista()}">Usuários</a></li>
			<li>
				<c:if test="${usuarioLogado.isLogado()}">
					<a href="${linkTo[LoginController].logout()}">Desconectar</a>
				</c:if>
				<c:if test="${!usuarioLogado.isLogado()}">
					<a href="${linkTo[LoginController].form()}">Conectar</a>
				</c:if>
			</li>
		</ul>
	</nav>
	<main class="container">