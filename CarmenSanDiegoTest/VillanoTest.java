package CarmenSanDiegoTest;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Assert;

import org.mockito.Mockito;

import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.Pais;
import CarmenSanDiego.src.Villano;


public class VillanoTest {
	
	@Test	
	public void agregarHobbie_agregarHobbieYDevolverlo() {
		
		ArrayList<String> hobbiesCarmenSanDiego = new ArrayList<String>();
		Villano CarmenSanDiego =new Villano("Carmen SanDiego","Mujer",hobbiesCarmenSanDiego,new ArrayList<String>());
		CarmenSanDiego.agregarHobbie("Baila Tango");
		String hobbie=CarmenSanDiego.obtenerHobbieRandom();
		Assert.assertEquals("Baila Tango",hobbie);
		
	}
	
	@Test
	public void agregarHobbie_agregarMasDe1HobbieYDevolverUno() {
		ArrayList<String> hobbiesCarmenSanDiego = new ArrayList<String>();
		Villano CarmenSanDiego =new Villano("Carmen SanDiego","Mujer",hobbiesCarmenSanDiego,new ArrayList<String>());
		CarmenSanDiego.agregarHobbie("Juega Tennis");
		CarmenSanDiego.agregarHobbie("Baila Tango");
		String hobbie=CarmenSanDiego.obtenerHobbieRandom();
		Assert.assertEquals(true,CarmenSanDiego.obtenerHobbies().contains(hobbie));
	}
	
}