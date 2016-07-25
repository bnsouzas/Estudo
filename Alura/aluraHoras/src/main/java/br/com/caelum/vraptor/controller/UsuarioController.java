package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.UsuarioDao;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.model.Usuario;
import br.com.caelum.vraptor.seguranca.FreeAuthenticate;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class UsuarioController {

	private final UsuarioDao usuarioDao;
	private final Result result;
	private final Validator validator;

	@Inject
	public UsuarioController(UsuarioDao usuarioDao, Result result, Validator validator) {
		this.usuarioDao = usuarioDao;
		this.result = result;
		this.validator = validator;
	}

	public UsuarioController() {
		this(null, null, null);
	}

	@Get
	@FreeAuthenticate
	public void form() {

	}

	@Post
	@FreeAuthenticate
	@IncludeParameters
	public void adiciona(@Valid Usuario usuario) {
		validator.onErrorRedirectTo(this).form();
		usuarioDao.adiciona(usuario);
		result.redirectTo(this).lista();
	}

	@Get
	public void lista() {
		result.include("usuarios", usuarioDao.lista());
	}
}
