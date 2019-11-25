package CarmenSanDiegoControladores;

import java.util.ArrayList;

import javax.swing.ListModel;

import CarmenSanDiego.src.Villano;
import CarmenSanDiegoModeloVistas.ExpedientesViewModel;

public class ExpedientesController {

	private ExpedientesViewModel modelo;

	public ArrayList<Villano> getVillanos() {
		return modelo.getVillanos();
	}
}
