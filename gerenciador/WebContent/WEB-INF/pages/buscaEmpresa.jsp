<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h3>Resultado da busca:</h3>
<ul>
<c:forEach var="empresa" items="${empresas}">
	<li>${empresa.id}: ${empresa.nome}</li>
</c:forEach>
</ul>
</body>
</html>