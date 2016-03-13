package br.com.alura.banco;

import br.com.alura.banco.Sistema.GerenciadorDeImpostoDeRenda;
import br.com.alura.banco.conta.ContaCorrente;
import br.com.alura.banco.conta.SeguroDeVida;

public class TestaGerenciadorDeImpostoDeRenda {

	public static void main(String[] args) {
		GerenciadorDeImpostoDeRenda gerenciador = new GerenciadorDeImpostoDeRenda();

		SeguroDeVida sv = new SeguroDeVida();
		gerenciador.adiciona(sv);

		ContaCorrente cc = new ContaCorrente();
		cc.deposita(1000);
		gerenciador.adiciona(cc);

		System.out.println(gerenciador.getTotal());
	}

}
