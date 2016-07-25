<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="alura" tagdir="/WEB-INF/tags" %>
<c:import url="/WEB-INF/jsp/header.jsp" />
<form action="${linkTo[UsuarioController].adiciona(null)}" method="post">
	<label for="nome">Nome:</label>
	<input type="text" id="nome" name="usuario.nome" class="form-control" value="${usuario.nome}"/>
	<alura:ValidationMessage field="usuario.nome" />
	<label for="email">E-mail:</label>
	<input type="text" id="email" name="usuario.email" class="form-control" value="${usuario.email}"/>
	<alura:ValidationMessage field="usuario.email" />
	<label for="login">Login:</label>
	<input type="text" id="login" name="usuario.login" class="form-control" value="${usuario.login}"/>
	<alura:ValidationMessage field="usuario.login"/>
	<label for="senha">Nome:</label>
	<input type="password" id="senha" name="usuario.senha" class="form-control"/>
	<alura:ValidationMessage field="usuario.senha"/>
	<input type="submit" value="Cadastrar" class="btn" />
</form>
<c:import url="/WEB-INF/jsp/footer.jsp" />