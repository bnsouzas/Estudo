package br.com.alura.banco;

import br.com.alura.banco.conta.ContaCorrente;

public class TestaComparacao {

	public static void main(String[] args) {
		
		ContaCorrente c1 = new ContaCorrente();
		ContaCorrente c2 = new ContaCorrente();
		c1.setNumero(1234567890);
		c2.setNumero(1234567890);
		if (c1.equals(c2))
			System.out.println("iguais");
		else
			System.out.println("diferente");
		
	}

}
