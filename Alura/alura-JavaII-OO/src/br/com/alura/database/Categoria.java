package br.com.alura.database;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private int id;
	private String nome;
	private List<Produto> produtos = new ArrayList<>();

	public Categoria(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void adiciona(Produto produto) {
		this.produtos.add(produto);
	}

}
