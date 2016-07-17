package br.com.caelum.vraptor.Interceptors;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotation.Public;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controllers.LoginController;
import br.com.caelum.vraptor.controllers.UsuarioLogado;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@Intercepts
public class AutenticacaoInterceptor {
	@Inject
	private UsuarioLogado usuarioLogado;
	@Inject
	private Result result;
	@Inject
	private ControllerMethod controllerMethod;
	
	@Accepts
	public boolean accepts() {
		return !controllerMethod.containsAnnotation(Public.class);
	}
	
	@AroundCall
	public void intercepta(SimpleInterceptorStack stack) {
		if (usuarioLogado.getUsuario() == null)
		{
			result.redirectTo(LoginController.class).formulario();
			return;
		}
		stack.next();
	}
}
