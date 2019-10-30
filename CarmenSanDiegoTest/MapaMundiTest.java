package CarmenSanDiegoTest;

import java.util.ArrayList;

import org.junit.Test;
import CarmenSanDiego.src.Pais;
import junit.framework.Assert;
import CarmenSanDiego.src.Lugar;
import CarmenSanDiego.src.Mapamundi;

public class MapaMundiTest {
	@Test 
	public void asignarConexion_agregoUnaConexionYSeDeberiaAgregarEnLasConexionDeAmboPaises() {
		Pais argentina = new Pais("argentina",new ArrayList<String>(),new ArrayList<Lugar>());
		Pais chile = new Pais("chile",new ArrayList<String>(),new ArrayList<Lugar>());
		Mapamundi mapa = new Mapamundi();
		
		mapa.asignarConexion(argentina, chile);
		
		Assert.assertEquals(true, (argentina.hayConexion(chile) && chile.hayConexion(argentina)));
		
	}
}
