package CarmenSanDiego.src;
import java.util.List;

public abstract class Lugar {
	private String nombre;
	
	public Lugar(String nombre) {
		this.nombre = nombre;
	}
	
	public String obtenerNombre() {
		return nombre;
	}
	
	public abstract List<String> obtenerPista(Caso caso);
}
