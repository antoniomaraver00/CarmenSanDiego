package CarmenSanDiego.src;
import java.util.List;

public abstract class Lugar {
	private String nombre;
	private Pais pais;
	
	public Lugar(String nombre, Pais pais) {
		this.nombre = nombre;
		this.pais = pais;
	}
	
	public String obtenerNombre() {
		return nombre;
	}
	
	public Pais obtenerPais() {
		return pais;
	}
	
	public List<String> obtenerPistas(Caso caso) {
		return caso.obtenerPistasPaisDondeEscapo(pais, this);
	}
	
	public abstract List<String> modelarPista(Villano villano, Pais paisSiguiente);
}
