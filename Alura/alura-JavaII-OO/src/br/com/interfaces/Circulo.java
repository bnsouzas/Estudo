package br.com.interfaces;

	public class Circulo implements AreaCalculavel {
		private int raio;
	
	    public Circulo(int raio) {
	        this.raio = raio;
	    }
	    
		@Override
		public double calculaArea() {
			return Math.PI * Math.pow(this.raio, 2);
		}
	
	}
