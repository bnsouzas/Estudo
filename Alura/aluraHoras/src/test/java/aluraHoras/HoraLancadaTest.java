package aluraHoras;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.vraptor.model.HoraLancada;

public class HoraLancadaTest {
	
	@Test
	public void DuracaoHoraInicialMenorQueFinal(){
		HoraLancada horaLancada = new HoraLancada();
		horaLancada.setHoraInicial("08:00");
		horaLancada.setHoraFinal("10:00");
		assertEquals(2.0, horaLancada.getDuracao(),0.01);
	}
}