package aluraHoras;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import br.com.caelum.vraptor.comparables.DataAscHoraLancadaComparator;
import br.com.caelum.vraptor.model.HoraLancada;

public class HoraLancadaComparatorTest {
	@Test
	public void testDaClasseDataAscHoraLancadaComparator(){
		HoraLancada hora1 = new HoraLancada();
		HoraLancada hora2 = new HoraLancada();
		HoraLancada hora3 = new HoraLancada();
		HoraLancada hora4 = new HoraLancada();
		
		hora1.setData(new GregorianCalendar(2016,07,23));
		hora2.setData(new GregorianCalendar(2016,07,24));
		hora3.setData(new GregorianCalendar(2016,07,24));
		hora4.setData(new GregorianCalendar(2016,07,25));
		
		List<HoraLancada> ordenado = Arrays.asList(hora1,hora2,hora3,hora4);
		List<HoraLancada> desordem1 = Arrays.asList(hora4,hora2,hora1,hora3);
		assertNotEquals(ordenado.get(3),desordem1.get(3));
		List<HoraLancada> desordem2 = Arrays.asList(hora2,hora3,hora4,hora1);
		
		Collections.sort(desordem1, new DataAscHoraLancadaComparator());
		assertEquals(ordenado,desordem1);
		
		Collections.sort(desordem2, new DataAscHoraLancadaComparator());
		assertEquals(ordenado,desordem2);
	}
}
