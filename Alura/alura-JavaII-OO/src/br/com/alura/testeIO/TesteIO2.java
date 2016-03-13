package br.com.alura.testeIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TesteIO2 {

	public static void main(String[] args) throws IOException {
		InputStream  is = new FileInputStream("Entrada.txt");
		InputStreamReader isr = new InputStreamReader(is);  
		BufferedReader br = new BufferedReader(isr);
		
		OutputStream os = new FileOutputStream("saida.txt");
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
		
		System.out.println("Escrevendo no arquivo saida.txt:\n");
		String linha = br.readLine();
		while (linha != null){
			bw.write(linha);
			bw.newLine();
			linha = br.readLine();
		}
		br.close();
		bw.close();
	}

}
