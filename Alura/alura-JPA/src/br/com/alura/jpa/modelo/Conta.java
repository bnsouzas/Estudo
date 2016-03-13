package br.com.alura.jpa.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_CONTAS", sequenceName = "SEQ_CONTAS", initialValue = 1)
public class Conta {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CONTAS")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String titular;
    private String banco;
    private String agencia;
    private String numero;
    // Mapeia pela propriedade que contém o relacionamento da classe Movimentacao
    @OneToMany(mappedBy="conta") 
    private Set<Movimentacao> movimentacoes;
    
    public Conta() {
	}
    
    public Conta(String titular, String banco, String agencia, String numero) {
		this.titular = titular;
		this.banco = banco;
		this.agencia = agencia;
		this.numero = numero;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public Set<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
}