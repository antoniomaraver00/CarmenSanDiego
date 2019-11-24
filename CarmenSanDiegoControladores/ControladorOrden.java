package CarmenSanDiegoControladores;

import java.util.ArrayList;
import java.util.Hashtable;

import CarmenSanDiego.src.Villano;
import CarmenSanDiegoModeloVistas.ResolverMisterioViewModel;


public class ControladorOrden {
	Hashtable<String, Villano> dicVillanos;
	ResolverMisterioViewModel modelo;
	
	public ControladorOrden(ResolverMisterioViewModel modelo) {
		this.modelo = modelo;
		dicVillanos = new Hashtable<String, Villano>();
		ArrayList<Villano> listaVillanos = new ArrayList<Villano>();
		listaVillanos.addAll(modelo.getCasoSeleccionado().getSospechosos());
		for(int i=0;i<listaVillanos.size();i++) {
			dicVillanos.put(listaVillanos.get(i).getNombre(), listaVillanos.get(i));
		}
	}

	public ArrayList<String> obtenerNombreVillanos(ResolverMisterioViewModel modelo){
		ArrayList<String> nombreVillanos = new ArrayList<String>();
		ArrayList<Villano> listaVillanos = new ArrayList<Villano>();
		listaVillanos.addAll(modelo.getCasoSeleccionado().getSospechosos());
		for(int i=0;i<listaVillanos.size();i++) {
			nombreVillanos.add(listaVillanos.get(i).getNombre());
		}
		return nombreVillanos;
	}
	
	public void generarOrden(String nombreVillano) {
		Villano villano = dicVillanos.get(nombreVillano);
		modelo.getDetective().generarOrden(villano);
	}
	

}
