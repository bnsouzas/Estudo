package br.com.alura.jpa.Teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;
import br.com.alura.jpa.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setTitular("Ana Maria");
        conta.setBanco("Itau");
        conta.setNumero("54321");
        conta.setAgencia("111");
        
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Conta de Luz");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("123.9"));
        movimentacao.setConta(conta);

        EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();

        manager.persist(conta);
        manager.persist(movimentacao);

        manager.getTransaction().commit();

        manager.close();
    }
}