package br.com.caelum.vraptor.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotation.Log;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController {
	private final Result result;
	private final ProdutoDao produtoDao;
	private final Validator validator;
	private final Mailer mailer;

	public ProdutoController() {
		this(null, null, null, null);
	}

	@Inject
	public ProdutoController(Result result, ProdutoDao produtoDao, Validator validator, Mailer mailer) {
		this.result = result;
		this.produtoDao = produtoDao;
		this.validator = validator;
		this.mailer = mailer;
	}

	@Get("/")
	public void inicio() {

	}

	@Get
	@Log
	public void lista() {
		result.include("produtoList", produtoDao.lista());
	}

	@Get
	public void listaXML() {
		result.use(Results.xml()).from(produtoDao.lista()).serialize();
	}

	@Get
	public void listaJSON() {
		result.use(Results.json()).from(produtoDao.lista()).serialize();
	}

	@Get
	@Log
	public void formulario() {

	}

	@Post
	public void adiciona(@Valid Produto produto) {
		// validator.check(produto.getQuantidade() > 0, new
		// I18nMessage("erro","produto.quantidade.negativa"));
		validator.onErrorUsePageOf(this).formulario();

		produtoDao.adiciona(produto);
		// result.forwardTo(ProdutoController.class).lista();
		result.include("mensagem", "O produto foi adicionado com sucesso!");
		result.redirectTo(ProdutoController.class).lista();
	}

	@Delete
	public void remove(Produto produto) {
		produtoDao.remove(produto);
		// result.forwardTo(this.getClass()).lista();
		result.include("mensagem", "O produto foi removido com sucesso!");
		result.redirectTo(ProdutoController.class).lista();
	}
	
	@Get
	public void enviaPedidoDeNovosItens(Produto produto) throws EmailException {
	    Email email = new SimpleEmail();
	    email.setSubject("Novo Pedido");
	    email.setMsg("O produto " + produto.getNome() + " foi pedido.");
	    email.addTo("bnsouzas@gmail.com");
	    mailer.send(email);
	    result.redirectTo(ProdutoController.class).lista();
	}
}
