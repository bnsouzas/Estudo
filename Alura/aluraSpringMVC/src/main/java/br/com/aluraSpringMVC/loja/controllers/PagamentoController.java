package br.com.aluraSpringMVC.loja.controllers;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.aluraSpringMVC.loja.models.CarrinhoCompras;
import br.com.aluraSpringMVC.loja.models.DadosPagamento;

@Controller
@RequestMapping(value = "/pagamento")
public class PagamentoController {

	@Autowired
	private CarrinhoCompras carrinho;
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "finalizar", method = RequestMethod.POST)
	public Callable<ModelAndView> finalizar(RedirectAttributes redirect) {
		return () -> {
			try {
				String uri = "http://book-payment.herokuapp.com/payment";
				String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);
				System.out.println(carrinho.getTotal());
				redirect.addFlashAttribute("sucesso", response);
				return new ModelAndView("redirect:/produtos");
			} catch (HttpClientErrorException e) {
				e.printStackTrace();
				redirect.addFlashAttribute("falha", "Valor maior que o permitido");
				return new ModelAndView("redirect:/produtos");
			}
		};
	}
}