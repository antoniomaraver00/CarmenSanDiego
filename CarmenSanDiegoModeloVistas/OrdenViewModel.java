package CarmenSanDiegoModeloVistas;

import java.util.ArrayList;

import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.Villano;

public class OrdenViewModel {
	private ArrayList<Villano> sospechosos;
	private Detective detective;
	
	public OrdenViewModel(ArrayList<Villano> sospechosos, Detective detective) {
		this.sospechosos = sospechosos;
		this.detective = detective;
	}

	public ArrayList<Villano> obtenerSospechosos() {
		return sospechosos;
	}

	public Detective obtenerDetective() {
		return detective;
	}
}
