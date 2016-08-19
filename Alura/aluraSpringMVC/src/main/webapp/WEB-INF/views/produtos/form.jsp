<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de java, Android, Iphone, PHP, Ruby e muito mais -
	Casa do código</title>
<c:url value="/resources" var="resourcePath" />
<link rel="stylesheet" href="${resourcePath}/bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${resourcePath}/bootstrap/css/bootstrap-theme.min.css"/>
</head>
<body>
	<form:form action="${s:mvcUrl('PC#gravar').build()}" method="post"
			commandName="produto" enctype="multipart/form-data" cssClass="container">
		<div class="form-group">
			<label>Título</label>
			<form:input path="titulo" cssClass="form-control" />
			<form:errors path="titulo" />
		</div>
		<div class="form-group">
			<label>Descrição</label>
			<form:textarea path="descricao" cssClass="form-control" />
			<form:errors path="descricao" />
		</div>
		<div class="form-group">
			<label>Páginas</label>
			<form:input path="paginas" cssClass="form-control" />
			<form:errors path="paginas" />
		</div>
		<div class="form-group">
			<label>Data de Lançamento</label>
			<form:input path="dataLancamento" cssClass="form-control" />
			<form:errors path="dataLancamento" />
		</div>
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
			<div class="form-group">
				<label>${tipoPreco}</label>
				<input type="text" name="precos[${status.index}].valor" class="form-control"/> 
				<input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}"/>
			</div>
		</c:forEach>
		<div class="form-group">
			<label>Sumário</label>
			<input type="file" name="sumario" class="form-control" />
		</div>
		<button type="submit" class="btn btn-primary">Cadastrar</button>
	</form:form>
</body>
</html>