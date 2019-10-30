package CarmenSanDiego.src;


public class Detective {
	private Villano sospechosoEnOrden = null;
	private Pais paisActual;
	
	public Detective() {
		this(null);
	}
	
	public Detective(Pais paisActual) {
		this.paisActual = paisActual;
	}
	
	public void generarOrden(Villano villano)
	{
		sospechosoEnOrden = villano;
	}
	
	public void viajar(Pais paisDestino)
	{
		if(paisActual == null || paisActual.hayConexion(paisDestino))
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
