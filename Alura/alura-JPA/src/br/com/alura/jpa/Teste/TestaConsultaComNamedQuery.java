package br.com.alura.jpa.Teste;

import javax.persistence.EntityManager;

import br.com.alura.jpa.dao.MovimentacaoDAO;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.util.JPAUtil;

public class TestaConsultaComNamedQuery {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(3);

		MovimentacaoDAO dao = new MovimentacaoDAO(manager);
		Long total = dao.totalDeMovimentacoes(conta);

		System.out.println("Total de Movimentações da Conta: " + total);
	}

}
