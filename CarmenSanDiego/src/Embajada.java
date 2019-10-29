package CarmenSanDiego.src;

import java.util.ArrayList;
import java.util.List;

public class Embajada extends Lugar {
	public Embajada(String nombre, Pais pais) {
		super(nombre, pais);
	}

	@Override
	public List<String> modelarPistas(Villano villano, Pais paisSiguiente) {
		List<String> pistas = new ArrayList<String>();
		
		pistas.add( paisSiguiente.obtenerCaracteristicaRandom() );
		pistas.add( paisSiguiente.obtenerCaracteristicaRandom() );
		
		return pistas;
	}
	
}
