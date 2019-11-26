package CarmenSanDiegoControladores;

import java.util.ArrayList;
import java.util.Hashtable;

import CarmenSanDiego.src.Villano;
import CarmenSanDiegoModeloVistas.ElegirCasoViewModel;
import CarmenSanDiegoModeloVistas.ResolviendoCasoViewModel;
import CarmenSanDiegoVistas.ResolviendoCaso;


public class OrdenControlador {
	Hashtable<String, Villano> dicVillanos;
	ResolviendoCasoViewModel modelo;
	
	public OrdenControlador(ResolviendoCasoViewModel modelo) {
		this.modelo = modelo;
		dicVillanos = new Hashtable<String, Villano>();
		ArrayList<Villano> listaVillanos = new ArrayList<Villano>();
		listaVillanos.addAll(modelo.obtenerCaso().getSospechosos());
		for(int i=0;i<listaVillanos.size();i++) {
			dicVillanos.put(listaVillanos.get(i).getNombre(), listaVillanos.get(i));
		}
	}

	public ArrayList<String> obtenerNombreVillanos(){
		ArrayList<String> nombreVillanos = new ArrayList<String>();
		ArrayList<Villano> listaVillanos = new ArrayList<Villano>();
		listaVillanos.addAll(modelo.obtenerCaso().getSospechosos());
		for(int i=0;i<listaVillanos.size();i++) {
			nombreVillanos.add(listaVillanos.get(i).getNombre());
		}
		return nombreVillanos;
	}
	
	public void generarOrden(String nombreVillano) {
		Villano villano = dicVillanos.get(nombreVillano);
		modelo.obtenerDetective().generarOrden(villano);
	}
	

}
