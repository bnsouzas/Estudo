package br.alura.refatoracao.cap2;

import java.util.List;

public class Trem {

	private List<Vagao> vagoes;
	private int capacidade;
	
	public boolean podeReservar(int reservas) {
		return lugaresDisponiveis() >= reservas; 
	}

	private int lugaresDisponiveis() {
		return capacidade - lugaresReservados();
	}

	private int lugaresReservados() {
		int reservasRealizadas = 0;
		for(Vagao vagao : vagoes) {
			reservasRealizadas += vagao.reservados();
		}
		return reservasRealizadas;
	}
	
}