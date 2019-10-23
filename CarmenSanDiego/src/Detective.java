package CarmenSanDiego.src;

public class Detective {
	private Villano sospechosoEnOrden = null;
	private Pais paisActual;
	
	public void generarOrden(Villano villano)
	{
		sospechosoEnOrden = villano;
	}
	
	public void viajar(Pais paisDestino)
	{
		if(paisActual.hayConexion(paisDestino))
		{
			paisActual = paisDestino;
		}
	}
}
