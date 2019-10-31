package CarmenSanDiego.src;

import java.util.Random;

public class Calculo {
	static Random r = new Random();
	
	public static int obtenerEnteroRandomDiferenteA(int maximoRandom, int intDiferente) {
		int numRandom = obtenerEnteroRandom(maximoRandom);
		while( numRandom == intDiferente ) {
			numRandom = obtenerEnteroRandom(maximoRandom);
		};
		
		return numRandom;
	}
	
	public static int obtenerEnteroRandom(int maximoRandom) {
		return r.nextInt(maximoRandom);
	}
}