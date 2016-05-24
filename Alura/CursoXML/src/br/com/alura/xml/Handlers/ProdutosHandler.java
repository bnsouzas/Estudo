package br.com.alura.xml.Handlers;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.alura.xml.Model.Produto;

public class ProdutosHandler extends DefaultHandler {
	private Produto produto;
	private StringBuilder content;
	private List<Produto> produtos = new ArrayList<>();

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("produto"))
			produto = new Produto();
		content = new StringBuilder();
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		content.append(new String(ch,start,length));
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("produto"))
			produtos.add(produto);
		else if (qName.equals("nome"))
			produto.setNome(content.toString());
		else if (qName.equals("preco"))
			produto.setPreco(Double.parseDouble(content.toString()));
		
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
}
