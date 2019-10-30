package CarmenSanDiegoTest;

import org.junit.Test;

import java.util.ArrayList;

import org.junit.Assert;

import org.mockito.Mockito;

import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.Pais;

public class DetectiveTest {

	@Test
	public void viajar_DetectiveRecienInstanciadoViajaAUnPais() {
		Detective detective = new Detective();
		Pais argentina = Mockito.mock(Pais.class);
		
		detective.viajar(argentina);
		
		Assert.assertEquals(argentina, detective.getPaisActual());
	}
	
	@Test
	public void viajar_elDetectiveNoViajaSiNoHayConexion()
	{
		Pais argentina = Mockito.mock(Pais.class);
		Detective sherlockHolmes = new Detective(argentina);
		Pais inglaterra = Mockito.mock(Pais.class);

		sherlockHolmes.viajar(inglaterra);
		
		Assert.assertEquals(argentina, sherlockHolmes.getPaisActual());
	}
}
