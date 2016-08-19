package br.com.aluraSpringMVC.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.aluraSpringMVC.loja.models.Usuario;

@Repository
public class UsuarioDao implements UserDetailsService {

    @PersistenceContext
    private EntityManager manager;
    
    public Usuario find(String email){
        List<Usuario> usuarios = manager.createQuery("select u from Usuario where u.email = :email", Usuario.class)
                .setParameter("email", email)
                .getResultList();
        
        if(usuarios.isEmpty()){
            throw new RuntimeException("O usuário "+ email +" não foi encontrado");
        }

        return usuarios.get(0);
    }

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		List<Usuario> usuarios = manager.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
                .setParameter("email", email)
                .getResultList();

        if(usuarios.isEmpty()){
            throw new UsernameNotFoundException("O usuário "+ email +" não foi encontrado");
        }

        return usuarios.get(0);
	}
}
