package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.vraptor.model.Usuario;

@RequestScoped
public class UsuarioDao {

	private final EntityManager manager;

	@Inject
	public UsuarioDao(EntityManager manager) {
		this.manager = manager;
	}

	public UsuarioDao() {
		this(null);
	}

	public void adiciona(Usuario usuario) {
		manager.persist(usuario);
	}

	public List<Usuario> lista() {
		String jpql = "select u from Usuario u";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		return query.getResultList();
	}

	public Usuario buscar(String login, String senha) {
		Usuario usuario = null;
		try {
			TypedQuery<Usuario> query = manager
					.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha", Usuario.class);
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			usuario = query.getSingleResult();
		} catch (Exception ex) {
		}
		return usuario;
	}
}
