package br.com.alura.xml.teste;

import java.io.FileInputStream;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.alura.xml.Handlers.ProdutosHandler;

public class LeituraXMLcomSAX {
	public static void main(String[] args) throws SAXException, IOException {
		XMLReader leitor = XMLReaderFactory.createXMLReader();
		ProdutosHandler logica = new ProdutosHandler();
		leitor.setContentHandler(logica);
		FileInputStream ips = new FileInputStream("src/Venda.xml");
		InputSource is = new InputSource(ips );
		leitor.parse(is);
		
		System.out.println(logica.getProdutos());
	}
}
