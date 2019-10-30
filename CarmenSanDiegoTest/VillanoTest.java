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
		String hobbie=CarmenSanDiego.getHobbieRandom();
		Assert.assertEquals("Baila Tango",hobbie);
		
	}
	
	@Test
	public void agregarHobbie_agregarMasDe1HobbieYDevolverUno() {
		ArrayList<String> hobbiesCarmenSanDiego = new ArrayList<String>();
		Villano CarmenSanDiego =new Villano("Carmen SanDiego","Mujer",hobbiesCarmenSanDiego,new ArrayList<String>());
		CarmenSanDiego.agregarHobbie("Juega Tennis");
		CarmenSanDiego.agregarHobbie("Baila Tango");
		String hobbie=CarmenSanDiego.getHobbieRandom();
		Assert.assertEquals(true,CarmenSanDiego.getHobbies().contains(hobbie));
	}
	
	@Test
	public void agregaSenia_agregarSeniaYDevolverla() {
		ArrayList<String> seniasCarmenSanDiego = new ArrayList<String>();
		Villano CarmenSanDiego =new Villano("Carmen SanDiego","Mujer",new ArrayList<String>(),seniasCarmenSanDiego);
		CarmenSanDiego.agregarSenia("Pelo Rojo");
		String senia=CarmenSanDiego.getSeniaRandom();
		Assert.assertEquals("Pelo Rojo",senia);
		}
	
	@Test
	public void agregarSenia_agregarMasDe1SeniaYDevolverUna() {
		ArrayList<String> seniasCarmenSanDiego = new ArrayList<String>();
		Villano CarmenSanDiego =new Villano("Carmen SanDiego","Mujer",new ArrayList<String>(),seniasCarmenSanDiego);
		CarmenSanDiego.agregarSenia("Pelo Rojo");
		CarmenSanDiego.agregarSenia("Maneja Convertible");
		String senia=CarmenSanDiego.getSeniaRandom();
		Assert.assertEquals(true,CarmenSanDiego.getSenias().contains(senia));
	}
	
	
}