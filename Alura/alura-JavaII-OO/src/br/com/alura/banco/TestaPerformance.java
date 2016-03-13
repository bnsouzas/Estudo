package br.com.alura.banco;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

	public static void main(String[] args) {
		System.out.println("HashSet\nIniciando...");
		Collection<Integer> teste = new HashSet<>();
		long inicio = System.currentTimeMillis();

		int total = 100000;

		long inicioadd = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			teste.add(i);
		}
		System.out.println("Tempo ADD: " + (System.currentTimeMillis() - inicioadd));
		long iniciocontais = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			teste.contains(i);
		}
		System.out.println("Tempo Search: " + (System.currentTimeMillis() - iniciocontais));
		long fim = System.currentTimeMillis();
		long tempo = fim - inicio;
		System.out.println("Tempo gasto: " + tempo);
		

		Collection<Integer> teste1 = new ArrayList<>();
		inicio = System.currentTimeMillis();

		System.out.println("ArrayList\nIniciando...");
		inicioadd = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			teste1.add(i);
		}
		System.out.println("Tempo ADD: " + (System.currentTimeMillis() - inicioadd));
		iniciocontais = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			teste1.contains(i);
		}
		System.out.println("Tempo Search: " + (System.currentTimeMillis() - iniciocontais));
		fim = System.currentTimeMillis();
		tempo = fim - inicio;
		System.out.println("Tempo gasto: " + tempo);
	}

}
