package CarmenSanDiegoModeloVistas;

import java.util.ArrayList;

import CarmenSanDiego.src.Caso;
import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.Lugar;

public class VisitarLugarViewModel {
	Caso caso;
	Detective detective;
	Lugar lugar;
	
	public VisitarLugarViewModel(Caso caso, Detective detective, Lugar lugar) {
		this.caso = caso;
		this.detective = detective;
		this.lugar = lugar;
	}

	public Caso getCaso() {
		return caso;
	}

	public Detective getDetective() {
		return detective;
	}

	public Lugar getLugar() {
		return lugar;
	}
	
	public String obtenerNombreLugarSeleccionado() {
		return lugar.getNombre();
	}
	
	public ArrayList<String> obtenerPistas() {
		return caso.getPistasPaisDondeEscapo(lugar, detective);
	}
	
	public String obtenerNombreObjetoRobado() {
		return caso.getObjeto();
	}
}
