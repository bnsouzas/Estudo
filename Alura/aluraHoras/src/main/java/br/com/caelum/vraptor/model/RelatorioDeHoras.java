package br.com.caelum.vraptor.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import br.com.caelum.vraptor.comparables.DataAscHoraLancadaComparator;

public class RelatorioDeHoras {

	private List<HorasPorDia> horasPorDia = new ArrayList<>();;

	public RelatorioDeHoras(List<HoraLancada> horas) {
		calculaHorasPorDia(horas);
	}

	private void calculaHorasPorDia(List<HoraLancada> horas) {
		if (!horas.isEmpty()) {
			Collections.sort(horas, new DataAscHoraLancadaComparator());
			Calendar dataAnterior = horas.get(0).getData();
			double horasDoDia = 0.0;
			for (HoraLancada horaLancada : horas) {
				if (!horaLancada.getData().equals(dataAnterior)) {
					double horasNormais = Math.min(horasDoDia, 8.0);
					double horasExtras = Math.max(horasDoDia - 8, 0.0);
					horasPorDia.add(new HorasPorDia(dataAnterior, horasNormais, horasExtras));
					dataAnterior = horaLancada.getData();
					horasDoDia = 0.0;
				}
				horasDoDia += horaLancada.getDuracao();
			}
			double horasNormais = Math.min(horasDoDia, 8.0);
			double horasExtras = Math.max(horasDoDia - 8, 0.0);
			horasPorDia.add(new HorasPorDia(dataAnterior, horasNormais, horasExtras));
		}
	}

	public List<HorasPorDia> getHorasPorDia() {
		return horasPorDia;
	}

}
