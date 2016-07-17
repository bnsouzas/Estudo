package br.com.caelum.vraptor.Interceptors;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@Intercepts(after={
	    AutenticacaoInterceptor.class, 
	    LogInterceptor.class
	})
public class ControleDeTransacaoInterceptor {

    private final EntityManager em;

    @Inject
    public ControleDeTransacaoInterceptor(EntityManager em) {
        this.em = em;
    }
    
    public ControleDeTransacaoInterceptor() {
        this(null); // para uso do CDI
    }

    @AroundCall
    public void intercept(SimpleInterceptorStack stack) {
//        em.getTransaction().begin();
        stack.next();
//        em.getTransaction().commit();
    }
}