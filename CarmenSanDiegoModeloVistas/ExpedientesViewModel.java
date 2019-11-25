package CarmenSanDiegoModeloVistas;

import java.util.ArrayList;

import CarmenSanDiego.src.Villano;

public class ExpedientesViewModel {
	private ArrayList<Villano> listaVillanos;
	private Villano villanoSeleccionado;
	
	public ExpedientesViewModel(ArrayList<Villano> villanos) {
		listaVillanos = villanos;
	}
}
