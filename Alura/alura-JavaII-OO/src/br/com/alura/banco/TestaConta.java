package br.com.alura.banco;

import br.com.alura.banco.Sistema.AtualizadorDeContas;
import br.com.alura.banco.conta.Conta;
import br.com.alura.banco.conta.ContaCorrente;
import br.com.alura.banco.conta.ContaPoupanca;

public class TestaConta {

	public static void main(String[] args) {
		Conta cc = new ContaCorrente();
		Conta cp = new ContaPoupanca();

        cc.deposita(1000); 
        cp.deposita(1000);

        AtualizadorDeContas adc = new AtualizadorDeContas(0.01);
        
        adc.roda(cc);
        adc.roda(cp);
        
        System.out.printf("Saldo Total: %.2f", adc.getSaldoTotal());

        
	}

}
