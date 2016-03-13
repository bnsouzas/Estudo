package br.com.alura.jpa.Teste;

import javax.persistence.EntityManager;

import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.util.JPAUtil;

public class TesteMovimentacaoConta {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Movimentacao movimentacao = manager.find(Movimentacao.class, 2);
		System.out.println(movimentacao.getConta().getTitular());
		manager.close();
	}
}
