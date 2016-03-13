package br.com.interfaces;

public class Teste {

	public static void main(String[] args) {
		AreaCalculavel q = new Quadrado(3);
		AreaCalculavel r = new Retangulo(3,2);
		AreaCalculavel c = new Circulo(2);
        System.out.println(q.calculaArea());
        System.out.println(r.calculaArea());
        System.out.println(c.calculaArea());
	}

}
