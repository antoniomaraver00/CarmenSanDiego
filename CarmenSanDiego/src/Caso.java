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
	
	public Caso(Villano responsable, List<Pais> rutaDeEscape, String reporte, String objeto, Pais paisDelCrimen) {
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
	
	public List<String> obtenerPistasPaisDondeEscapo(Pais paisActual, Lugar lugar, Detective detective) {
		List<String> pistas = new ArrayList<String>();
		
		if(esPaisFinal(paisActual)) {
			if( rutaDeEscape.indexOf(lugar) == ultimoLugarEscape ) {
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
