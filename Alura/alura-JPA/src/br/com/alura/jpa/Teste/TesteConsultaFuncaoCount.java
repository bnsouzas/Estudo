package br.com.alura.jpa.Teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.util.JPAUtil;

public class TesteConsultaFuncaoCount {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = manager.find(Conta.class, 2);
		TypedQuery<BigDecimal> query = manager.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta",BigDecimal.class);
		query.setParameter("pConta", conta);
		BigDecimal quantidade = query.getSingleResult();
		System.out.println("Maior movimentação: " + quantidade);
		manager.close();
	}
}
