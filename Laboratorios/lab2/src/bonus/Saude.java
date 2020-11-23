package bonus;

/**
 * Representa��o da saude do aluno, a saude deve ser analisada fisica e mentalmente.
 * 
 * @author Beatriz Miranda
 */
public class Saude {

	/**
	 * Saude mental do aluno.
	 * � uma String que pode ser "boa" ou "fraca"
	 */
	private String saudeMental;
	
	/**
	 * Saude fisica do aluno.
	 * � uma String que pode ser "boa" ou "fraca"
	 */
	private String saudeFisica;
	
	/**
	 * Emoji que descreve a �ltima sensa��o em geral do aluno, 
	 * n�o tem rela��o direta com sua saude geral do aluno
	 */
	private String emoji;
	
	/**
	 * Constr�i a sa�de do aluno.
	 * A saude de todo aluno come�a com os campos de saudeMental e saudeFisica como "boa"
	 */
	public Saude() {
		saudeMental = "boa";
		saudeFisica = "boa";
		emoji = "";
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
	 * Atribui um valor a saude f�sica do aluno.
	 * Pode ser "boa" ou "fraca".
	 * 
	 * @param valor: saude f�sica do aluno
	 */
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
	}
	
	/**
	 * Atribui um valor ao emoji, que descreve a �ltima sensa��o em geral do aluno
	 * 
	 * @param valor: emoji
	 */
	public void definirEmoji(String valor) {
		this.emoji = valor;
	}

	/**
	 * Retorna o status geral do aluno, como est� sua saude geral baseado na saude fisica e mental.
	 * Se tiver a saude mental "boa" e a saude fisica "boa", seu status geral ser� "boa"
	 * Se tiver a saude mental "fraca" e a saude fisica "fraca", seu status geral ser� "fraca"
	 * Se tiver a saude mental "boa" e a saude fisica "fraca" ou
	 * saude mental "fraca" e saude fisica "boa", seu status geral ser� "ok".
	 * Al�m de adicionar um emoji(caso o aluno tenha definido um) do lado do status geral
	 * 
	 * @return a representa��o em String do status gerak da saude do aluno
	 */
	public String getStatusGeral() {
		String saude = "";
		if (this.saudeMental.equals("boa") && this.saudeFisica.equals("boa")) {
			saude = "boa";
		} else if(this.saudeMental.equals("fraca") && this.saudeFisica.equals("fraca")) {
			saude = "fraca";
		} else {
			saude = "ok";
		}
		if (!this.emoji.equals("")) {
			return saude + " " + emoji;
		} else {
			return saude;
		}
	}
	
}
