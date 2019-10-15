
public class Villano {
	private String nombre;
	private String sexo;
	private List<String> hobbies;
	private List<String> senias;
	
	public void setName(String name) {
		this.nombre=name;
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
	public void setSexo(String sexo) {
		this.sexo=sexo;
	}
	
	public String obtenerSexo() {
		return sexo;
		}

}
