package CarmenSanDiegoTest;

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
	public void paisPerteneceRutaDeEscape_PaisNoPerteneceALaRuta_DevuelveFalse() {
		Pais argentina = Mockito.mock(Pais.class);
		Pais chile = Mockito.mock(Pais.class);
		Pais bolivia = Mockito.mock(Pais.class);
		
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		rutaDeEscape.add(argentina);
		rutaDeEscape.add(chile);
		
		Caso caso = new Caso(null, rutaDeEscape, "", "", argentina, null);
		
		Assert.assertFalse(caso.paisPerteneceRutaDeEscape(bolivia));
	}
	
	@Test
	public void paisPerteneceRutaDeEscape_PaisPerteneceALaRuta_DevuelveTrue() {
		Pais argentina = Mockito.mock(Pais.class);
		Pais chile = Mockito.mock(Pais.class);
		Pais bolivia = Mockito.mock(Pais.class);
		
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		rutaDeEscape.add(argentina);
		rutaDeEscape.add(chile);
		rutaDeEscape.add(bolivia);
		
		Caso caso = new Caso(null, rutaDeEscape, "", "", argentina, null);
		
		Assert.assertTrue(caso.paisPerteneceRutaDeEscape(bolivia));
	}
	
	@Test
	public void esPaisFinal_LePasoUnPaisQueNoPerteneceALaRutaDeEscape_DevuelveFalse() {
		Pais argentina = Mockito.mock(Pais.class);
		Pais chile = Mockito.mock(Pais.class);
		Pais bolivia = Mockito.mock(Pais.class);
		
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		rutaDeEscape.add(argentina);
		rutaDeEscape.add(chile);
		
		Caso caso = new Caso(null, rutaDeEscape, "", "", argentina, null);
		
		Assert.assertFalse(caso.esPaisFinal(bolivia));
	}
	
	@Test
	public void esPaisFinal_LePasoElPrimerPaisDeLaRuta_DevuelveFalse() {
		Pais argentina = Mockito.mock(Pais.class);
		Pais chile = Mockito.mock(Pais.class);
		
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		rutaDeEscape.add(argentina);
		rutaDeEscape.add(chile);
		
		Caso caso = new Caso(null, rutaDeEscape, "", "", argentina, null);
		
		Assert.assertFalse(caso.esPaisFinal(argentina));
	}
	
	@Test
	public void esPaisFinal_LePasoElUltimoPaisDeLaRuta_DevuelveTrue() {
		Pais argentina = Mockito.mock(Pais.class);
		Pais chile = Mockito.mock(Pais.class);
		
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		rutaDeEscape.add(argentina);
		rutaDeEscape.add(chile);
		
		Caso caso = new Caso(null, rutaDeEscape, "", "", argentina, null);
		
		Assert.assertTrue(caso.esPaisFinal(chile));
	}
	
	@Test
	public void esElResponsable_LePasoUnSospechosoQueNoEsElResponsable_DevuelveFalse() {
		Villano sospechoso = new Villano("Mario", "");
		Villano responsable = new Villano("Carmen San Diego", "");
		
		Pais argentina = Mockito.mock(Pais.class);
		Pais chile = Mockito.mock(Pais.class);
		
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		rutaDeEscape.add(argentina);
		rutaDeEscape.add(chile);
		
		
		Caso caso = new Caso(responsable, rutaDeEscape, "", "", null, null);
		
		Assert.assertFalse(caso.esElResponsable(sospechoso));
	}
	
	@Test
	public void esElResponsable_LePasoElResponsable_DevuelveTrue() {
		Villano responsable = new Villano("Carmen San Diego", "");
		
		Pais argentina = Mockito.mock(Pais.class);
		Pais chile = Mockito.mock(Pais.class);
		
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		rutaDeEscape.add(argentina);
		rutaDeEscape.add(chile);
		
		
		Caso caso = new Caso(responsable, rutaDeEscape, "", "", null, null);
		
		Assert.assertTrue(caso.esElResponsable(responsable));
	}
	
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
		
		Caso caso = new Caso(responsable, rutaDeEscape, "", "", paisDelCrimen, null, bbva);
		
		ArrayList<String> pistas = caso.getPistasPaisDondeEscapo(clubMol, detective);
		
		Assert.assertEquals("Estas cerca...", pistas.get(0));
	}
	
	@Test(expected = GameOverException.class)
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
		
		caso.getPistasPaisDondeEscapo(ultimoLugarDeEscape, detective);
	}
	
	@Test(expected = GameOverException.class)
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
		
		caso.getPistasPaisDondeEscapo(ultimoLugarDeEscape, detective);
	}
	
	@Test(expected = GameWonException.class)
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
		
		caso.getPistasPaisDondeEscapo(ultimoLugarDeEscape, detective);
	}
	
	@Test
	public void filtrarSospechosos_LePasoSeniasQueNoPoseeSospechoso_DevuelveUnaListaVacia() {
		ArrayList<String> seniasSospechoso1 = new ArrayList<String>();
		seniasSospechoso1.add("Ojo morado");
		seniasSospechoso1.add("Cabello rizado");
		seniasSospechoso1.add("Tatuaje en el hombro");
		ArrayList<String> hobbiesSospechoso1 = new ArrayList<String>();
		hobbiesSospechoso1.add("Le gusta hacer ciclismo");
		
		ArrayList<String> seniasSospechoso2 = new ArrayList<String>();
		seniasSospechoso2.add("Cabello negro");
		seniasSospechoso2.add("Pierna izquierda corta");
		
		Villano sospechoso1 = new Villano("Jaime", "M", seniasSospechoso1, hobbiesSospechoso1);
		Villano sospechoso2 = new Villano("Mario", "M", seniasSospechoso1, new ArrayList<String>());
		
		ArrayList<Villano> sospechosos = new ArrayList<Villano>();
		
		ArrayList<String> seniasFiltro = new ArrayList<String>();
		seniasFiltro.add("Mide 2 metros");
		seniasFiltro.add("Camina raro");
		
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		
		Pais chile = Mockito.mock(Pais.class);
		Pais argentina = Mockito.mock(Pais.class);
		
		rutaDeEscape.add(chile);
		rutaDeEscape.add(argentina);
		
		Caso caso = new Caso(sospechoso1, rutaDeEscape, "", "", null, sospechosos );
		Assert.assertEquals(0, caso.filtrarSospechosos(seniasFiltro, null).size());
	}
	
	@Test
	public void filtrarSospechosos_LePasoSeniasQuePoseeElPrimerSospechoso_DevuelveEste() {
		ArrayList<String> seniasSospechoso1 = new ArrayList<String>();
		seniasSospechoso1.add("Ojo morado");
		seniasSospechoso1.add("Cabello rizado");
		seniasSospechoso1.add("Tatuaje en el hombro");
		ArrayList<String> hobbiesSospechoso1 = new ArrayList<String>();
		hobbiesSospechoso1.add("Le gusta hacer ciclismo");
		
		ArrayList<String> seniasSospechoso2 = new ArrayList<String>();
		seniasSospechoso2.add("Cabello negro");
		seniasSospechoso2.add("Pierna izquierda corta");
		
		Villano sospechoso1 = new Villano("Jaime", "M", hobbiesSospechoso1, seniasSospechoso1);
		Villano sospechoso2 = new Villano("Mario", "M", new ArrayList<String>(), seniasSospechoso2);
		
		ArrayList<Villano> sospechosos = new ArrayList<Villano>();
		sospechosos.add(sospechoso1);
		sospechosos.add(sospechoso2);
		
		ArrayList<String> seniasFiltro = new ArrayList<String>();
		seniasFiltro.add("Ojo morado");
		seniasFiltro.add("Camina raro");
		
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		
		Pais chile = Mockito.mock(Pais.class);
		Pais argentina = Mockito.mock(Pais.class);
		
		rutaDeEscape.add(chile);
		rutaDeEscape.add(argentina);
		
		Caso caso = new Caso(sospechoso1, rutaDeEscape, "", "", null, sospechosos );
		
		ArrayList<Villano> sospechososFiltrados = caso.filtrarSospechosos(seniasFiltro, null);
		
		Assert.assertTrue(sospechososFiltrados.size() == 1 && sospechososFiltrados.contains(sospechoso1));
	}
	
	@Test
	public void filtrarSospechosos_LePasoSeniasQuePoseeElPrimerYSegundoSospechoso_DevuelveLosDos() {
		ArrayList<String> seniasSospechoso1 = new ArrayList<String>();
		seniasSospechoso1.add("Ojo morado");
		seniasSospechoso1.add("Cabello rizado");
		seniasSospechoso1.add("Tatuaje en el hombro");
		ArrayList<String> hobbiesSospechoso1 = new ArrayList<String>();
		hobbiesSospechoso1.add("Le gusta hacer ciclismo");
		
		ArrayList<String> seniasSospechoso2 = new ArrayList<String>();
		seniasSospechoso2.add("Cabello negro");
		seniasSospechoso2.add("Pierna izquierda corta");
		
		Villano sospechoso1 = new Villano("Jaime", "M", hobbiesSospechoso1, seniasSospechoso1);
		Villano sospechoso2 = new Villano("Mario", "M", new ArrayList<String>(), seniasSospechoso2);
		
		ArrayList<Villano> sospechosos = new ArrayList<Villano>();
		sospechosos.add(sospechoso1);
		sospechosos.add(sospechoso2);
		
		ArrayList<String> seniasFiltro = new ArrayList<String>();
		seniasFiltro.add("Ojo morado");
		seniasFiltro.add("Pierna izquierda corta");
		
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		
		Pais chile = Mockito.mock(Pais.class);
		Pais argentina = Mockito.mock(Pais.class);
		
		rutaDeEscape.add(chile);
		rutaDeEscape.add(argentina);
		
		Caso caso = new Caso(sospechoso1, rutaDeEscape, "", "", null, sospechosos );
		
		ArrayList<Villano> sospechososFiltrados = caso.filtrarSospechosos(seniasFiltro, null);
		
		Assert.assertTrue(sospechososFiltrados.contains(sospechoso1) && sospechososFiltrados.contains(sospechoso2));
	}
	
	@Test
	public void filtrarSospechosos_LePasoHobbyQuePoseeElPrimeroYSeniaQuePoseeElSegundo_DevuelveLosDos() {
		ArrayList<String> seniasSospechoso1 = new ArrayList<String>();
		seniasSospechoso1.add("Ojo morado");
		seniasSospechoso1.add("Cabello rizado");
		seniasSospechoso1.add("Tatuaje en el hombro");
		ArrayList<String> hobbiesSospechoso1 = new ArrayList<String>();
		hobbiesSospechoso1.add("Le gusta hacer ciclismo");
		
		ArrayList<String> seniasSospechoso2 = new ArrayList<String>();
		seniasSospechoso2.add("Cabello negro");
		seniasSospechoso2.add("Pierna izquierda corta");
		
		Villano sospechoso1 = new Villano("Jaime", "M", hobbiesSospechoso1, seniasSospechoso1);
		Villano sospechoso2 = new Villano("Mario", "M", new ArrayList<String>(), seniasSospechoso2);
		
		ArrayList<Villano> sospechosos = new ArrayList<Villano>();
		sospechosos.add(sospechoso1);
		sospechosos.add(sospechoso2);
		
		ArrayList<String> seniasFiltro = new ArrayList<String>();
		seniasFiltro.add("Cabello negro");
		ArrayList<String> hobbiesFiltro = new ArrayList<String>();
		hobbiesFiltro.add("Le gusta hacer ciclismo");
		
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		Pais chile = Mockito.mock(Pais.class);
		Pais argentina = Mockito.mock(Pais.class);
		
		rutaDeEscape.add(chile);
		rutaDeEscape.add(argentina);
		
		Caso caso = new Caso(sospechoso1, rutaDeEscape, "", "", null, sospechosos );
		
		ArrayList<Villano> sospechososFiltrados = caso.filtrarSospechosos(seniasFiltro, hobbiesFiltro);
		
		Assert.assertTrue(sospechososFiltrados.contains(sospechoso1) && sospechososFiltrados.contains(sospechoso2));
	}
}
