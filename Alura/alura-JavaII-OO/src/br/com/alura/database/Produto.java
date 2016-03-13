package br.com.alura.database;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
	private int categoria_id;
	
	public Produto(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public Produto(int id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Produto(int id, String nome, String descricao, int categoria_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.setCategoria_id(categoria_id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id +", Nome: " + this.nome + ", Descrição: " + this.descricao;
	}

	public int getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}
}
