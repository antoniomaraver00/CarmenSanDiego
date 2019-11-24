package CarmenSanDiegoControladores;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import CarmenSanDiego.src.Pais;

public class ViajarController {
	ArrayList<Pais> conexiones;
	
	public ViajarController(ArrayList<Pais> conexiones) {
		this.conexiones = conexiones;
	}
	
	public ListModel<Pais> getPaises() {
		DefaultListModel<Pais> lista = new DefaultListModel<Pais>();
		for (int i = 0; i < conexiones.size(); i++) {
			lista.add(i, conexiones.get(i));
		}
		return lista;
	}

}
