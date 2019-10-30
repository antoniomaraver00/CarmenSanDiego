package CarmenSanDiego.src;

import java.util.ArrayList;
import java.util.List;

public class Detective {
	private Villano sospechosoEnOrden = null;
	private Pais paisActual;
	private ArrayList<String> pistasObtenidas;
	
	public Detective() {
		this(null);
	}
	
	public Detective(Pais paisActual) {
		this.paisActual = paisActual;
		this.pistasObtenidas = new ArrayList<String>();
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
	
	public void guardarPistas(List<String> pistas) {
		if(pistas != null) {
			this.pistasObtenidas.addAll(pistas);
		}
	}
	
	public ArrayList<String> obtenerPistasGuaradadas() {
		return this.pistasObtenidas;
	}
}
