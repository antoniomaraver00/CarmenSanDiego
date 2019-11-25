package CarmenSanDiego.src;

import java.util.ArrayList;

public class DataDummy {

	public ArrayList<Caso> crearCasos() {
		ArrayList<Caso> casos = new ArrayList<Caso>();
		
		ArrayList<Pais> paises = crearListaPaises();
		ArrayList<Villano> sospechosos = crearListaVillanos();
		crearMapamundi(paises);
		
		ArrayList<Pais> rutaDeEscape1 = new ArrayList<Pais>();
		rutaDeEscape1.add(paises.get(0));
		rutaDeEscape1.add(paises.get(2));
		rutaDeEscape1.add(paises.get(1));
		
		Caso caso1 = new Caso(sospechosos.get(0), rutaDeEscape1, "Se han robado la espada de San Martin", "Espada de San Martin", rutaDeEscape1.get(0), sospechosos);
		
		ArrayList<Pais> rutaDeEscape2 = new ArrayList<Pais>();
		rutaDeEscape2.add(paises.get(3));
		rutaDeEscape2.add(paises.get(4));
		rutaDeEscape2.add(paises.get(5));
		
		Caso caso2 = new Caso(sospechosos.get(1), rutaDeEscape2, "Ha desaparecido la antigua escultura de The Beatles", "Escultura de Ringo Star", rutaDeEscape2.get(0), sospechosos);
		
		casos.add(caso1);
		casos.add(caso2);
		
		return casos;
	}
	
	public void crearMapamundi(ArrayList<Pais> paises) {
		Mapamundi mapa = new Mapamundi();
		
		for(int i = 0; i < (paises.size()-2); i++) {
			mapa.asignarConexion(paises.get(i), paises.get(i+1));
			mapa.asignarConexion(paises.get(i), paises.get(i+2));
		}
		
		mapa.asignarConexion(paises.get(paises.size()-2), paises.get(paises.size()-1));
		mapa.asignarConexion(paises.get(paises.size()-2), paises.get(0));
		mapa.asignarConexion(paises.get(0), paises.get(paises.size()-1));
	}
	
	public ArrayList<Villano> crearListaVillanos() {
		ArrayList<Villano> villanos = new ArrayList<Villano>();
		
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
		
		Villano pepo = new Villano("El pepo", "Hombre", new ArrayList<String>(), new ArrayList<String>());
		pepo.agregarHobbie("Le gusta cantar cumbia");
		pepo.agregarHobbie("Juega a la pelota");
		pepo.agregarSenia("Tiene el pelo muy corto");
		pepo.agregarSenia("Tiene la cara cortada");
		
		Villano ihar = new Villano("Ihar Iharovich", "Hombre", new ArrayList<String>(), new ArrayList<String>());
		ihar.agregarHobbie("Juega al croquet");
		ihar.agregarHobbie("Le gusta la cocina");
		ihar.agregarSenia("Tiene pelo rubio");
		ihar.agregarSenia("Maneja limosina");
		ihar.agregarSenia("Tiene tatuaje en su brazo");
		
		villanos.add(pepo);
		villanos.add(marioPorte);
		villanos.add(carmenSanDiego);
		villanos.add(ihar);
		
		return villanos;
	}
	
	public ArrayList<Pais> crearListaPaises() {
		ArrayList<Pais> paises = new ArrayList<Pais>();
		
		ArrayList<String> caractArg = new ArrayList<String>();
		caractArg.add("Toman mate");
		caractArg.add("Juegan al futbol");
		caractArg.add("La bandera es color blanco y celeste");
		
		Pais argentina = new Pais("Argentina", caractArg, new ArrayList<Lugar>());
		agregarLugares(argentina);
		
		ArrayList<String> caractPeru = new ArrayList<String>();
		caractPeru.add("La bandera es roja y blanca");
		caractPeru.add("En su pais se encuentran las ruinas del Machu Picchu");
		caractPeru.add("Su capital es Lima");
		
		Pais peru = new Pais("Peru", caractPeru, new ArrayList<Lugar>());
		agregarLugares(peru);
		
		
		ArrayList<String> caractUruguay = new ArrayList<String>();
		caractUruguay.add("A su seleccion de futbol le dicen la garra charrua");
		caractUruguay.add("Su bandera es blanca y celeste");
		caractUruguay.add("Toman mate");
		
		Pais uruguay = new Pais("Uruguay", caractUruguay, new ArrayList<Lugar>());
		agregarLugares(uruguay);
		
		ArrayList<String> caractEspania = new ArrayList<String>();
		caractEspania.add("Su bandera es de color amarilla y roja");
		caractEspania.add("Un festival principal es el de San Fermin");
		caractEspania.add("Su capital es Madrid");
		
		Pais espania = new Pais("Espania", caractEspania, new ArrayList<Lugar>());
		agregarLugares(espania);
		
		ArrayList<String> caractFrancia = new ArrayList<String>();
		caractFrancia.add("Su bandera es azul, blanca y roja");
		caractFrancia.add("Inventaron la baguette");
		caractFrancia.add("En el pais se encuentra la torre Eiffel");
		
		Pais francia = new Pais("Francia", caractFrancia, new ArrayList<Lugar>());
		agregarLugares(francia);
		
		ArrayList<String> caractInglaterra = new ArrayList<String>();
		caractInglaterra.add("Inventaron el futbol");
		caractInglaterra.add("Su bandera es roja y blanca");
		caractInglaterra.add("Es uno de los paises del Reino Unido");
		
		Pais inglaterra = new Pais("Inglaterra", caractInglaterra, new ArrayList<Lugar>());
		agregarLugares(inglaterra);
		
		paises.add(argentina);
		paises.add(espania);
		paises.add(peru);
		paises.add(inglaterra);
		paises.add(francia);
		paises.add(uruguay);
		
		return paises;
	}
	
	public void agregarLugares(Pais pais) {
		Banco banco = new Banco("Banco", pais);
		Biblioteca bib = new Biblioteca("Biblioteca", pais);
		Embajada emb = new Embajada("Embajada", pais);
		Club club = new Club("Club", pais);
				
		pais.agregarLugar(banco);
		pais.agregarLugar(bib);
		pais.agregarLugar(emb);
		pais.agregarLugar(club);
	}
}
