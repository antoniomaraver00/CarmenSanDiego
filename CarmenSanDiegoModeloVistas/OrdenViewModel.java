package CarmenSanDiegoModeloVistas;

import java.util.ArrayList;

import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.Villano;

public class OrdenViewModel {
	private ArrayList<Villano> sospechosos;
	private Detective detective;
	private Villano villanoSeleccionado;
	
	public OrdenViewModel(ArrayList<Villano> sospechosos, Detective detective) {
		this.sospechosos = sospechosos;
		this.detective = detective;
		this.setVillanoSeleccionado(null);
	}

	public ArrayList<Villano> obtenerSospechosos() {
		return sospechosos;
	}
	
	public Detective obtenerDetective() {
		return detective;
	}

	public Villano getVillanoSeleccionado() {
		return villanoSeleccionado;
	}

	public void setVillanoSeleccionado(Villano villanoSeleccionado) {
		this.villanoSeleccionado = villanoSeleccionado;
	}
	
	public void generarOrdenDeArresto() {
		this.obtenerDetective().generarOrden(this.getVillanoSeleccionado());
	}
}
