package validacao;

public class ValidaOrdenacao {

	/**
	 * Metodo que verifica o criterio da ordenacao
	 * @param criterio: criterio da ordenacao
	 */
	public static void criterio(String criterio) {
		if (criterio == null || criterio.isBlank()) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	 * Metodo que verifica se o criterio da ordenacao eh nulo
	 * @param criterio: criterio da ordenacao
	 */
	public static void criterioNull(String criterio) {
		if (criterio == null) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio ainda nao definido pelo sistema.");
		}
	}
	
	/**
	 * Metodo que lanca excessao na ordenacao caso o criterio passado nao seja oferecido pelo sistema
	 */
	public static void defaultOutput() {
		throw new IllegalArgumentException("Erro na listagem de compras: criterio nao oferecido pelo sistema.");
	}
}
