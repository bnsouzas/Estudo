<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulário de Produto</title>
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../base.css">
</head>
<body>
	<div class="container">
		<h1>Adicione um novo produto</h1>
		<form action="<c:url value='/produto/adiciona' />" method="post">
			<label>Nome:</label>
			<input type="text" name="produto.nome" value="${produto.nome}" class="form-control" />
			<label>Valor:</label>
			<input type="text" name="produto.valor" value="${produto.valor}" class="form-control" />
			<label>Quantidade:</label>
			<input type="text" name="produto.quantidade" value="${produto.quantidade}" class="form-control" />
			<input type="submit" value="Adicionar" class="btn btn-primary" />
		</form>
		<c:if test="${not empty errors}">
			<div class="alert alert-danger">
				<ul>
					<c:forEach items="${errors}" var="erro">
						<li>${erro.category}- ${erro.message}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
	</div>
</body>
</html>