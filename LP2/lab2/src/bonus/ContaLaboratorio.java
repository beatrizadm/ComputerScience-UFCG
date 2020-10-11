package bonus;

/**
 * Representação da conta do aluno no laboratorio, cada laboratorio deve ter nome, nota e espaco ocupado.
 * 
 * @author Beatriz Miranda
 *
 */
public class ContaLaboratorio {
	
	/**
	 * Nome do laboratorio
	 */
	private String nomeLaboratorio;
	
	/**
	 * Cota disponivel no do sistema de armazenamento do laboraorio
	 */
	private int cota;
	
	/**
	 * Espaco utilizado do sistema de armazenamento do laboratorio
	 */
	private int espacoUtilizado;
	
	
	
	/**
	 * Constrói a conta do laboratório. Toda conta tem nome e começa com 2000 de cota
	 * 
	 * @param nomeLaboratorio: nome do laboratorio
	 */
	public ContaLaboratorio(String nomeLaboratorio){
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = 2000;
	}
	
	/**
	 * Constrói a conta do laboratório a partir do nome e da cota do sistema de armazenamento
	 * 
	 * @param nomeLaboratorio: nome do laboratorio
	 * @param cota: cota disponivel no laboratorio
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
	}
	
	/**
	 * Consome espaco do sistema de armazenamento
	 * 
	 * @param mbytes: quantidade de espaco
	 */
	public void consomeEspaco(int mbytes) {
		this.espacoUtilizado += mbytes;
	}
	
	/**
	 * Libera espaco do sistema de armazenamento
	 * 
	 * @param mbytes: quantidade de espaco
	 */
	public void liberaEspaco(int mbytes) {
		this.espacoUtilizado -= mbytes;
	}
	
	/**
	 * Retorna se o aluno atingiu a cota do sistema de armazenamento do laboratorio
	 * 
	 * @return true(se atingiu a cota) ou false(se nao atingiu a cota)
	 */
	public boolean atingiuCota() {
		if (this.espacoUtilizado >= this.cota) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna a String que representa a Conta do aluno no laboratorio.
	 * A representação segue o formato "nome_laboratorio espaco_utilizado cota"
	 * 
	 * @return a representação em String da conta do aluno no laboratorio
	 */
	@Override 
	public String toString() {
		return this.nomeLaboratorio + " " + this.espacoUtilizado + "/" + this.cota;
	}
}