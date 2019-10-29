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
	
	@Test
	public void viajar_elDetectiveNoViajaSiNoHayConexion()
	{
		Detective SherlockHolmes = new Detective();
		Pais Argentina = new Pais("Argentina",null, null);
		SherlockHolmes.viajar(Argentina);
		Pais Chile = new Pais("Chile", null, null);
		Pais Inglaterra = new Pais ("Inglaterra", null, null);
		Argentina.asignarConexion(Chile);
		SherlockHolmes.viajar(Inglaterra);
		Assert.assertEquals(Argentina, SherlockHolmes.obtenerPaisActual());
	}
}
