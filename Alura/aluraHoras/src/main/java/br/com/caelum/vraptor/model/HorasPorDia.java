package br.com.caelum.vraptor.model;

import java.util.Calendar;

public class HorasPorDia {
	private Calendar data;
	private double horasNormais;
	private double horasExtras;
	
	public HorasPorDia(Calendar data, double horasNormais, double horasExtras) {
		this.data = data;
		this.horasNormais = horasNormais;
		this.horasExtras = horasExtras;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public double getHorasNormais() {
		return horasNormais;
	}

	public void setHorasNormais(double horasNormais) {
		this.horasNormais = horasNormais;
	}

	public double getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(double horasExtras) {
		this.horasExtras = horasExtras;
	}
	
}
