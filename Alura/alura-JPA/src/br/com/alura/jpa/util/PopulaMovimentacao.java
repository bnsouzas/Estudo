package br.com.alura.jpa.util;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class PopulaMovimentacao {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        Calendar date = Calendar.getInstance();
        date.set(2013, Calendar.APRIL, 13, 0, 0, 0);
        manager.persist(new Movimentacao(TipoMovimentacao.SAIDA,date,manager.find(Conta.class, 1),"Conta de luz - ABRIL/2012",new BigDecimal("135.00")));
        manager.persist(new Movimentacao(TipoMovimentacao.SAIDA,date,manager.find(Conta.class, 1),"Almoco no Restaurante - AGOSTO/2012",new BigDecimal("175.80")));
        manager.persist(new Movimentacao(TipoMovimentacao.ENTRADA,date,manager.find(Conta.class, 1),"Aluguel - MAIO/2012",new BigDecimal("680.00")));
        manager.persist(new Movimentacao(TipoMovimentacao.ENTRADA,date,manager.find(Conta.class, 1),"Salario - FEVEREIRO/2012",new BigDecimal("3830.68")));
        manager.persist(new Movimentacao(TipoMovimentacao.SAIDA,date,manager.find(Conta.class, 2),"Conta de telefone - SETEMBRO/2011",new BigDecimal("168.27")));
        manager.persist(new Movimentacao(TipoMovimentacao.ENTRADA,date,manager.find(Conta.class, 2),"Aniversario - MAIO/2011",new BigDecimal("200.00")));
        manager.persist(new Movimentacao(TipoMovimentacao.SAIDA,date,manager.find(Conta.class, 3),"Lanche - JULHO/2011",new BigDecimal("28.50")));
        manager.persist(new Movimentacao(TipoMovimentacao.SAIDA,date,manager.find(Conta.class, 3),"Presente - DEZEMBRO/2011",new BigDecimal("49.99")));
        manager.persist(new Movimentacao(TipoMovimentacao.ENTRADA,date,manager.find(Conta.class, 3),"Bonus - JANEIRO/2012",new BigDecimal("2000.00")));
        manager.persist(new Movimentacao(TipoMovimentacao.SAIDA,date,manager.find(Conta.class,4),"Carnaval - MARCO/2012",new BigDecimal("765.20")));
        manager.persist(new Movimentacao(TipoMovimentacao.ENTRADA,date,manager.find(Conta.class, 5),"Salario - ABRIL/2012",new BigDecimal("2651.90")));
        manager.persist(new Movimentacao(TipoMovimentacao.ENTRADA,date,manager.find(Conta.class, 5),"Bonus - JANEIRO/2012",new BigDecimal("1000.00")));

        manager.getTransaction().commit();

        manager.close();
	}

}
