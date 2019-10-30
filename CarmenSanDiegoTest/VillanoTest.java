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
	public void agregaSenia_agregarSeniaYDeberiaAgregarse() {
		Villano CarmenSanDiego =new Villano("Carmen SanDiego","Mujer",new ArrayList<String>(),new ArrayList<String>());
		
		CarmenSanDiego.agregarSenia("Pelo Rojo");
		
		ArrayList<String> senias = CarmenSanDiego.getSenias();
		Assert.assertTrue(senias.contains("Pelo Rojo"));
	}
	
	@Test 
	public void agregarHobbie_agregoUnHobbieYDeveriaAgregarse() {
		Villano CarmenSanDiego =new Villano("Carmen SanDiego","Mujer",new ArrayList<String>(),new ArrayList<String>());

		CarmenSanDiego.agregarHobbie("le gusta leer");
		
		ArrayList<String> hobbies = CarmenSanDiego.getHobbies();
		Assert.assertTrue(hobbies.contains("le gusta leer"));
	}
}