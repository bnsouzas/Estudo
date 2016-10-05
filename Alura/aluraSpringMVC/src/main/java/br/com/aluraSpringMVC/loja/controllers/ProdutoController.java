package br.com.aluraSpringMVC.loja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.aluraSpringMVC.loja.daos.ProdutoDao;
import br.com.aluraSpringMVC.loja.infra.FileSaver;
import br.com.aluraSpringMVC.loja.models.Produto;
import br.com.aluraSpringMVC.loja.models.TipoPreco;
import br.com.aluraSpringMVC.loja.validation.ProdutoValidation;



@Controller
@RequestMapping(value="/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoDao produtoDao;
	
	@Autowired
    private FileSaver fileSaver;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		dataBinder.addValidators(new ProdutoValidation());
	}
	
	@RequestMapping("form")
	public ModelAndView form(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@CacheEvict(value="produtosHome", allEntries=true)
	public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {
		System.out.println(sumario.getOriginalFilename());
		if (result.hasErrors()){
			return form(produto);
		}
		String path = fileSaver.write("alura-imagens", sumario);
		produto.setSumarioPath(path);
		produtoDao.gravar(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso.");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos",produtoDao.listar());
		return modelAndView;
	}
	
	@RequestMapping(value="detalhe/{id}", method=RequestMethod.GET)
	public ModelAndView detalhe(@PathVariable int id){
		ModelAndView modelAndView = new ModelAndView("produtos/detalhe");
		modelAndView.addObject("produto", produtoDao.find(id));
		return modelAndView;
	}
	
//	@RequestMapping(value="/{id}", method=RequestMethod.GET)
//	@ResponseBody
//	public Produto detalheJson(@PathVariable int id){
//		return produtoDao.find(id);
//	}
}
