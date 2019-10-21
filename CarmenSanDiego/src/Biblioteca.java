package CarmenSanDiego.src;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca extends Lugar {

	public Biblioteca(String nombre, Pais pais) {
		super(nombre, pais);
	}

	@Override
	public List<String> modelarPistas(Villano villano, Pais paisSiguiente) {
		List<String> pistas = new ArrayList<String>();
		
		pistas.add(paisSiguiente.obtenerCaracteristicaRandom());
		pistas.add(villano.obtenerSeniaRandom());
		
		if( Math.random() >= 0.5 ) {
			pistas.add(villano.obtenerHobbieRandom());
		}
		
		return pistas;
	}

}
