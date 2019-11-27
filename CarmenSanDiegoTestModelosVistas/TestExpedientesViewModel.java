package CarmenSanDiegoTestModelosVistas;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import CarmenSanDiego.src.Villano;
import CarmenSanDiegoModeloVistas.ExpedientesViewModel;

public class TestExpedientesViewModel {
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
