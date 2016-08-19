<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de java, Android, Iphone, PHP, Ruby e muito mais - Casa do código</title>
<c:url value="/resources" var="resourcePath" />
<link rel="stylesheet" href="${resourcePath}/bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${resourcePath}/bootstrap/css/bootstrap-theme.min.css"/>
</head>
<body>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="${s:mvcUrl('PC#listar').build() }">Lista de Produtos</a></li>
				<li><a href="${s:mvcUrl('PC#form').build() }">Cadastro de Produtos</a></li>
			</security:authorize>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li>
				<a href="#">
					<security:authentication property="principal" var="usuario"/>
					Usuário: ${usuario.nome}
				</a>
			</li>
		</ul>
	</div>
	<div class="container">
	<h1>Lista de Produtos</h1>
	<div class="table-responsive">
		<table class="table table-striped table-bordered table-hover table-condensed">
			<thead>
				<tr>
					<th>Título</th>
					<th>Descrição</th>
					<th>Páginas</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produtos}" var="p" >
					<tr>
						<td><a href="${s:mvcUrl('PC#detalhe').arg(0,p.id).build()}" >${p.titulo}</a></td>
						<td>${p.descricao}</td>
						<td>${p.paginas}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		${sucesso}
		${falha}
		</div>
	</div>
</body>
</html>