package br.com.aluraSpringMVC.loja.controllers;

import javax.servlet.Filter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.aluraSpringMVC.conf.DataSourceConfigurationTest;
import br.com.aluraSpringMVC.loja.conf.AppWebConfiguration;
import br.com.aluraSpringMVC.loja.conf.JPAConfiguration;
import br.com.aluraSpringMVC.loja.conf.SecurityConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={JPAConfiguration.class, AppWebConfiguration.class,
							DataSourceConfigurationTest.class, SecurityConfiguration.class})
@ActiveProfiles("test")
public class ProdutoControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private Filter springSecurityFilterChain;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
									  .addFilter(springSecurityFilterChain)
									  .build();
	}
	
	@Test
	public void deveRetornarParaHomeComLivros() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
			   .andExpect(MockMvcResultMatchers.model().attributeExists("produtos"))
			   .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/home.jsp"));
	}
	
	@Test
	public void somenteAdminDeveAcessarProdutosForm() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/produtos/form")
							.with(SecurityMockMvcRequestPostProcessors
									.user("user@alurasppringmvc.com").password("1234567890")
									.roles("USUARIO")))
			   .andExpect(MockMvcResultMatchers.status().is(403));
				
	}
}