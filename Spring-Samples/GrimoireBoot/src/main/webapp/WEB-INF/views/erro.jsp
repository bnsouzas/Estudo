<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Ocorreu um erro" backWidth="">
	<section id="index-section" class="container middle">
		<!-- 
		Mensagem: ${exception.message}
		<c:forEach items="${exception.stackTrace}" var="stk">
			${stk}
		</c:forEach>
		 -->
	</section>
</tags:pageTemplate>