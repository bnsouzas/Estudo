package br.com.alura.jpa.Teste;

import javax.persistence.EntityManager;

import br.com.alura.jpa.dao.MovimentacaoDAO;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.util.JPAUtil;

public class TesteConsultaComDAO {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = manager.find(Conta.class, 2);
		MovimentacaoDAO dao = new MovimentacaoDAO(manager);
	    Double media = dao.mediaDaConta(conta);
	    System.out.println("Média do valor das Movimentações: " + media);
		manager.close();
	}

}
