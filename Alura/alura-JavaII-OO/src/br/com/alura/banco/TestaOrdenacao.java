package br.com.alura.banco;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import br.com.alura.banco.conta.ContaPoupanca;

public class TestaOrdenacao {

	public static void main(String[] args) {
		List<ContaPoupanca> lista = new LinkedList<ContaPoupanca>();
		ContaPoupanca cp1 = new ContaPoupanca();
		ContaPoupanca cp2 = new ContaPoupanca();
		ContaPoupanca cp3 = new ContaPoupanca();
		ContaPoupanca cp4 = new ContaPoupanca();
		cp1.deposita(350.0);
		cp2.deposita(250.0);
		cp3.deposita(370.0);
		cp4.deposita(270.0);
		lista.add(cp1);
		lista.add(cp2);
		lista.add(cp3);
		lista.add(cp4);
		//Collections.sort(lista);
		//Collections.shuffle(lista);
		//Collections.reverse(lista);
		Collections.rotate(lista, 1);
		
		for(ContaPoupanca poupanca : lista)
			System.out.println(poupanca.getSaldo());
	}

}
