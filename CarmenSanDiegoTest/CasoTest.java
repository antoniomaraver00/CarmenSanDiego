package CarmenSanDiegoTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;

import CarmenSanDiego.src.Banco;
import CarmenSanDiego.src.Caso;
import CarmenSanDiego.src.Club;
import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.GameOverException;
import CarmenSanDiego.src.GameWonException;
import CarmenSanDiego.src.Lugar;
import CarmenSanDiego.src.Pais;
import CarmenSanDiego.src.Villano;

public class CasoTest {
	@Test
	public void getPistasPaisDondeEscapo_PaisEsPaisFinalYPreguntaEnLugarQueNoEsElUltimo_EstaCerca() {
		Villano responsable = Mockito.mock(Villano.class);
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		Pais paisDelCrimen = Mockito.mock(Pais.class);
		
		Pais chile = Mockito.mock(Pais.class);
		Pais argentina = new Pais("Argentina", new ArrayList<String>(), new ArrayList<Lugar>());
		
		rutaDeEscape.add(chile);
		rutaDeEscape.add(argentina);
		
		Banco bbva = new Banco("BBVA", argentina);
		Club clubMol = new Club("Club MOL", argentina);
		
		argentina.agregarLugar(bbva);
		argentina.agregarLugar(clubMol);
		
		Detective detective = new Detective(argentina);
		
		Caso caso = new Caso(responsable, rutaDeEscape, "", "", paisDelCrimen, null);
		
		ArrayList<String> pistas = caso.getPistasPaisDondeEscapo(clubMol, detective);
		
		Assert.assertEquals("Estas cerca...", pistas.get(0));
	}
	
	@Test
	public void getPistasPaisDondeEscapo_PaisEsPaisFinalYPreguntaEnLugarDelVillanoYNoTieneSospechosoEnOrden_Pierde() {
		Villano responsable = Mockito.mock(Villano.class);
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		Pais paisDelCrimen = Mockito.mock(Pais.class);
		
		Pais chile = new Pais("Chile", new ArrayList<String>(), new ArrayList<Lugar>());
		Pais argentina = new Pais("Argentina", new ArrayList<String>(), new ArrayList<Lugar>());
		
		Banco bbva = new Banco("BBVA", argentina);
		Club clubMol = new Club("Club MOL", argentina);
		
		argentina.agregarLugar(bbva);
		argentina.agregarLugar(clubMol);
		
		rutaDeEscape.add(chile);
		rutaDeEscape.add(argentina);
		
		Detective detective = new Detective(argentina);
		Caso caso = new Caso(responsable, rutaDeEscape, "", "", paisDelCrimen, null);
		
		Lugar ultimoLugarDeEscape = caso.getUltimoLugarDeEscape();
		
		assertThrows(GameOverException.class, () -> {
			ArrayList<String> pistas = new ArrayList<String>();
			pistas = caso.getPistasPaisDondeEscapo(ultimoLugarDeEscape, detective);
		});
	}
	
	@Test
	public void getPistasPaisDondeEscapo_PaisEsPaisFinalYPreguntaEnLugarDelVillanoYTieneOrdenIncorrecta_Pierde() {
		Villano responsable = Mockito.mock(Villano.class);
		Villano sospechosoIncorrecto = Mockito.mock(Villano.class);
		
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		Pais paisDelCrimen = Mockito.mock(Pais.class);
		
		Pais chile = new Pais("Chile", new ArrayList<String>(), new ArrayList<Lugar>());
		Pais argentina = new Pais("Argentina", new ArrayList<String>(), new ArrayList<Lugar>());
		
		Banco bbva = new Banco("BBVA", argentina);
		Club clubMol = new Club("Club MOL", argentina);
		
		argentina.agregarLugar(bbva);
		argentina.agregarLugar(clubMol);
		
		rutaDeEscape.add(chile);
		rutaDeEscape.add(argentina);
		
		Detective detective = new Detective(argentina);
		detective.generarOrden(sospechosoIncorrecto);
		Caso caso = new Caso(responsable, rutaDeEscape, "", "", paisDelCrimen, null);
		
		Lugar ultimoLugarDeEscape = caso.getUltimoLugarDeEscape();
		
		assertThrows(GameOverException.class, () -> {
			ArrayList<String> pistas = new ArrayList<String>();
			pistas = caso.getPistasPaisDondeEscapo(ultimoLugarDeEscape, detective);
		});
	}
	
	@Test
	public void getPistasPaisDondeEscapo_PaisEsPaisFinalYPreguntaEnLugarDelVillanoYTieneOrdenCorrecta_Gana() {
		Villano responsable = Mockito.mock(Villano.class);
		
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		Pais paisDelCrimen = Mockito.mock(Pais.class);
		
		Pais chile = new Pais("Chile", new ArrayList<String>(), new ArrayList<Lugar>());
		Pais argentina = new Pais("Argentina", new ArrayList<String>(), new ArrayList<Lugar>());
		
		Banco bbva = new Banco("BBVA", argentina);
		Club clubMol = new Club("Club MOL", argentina);
		
		argentina.agregarLugar(bbva);
		argentina.agregarLugar(clubMol);
		
		rutaDeEscape.add(chile);
		rutaDeEscape.add(argentina);
		
		Detective detective = new Detective(argentina);
		detective.generarOrden(responsable);
		Caso caso = new Caso(responsable, rutaDeEscape, "", "", paisDelCrimen, null);
		
		Lugar ultimoLugarDeEscape = caso.getUltimoLugarDeEscape();
		
		assertThrows(GameWonException.class, () -> {
			ArrayList<String> pistas = new ArrayList<String>();
			pistas = caso.getPistasPaisDondeEscapo(ultimoLugarDeEscape, detective);
		});
	}
}
