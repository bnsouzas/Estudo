package br.com.caelum.vraptor.Interceptors;

import javax.inject.Inject;

import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.annotation.Log;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;

@AcceptsWithAnnotations(Log.class)
@Intercepts(after=AutenticacaoInterceptor.class)
public class LogInterceptor {

	private final ControllerMethod controllerMethod;

	@Inject
	public LogInterceptor(ControllerMethod controllerMethod) {
		this.controllerMethod = controllerMethod;
	}

	public LogInterceptor() {
		this(null); // para uso do CDI
	}

//	@Accepts
//	public boolean accepts() {
//		return controllerMethod.containsAnnotation(Log.class);
//	}

	@BeforeCall
	public void before() {
		String nomeDoMetodo = controllerMethod.getMethod().getName();
		System.out.println("Executando o método: " + nomeDoMetodo);
	}
}
