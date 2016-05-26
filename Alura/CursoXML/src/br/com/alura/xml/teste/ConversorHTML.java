package br.com.alura.xml.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConversorHTML {

	public static void main(String[] args) throws FileNotFoundException, TransformerFactoryConfigurationError, TransformerException {
		InputStream xml = new FileInputStream("src/Venda.xml");
		StreamSource xmlSource = new StreamSource(xml);
		InputStream xsl = new FileInputStream("src/htmlVenda.xsl");
		StreamSource xslSource = new StreamSource(xsl);
		
		Transformer transform = TransformerFactory.newInstance().newTransformer(xslSource);
		StreamResult result = new StreamResult("src/Venda.html");
		transform.transform(xmlSource, result);
		
		System.out.println("Conversão Concluída!");
	}

}
