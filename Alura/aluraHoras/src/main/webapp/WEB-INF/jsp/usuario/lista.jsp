<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/jsp/header.jsp" />
<a href="${linkTo[UsuarioController].form()}" class="btn">Novo Usuário</a>
<table class="table table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Login</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${usuarios}" var="u">
			<tr>
				<td>${u.id}</td>
				<td>${u.nome}</td>
				<td>${u.email}</td>
				<td>${u.login}</td>
			</tr>
		</c:forEach>
		
	</tbody>
</table>
<c:import url="/WEB-INF/jsp/footer.jsp" />