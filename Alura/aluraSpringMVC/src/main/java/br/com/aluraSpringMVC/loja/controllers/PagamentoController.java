package br.com.aluraSpringMVC.loja.controllers;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.aluraSpringMVC.loja.models.CarrinhoCompras;
import br.com.aluraSpringMVC.loja.models.DadosPagamento;
import br.com.aluraSpringMVC.loja.models.Usuario;

@Controller
@RequestMapping(value = "/pagamento")
public class PagamentoController {

	@Autowired
	private CarrinhoCompras carrinho;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private MailSender sender;
	@RequestMapping(value = "finalizar", method = RequestMethod.POST)
	public Callable<ModelAndView> finalizar(@AuthenticationPrincipal Usuario usuario, RedirectAttributes redirect) {
		return () -> {
			try {
				String response = "sucesso";
				//String uri = "http://book-payment.herokuapp.com/payment";
				//response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);
				System.out.println(carrinho.getTotal());
				enviarEmailSucesso(usuario);
				redirect.addFlashAttribute("sucesso", response);
				return new ModelAndView("redirect:/produtos");
			} catch (HttpClientErrorException e) {
				e.printStackTrace();
				redirect.addFlashAttribute("falha", "Valor maior que o permitido");
				return new ModelAndView("redirect:/produtos");
			}
		};
	}

	private void enviarEmailSucesso(Usuario usuario) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setSubject("Compra finalizada com Sucesso");
		//mail.setTo(usuario.getEmail());
		mail.setTo("bnsouzas@gmail.com");
		mail.setText("Compra aprovada com sucesso no valor: " + carrinho.getTotal());
		mail.setFrom("bnssdev@gmail.com");
		sender.send(mail);
	}
	
	
}