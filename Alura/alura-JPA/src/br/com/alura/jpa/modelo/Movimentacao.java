package br.com.alura.jpa.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@NamedQueries({
	@NamedQuery(name="mediaDaContaPeloTipoMovimentacao", 
				query="select avg(m.valor) from Movimentacao m where m.conta=:pConta and m.tipoMovimentacao = :pTipo") ,
	@NamedQuery(name="totalDeMovimentacoes", 
    			query="select count(m) from Movimentacao m where m.conta = :pConta")
})
@Entity
public class Movimentacao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;
	@Temporal(TemporalType.DATE)
	private Calendar data;
	@ManyToOne
	private Conta conta;
	private String descricao;
	private BigDecimal valor;
	
	public Movimentacao() {
	}
	
	public Movimentacao(TipoMovimentacao tipoMovimentacao, Calendar data, Conta conta, String descricao,
			BigDecimal valor) {
		this.tipoMovimentacao = tipoMovimentacao;
		this.data = data;
		this.conta = conta;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
