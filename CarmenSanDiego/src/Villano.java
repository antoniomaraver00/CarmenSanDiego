package CarmenSanDiego.src;
import java.util.List;

public class Villano {
	private String nombre;
	private String sexo;
	private List<String> hobbies;
	private List<String> senias;
	private int ultimoIndexRandomSenias = -1;
	private int ultimoIndexRandomHobbies = -1;
	
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
	
	public String obtenerSeniaRandom() {
		int indexRandom = -1;
		
		while( (indexRandom = (int)(Math.random() * senias.size())) == ultimoIndexRandomSenias );
		
		return senias.get(indexRandom);
	}
	
	public String obtenerHobbieRandom() {
		int indexRandom = -1;
		
		while( (indexRandom = (int)(Math.random() * hobbies.size())) == ultimoIndexRandomHobbies );
		
		return hobbies.get(indexRandom);
	}
	
	public String obtenerSexo() {
		return sexo;
	}

}
