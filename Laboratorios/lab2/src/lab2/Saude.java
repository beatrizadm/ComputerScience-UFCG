package lab2;

/**
 * Representação da saude do aluno, a saude deve ser analisada fisica e mentalmente.
 * 
 * @author Beatriz Miranda
 */
public class Saude {

	/**
	 * Saude mental do aluno.
	 * É uma String que pode ser "boa" ou "fraca"
	 */
	private String saudeMental;
	
	/**
	 * Saude fisica do aluno.
	 * É uma String que pode ser "boa" ou "fraca"
	 */
	private String saudeFisica;
	
	/**
	 * Constrói a saúde do aluno.
	 * A saude de todo aluno começa com os campos de saudeMental e saudeFisica como "boa"
	 */
	public Saude() {
		this.saudeMental = "boa";
		this.saudeFisica = "boa";
	}
	
	/**
	 * Atribui um valor a saude mental do aluno.
	 * Pode ser "boa" ou "fraca".
	 * 
	 * @param valor: saude mental do aluno
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
	}
	
	/**
	 * Atribui um valor a saude física do aluno.
	 * Pode ser "boa" ou "fraca".
	 * 
	 * @param valor: saude física do aluno
	 */
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
	}
	
	/**
	 * Retorna o status geral do aluno, como está sua saude geral baseado na saude fisica e mental.
	 * Se tiver a saude mental "boa" e a saude fisica "boa", seu status geral será "boa"
	 * Se tiver a saude mental "fraca" e a saude fisica "fraca", seu status geral será "fraca"
	 * Se tiver a saude mental "boa" e a saude fisica "fraca" ou
	 * saude mental "fraca" e saude fisica "boa", seu status geral será "ok"
	 * 
	 * @return a representação em String do status gerak da saude do aluno
	 */
	public String getStatusGeral() {
		if (this.saudeMental.equals("boa") && this.saudeFisica.equals("boa")) {
			return "boa";
		} else if(this.saudeMental.equals("fraca") && this.saudeFisica.equals("fraca")) {
			return "fraca";
		} else {
			return "ok";
		}
	}
}
