package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.vraptor.model.HoraLancada;
import br.com.caelum.vraptor.model.Usuario;

@RequestScoped
public class HoraLancadaDao {

	private final EntityManager manager;

	public HoraLancadaDao(){
		this(null);
	}
	
	@Inject
	public HoraLancadaDao(EntityManager manager){
		this.manager = manager;
		
	}
	public void adiciona(HoraLancada horaLancada) {
		manager.persist(horaLancada);
	}

	public List<HoraLancada> lista() {
		String jpql = "select h from HoraLancada h";
		TypedQuery<HoraLancada> query = manager.createQuery(jpql,HoraLancada.class);
		return query.getResultList();
	}

	
	public List<HoraLancada> HorasDoUsuario(Usuario usuario){
		String jpql = "select h from HoraLancada h where h.usuario = :usuario";
		TypedQuery<HoraLancada> query = manager.createQuery(jpql,HoraLancada.class);
		query.setParameter("usuario", usuario);
		return query.getResultList();
	}
}
