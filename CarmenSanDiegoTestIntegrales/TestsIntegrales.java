package CarmenSanDiegoTestIntegrales;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import CarmenSanDiego.src.Banco;
import CarmenSanDiego.src.Biblioteca;
import CarmenSanDiego.src.Caso;
import CarmenSanDiego.src.Club;
import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.Embajada;
import CarmenSanDiego.src.GameOverException;
import CarmenSanDiego.src.GameWonException;
import CarmenSanDiego.src.Lugar;
import CarmenSanDiego.src.Mapamundi;
import CarmenSanDiego.src.Pais;
import CarmenSanDiego.src.Villano;

public class TestsIntegrales {
	@Test(expected = GameOverException.class)
	public void CasoQueLlegaAlFinalSinGenerarOrden() {
		//ARGENTINA
		ArrayList<String> caracteristicasArgentina = new ArrayList<String>();
		caracteristicasArgentina.add("Toman mate");
		caracteristicasArgentina.add("Juegan al futbol");
		caracteristicasArgentina.add("Su bandera es blanca y celeste");
		
		List<Lugar> lugaresArgentina = new ArrayList<Lugar>();
		Pais argentina = new Pais("Argentina", caracteristicasArgentina, lugaresArgentina);
		
		Banco bancoNacion = new Banco("Banco Nacion", argentina);
		Club leloir = new Club("Club Leloir", argentina);
		Embajada embajada = new Embajada("Embajada Argentina", argentina);
		argentina.agregarLugar(bancoNacion);
		argentina.agregarLugar(leloir);
		argentina.agregarLugar(embajada);
		
		//CHILE
		ArrayList<String> caracteristicasChile = new ArrayList<String>();
		caracteristicasChile.add("Su bandera es roja, blanca y azul");
		caracteristicasChile.add("Su capital es Santiago...");
		caracteristicasChile.add("Estan bordeados por la Cordillera de los Andes");
		
		List<Lugar> lugaresChile = new ArrayList<Lugar>();
		Pais chile = new Pais("Chile", caracteristicasChile, lugaresChile);
		
		Banco bancoChileno = new Banco("Banco Chileno", chile);
		Club clubAWE = new Club("Club AWE", chile);
		Biblioteca bibNacional = new Biblioteca("Biblioteca Nacional Chilena", chile);
		
		chile.agregarLugar(bancoChileno);
		chile.agregarLugar(clubAWE);
		chile.agregarLugar(bibNacional);
		
		//BRASIL
		ArrayList<String> caracteristicasBrasil = new ArrayList<String>();
		caracteristicasBrasil.add("Juegan al futbol");
		caracteristicasBrasil.add("En su pais se encuentra el cristo redentor");
		caracteristicasBrasil.add("Conocido por sus playas");
		
		List<Lugar> lugaresBrasil = new ArrayList<Lugar>();
		Pais brasil = new Pais("Brasil", caracteristicasBrasil, lugaresBrasil);
		
		Club clubMacaco = new Club("Club Macaco", brasil);
		Biblioteca bibliotecaJaneiro = new Biblioteca("Biblioteca de Janeiro", brasil);
		Embajada embajadaBrasil = new Embajada("Embajada de Brasil", brasil);
		
		brasil.agregarLugar(clubMacaco);
		brasil.agregarLugar(bibliotecaJaneiro);
		brasil.agregarLugar(embajadaBrasil);
		
		Mapamundi mapamundi = new Mapamundi();
		mapamundi.asignarConexion(argentina, chile);
		mapamundi.asignarConexion(chile, brasil);
		
		Villano carmenSanDiego = new Villano("Carmen San Diego", "Mujer", new ArrayList<String>(), new ArrayList<String>());
		carmenSanDiego.agregarHobbie("Le gusta la playa");
		carmenSanDiego.agregarHobbie("Le gusta el ceviche");
		carmenSanDiego.agregarSenia("Tiene el pelo rojo");
		carmenSanDiego.agregarSenia("Es muy alta");
		
		Villano marioPorte = new Villano("Mario Porte", "Hombre", new ArrayList<String>(), new ArrayList<String>());
		marioPorte.agregarHobbie("Le gusta jugar a la pelota");
		marioPorte.agregarHobbie("Le gusta la montaña");
		marioPorte.agregarSenia("Tiene un ojo grande");
		marioPorte.agregarSenia("Tiene sobrepeso");
		
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		rutaDeEscape.add(argentina);
		rutaDeEscape.add(chile);
		rutaDeEscape.add(brasil);
		
		ArrayList<Villano> sospechosos = new ArrayList<Villano>();
		sospechosos.add(carmenSanDiego);
		sospechosos.add(marioPorte);
		
		Caso caso = new Caso(carmenSanDiego, rutaDeEscape, "Se han robado la espada de San Martin", "Espada de San Martin", argentina, sospechosos);
		
		Detective julian = new Detective(argentina);
		

			System.out.println(bancoNacion.getPistas(caso, julian));
			
			julian.viajar(chile);
			
			System.out.println(clubAWE.getPistas(caso, julian));
			
			julian.viajar(brasil);
			
			//o usamos spy o lo fijamos de alguna manera
			System.out.println(clubMacaco.getPistas(caso, julian));
			System.out.println(bibliotecaJaneiro.getPistas(caso, julian));
			System.out.println(embajadaBrasil.getPistas(caso, julian));
	}
	
