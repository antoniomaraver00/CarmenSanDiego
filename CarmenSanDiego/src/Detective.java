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
		if(sospechosoEnOrden==null) {
			sospechosoEnOrden = villano;
		}
	}
	
	public void viajar(Pais paisDestino)
	{
		if(paisActual == null || paisActual.hayConexion(paisDestino))
		{
			paisActual = paisDestino;
		}
	}
	public Pais getPaisActual()
	{
		return paisActual;
	}
	
	public Villano getSospechosoEnOrden()
	{
		return sospechosoEnOrden;
	}
}
