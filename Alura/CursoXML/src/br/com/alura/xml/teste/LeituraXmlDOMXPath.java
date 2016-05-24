package br.com.alura.xml.teste;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.alura.xml.Model.Produto;

public class LeituraXmlDOMXPath {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse("src/Venda.xml");
		
		XPath path = XPathFactory.newInstance().newXPath();
		XPathExpression expression = path.compile("/venda/produtos/produto[contains(nome,'3')]");
		
		NodeList produtos = (NodeList)expression.evaluate(document, XPathConstants.NODESET);
		
		for(int i = 0; i < produtos.getLength();i++){
			Element produtoElement = (Element)produtos.item(i);
			String nome = produtoElement.getElementsByTagName("nome").item(0).getTextContent();
			Double preco = Double.parseDouble(produtoElement.getElementsByTagName("preco").item(0).getTextContent());
			Produto produto = new Produto(nome,preco);
			System.out.println(produto);
		}
	}

}
