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
	
	public Boolean hayConexionAerea(Pais paisA,Pais paisB) {
		return (paisA.hayConexion(paisB) && paisB.hayConexion(paisA));
	}
	
}
