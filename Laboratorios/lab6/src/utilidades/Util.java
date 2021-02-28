package utilidades;

/**
 * @author Beatriz Miranda - 119210170
 */
public class Util {
	/**
	 * 
	 * @param o
	 * @param mensagem
	 */
	public static void testaNull(Object o, String mensagem) {
		if (o == null) {
			throw new NullPointerException(mensagem);
		}
	}

	/**
	 * 
	 * @param s
	 * @param mensagem
	 */
	public static void testaVazio(String s, String mensagem) {
		if (s.equals("")) {
			throw new IllegalArgumentException(mensagem);
		}
	}
}
