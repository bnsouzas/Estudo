<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h1>Bem vindo ao nosso gerenciador de empresas</h1>
<c:if test="${usuarioLogado!=null}">
<span>${usuarioLogado.email}</span>
</c:if>
<form action="executa" method="post">
	<input type="hidden" name="tarefa" value="NovaEmpresa" />
    Nome: <input type="text" name="nome" />
    <input type="submit" value="Enviar" />
</form>
<form action="login" method="post">
    Email: <input type="text" name="email" />
    Senha: <input type="password" name="senha" />
    <input type="submit" value="Login" />
</form>
<form action="executa" method="post">
	<input type="hidden" name="tarefa" value="Logout" />
    <input type="submit" value="Logout" />
</form>
</body>
</html>