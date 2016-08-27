package br.com.aluraSpringMVC.daos;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.aluraSpringMVC.builders.ProdutoBuilder;
import br.com.aluraSpringMVC.conf.DataSourceConfigurationTest;
import br.com.aluraSpringMVC.loja.conf.JPAConfiguration;
import br.com.aluraSpringMVC.loja.daos.ProdutoDao;
import br.com.aluraSpringMVC.loja.models.Produto;
import br.com.aluraSpringMVC.loja.models.TipoPreco;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={JPAConfiguration.class, ProdutoDao.class,
							DataSourceConfigurationTest.class})
@ActiveProfiles("test")
public class ProdutoDaoTest {
	@Autowired
	ProdutoDao produtoDao;
	
	@Test
	@Transactional
	public void deveSomarTodosPrecosPorTipoLivro(){
		
		List<Produto> livrosImpressos = ProdutoBuilder
											.newProduto(TipoPreco.IMPRESSO, BigDecimal.TEN)
											.more(3).buildAll();
		List<Produto> livrosEbook = ProdutoBuilder
											.newProduto(TipoPreco.EBOOK, BigDecimal.TEN)
											.more(3).buildAll();
		livrosImpressos.stream().forEach(produtoDao::gravar);
		livrosEbook.stream().forEach(produtoDao::gravar);
		BigDecimal valor = produtoDao.PrecosPorTipo(TipoPreco.EBOOK);
		Assert.assertEquals(new BigDecimal(40).setScale(2), valor);		
	}
}
