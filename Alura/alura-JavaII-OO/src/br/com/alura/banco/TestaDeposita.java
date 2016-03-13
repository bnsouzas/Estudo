package br.com.alura.banco;

import br.com.alura.banco.conta.Conta;
import br.com.alura.banco.conta.ContaCorrente;
import br.com.alura.banco.conta.ValorInvalidoException;

public class TestaDeposita {

	public static void main(String[] args) {
		
		Conta cp = new ContaCorrente();
		try {
			cp.deposita(-100);
		} catch (ValorInvalidoException e) {
			System.out.println(e);
		}
		
	}

}
