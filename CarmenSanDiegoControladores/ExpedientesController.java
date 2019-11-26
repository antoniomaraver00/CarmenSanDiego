package CarmenSanDiegoControladores;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import CarmenSanDiego.src.Pais;
import CarmenSanDiego.src.Villano;
import CarmenSanDiegoModeloVistas.ExpedientesViewModel;

public class ExpedientesController {

	private ExpedientesViewModel modelo;
	
	public ExpedientesController(ExpedientesViewModel modelo) {
		this.modelo = modelo;
	}

	public ExpedientesViewModel getModelo()
	{
		return modelo;
	}

	public ListModel<Villano> getVillanos() {
		DefaultListModel<Villano> lista = new DefaultListModel<Villano>();
		for (int i = 0; i < modelo.getVillanos().size(); i++) {
			lista.add(i, modelo.getVillanos().get(i));
		}
		return lista;
	}
}
