package br.com.alura.banco.conta;

@SuppressWarnings("serial")
public class ValorInvalidoException extends RuntimeException {
	
	private double valor;

	public ValorInvalidoException(double valor){
		super("Valor Inválido: " + valor);
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

}
