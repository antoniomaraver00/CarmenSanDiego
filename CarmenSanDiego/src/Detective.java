package CarmenSanDiego.src;

public class Detective {
	private Villano sospechosoEnOrden = null;
	private Pais paisActual = null;
	
	public void generarOrden(Villano villano)
	{
		sospechosoEnOrden = villano;
	}
	
	public void viajar(Pais paisDestino)
	{
		if(paisActual.hayConexion(paisDestino) || paisActual == null)
		{
			paisActual = paisDestino;
		}
	}
	public Pais obtenerPaisActual()
	{
		return paisActual;
	}
	
	public Villano obtenerSospechosoEnOrden()
	{
		return sospechosoEnOrden;
	}
}
