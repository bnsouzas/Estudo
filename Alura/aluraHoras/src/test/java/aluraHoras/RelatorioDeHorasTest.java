package aluraHoras;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import br.com.caelum.vraptor.model.HoraLancada;
import br.com.caelum.vraptor.model.HorasPorDia;
import br.com.caelum.vraptor.model.RelatorioDeHoras;

public class RelatorioDeHorasTest {
	
	@Test
	public void calculaRelatorioDeHorasIguais(){
		Calendar data = new GregorianCalendar(2016,07,24);
		HoraLancada	hora1 = novaHoraLancada("08:00","16:00",data);
		HoraLancada	hora2 = novaHoraLancada("16:00","19:00",data);
		RelatorioDeHoras relatorio = new RelatorioDeHoras(Arrays.asList(hora1,hora2));
		
		HorasPorDia horasPorDia = relatorio.getHorasPorDia().get(0);
		assertEquals(1,relatorio.getHorasPorDia().size());
		assertEquals(8.0,horasPorDia.getHorasNormais(),0.01);
		assertEquals(3.0,horasPorDia.getHorasExtras(),0.01);
	}
	
	@Test
	public void calculaRelatorioDeHorasDiferentes(){
		Calendar data1 = new GregorianCalendar(2016,07,24);
		Calendar data2 = new GregorianCalendar(2016,07,25);
		HoraLancada	hora1 = novaHoraLancada("08:00","16:00",data1);
		HoraLancada	hora2 = novaHoraLancada("01:00","19:00",data2);
		RelatorioDeHoras relatorio = new RelatorioDeHoras(Arrays.asList(hora1,hora2));
		
		
		assertEquals(2,relatorio.getHorasPorDia().size());
		
		HorasPorDia horasPorDia1 = relatorio.getHorasPorDia().get(0);
		
		assertEquals(8.0,horasPorDia1.getHorasNormais(),0.01);
		assertEquals(0.0,horasPorDia1.getHorasExtras(),0.01);
		
		HorasPorDia horasPorDia2 = relatorio.getHorasPorDia().get(1);
		assertEquals(8.0,horasPorDia2.getHorasNormais(),0.01);
		assertEquals(18.0,horasPorDia2.getHorasExtras(),0.01);
	}

	private HoraLancada novaHoraLancada(String horaInicial, String horaFinal, Calendar data) {
		HoraLancada horaLancada = new HoraLancada();
		horaLancada.setData(data);
		horaLancada.setHoraInicial(horaInicial);
		horaLancada.setHoraFinal(horaFinal);
		return horaLancada;
	}
}
