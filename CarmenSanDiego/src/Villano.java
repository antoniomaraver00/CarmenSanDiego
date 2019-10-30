package CarmenSanDiego.src;
import java.util.ArrayList;
import java.util.List;

public class Villano {
	private String nombre;
	private String sexo;
	private ArrayList<String> hobbies;
	private ArrayList<String> senias;
	private int ultimoIndexRandomSenias = -1;
	private int ultimoIndexRandomHobbies = -1;
	
	Villano(String nombre, String sexo) {
		this.nombre = nombre;
		this.sexo = sexo;
		this.hobbies = new ArrayList<String>();
		this.senias = new ArrayList<String>();
	}
	
	Villano(String nombre, String sexo, List<String> hobbies, List<String> senias) {
		this.nombre = nombre;
		this.sexo = sexo;
		this.hobbies = new ArrayList<String>();
		this.senias = new ArrayList<String>();
		
		this.hobbies.addAll(hobbies);
		this.senias.addAll(senias);
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
