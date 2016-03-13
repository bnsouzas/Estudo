package br.com.alura.jpa.Teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;
import br.com.alura.jpa.util.JPAUtil;

public class TesteConsultaPositionParameterNotation {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = new Conta();
		conta.setId(1);
		Query query = manager
				.createQuery("select m from Movimentacao m "
						   + "where m.conta=?1 and m.tipoMovimentacao=?2");
		query.setParameter(1, conta);
		query.setParameter(2, TipoMovimentacao.ENTRADA);
		@SuppressWarnings("unchecked")
		List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao m : movimentacoes) {
            System.out.println("\nDescricao ..: " + m.getDescricao());
            System.out.println("Valor ......: R$ " + m.getValor());
        }
		manager.close();
	}
}
