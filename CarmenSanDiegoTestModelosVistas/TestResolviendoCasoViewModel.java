package CarmenSanDiegoTestModelosVistas;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import CarmenSanDiego.src.Caso;
import CarmenSanDiego.src.Pais;
import CarmenSanDiegoModeloVistas.ResolviendoCasoViewModel;

public class TestResolviendoCasoViewModel {

	@Test
	public void actualizarListaPaisesOKYFallidos_AgregoPaisFallidoDeberiaAgregarseAListaFallidos() {
		Caso caso = Mockito.mock(Caso.class);
		Pais pais = Mockito.mock(Pais.class);
		Mockito.when(caso.getPaisInicio()).thenReturn(pais);
		ResolviendoCasoViewModel modelo = new ResolviendoCasoViewModel(caso, "july");
		Mockito.when(caso.paisPerteneceRutaDeEscape(pais)).thenReturn(false);
		
		modelo.actualizarListaPaisesOKYFallidos();
		
		Assert.assertTrue(modelo.getPaisesFallidos().contains(pais));
	}
	
	@Test
	public void actualizarListaPaisesOKYFallidos_AgregoPaisRecorridoPorElCriminalDeberiaAgregarseAListaRecorridoCriminal() {
		Caso caso = Mockito.mock(Caso.class);
		Pais pais = Mockito.mock(Pais.class);
		Mockito.when(caso.getPaisInicio()).thenReturn(pais);
		ResolviendoCasoViewModel modelo = new ResolviendoCasoViewModel(caso, "july");
		Mockito.when(caso.paisPerteneceRutaDeEscape(pais)).thenReturn(true);
		
		modelo.actualizarListaPaisesOKYFallidos();
		
		Assert.assertTrue(modelo.getPaisesRecorridoCriminal().contains(pais));
	}
}
