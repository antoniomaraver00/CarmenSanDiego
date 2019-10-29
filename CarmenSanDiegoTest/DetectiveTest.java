package CarmenSanDiegoTest;

import org.junit.Test;
import org.junit.Assert;

import org.mockito.Mockito;

import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.Pais;

public class DetectiveTest {
	
	@Test
	public void viajar_DetectiveRecienInstanciadoViajaAUnPais() {
		Detective detective = new Detective();
		
		Pais argentina = Mockito.mock(Pais.class);
		Mockito.when(argentina.getNombre()).thenReturn("Argentina");
		
		detective.viajar(argentina);
		Assert.assertEquals(argentina, detective.obtenerPaisActual());
	}
}
