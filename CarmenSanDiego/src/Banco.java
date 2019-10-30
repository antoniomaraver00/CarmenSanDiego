package CarmenSanDiego.src;

import java.util.ArrayList;
import java.util.List;
public class Banco extends Lugar {
	
	public Banco(String nombre, Pais pais) {
		super(nombre, pais);
	}

	@Override
	public List<String> modelarPistas(Villano villano, Pais paisSiguiente) {
		List<String> pistas = new ArrayList<String>();
		
		pistas.add(paisSiguiente.getCaracteristicaRandom());
		pistas.add(villano.getSeniaRandom());
		
		return pistas;
	}
}