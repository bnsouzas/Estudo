package br.com.aluraSpringMVC.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(){
		System.out.println("Exibindo a Home da aluraSpringMVC");
		return "home";
	}
}
