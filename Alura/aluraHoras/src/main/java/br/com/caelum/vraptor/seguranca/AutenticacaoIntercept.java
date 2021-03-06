package br.com.caelum.vraptor.seguranca;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controller.LoginController;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@Intercepts
public class AutenticacaoIntercept {
	
	private final UsuarioLogado usuarioLogado;
	private final Result result;
	private final ControllerMethod method;
	
	public AutenticacaoIntercept(){
		this(null, null, null);
	}
	
	@Inject
	public AutenticacaoIntercept(UsuarioLogado usuarioLogado, Result result, ControllerMethod method){
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.method = method;
		
	}
	@Accepts
	public boolean accept(){
		return !method.containsAnnotation(FreeAuthenticate.class);
	}

	@AroundCall
	public void Intercept(SimpleInterceptorStack stack){
		if (usuarioLogado.isLogado()){
			stack.next();
		} else {
			result.redirectTo(LoginController.class).form();
		}
		
	}

}
