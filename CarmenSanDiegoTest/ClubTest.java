package CarmenSanDiegoTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


import CarmenSanDiego.src.Club;
import CarmenSanDiego.src.Pais;
import CarmenSanDiego.src.Villano;

public class ClubTest {
	@Test
	public void modelarPista_DeberiaDevolverDosSeniaYPuedeONoUnHobbie() {
		Pais paisActual = Mockito.mock(Pais.class);
		Pais paisSiguiente = Mockito.mock(Pais.class);
		Villano villano = Mockito.mock(Villano.class);
		Mockito.when(villano.getSeniaRandom()).thenReturn("utiliza anteojos");
		Mockito.when(villano.getHobbieRandom()).thenReturn("le gusta jugar a la pelota");
		ArrayList<String> pistasEsperadas = new ArrayList<String>(); 
		pistasEsperadas.add("utiliza anteojos");
		pistasEsperadas.add("utiliza anteojos");
		pistasEsperadas.add("le gusta jugar a la pelota");
		ArrayList<String> pistas = new ArrayList<String>();
		Club club = new Club("club", paisActual);
		
		pistas.addAll(club.modelarPistas(villano, paisSiguiente));
		
		Assert.assertEquals(true, pistasEsperadas.containsAll(pistas));
	}
}
