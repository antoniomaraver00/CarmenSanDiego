package CarmenSanDiego.src;

import java.util.ArrayList;
import java.util.List;

public class Club extends Lugar {

	public Club(String nombre, Pais pais) {
		super(nombre, pais);
	}

	@Override
	public List<String> modelarPistas(Villano villano, Pais paisSiguiente) {
		List<String> pistas = new ArrayList<String>();
		
		pistas.add(villano.obtenerSeniaRandom());
		pistas.add(villano.obtenerSeniaRandom());
		
		if( Math.random() >= 0.3 ) {
			pistas.add(villano.obtenerHobbieRandom());
		}
		
		return pistas;
	}

}
