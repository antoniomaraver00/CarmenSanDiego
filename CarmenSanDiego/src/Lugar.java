package CarmenSanDiego.src;
import java.util.List;

public abstract class Lugar {
	private String nombre;
	private Pais pais;
	
	public Lugar(String nombre, Pais pais) {
		this.nombre = nombre;
		this.pais = pais;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Pais getPais() {
		return pais;
	}
	
	public List<String> getPistas(Caso caso, Detective detective) {
		return caso.getPistasPaisDondeEscapo(this, detective);
	}
	
	public abstract List<String> modelarPistas(Villano villano, Pais paisSiguiente);
}
