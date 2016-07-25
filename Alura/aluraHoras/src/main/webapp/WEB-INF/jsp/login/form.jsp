<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura" %>
<c:import url="/WEB-INF/jsp/header.jsp" />

<form action="${linkTo[LoginController].loginIn(null, null)}" method="post">
	<label for="login">Login:</label>
	<input type="text" id="login" name="login" class="form-control" />
	
	<label for="senha">Senha:</label>
	<input type="password" id="senha" name="senha" class="form-control" />
	<alura:ValidationMessage field="login_invalido"></alura:ValidationMessage>
	<input type="submit" value="Logar" class="btn" />
	<a href="${linkTo[UsuarioController].form()}" class="btn">Cadastre-se</a>
</form>

<c:import url="/WEB-INF/jsp/footer.jsp" />