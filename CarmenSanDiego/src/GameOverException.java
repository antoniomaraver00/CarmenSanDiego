package CarmenSanDiego.src;

public class GameOverException extends RuntimeException {
	public GameOverException(String error) {
		super("Juego finalizado, perdio. Causa: "+error);
	}
}
