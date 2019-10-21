package CarmenSanDiego.src;

import java.util.List;


public class Mapamundi {
	private List <Pais> paises;
	public Boolean hayConexionAerea(Pais paisA,Pais paisB) {
		return (paisA.hayConexion(paisB) && paisB.hayConexion(paisA));
		
	}
	
}
