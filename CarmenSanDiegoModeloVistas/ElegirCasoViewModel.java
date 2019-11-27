package CarmenSanDiegoModeloVistas;

import java.util.ArrayList;


import CarmenSanDiego.src.Caso;
import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.Lugar;
import CarmenSanDiego.src.Pais;

public class ElegirCasoViewModel {
	private ArrayList<Caso> casos;
	private Caso casoSeleccionado;
	private String nombreDetective;
	
	public ElegirCasoViewModel(String nombreDetective) {
		this.nombreDetective = nombreDetective;
	}
	
	public ArrayList<Caso> getCasos() {
		return casos;
	}
	
	public void setCasos(ArrayList<Caso> casos) {
		this.casos = casos;
	}

	public Caso getCasoSeleccionado() {
		return casoSeleccionado;
	}

	public void setCasoSeleccionado(Caso casoSeleccionado) {
		this.casoSeleccionado = casoSeleccionado;
	}
	
	private Caso obtenerCasoRandom() {
		int rand = (int)Math.random()*(casos.size()-1);
		
		return casos.get(rand);
	}
	
	public void setCasoSeleccionadoRandom() {
		int i = this.casos.indexOf(casoSeleccionado);
		if(++i >= casos.size()) i = 0;
		
		setCasoSeleccionado(casos.get(i));
	}

	public String getNombreDetective() {
		return nombreDetective;
	}

}
