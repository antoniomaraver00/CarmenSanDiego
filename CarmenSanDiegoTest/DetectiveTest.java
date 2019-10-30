package CarmenSanDiegoTest;

import org.junit.Test;

import java.util.ArrayList;

import org.junit.Assert;

import org.mockito.Mockito;

import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.Pais;
import CarmenSanDiego.src.Villano;

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
	
	@Test
	public void generarOrden_elDecetiveGeneraOrdenDeArresto()
	{
		Detective detective = new Detective();
		Villano villano = Mockito.mock(Villano.class);
		
		detective.generarOrden(villano);
		
		Assert.assertEquals(villano, detective.getSospechosoEnOrden());
	}
	
	@Test
	public void generarOrden_GeneroOrdenCuandoYaTengoUnaNoDeberiaModificarse() {
		Detective detective = new Detective();
		Villano villano = Mockito.mock(Villano.class);
		Villano villano2 = Mockito.mock(Villano.class);
		detective.generarOrden(villano);
		
		detective.generarOrden(villano2);
		
		Assert.assertEquals(villano, detective.getSospechosoEnOrden());
	}
	
}
