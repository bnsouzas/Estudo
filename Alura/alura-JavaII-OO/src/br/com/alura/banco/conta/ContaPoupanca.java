package br.com.alura.banco.conta;

public class ContaPoupanca extends Conta implements Comparable<Conta> {

	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa * 3;
	}

	public void deposita(double valor) {
		this.saldo += valor - 0.10;
	}

	@Override
	public int compareTo(Conta o) {
		if (this.getSaldo() > o.getSaldo())
			return 1;
		else if (this.getSaldo() < o.getSaldo())
			return -1;
		else
			return 0;
	}
}
