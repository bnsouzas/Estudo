<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<a href="${linkTo[HoraLancadaController].form()}" class="btn">Lançar Hora</a>
<a href="${linkTo[HoraLancadaController].relatorioHoras()}" class="btn">Meu relatório de Horas</a>
<table class="table table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>data</th>
			<th>Hora Inicial</th>
			<th>Hora Final</th>
			<th>Comentário</th>
			<th>Usuário</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${horaLancada}" var="h">
			<tr>
				<td>${h.id}</td>
				<td><fmt:formatDate value="${h.data.time}" pattern="dd/MM/yyyy" /></td>
				<td>${h.horaInicial}</td>
				<td>${h.horaFinal}</td>
				<td>${h.comentario}</td>
				<td>${h.usuario.nome}</td>
			</tr>
		</c:forEach>

	</tbody>
</table>

<c:import url="/WEB-INF/jsp/footer.jsp" />