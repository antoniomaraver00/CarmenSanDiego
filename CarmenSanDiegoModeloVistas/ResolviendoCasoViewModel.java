package CarmenSanDiegoModeloVistas;

import java.util.ArrayList;

import javax.swing.JFrame;

import CarmenSanDiego.src.Caso;
import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.Lugar;
import CarmenSanDiego.src.Pais;

public class ResolviendoCasoViewModel {
	private Caso caso;
	private Detective detective;
	private JFrame previousFrame;
	
	public ResolviendoCasoViewModel(Caso caso, String nombre, JFrame previousFrame) {
		this.caso = caso;
		this.detective = new Detective(caso.getPaisInicio());
		this.detective.setNombre(nombre);
		this.previousFrame = previousFrame;
	}
	
	public Detective obtenerDetective() {
		return detective;
	}

	public void crearDetective(String nombre) {
		detective = new Detective(caso.getPaisInicio());
		detective.setNombre(nombre);
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

	public JFrame obtenerPreviousFrame() {
		return previousFrame;
	}

	public Caso obtenerCaso() {
		return caso;
	}
}
