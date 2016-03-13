package br.com.alura.testeIO;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class TesteIO3 {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		PrintStream ps = new PrintStream("saida.txt");
		
		System.out.println("Lendo o arquivo Entrada.txt:\n");
		
		while (scanner.hasNextLine()){
			String linha = scanner.nextLine();
			ps.println(linha);
		}
		scanner.close();
		ps.close();
	}

}
