package br.com.alura.jpa.util;

import javax.persistence.EntityManager;

import br.com.alura.jpa.modelo.Conta;

public class PopulaConta {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();
        
        manager.persist(new Conta("Maria dos Santos","001 - BANCO DO BRASIL","6543","16987-8"));
        manager.persist(new Conta("Paulo Roberto Souza","237 - BANCO BRADESCO","1745","86759-1"));
		manager.persist(new Conta("Antonio Duraes","341 - BANCO ITAU UNIBANCO","4606","46346-3"));
		manager.persist(new Conta("Leandra Marques","033 - BANCO SANTANDER","9876","12345-6"));
		manager.persist(new Conta("Alexandre Duarte","104 - CAIXA ECONOMICA FEDERAL","1234","98654-3"));

        manager.getTransaction().commit();

        manager.close();
	}

}
