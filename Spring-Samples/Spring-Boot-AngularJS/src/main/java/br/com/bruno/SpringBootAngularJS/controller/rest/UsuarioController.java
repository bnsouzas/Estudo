package br.com.bruno.SpringBootAngularJS.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.SpringBootAngularJS.model.Usuario;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	@RequestMapping(value="logado", method=RequestMethod.GET)
	public Usuario logado(){
		return new Usuario("admin","admin","admin@admin.com","admin");
	}
}
