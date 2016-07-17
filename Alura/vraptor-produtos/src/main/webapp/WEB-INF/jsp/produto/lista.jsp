<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Produtos</title>
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../base.css">
</head>
<body>
	<div class="container">
		<h1>Listagem de Produtos do ${usuarioLogado.usuario.nome}</h1>
		<a href="<c:url value='/produto/formulario'/>"> Adicionar mais
			produtos! </a>
		<table class="table table-stripped table-hover table-bordered">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Valor</th>
					<th>Quantidade</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produtoList}" var="produto">
					<tr>
						<td>${produto.nome}</td>
						<td>${produto.valor}</td>
						<td>${produto.quantidade}</td>
						<td>
							<a href="<c:url value='/produto/remove?produto.id=${produto.id}'/>">Remover</a>
						</td>
						<td>
							<c:url value="/produto/enviaPedidoDeNovosItens?produto.nome=${produto.nome}" var="urlEnviaEmail"/>
						    <a href="${urlEnviaEmail}">Pedir mais itens!</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul>
			<li><a href="<c:url value='/produto/listaXML' />">Visualizar XML</a></li>
			<li><a href="<c:url value='/produto/listaJSON' />">Visualizar JSON</a></li>
		</ul>
		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">${mensagem}</div>
		</c:if>
	</div>
</body>
</html>