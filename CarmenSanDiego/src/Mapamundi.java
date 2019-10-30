package CarmenSanDiego.src;

import java.util.ArrayList;

public class Mapamundi {
	private ArrayList <Pais> paises;
	
	public Mapamundi() {
		paises = new ArrayList<Pais>();
	}
	
	public Mapamundi(ArrayList<Pais> paises) {
		this.paises = paises;
	}
	
	public void asignarConexion(Pais paisA,Pais paisB) {
		paisA.asignarConexion(paisB); 
		paisB.asignarConexion(paisA);
	}
	
}
