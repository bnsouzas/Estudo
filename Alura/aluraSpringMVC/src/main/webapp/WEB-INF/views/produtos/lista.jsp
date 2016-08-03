<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de java, Android, Iphone, PHP, Ruby e muito mais - Casa do código</title>
</head>
<body>
	<h1>Lista de Produtos</h1>
	<table>
		<thead>
			<tr>
				<td>Título</td>
				<td>Descrição</td>
				<td>Páginas</td>
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
</body>
</html>