package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.HoraLancadaDao;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.model.HoraLancada;
import br.com.caelum.vraptor.model.HorasPorDia;
import br.com.caelum.vraptor.model.RelatorioDeHoras;
import br.com.caelum.vraptor.seguranca.UsuarioLogado;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class HoraLancadaController {
	private final HoraLancadaDao horaLancadaDao;
	private Validator validator;
	private final Result result;
	private final UsuarioLogado usuarioLogado;

	public HoraLancadaController() {
		this(null, null, null, null);
	}

	@Inject
	public HoraLancadaController(HoraLancadaDao horaLancadaDao, Validator validator, Result result,
			UsuarioLogado usuarioLogado) {
		this.horaLancadaDao = horaLancadaDao;
		this.validator = validator;
		this.result = result;
		this.usuarioLogado = usuarioLogado;
	}
	
	@Get
	public void form() {
	}

	@Post
	@IncludeParameters
	public void adiciona(@Valid HoraLancada horaLancada) {
		horaLancada.setUsuario(usuarioLogado.getUsuario());
		validator.onErrorRedirectTo(this).form();
		horaLancadaDao.adiciona(horaLancada);
		result.redirectTo(this).lista();
	}
	
	@Get
	public void lista() {
		result.include("horaLancada", horaLancadaDao.lista());
	}
	
	@Get
	public void relatorioHoras(){
		List<HoraLancada> horas = horaLancadaDao.HorasDoUsuario(this.usuarioLogado.getUsuario());
		List<HorasPorDia> horasPorDia = new RelatorioDeHoras(horas).getHorasPorDia();
		result.include("horasPorDia",horasPorDia);
	}
}
