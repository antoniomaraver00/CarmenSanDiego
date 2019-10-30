package CarmenSanDiegoTest;

import org.junit.Test;
import CarmenSanDiego.src.Pais;
import CarmenSanDiego.src.Lugar;
import java.util.ArrayList;

import org.junit.Assert;


public class PaisTest {
	
	@Test
	public void hayConexion_agregoUnaConexionYDeberiaDevolverQueEstanConectados(){
		
		Pais argentina = new Pais("Argentina",new ArrayList<String>(),new ArrayList<Lugar>());
		Pais brasil = new Pais("Brasil",new ArrayList<String>(),new ArrayList<Lugar>());
		
		argentina.asignarConexion(brasil);
		
		Assert.assertEquals(true,(argentina.hayConexion(brasil)));
	}
	
	@Test 
	public void obternerCaracteristicaRandom_agregoUnaSolaCaracteristicaYDevuelveEsa() {
		ArrayList<String> caracteristicasArgentina = new ArrayList<String>();
		caracteristicasArgentina.add("toman mate");
		Pais argentina = new Pais("Argentina",caracteristicasArgentina,new ArrayList<Lugar>());
		
		String caracteristica = argentina.getCaracteristicaRandom();
		
		Assert.assertEquals("toman mate",caracteristica);
		
	}
	
	@Test
	public void obternerCaracteristicaRandom_agregoDosCaracteristicaYDeberiaDevolverUnaDeEsasDos() {
		ArrayList<String> caracteristicasArgentina = new ArrayList<String>();
		caracteristicasArgentina.add("toman mate");
		caracteristicasArgentina.add("comen asado");
		Pais argentina = new Pais("Argentina",caracteristicasArgentina,new ArrayList<Lugar>());
		
		String caracteristica= argentina.getCaracteristicaRandom();
		
		Assert.assertEquals(true,caracteristicasArgentina.contains(caracteristica));
	}
	
	@Test 
	public void obternerCaracteristicaRandom_pido2CaracteristicasYMeDevuelveDosDistintas() {
		ArrayList<String> caracteristicasArgentina = new ArrayList<String>();
		caracteristicasArgentina.add("toman mate");
		caracteristicasArgentina.add("comen asado");
		caracteristicasArgentina.add("su capital es Bs.As");
		Pais argentina = new Pais("Argentina",caracteristicasArgentina,new ArrayList<Lugar>());
		
		String caracteristica1 = argentina.getCaracteristicaRandom();
		String caracteristica2 = argentina.getCaracteristicaRandom();
		
		Assert.assertEquals(false, caracteristica1.contentEquals(caracteristica2));
	}
}
