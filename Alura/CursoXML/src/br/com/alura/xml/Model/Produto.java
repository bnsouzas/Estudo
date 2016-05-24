package br.com.alura.xml.Model;

public class Produto {

	private String nome;
	private Double preco;

	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public Produto() {
	}

	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}

	@Override
	public String toString() {
		return "Nome: "+ this.nome + "\nPreço: " + this.preco + "\n";
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
