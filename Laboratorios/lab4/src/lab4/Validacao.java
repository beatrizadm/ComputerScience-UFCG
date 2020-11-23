package lab4;

public class Validacao {

	public static void valida(String entrada) {
		if (entrada == null) {
			throw new NullPointerException("Nao pode ser nulo.");
		}
		
		if(entrada.isBlank()) {
			throw new IllegalArgumentException("Nao pode ser vazio.");
		}
	}
}
