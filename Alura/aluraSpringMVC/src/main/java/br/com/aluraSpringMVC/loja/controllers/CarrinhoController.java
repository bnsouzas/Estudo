package br.com.aluraSpringMVC.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.aluraSpringMVC.loja.daos.ProdutoDao;
import br.com.aluraSpringMVC.loja.models.CarrinhoCompras;
import br.com.aluraSpringMVC.loja.models.CarrinhoItem;
import br.com.aluraSpringMVC.loja.models.TipoPreco;

@Controller
@RequestMapping(value="/carrinho")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoController {
	@Autowired
	private CarrinhoCompras carrinho;
	@Autowired
	private ProdutoDao produtoDao;
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public ModelAndView add(Integer produtoId, TipoPreco tipo){
		ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
		carrinho.add(new CarrinhoItem(produtoDao.find(produtoId), tipo));
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView itens(){
	    return new ModelAndView("/carrinho/itens");
	}
	
	@RequestMapping(value="remover",method=RequestMethod.POST)
	public ModelAndView remover(Integer produtoID, TipoPreco tipoPreco){
		carrinho.Remover(produtoID,tipoPreco);
		return new ModelAndView("redirect:/carrinho");
	}
}
