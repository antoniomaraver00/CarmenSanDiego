package CarmenSanDiego.src;

import java.util.ArrayList;
import java.util.List;

public class Embajada extends Lugar {
	public Embajada(String nombre, Pais pais) {
		super(nombre, pais);
	}

	@Override
	public List<String> modelarPistas(Villano villano, Pais paisSiguiente) {
		List<String> caracteristicasPais = paisSiguiente.getCaracteristicas();
		List<String> pistas = new ArrayList<String>();
		
		List<Integer> ultimosIndexs = new ArrayList<Integer>();
		
		for( int i = 0; i < 2; i++ ) {
			int index = (int)(Math.random() * caracteristicasPais.size());
			
			if(ultimosIndexs.contains(index)) {
				i--;
			} else {
				pistas.add(caracteristicasPais.get(index));
			}
		}
		
		return pistas;
	}
	
}
