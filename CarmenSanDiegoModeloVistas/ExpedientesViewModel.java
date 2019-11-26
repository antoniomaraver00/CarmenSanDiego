package CarmenSanDiegoModeloVistas;

import java.util.ArrayList;
import CarmenSanDiego.src.Villano;

public class ExpedientesViewModel {

	private ArrayList<Villano> villanos;
	private Villano villanoSeleccionado;
	
	public ArrayList<Villano> getVillanos(){
		return villanos;
	}
	public void setVillanoSeleccionado(Villano villanoSelecionado)
	{
		this.villanoSeleccionado = villanoSeleccionado;
	}
}
