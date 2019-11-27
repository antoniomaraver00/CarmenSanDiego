package CarmenSanDiegoTestModelosVistas;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.Villano;
import CarmenSanDiegoModeloVistas.ExpedientesViewModel;
import CarmenSanDiegoModeloVistas.OrdenViewModel;

public class TestResolviendoCasoViewModel {

	@Test
	public void actualizarListaPaisesOKYFallidos() {
		
	}
	
	@Test
	public void generarOrdenDeArresto_generaOrdenSinHaberGeneradoAnteriormenteYSeGeneraLaOrdenCorrecta() {
		Villano villano1 = Mockito.mock(Villano.class);
		Mockito.when(villano1.getNombre()).thenReturn("Pepe");
		
		Villano villano2 = Mockito.mock(Villano.class);
		Mockito.when(villano2.getNombre()).thenReturn("Diego");

		Villano villano3 = Mockito.mock(Villano.class);
		Mockito.when(villano3.getNombre()).thenReturn("Felicia");
		
		ArrayList<Villano> villanos = new ArrayList<Villano>();
		villanos.add(villano1);
		villanos.add(villano2);
		villanos.add(villano3);
		
		Detective detective = new Detective();
		OrdenViewModel modelo = new OrdenViewModel(villanos, detective);
		
		modelo.setVillanoSeleccionado(villano1);
		modelo.generarOrdenDeArresto();
		
		Assert.assertEquals(modelo.obtenerDetective().getSospechosoEnOrden(), villano1);
	}
	

	@Test
	public void generarOrdenDeArresto_generaOrdenSinHaberGeneradoAnteriormenteYSeGeneraLaOrdenIncorrecta() {
		Villano villano1 = Mockito.mock(Villano.class);
		Mockito.when(villano1.getNombre()).thenReturn("Pepe");
		
		Villano villano2 = Mockito.mock(Villano.class);
		Mockito.when(villano2.getNombre()).thenReturn("Diego");

		Villano villano3 = Mockito.mock(Villano.class);
		Mockito.when(villano3.getNombre()).thenReturn("Felicia");
		
		ArrayList<Villano> villanos = new ArrayList<Villano>();
		villanos.add(villano1);
		villanos.add(villano2);
		villanos.add(villano3);
		
		Detective detective = new Detective();
		OrdenViewModel modelo = new OrdenViewModel(villanos, detective);
		
		modelo.setVillanoSeleccionado(villano1);
		modelo.generarOrdenDeArresto();
		
		Assert.assertNotEquals(modelo.obtenerDetective().getSospechosoEnOrden(), villano2);
	}
	
	@Test
	public void obtenerRutaImagenPorSexoSeleccionado_SeSeleccionaUnVillanoHombreYRetornaLaStringParaVillanosHombres() {
		Villano villano1 = Mockito.mock(Villano.class);
		Mockito.when(villano1.getSexo()).thenReturn("Hombre");
		
		Villano villano2 = Mockito.mock(Villano.class);
		Mockito.when(villano2.getSexo()).thenReturn("Mujer");

		Villano villano3 = Mockito.mock(Villano.class);
		Mockito.when(villano3.getSexo()).thenReturn("Hombre");
		
		ArrayList<Villano> villanos = new ArrayList<Villano>();
		villanos.add(villano1);
		villanos.add(villano2);
		villanos.add(villano3);
		
		ExpedientesViewModel modelo = new ExpedientesViewModel(villanos);
		
		modelo.setVillanoSeleccionado(villano1);
		
		Assert.assertEquals("CarmenSanDiegoImagenes/Hombre.png", modelo.obtenerRutaImagenPorSexoSeleccionado());
	}
	
	@Test
	public void obtenerRutaImagenPorSexoSeleccionado_SeSeleccionaUnaVillanaMujerYRetornaLaStringParaVillanasMujeres() {
		Villano villano2 = Mockito.mock(Villano.class);
		Mockito.when(villano2.getSexo()).thenReturn("Mujer");

		Villano villano3 = Mockito.mock(Villano.class);
		Mockito.when(villano3.getSexo()).thenReturn("Hombre");
		
		ArrayList<Villano> villanos = new ArrayList<Villano>();
		villanos.add(villano2);
		villanos.add(villano3);
		
		ExpedientesViewModel modelo = new ExpedientesViewModel(villanos);
		
		modelo.setVillanoSeleccionado(villano2);
		
		Assert.assertEquals("CarmenSanDiegoImagenes/Mujer.png", modelo.obtenerRutaImagenPorSexoSeleccionado());
	}
}
