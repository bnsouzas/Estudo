package br.com.caelum.vraptor.seguranca;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.caelum.vraptor.model.Usuario;

@Named
@SessionScoped
public class UsuarioLogado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;

	public void Login(Usuario usuario) {
		this.setUsuario(usuario);
	}
	public void logout(){
		this.setUsuario(null);
	}
	
	public boolean isLogado(){
		return this.getUsuario() != null;
	}
	public Usuario getUsuario() {
		return this.usuario;
	}
	private void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
