package CarmenSanDiegoModeloVistas;

import java.util.ArrayList;
import CarmenSanDiego.src.Villano;

public class ExpedientesViewModel {

	private ArrayList<Villano> villanos;
	private Villano villanoSeleccionado;
	
	
	public ExpedientesViewModel(ArrayList<Villano> villanos) {
		this.villanos = villanos;
	}
	public ArrayList<Villano> getVillanos(){
		return villanos;
	}
	public void setVillanoSeleccionado(Villano villanoSeleccionado)
	{
		this.villanoSeleccionado = villanoSeleccionado;
	}
	public String obtenerNombreSeleccionado() {
		return villanoSeleccionado.getNombre();
	}
	public String obtenerSexoSeleccionado() {
		return villanoSeleccionado.getSexo();
	}
	public ArrayList<String> obtenerSenias() {
		return villanoSeleccionado.getSenias();
	}
	public ArrayList<String> obtenerHobbies() {
		return villanoSeleccionado.getHobbies();
	}
}
