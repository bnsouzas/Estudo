package br.com.alura.xml.teste;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.alura.xml.Model.Produto;
import br.com.alura.xml.Model.Venda;

public class LeituraEscritaJAXB {

	public static void main(String[] args) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
		
		Leitura(jaxbContext);
		
		Escrita(jaxbContext);
		
	}

	private static void Escrita(JAXBContext jaxbContext) throws JAXBException {
		Marshaller marshaller = jaxbContext.createMarshaller();
		Venda venda = new Venda();
		venda.setFormaDePagamento("Crédito");
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("Nintendo Wii",549.99));
		produtos.add(new Produto("Nintendo 3DS",349.99));
		produtos.add(new Produto("Playstation Vita",449.99));
		venda.setProdutos(produtos);
		StringWriter writer = new StringWriter();
		marshaller.marshal(venda, writer);
		System.out.println(writer);
	}

	private static void Leitura(JAXBContext jaxbContext) throws JAXBException {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Venda venda = (Venda) unmarshaller.unmarshal(new File("src/Venda.xml"));
		
		System.out.println(venda);
	}

}
