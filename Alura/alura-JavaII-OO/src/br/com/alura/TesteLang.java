package br.com.alura;

import java.io.PrintStream;

import br.com.alura.banco.conta.Conta;
import br.com.alura.banco.conta.ContaCorrente;

public class TesteLang {

	public static void main(String[] args) {
		Integer n1 = new Integer(Integer.parseInt("1832"));
		Integer n2 = new Integer(Integer.parseInt("121"));
		System.out.println(n1 + n2);
		PrintStream saida = System.out;
		saida.println(n1 * n2);
		
		Conta conta = new ContaCorrente();
	    System.out.println(conta);
	}

}
