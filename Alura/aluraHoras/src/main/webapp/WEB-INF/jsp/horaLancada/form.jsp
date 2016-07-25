<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<form action="${linkTo[HoraLancadaController].adiciona(null)}"
	method="post">
	<label for="data">Data:</label>
	<input type="text"  name="horaLancada.data" id="data"
		value='<fmt:formatDate value="${horaLancada.data.time}" pattern="dd/MM/yyyy" />' class="form-control" />
	<alura:ValidationMessage field="horaLancada.data" />
	<label for="horaInicial">Hora Inicial:</label>
	<input type="text" name="horaLancada.horaInicial" id="horaInicial" 
		value="${horaLancada.horaInicial}" class="form-control" />
	<alura:ValidationMessage field="horaLancada.horaInicial" />
	<label for="horaFinal">Hora Final:</label>
	<input type="text" name="horaLancada.horaFinal" id="horaFinal" 
		value="${horaLancada.horaFinal}" class="form-control" />
	<alura:ValidationMessage field="horaLancada.horaFinal" />
	<label for="comentario">Comentário:</label>
	<textarea rows="6" cols="50" name="horaLancada.comentario"
		id="comentario" value="${horaLancada.comentario}" 
		class="form-control"></textarea>
	<alura:ValidationMessage field="horaLancada.comentario" />
	<alura:ValidationMessage field="horaLancada.usuario" />
	<input type="submit" value="adicionar" class="btn" />
</form>

<c:import url="/WEB-INF/jsp/footer.jsp" />