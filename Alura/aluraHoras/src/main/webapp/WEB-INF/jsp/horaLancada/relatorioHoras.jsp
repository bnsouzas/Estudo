<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<table class="table table-hover">
	<thead>
		<tr>
			<th>Data</th>
			<th>Horas Normais</th>
			<th>Horas Extras</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${horasPorDia}" var="h">
			<tr>
				<td><fmt:formatDate value="${h.data.time}" pattern="dd/MM/yyyy" /></td>
				<td>${h.horasNormais}</td>
				<td>${h.horasExtras}</td>
		</c:forEach>
	</tbody>
</table>

<c:import url="/WEB-INF/jsp/footer.jsp" />