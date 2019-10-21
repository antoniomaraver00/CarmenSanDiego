package CarmenSanDiego.src;

import java.util.ArrayList;
import java.util.List;

public class Caso {
	private Villano responsable;
	private List<Pais> rutaDeEscape;
	private String reporte;
	private String objeto;
	private Pais paisDelCrimen;
	
	Caso(Villano responsable, List<Pais> rutaDeEscape, String reporte, String objeto, Pais paisDelCrimen) {
		this.responsable = responsable;
		this.rutaDeEscape = rutaDeEscape;
		this.reporte = reporte;
		this.objeto = objeto;
		this.paisDelCrimen = paisDelCrimen;
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
		if(!paisPerteneceRutaDeEscape(paisActual)) {
			pistas.add("No se nada acerca de aquella persona.");
		} else if(esPaisFinal(paisActual)) {
			pistas.add("Estas cerca...");
		} else {
			Pais siguientePais = obtenerPaisSiguienteDeRuta(paisActual);
			
			List<String> pistaModelada = modelarPista(responsable, siguientePais);
			pistas.addAll(pistaModelada);
		}
		
		return pistas;
	}
}
