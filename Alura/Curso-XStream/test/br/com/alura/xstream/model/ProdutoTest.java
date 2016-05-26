package br.com.alura.xstream.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.alura.xstream.converter.SimplesPrecoConverter;

public class ProdutoTest {
	@Test
	public void DeveGerarOProdutoXMLComONomePrecoEDescricao(){
		String resultadoEsperado = "<produto codigo=\"4356\">\n" +
		        "  <nome>geladeira</nome>\n" +
		        "  <preco>R$ 1.000,00</preco>\n" +
		        "  <descrição>geladeira duas portas</descrição>\n" +
		        "</produto>";
		
		Produto geladeira = new Produto("geladeira",1000.0,"geladeira duas portas", 4356);
		
		XStream xstream = new XStream();
		xstream.alias("produto", Produto.class);
		xstream.aliasField("descrição", Produto.class, "descricao");
		xstream.useAttributeFor(Produto.class, "codigo");
		xstream.registerLocalConverter(Produto.class, "preco", new SimplesPrecoConverter());
		String xmlProduto = xstream.toXML(geladeira);
		
		assertEquals(resultadoEsperado, xmlProduto);
	}
	
	@Test
	public void deveGerarUmProdutoAdequado() {
	    String xmlDeOrigem = "<produto codigo=\"4356\">\n" +
		        "  <nome>geladeira</nome>\n" +
		        "  <preco>R$ 1.000,00</preco>\n" +
		        "  <descrição>geladeira duas portas</descrição>\n" +
		        "</produto>";
	    
		XStream xstream = new XStream();
		xstream.alias("produto", Produto.class);
		xstream.aliasField("descrição", Produto.class, "descricao");
		xstream.useAttributeFor(Produto.class, "codigo");
		xstream.registerLocalConverter(Produto.class, "preco", new SimplesPrecoConverter());
		
		Produto produtoResultado = (Produto) xstream.fromXML(xmlDeOrigem);
		
		Produto produtoEsperado = new Produto("geladeira",1000.0,"geladeira duas portas", 4356);
		
		assertEquals(produtoEsperado,produtoResultado);
	}
}
