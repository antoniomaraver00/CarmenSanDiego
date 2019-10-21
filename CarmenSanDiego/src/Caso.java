package CarmenSanDiego.src;

import java.util.ArrayList;
import java.util.List;

public class Caso {
	private Villano responsable;
	private List<Pais> rutaDeEscape;
	private String reporte;
	private String objeto;
	private Pais paisDelCrimen;
	private int ultimoLugarEscape;
	
	Caso(Villano responsable, List<Pais> rutaDeEscape, String reporte, String objeto, Pais paisDelCrimen) {
		this.responsable = responsable;
		this.rutaDeEscape = rutaDeEscape;
		this.reporte = reporte;
		this.objeto = objeto;
		this.paisDelCrimen = paisDelCrimen;
		
		ultimoLugarEscape = (int)(Math.random()*(rutaDeEscape.size()-1));
	}

	public String getReporte() {
		return reporte;
	}

	public String getObjeto() {
		return objeto;
	}

	public Boolean paisPerteneceRutaDeEscape(Pais pais) {
		return rutaDeEscape.contains(pais);
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
	
	public List<String> obtenerPistasPaisDondeEscapo(Pais paisActual, Lugar lugar) {
		List<String> pistas = new ArrayList<String>();
		
		if(esPaisFinal(paisActual)) {
			if( rutaDeEscape.indexOf(lugar) == ultimoLugarEscape ) {
				// FALTA IMPLEMENTAR SABER SI TERMINA EL JUEGO O NO DE ACUERDO A SI EMITIO ORDEN CORRECTA
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
