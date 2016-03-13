package br.com.alura.jpa.Teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.util.JPAUtil;

public class TesteConsultaFuncaoMax {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = manager.find(Conta.class, 2);
		Query query = manager.createQuery("select count(m) from Movimentacao m where m.conta = :pConta");
		query.setParameter("pConta", conta);
		Long quantidade =  (Long) query.getSingleResult();
		System.out.println("Total de movimentações: " + quantidade);
		manager.close();
	}
}
