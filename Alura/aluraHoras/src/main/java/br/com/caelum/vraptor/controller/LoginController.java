package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.UsuarioDao;
import br.com.caelum.vraptor.model.Usuario;
import br.com.caelum.vraptor.seguranca.FreeAuthenticate;
import br.com.caelum.vraptor.seguranca.UsuarioLogado;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LoginController {
	
	private final UsuarioDao usuarioDao;
	private final UsuarioLogado usuarioLogado;
	private final Result result;
	private final Validator validator;
	
	public LoginController(){
		this(null,null,null,null);
	}
	
	@Inject
	public LoginController(UsuarioDao usuarioDao, UsuarioLogado usuarioLogado, Result result,Validator validator){
		this.usuarioDao = usuarioDao;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.validator = validator;
	}
	
	@Get
	@FreeAuthenticate
	public void form(){
		
	}
	
	@Post
	@FreeAuthenticate
	public void loginIn(String login, String senha){
		Usuario usuario = usuarioDao.buscar(login, senha);
		if (usuario != null){
			usuarioLogado.Login(usuario);
			result.redirectTo(IndexController.class).index();
		} else {
			validator.add(new SimpleMessage("login_invalido", "Login ou senha inválida!"));
			validator.onErrorRedirectTo(this).form();
		}
	}
	
	public void logout(){
		usuarioLogado.logout();
		result.redirectTo(this).form();
	}
}