	@Test(expected = GameOverException.class)
	public void CasoQueLlegaAlFinalConOrdenErroneaYPierde() {
		//ARGENTINA
		ArrayList<String> caracteristicasArgentina = new ArrayList<String>();
		caracteristicasArgentina.add("Toman mate");
		caracteristicasArgentina.add("Juegan al futbol");
		caracteristicasArgentina.add("Su bandera es blanca y celeste");
		
		List<Lugar> lugaresArgentina = new ArrayList<Lugar>();
		Pais argentina = new Pais("Argentina", caracteristicasArgentina, lugaresArgentina);
		
		Banco bancoNacion = new Banco("Banco Nacion", argentina);
		Club leloir = new Club("Club Leloir", argentina);
		Embajada embajada = new Embajada("Embajada Argentina", argentina);
		argentina.agregarLugar(bancoNacion);
		argentina.agregarLugar(leloir);
		argentina.agregarLugar(embajada);
		
		//CHILE
		ArrayList<String> caracteristicasChile = new ArrayList<String>();
		caracteristicasChile.add("Su bandera es roja, blanca y azul");
		caracteristicasChile.add("Su capital es Santiago...");
		caracteristicasChile.add("Estan bordeados por la Cordillera de los Andes");
		
		List<Lugar> lugaresChile = new ArrayList<Lugar>();
		Pais chile = new Pais("Chile", caracteristicasChile, lugaresChile);
		
		Banco bancoChileno = new Banco("Banco Chileno", chile);
		Club clubAWE = new Club("Club AWE", chile);
		Biblioteca bibNacional = new Biblioteca("Biblioteca Nacional Chilena", chile);
		
		chile.agregarLugar(bancoChileno);
		chile.agregarLugar(clubAWE);
		chile.agregarLugar(bibNacional);
		
		//BRASIL
		ArrayList<String> caracteristicasBrasil = new ArrayList<String>();
		caracteristicasBrasil.add("Juegan al futbol");
		caracteristicasBrasil.add("En su pais se encuentra el cristo redentor");
		caracteristicasBrasil.add("Conocido por sus playas");
		
		List<Lugar> lugaresBrasil = new ArrayList<Lugar>();
		Pais brasil = new Pais("Brasil", caracteristicasBrasil, lugaresBrasil);
		
		Club clubMacaco = new Club("Club Macaco", brasil);
		Biblioteca bibliotecaJaneiro = new Biblioteca("Biblioteca de Janeiro", brasil);
		Embajada embajadaBrasil = new Embajada("Embajada de Brasil", brasil);
		
		brasil.agregarLugar(clubMacaco);
		brasil.agregarLugar(bibliotecaJaneiro);
		brasil.agregarLugar(embajadaBrasil);
		
		Mapamundi mapamundi = new Mapamundi();
		mapamundi.asignarConexion(argentina, chile);
		mapamundi.asignarConexion(chile, brasil);
		
		Villano carmenSanDiego = new Villano("Carmen San Diego", "Mujer", new ArrayList<String>(), new ArrayList<String>());
		carmenSanDiego.agregarHobbie("Le gusta la playa");
		carmenSanDiego.agregarHobbie("Le gusta el ceviche");
		carmenSanDiego.agregarSenia("Tiene el pelo rojo");
		carmenSanDiego.agregarSenia("Es muy alta");
		
		Villano marioPorte = new Villano("Mario Porte", "Hombre", new ArrayList<String>(), new ArrayList<String>());
		marioPorte.agregarHobbie("Le gusta jugar a la pelota");
		marioPorte.agregarHobbie("Le gusta la montaña");
		marioPorte.agregarSenia("Tiene un ojo grande");
		marioPorte.agregarSenia("Tiene sobrepeso");
		
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		rutaDeEscape.add(argentina);
		rutaDeEscape.add(chile);
		rutaDeEscape.add(brasil);
		
		ArrayList<Villano> sospechosos = new ArrayList<Villano>();
		sospechosos.add(carmenSanDiego);
		sospechosos.add(marioPorte);
		
		Caso caso = new Caso(marioPorte, rutaDeEscape, "Se han robado la espada de San Martin", "Espada de San Martin", argentina, sospechosos);
		
		Detective julian = new Detective(argentina);
		
			System.out.println(embajada.getPistas(caso, julian));
			
			julian.viajar(chile);
			
			System.out.println(bibNacional.getPistas(caso, julian));
			
			julian.viajar(brasil);
			
			julian.generarOrden(carmenSanDiego);
			
			System.out.println(clubMacaco.getPistas(caso, julian));
			System.out.println(bibliotecaJaneiro.getPistas(caso, julian));
			System.out.println(embajadaBrasil.getPistas(caso, julian));

	}
	
