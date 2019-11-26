package CarmenSanDiegoControladores;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import CarmenSanDiego.src.Lugar;
import CarmenSanDiegoModeloVistas.ElegirCasoViewModel;
import CarmenSanDiegoModeloVistas.ResolviendoCasoViewModel;

public class ResolviendoCasoController {
	ResolviendoCasoViewModel modelo;
	
	public ResolviendoCasoController(ResolviendoCasoViewModel modelo) {
		this.modelo = modelo;
	}
	
	public ListModel<Lugar> getLugares() {
		DefaultListModel<Lugar> lista = new DefaultListModel<Lugar>();
		for (int i = 0; i < modelo.obtenerLugaresDelPaisActual().size(); i++) {
			lista.add(i, modelo.obtenerLugaresDelPaisActual().get(i));
		}
		return lista;
	}
}
