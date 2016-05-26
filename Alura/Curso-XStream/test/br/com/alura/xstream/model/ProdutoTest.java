package br.com.alura.xstream.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class ProdutoTest {
	@Test
	public void DeveGerarOProdutoXMLComONomePrecoEDescricao(){
		String resultadoEsperado = "<produto codigo=\"4356\">\n" +
		        "  <nome>geladeira</nome>\n" +
		        "  <preco>1000.0</preco>\n" +
		        "  <descrição>geladeira duas portas</descrição>\n" +
		        "</produto>";
		
		Produto geladeira = new Produto("geladeira",1000.0,"geladeira duas portas", 4356);
		
		XStream xstream = new XStream();
		xstream.alias("produto", Produto.class);
		xstream.aliasField("descrição", Produto.class, "descricao");
		xstream.useAttributeFor(Produto.class, "codigo");
		String xmlProduto = xstream.toXML(geladeira);
		
		assertEquals(resultadoEsperado, xmlProduto);
	}
}
