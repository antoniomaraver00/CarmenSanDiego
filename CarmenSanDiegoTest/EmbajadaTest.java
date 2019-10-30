package CarmenSanDiegoTest;
import CarmenSanDiego.src.Villano;
import CarmenSanDiego.src.Pais;
import CarmenSanDiego.src.Embajada;
import org.mockito.Mockito;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class EmbajadaTest {
	@Test
	public void modelarPistas_pinaPistaYDeberiaDevolverDosPistasDelSiguientePais() {
	Pais paisActual = Mockito.mock(Pais.class);
	Pais paisSiguiente = Mockito.mock(Pais.class);
	Villano villano = Mockito.mock(Villano.class);
	Mockito.when(paisSiguiente.obtenerCaracteristicaRandom()).thenReturn("toman mate");
	Embajada embajada = new Embajada("embajada", paisActual);
	ArrayList<String> pistasEsperadas = new ArrayList<String>();
	pistasEsperadas.add("toman mate");
	pistasEsperadas.add("toman mate");
	ArrayList<String> pistas = new ArrayList<String>();
	
	pistas.addAll(embajada.modelarPistas(villano, paisSiguiente));
	
	Assert.assertEquals(true,pistasEsperadas.equals(pistas));
	
	}
}
