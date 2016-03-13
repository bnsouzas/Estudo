package br.com.alura.jpa.Teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.util.JPAUtil;

public class TesteContaMovimentacoes {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = new Conta();
		conta.setId(1);
		Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes where c = :pConta");
		query.setParameter("pConta", conta);
		conta = (Conta) query.getSingleResult();
		manager.close();
        System.out.println(conta.getMovimentacoes().size());
	}

}
