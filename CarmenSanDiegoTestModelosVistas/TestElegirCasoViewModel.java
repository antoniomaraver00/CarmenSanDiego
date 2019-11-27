package CarmenSanDiegoTestModelosVistas;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;
import CarmenSanDiego.src.Caso;
import CarmenSanDiegoModeloVistas.ElegirCasoViewModel;


public class TestElegirCasoViewModel{
@Test

public void setCasoSeleccionadoRandom_EstaDentroDeListaDeCasos() {
	Caso caso1=Mockito.mock(Caso.class);
	Caso caso2=Mockito.mock(Caso.class);
	Caso caso3=Mockito.mock(Caso.class);
	
	ArrayList<Caso> casos=new ArrayList<Caso>();
	casos.add(caso1);
	casos.add(caso2);
	casos.add(caso3);
	
	ElegirCasoViewModel modelo=new ElegirCasoViewModel("Carlos");
	modelo.setCasos(casos);
	modelo.setCasoSeleccionadoRandom();
	Caso casoSeleccionado=modelo.getCasoSeleccionado();
	Assert.assertTrue(casos.contains(casoSeleccionado));
	
}

@Test

public void setCasoSeleccionadoRandom_PidoDosCasosYDeberianSerDistinto() {
	Caso caso1=Mockito.mock(Caso.class);
	Caso caso2=Mockito.mock(Caso.class);
	Caso caso3=Mockito.mock(Caso.class);
	
	ArrayList<Caso> casos=new ArrayList<Caso>();
	casos.add(caso1);
	casos.add(caso2);
	casos.add(caso3);
	
	ElegirCasoViewModel modelo=new ElegirCasoViewModel("Carlos");
	modelo.setCasos(casos);
	modelo.setCasoSeleccionadoRandom();
	Caso casoSeleccionado1=modelo.getCasoSeleccionado();
	modelo.setCasoSeleccionadoRandom();
	Caso casoSeleccionado2=modelo.getCasoSeleccionado();
	Assert.assertNotEquals(casoSeleccionado1,casoSeleccionado2);
}

}
