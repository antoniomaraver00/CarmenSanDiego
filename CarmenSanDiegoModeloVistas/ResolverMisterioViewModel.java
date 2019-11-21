package CarmenSanDiegoModeloVistas;

import java.util.ArrayList;

import CarmenSanDiego.src.Caso;

public class ResolverMisterioViewModel {
	private ArrayList<Caso> casos;
	private Caso casoSeleccionado;
	
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
}
