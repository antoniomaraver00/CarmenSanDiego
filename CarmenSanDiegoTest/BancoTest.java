package CarmenSanDiegoTest;
import CarmenSanDiego.src.Lugar;
import CarmenSanDiego.src.Pais;
import CarmenSanDiego.src.Banco;
import CarmenSanDiego.src.Villano;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class BancoTest {
	
	@Test
	public void modelarPistas_pidoUnaPistaYDeberiaDevolverUnaCaracteristicaDelPaisYUnaSeniaDelVillano(){
		Pais paisSiguiente = Mockito.mock(Pais.class);
		Mockito.when(paisSiguiente.obtenerCaracteristicaRandom()).thenReturn("tiene cristo");
		Villano villano = Mockito.mock(Villano.class);
		Mockito.when(villano.obtenerSeniaRandom()).thenReturn("tiene una cicatriz en la cara");
		Pais argentina = Mockito.mock(Pais.class);
		Banco bancoProvincia = new Banco("banco provincia",argentina);
		ArrayList<String> pistasEsperadas = new ArrayList<String>();
		pistasEsperadas.add("tiene cristo");
		pistasEsperadas.add("tiene una cicatriz en la cara");
		ArrayList<String> pistas = new ArrayList<String>();
		
		pistas.addAll(bancoProvincia.modelarPistas(villano,paisSiguiente));

		Assert.assertEquals(true, pistasEsperadas.equals(pistas));
	}
}
