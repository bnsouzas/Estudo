package br.com.alura.jpa.Teste;

import javax.persistence.EntityManager;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.util.JPAUtil;

public class TesteEstadosJPA {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();

        // ID de uma conta que exista no banco de dados, no caso ID: 1
        Conta conta = manager.find(Conta.class, 1);

        // commit antes da alteração
        manager.getTransaction().commit();

        // Alteração do titular da conta
        conta.setTitular("Caelum Ensino e Inovação");

        manager.getTransaction().begin();
        manager.merge(conta);
        manager.getTransaction().commit();
	}
}
