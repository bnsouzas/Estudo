package br.com.alura.testeIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TesteIO1 {

	public static void main(String[] args) throws IOException {
		InputStream  is = System.in;
		InputStreamReader isr = new InputStreamReader(is);  
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Digite sua Mensagem:");
		String linha = br.readLine();
		while (linha != null){
			System.out.println(linha);
			linha = br.readLine();
		}
		br.close();
	}

}
