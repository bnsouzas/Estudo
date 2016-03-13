package br.com.alura.banco.conta;

public abstract class Conta {
	protected double saldo;
	private int numero;
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public double getSaldo() {
		return this.saldo;
	}

	public void deposita(double valor) {
		if (valor < 0)
			throw new ValorInvalidoException(valor);

		this.saldo += valor;
	}

	public void saca(double valor) {
		if (this.saldo - valor < 0)
			System.out.println("Conta sem saldo suficiente");
		else
			this.saldo -= valor;
	}

	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa;
	}
	
	public String toString() {    
        return "esse objeto é uma conta com saldo R$" + this.saldo;
    }

	public boolean equals(Object obj) {
        Conta outraConta = (Conta) obj;

        return this.numero == outraConta.numero && 
                this.nome.equals(outraConta.nome);
    }
}
