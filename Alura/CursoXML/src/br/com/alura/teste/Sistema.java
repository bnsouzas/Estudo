package br.com.alura.teste;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.alura.Model.Produto;

public class Sistema {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse("src/Venda.xml");
		
		String moeda = document.getDocumentElement().getAttribute("moeda");
		System.out.println("Moeda: " + moeda);
		
		NodeList tag = document.getElementsByTagName("formaDePagamento");
		String result = tag.item(0).getTextContent();
		System.out.println("Forma de Pagamento: " + result + "\n");
		
		
		NodeList produtos = document.getElementsByTagName("produto");
		System.out.println("Produtos ");
		for(int i = 0; i < produtos.getLength();i++){
			Element produtoElement = (Element)produtos.item(i);
			String nome = produtoElement.getElementsByTagName("nome").item(0).getTextContent();
			Double preco = Double.parseDouble(produtoElement.getElementsByTagName("preco").item(0).getTextContent());
			Produto produto = new Produto(nome,preco);
			System.out.println(produto);
		}
		
	}

}
