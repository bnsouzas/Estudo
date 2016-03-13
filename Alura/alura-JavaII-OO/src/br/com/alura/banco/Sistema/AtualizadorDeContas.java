package br.com.alura.banco.Sistema;

import br.com.alura.banco.conta.Conta;

public class AtualizadorDeContas {

	private double saldoTotal = 0;
	private double selic;

	public AtualizadorDeContas(double selic) {
		this.selic = selic;
	}

	public void roda(Conta c) {
		System.out.println("Saldo Anterior: " + c.getSaldo());
		c.atualiza(selic);
		System.out.println("Saldo Final: " + c.getSaldo());
		this.saldoTotal += c.getSaldo();
	}

	public double getSaldoTotal() {
		return this.saldoTotal;
	}

}