	@Test(expected = GameWonException.class)
	public void CasoQueLlegaAlFinalConOrdenCorrectaYGana() {
		//ARGENTINA
		ArrayList<String> caracteristicasArgentina = new ArrayList<String>();
		caracteristicasArgentina.add("Toman mate");
		caracteristicasArgentina.add("Juegan al futbol");
		caracteristicasArgentina.add("Su bandera es blanca y celeste");
		
		List<Lugar> lugaresArgentina = new ArrayList<Lugar>();
		Pais argentina = new Pais("Argentina", caracteristicasArgentina, lugaresArgentina);
		
		Banco bancoNacion = new Banco("Banco Nacion", argentina);
		Club leloir = new Club("Club Leloir", argentina);
		Embajada embajada = new Embajada("Embajada Argentina", argentina);
		argentina.agregarLugar(bancoNacion);
		argentina.agregarLugar(leloir);
		argentina.agregarLugar(embajada);
		
		//CHILE
		ArrayList<String> caracteristicasChile = new ArrayList<String>();
		caracteristicasChile.add("Su bandera es roja, blanca y azul");
		caracteristicasChile.add("Su capital es Santiago...");
		caracteristicasChile.add("Estan bordeados por la Cordillera de los Andes");
		
		List<Lugar> lugaresChile = new ArrayList<Lugar>();
		Pais chile = new Pais("Chile", caracteristicasChile, lugaresChile);
		
		Banco bancoChileno = new Banco("Banco Chileno", chile);
		Club clubAWE = new Club("Club AWE", chile);
		Biblioteca bibNacional = new Biblioteca("Biblioteca Nacional Chilena", chile);
		
		chile.agregarLugar(bancoChileno);
		chile.agregarLugar(clubAWE);
		chile.agregarLugar(bibNacional);
		
		//BRASIL
		ArrayList<String> caracteristicasBrasil = new ArrayList<String>();
		caracteristicasBrasil.add("Juegan al futbol");
		caracteristicasBrasil.add("En su pais se encuentra el cristo redentor");
		caracteristicasBrasil.add("Conocido por sus playas");
		
		List<Lugar> lugaresBrasil = new ArrayList<Lugar>();
		Pais brasil = new Pais("Brasil", caracteristicasBrasil, lugaresBrasil);
		
		Club clubMacaco = new Club("Club Macaco", brasil);
		Biblioteca bibliotecaJaneiro = new Biblioteca("Biblioteca de Janeiro", brasil);
		Embajada embajadaBrasil = new Embajada("Embajada de Brasil", brasil);
		
		brasil.agregarLugar(clubMacaco);
		brasil.agregarLugar(bibliotecaJaneiro);
		brasil.agregarLugar(embajadaBrasil);
		
		Mapamundi mapamundi = new Mapamundi();
		mapamundi.asignarConexion(argentina, chile);
		mapamundi.asignarConexion(chile, brasil);
		
		Villano carmenSanDiego = new Villano("Carmen San Diego", "Mujer", new ArrayList<String>(), new ArrayList<String>());
		carmenSanDiego.agregarHobbie("Le gusta la playa");
		carmenSanDiego.agregarHobbie("Le gusta el ceviche");
		carmenSanDiego.agregarSenia("Tiene el pelo rojo");
		carmenSanDiego.agregarSenia("Es muy alta");
		
		Villano marioPorte = new Villano("Mario Porte", "Hombre", new ArrayList<String>(), new ArrayList<String>());
		marioPorte.agregarHobbie("Le gusta jugar a la pelota");
		marioPorte.agregarHobbie("Le gusta la montaña");
		marioPorte.agregarSenia("Tiene un ojo grande");
		marioPorte.agregarSenia("Tiene sobrepeso");
		
		ArrayList<Pais> rutaDeEscape = new ArrayList<Pais>();
		rutaDeEscape.add(argentina);
		rutaDeEscape.add(chile);
		rutaDeEscape.add(brasil);
		
		ArrayList<Villano> sospechosos = new ArrayList<Villano>();
		sospechosos.add(carmenSanDiego);
		sospechosos.add(marioPorte);
		
		Caso caso = new Caso(marioPorte, rutaDeEscape, "Se han robado la espada de San Martin", "Espada de San Martin", argentina, sospechosos);
		
		Detective julian = new Detective(argentina);
		
			System.out.println(embajada.getPistas(caso, julian));
			
			julian.viajar(chile);
			
			System.out.println(bibNacional.getPistas(caso, julian));
			
			julian.viajar(brasil);
			
			julian.generarOrden(marioPorte);
			
			System.out.println(clubMacaco.getPistas(caso, julian));
			System.out.println(bibliotecaJaneiro.getPistas(caso, julian));
			System.out.println(embajadaBrasil.getPistas(caso, julian));
		
	}
}
