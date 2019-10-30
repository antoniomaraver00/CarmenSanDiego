package CarmenSanDiego.src;

import java.util.ArrayList;

public class Mapamundi {
	private ArrayList <Pais> paises;
	
	public Mapamundi() {
		paises = new ArrayList<Pais>();
	}
	
	public Boolean hayConexionAerea(Pais paisA,Pais paisB) {
		return (paisA.hayConexion(paisB) && paisB.hayConexion(paisA));
		
	}
	
}
