package CarmenSanDiego.src;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Caso {
	private Villano responsable;
	private List<Pais> rutaDeEscape;
	private String reporte;
	private String objeto;
	private Pais paisDelCrimen;
	private Lugar ultimoLugarEscape;
	private ArrayList<Villano> sospechosos;
	
	public Caso(Villano responsable, List<Pais> rutaDeEscape, String reporte, String objeto, Pais paisDelCrimen, ArrayList<Villano> sospechosos) {
		this.responsable = responsable;
		this.rutaDeEscape = rutaDeEscape;
		this.reporte = reporte;
		this.objeto = objeto;
		this.paisDelCrimen = paisDelCrimen;
		
		this.ultimoLugarEscape = getUltimoPaisDeRuta().getLugarRandom();
		this.sospechosos = sospechosos;
	}

	public ArrayList<Villano> getSospechosos() {
		return sospechosos;
	}

	public String getReporte() {
		return reporte;
	}

	public String getObjeto() {
		return objeto;
	}
	
	private Pais getUltimoPaisDeRuta() {
		if( this.rutaDeEscape == null ) return null;
		
		return this.rutaDeEscape.get( this.rutaDeEscape.size()-1 );
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
	
	public Boolean esElResponsable(Villano sospechoso) {		
		return sospechoso == this.responsable;
	}
	
	private Pais getPaisSiguienteDeRuta(Pais paisActual) {
		if(paisPerteneceRutaDeEscape(paisActual) && !esPaisFinal(paisActual)) {
			return rutaDeEscape.get(rutaDeEscape.indexOf(paisActual)+1);
		}
		
		return null;
	}
	
	public Lugar getUltimoLugarDeEscape() {
		return this.ultimoLugarEscape;
	}
	
	public ArrayList<String> getPistasPaisDondeEscapo(Lugar lugar, Detective detective) {
		ArrayList<String> pistas = new ArrayList<String>();
		Pais paisActual = detective.getPaisActual();
		
		if(esPaisFinal(paisActual)) {
			if( esUltimoLugarDeEscape(lugar) ) {
				Villano sospechoso = detective.getSospechosoEnOrden();
				
				if( !esElResponsable(sospechoso) ) {
					String mensaje;
					
					if( sospechoso == null) {
						mensaje = "El villano esta en el lugar, pero no tenia orden de arresto!";
					} else {
						mensaje = "El sospechoso "+sospechoso.getNombre()+" no es el culpable!";
					}
					throw new GameOverException(mensaje);
				} else {
					throw new GameWonException("Atrapo al malechor!");
				}
			} else {
				pistas.add("Estas cerca...");
			}
		} else if(!paisPerteneceRutaDeEscape(paisActual)) {
			pistas.add("No se nada acerca de aquella persona.");
		} else {
			Pais siguientePais = getPaisSiguienteDeRuta(paisActual);
			
			List<String> pistaModelada = lugar.modelarPistas(responsable, siguientePais);
			pistas.addAll(pistaModelada);
		}
		
		return pistas;
	}
	
	private Boolean sospechosoPoseeAlgunaSenia( ArrayList<String> seniasFiltro, Villano sospechoso ) {
		if( seniasFiltro == null || seniasFiltro.size() == 0 ) {
			return false;
		}
		
		ArrayList<String> sospechosoSenias = sospechoso.getSenias();
		
		if( sospechosoSenias == null || sospechosoSenias.size() == 0 ) {
			return false;
		}
		
		return sospechosoSenias.stream().anyMatch( senia -> seniasFiltro.contains(senia) );
	}
	
	private Boolean sospechosoPoseeAlgunHobby( ArrayList<String> hobbiesFiltro, Villano sospechoso ) {
		if( hobbiesFiltro == null || hobbiesFiltro.size() == 0 ) {
			return false;
		}
		
		ArrayList<String> sospechosoHobbies = sospechoso.getHobbies();
		
		if( sospechosoHobbies == null || sospechosoHobbies.size() == 0 ) {
			return false;
		}
		
		return sospechosoHobbies.stream().anyMatch( hobby -> hobbiesFiltro.contains(hobby) );
	}
	
	private Boolean filtroSospechosoPorHobbiesYSenias( ArrayList<String> hobbiesFiltro, ArrayList<String> seniasFiltro, Villano sospechoso ) {
		return (sospechosoPoseeAlgunaSenia(seniasFiltro, sospechoso) || sospechosoPoseeAlgunHobby(hobbiesFiltro, sospechoso));
	}
	
	public ArrayList<Villano> filtrarSospechosos(ArrayList<String> senias, ArrayList<String> hobbies) {	
		return sospechosos.stream().filter( sospechoso -> filtroSospechosoPorHobbiesYSenias(hobbies, senias, sospechoso)).collect(Collectors.toCollection(ArrayList::new));
	}
}