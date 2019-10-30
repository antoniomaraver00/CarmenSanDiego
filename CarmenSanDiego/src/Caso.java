package CarmenSanDiego.src;

import java.util.ArrayList;
import java.util.List;

public class Caso {
	private Villano responsable;
	private List<Pais> rutaDeEscape;
	private String reporte;
	private String objeto;
	private Pais paisDelCrimen;
	private Lugar ultimoLugarEscape;
	
	public Caso(Villano responsable, List<Pais> rutaDeEscape, String reporte, String objeto, Pais paisDelCrimen) {
		this.responsable = responsable;
		this.rutaDeEscape = rutaDeEscape;
		this.reporte = reporte;
		this.objeto = objeto;
		this.paisDelCrimen = paisDelCrimen;
		
		this.ultimoLugarEscape = ultimoPaisDeRuta().obtenerLugarRandom();
	}

	public String getReporte() {
		return reporte;
	}

	public String getObjeto() {
		return objeto;
	}
		
	private Pais ultimoPaisDeRuta() {
		if( this.rutaDeEscape == null ) return null;
		
		return this.rutaDeEscape.get( this.rutaDeEscape.size() );
	}
	
	public Boolean paisPerteneceRutaDeEscape(Pais pais) {
		return rutaDeEscape.contains(pais);
	}
	
	private Boolean esUltimoLugarDeEscape(Lugar lugar) {
		if( lugar == null ) return false;
	
		return lugar == this.ultimoLugarEscape;
	}
	
	public Boolean esPaisFinal(Pais pais) {
		return rutaDeEscape.indexOf(pais) == (rutaDeEscape.size()-1);
	}
	
	private Pais obtenerPaisSiguienteDeRuta(Pais paisActual) {
		if(paisPerteneceRutaDeEscape(paisActual) && !esPaisFinal(paisActual)) {
			return rutaDeEscape.get(rutaDeEscape.indexOf(paisActual)+1);
		}
		
		return null;
	}
	
	public List<String> obtenerPistasPaisDondeEscapo(Lugar lugar, Detective detective) {
		List<String> pistas = new ArrayList<String>();
		Pais paisActual = detective.obtenerPaisActual();
		
		if(esPaisFinal(paisActual)) {
			if( esUltimoLugarDeEscape(lugar) ) {
				Villano sospechoso = detective.obtenerSospechosoEnOrden();
				
				if(sospechoso == null || sospechoso != responsable) {
					throw new GameOverException("El sospechoso "+sospechoso.obtenerNombre()+" no es el culpable!");
				} else {
					throw new GameWonException("Atrapo al malechor!");
				}
			} else {
				pistas.add("Estas cerca...");
			}
		} else if(!paisPerteneceRutaDeEscape(paisActual)) {
			pistas.add("No se nada acerca de aquella persona.");
		} else {
			Pais siguientePais = obtenerPaisSiguienteDeRuta(paisActual);
			
			List<String> pistaModelada = lugar.modelarPistas(responsable, siguientePais);
			pistas.addAll(pistaModelada);
		}
		
		return pistas;
	}
}
