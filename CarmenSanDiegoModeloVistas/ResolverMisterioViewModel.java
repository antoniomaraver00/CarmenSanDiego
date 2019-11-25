package CarmenSanDiegoModeloVistas;

import java.util.ArrayList;
import java.util.List;

import CarmenSanDiego.src.Caso;
import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.Lugar;
import CarmenSanDiego.src.Pais;

public class ResolverMisterioViewModel {
	private ArrayList<Caso> casos;
	private Caso casoSeleccionado;
	private Detective detective;
	
	
	
	public Detective getDetective() {
		return detective;
	}

	public void crearDetective(String nombre) {
		detective = new Detective(casoSeleccionado.getPaisInicio());
		detective.setNombre(nombre);
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
		
		this.casoSeleccionado = casos.get(i);
	}

	public String obtenerNombreVillanoEnOrden() {
		if( detective.getSospechosoEnOrden() == null ) return "";
		
		return detective.getSospechosoEnOrden().getNombre();
	}
	
	public ArrayList<Lugar> obtenerLugaresDelPaisActual() {
		return (ArrayList<Lugar>) detective.getPaisActual().getLugares();
	}

	public ArrayList<Pais> obtenerConexionesPaisActual() {
		return (ArrayList<Pais>) detective.getPaisActual().getConexiones();
	}
	
	public String obtenerNombrePaisActual() {
		return detective.getPaisActual().getNombre();
	}
}
