
public class Villano {
	private String nombre;
	private String sexo;
	private List<String> hobbies;
	private List<String> senias;
	
	public String obtenerNombre() {
		return nombre;
		}
	
	public void agregarHobbie(String::hobbie) {
		if (!hobbies.contains(hobbie)) {
			hobbies.add(hobbie);
			}
		
	}
	
	public String obtenerSexo() {
		return sexo;
		}

}
