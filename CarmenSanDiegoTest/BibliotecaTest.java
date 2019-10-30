package CarmenSanDiegoTest;
import CarmenSanDiego.src.Biblioteca;
import CarmenSanDiego.src.Pais;
import CarmenSanDiego.src.Villano;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class BibliotecaTest {
	@Test
	public void test() {
		Pais paisActual = Mockito.mock(Pais.class);
		Pais paisSiguiente = Mockito.mock(Pais.class);
		Villano villano = Mockito.mock(Villano.class);
		Biblioteca biblioteca = new Biblioteca("biblioteca", paisActual);
		ArrayList<String> pistasEsperadas = new ArrayList<String>();
		ArrayList<String> pistas = new ArrayList<String>();
		Mockito.when(paisSiguiente.getCaracteristicaRandom()).thenReturn("toman mate");
		Mockito.when(villano.getSeniaRandom()).thenReturn("usa anillo");
		Mockito.when(villano.getHobbieRandom()).thenReturn("le gusta jugar a la pelota");
		pistasEsperadas.add("toman mate");
		pistasEsperadas.add("usa anillo");
		pistasEsperadas.add("le gusta jugar a la pelota");
		
		pistas.addAll(biblioteca.modelarPistas(villano, paisSiguiente));
		
		Assert.assertEquals(true, pistasEsperadas.containsAll(pistas));
	}
}
