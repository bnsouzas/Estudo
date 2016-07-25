package br.com.caelum.vraptor.comparables;

import java.util.Comparator;

import br.com.caelum.vraptor.model.HoraLancada;

public class DataAscHoraLancadaComparator implements Comparator<HoraLancada> {
	
	public DataAscHoraLancadaComparator(){
		//definir se é crescente ou decrescente pelo construtor.
	}
	
	@Override
	public int compare(HoraLancada hora1, HoraLancada hora2) {
		return hora1.getData().getTime().compareTo(hora2.getData().getTime());
	}

}
