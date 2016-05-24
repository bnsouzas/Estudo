package br.com.alura.xml.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import br.com.alura.xml.Model.Produto;

public class LeituraXMLcomSTAX {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		InputStream is = new FileInputStream("src/Venda.xml");
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader eventos = factory.createXMLEventReader(is);
		Produto produto = new Produto();
		List<Produto> produtos = new ArrayList<>();
		while (eventos.hasNext()){
			XMLEvent evento = eventos.nextEvent();
			
			if (evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("produto"))
				produto = new Produto();
			else if (evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("nome")) {
				evento = eventos.nextEvent();
				String nome = evento.asCharacters().getData();
				produto.setNome(nome);
			}
			else if (evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("preco")){
				evento = eventos.nextEvent();
				String precoStr = evento.asCharacters().getData();
				Double preco = Double.parseDouble(precoStr);
				produto.setPreco(preco);
			}
			else if (evento.isEndElement() && evento.asEndElement().getName().getLocalPart().equals("produto"))
				produtos.add(produto);
		}
		System.out.println(produtos);
	}

}
