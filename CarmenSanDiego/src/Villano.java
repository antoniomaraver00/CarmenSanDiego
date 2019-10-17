import java.util.List;

public class Villano {
	private String nombre;
	private String sexo;
	private List<String> hobbies;
	private List<String> senias;
	
	Villano(String nombre, String sexo) {
		this.nombre = nombre;
		this.sexo = sexo;
	}
	
	public String obtenerNombre() {
		return nombre;
		}
	
	public void agregarSenia(String senia) {
		if (!senias.contains(senia)) {
			hobbies.add(senia);
			}
	}
		
	public void agregarHobbie(String hobbie) {
		if (!hobbies.contains(hobbie)) {
			hobbies.add(hobbie);
			}
		
	}
	
	public String obtenerSexo() {
		return sexo;
		}

}
