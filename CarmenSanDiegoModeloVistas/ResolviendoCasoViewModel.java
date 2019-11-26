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
	private ArrayList<Pais> paisesRecorridoCriminal;
	private ArrayList<Pais> paisesFallidos;
	
	public ArrayList<Pais> obtenerPaisesRecorridoCriminal() {
		return paisesRecorridoCriminal;
	}

	public ArrayList<Pais> obtenerPaisesFallidos() {
		return paisesFallidos;
	}

	public ResolviendoCasoViewModel(Caso caso, String nombre) {
		this.caso = caso;
		this.detective = new Detective(caso.getPaisInicio());
		this.detective.setNombre(nombre);
		paisesRecorridoCriminal = new ArrayList<Pais>();
		paisesFallidos = new ArrayList<Pais>();
		
		paisesRecorridoCriminal.add(caso.getPaisInicio());
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

	public Caso obtenerCaso() {
		return caso;
	}
	
	public void actualizarListaPaisesOKYFallidos() {
		Pais pais = detective.getPaisActual();
		
		if( caso.paisPerteneceRutaDeEscape(pais) ) {
			if( !paisesRecorridoCriminal.contains(pais) ) {
				paisesRecorridoCriminal.add(pais);
			}
		} else {
			if( !paisesFallidos.contains(pais) ) {
				paisesFallidos.add(pais);
			}
		}
	}
}
