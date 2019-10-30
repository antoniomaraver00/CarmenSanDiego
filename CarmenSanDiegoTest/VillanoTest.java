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
	
	@Test
	public void getSeniaRandom_DevuelveUnaSeniaPertenecienteAlVillano() {
		ArrayList<String> senias = new ArrayList<String>();
		senias.add("Pelo rojo");
		senias.add("Pie corto");
		
		Villano carmen = new Villano("Carmen", "Mujer", new ArrayList<String>(), senias);
		
		String seniaRandom = carmen.getSeniaRandom();
		
		Assert.assertTrue( senias.stream().anyMatch( senia -> senia.equals(seniaRandom) ));
	}
	
	@Test
	public void getSeniaRandom_DevuelveUnaSeniaDiferenteSiempre() {
		ArrayList<String> senias = new ArrayList<String>();
		senias.add("Pelo rojo");
		senias.add("Pie corto");
		
		Villano carmen = new Villano("Carmen", "Mujer", new ArrayList<String>(), senias);
		
		String seniaRandom1 = carmen.getSeniaRandom();
		String seniaRandom2 = carmen.getSeniaRandom();
				
		Assert.assertNotEquals( seniaRandom1, seniaRandom2 );
	}
	
	@Test
	public void getHobbyRandom_DevuelveUnHobbyertenecienteAlVillano() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("Pelo rojo");
		hobbies.add("Pie corto");
		
		Villano carmen = new Villano("Marito", "Hombre", hobbies, new ArrayList<String>());
		
		String hobbyRandom = carmen.getHobbieRandom();
		
		Assert.assertTrue( hobbies.stream().anyMatch( hobby -> hobby.equals(hobbyRandom) ));
	}
	
	@Test
	public void getHobbyRandom_DevuelveUnHobbyDiferenteSiempre() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("Jugar a la pelota");
		hobbies.add("Levantar pesas");
		
		Villano carmen = new Villano("Marito", "Hombre", hobbies, new ArrayList<String>());
		
		String hobbyRandom1 = carmen.getHobbieRandom();
		String hobbyRandom2 = carmen.getHobbieRandom();
				
		Assert.assertNotEquals( hobbyRandom1, hobbyRandom2 );
	}
}