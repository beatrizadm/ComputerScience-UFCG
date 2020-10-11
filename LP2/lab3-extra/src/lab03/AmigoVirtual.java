package lab03;

public class AmigoVirtual {
	
	//atributos
	public AmigoVirtual arrayAmigos[];
	private int posicaoAV;
	private String nomeAV;
	private String idAV;
	private String anotacoesAV;
	
	//constructor
	public AmigoVirtual(int posicao, String nome, String id, String anotacoes) {
		this.posicaoAV = posicao;
		this.nomeAV = nome;
		this.idAV = id;
		this.anotacoesAV = anotacoes;
		this.arrayAmigos = new AmigoVirtual[1000];
	}
	
	//metodos
	@Override
	public String toString() {
		if (! anotacoesAV.equals("")) {
			return "\n" + posicaoAV + " -- " + nomeAV + " -- " + idAV + "\nAnotacoes: " + anotacoesAV + "\n";
		} return "\n" + posicaoAV + " -- " + nomeAV + " -- " + idAV + "\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		AmigoVirtual outroAmigo = (AmigoVirtual) obj;
		if (this.posicaoAV == outroAmigo.posicaoAV && this.nomeAV.equals(outroAmigo.nomeAV) && this.idAV.equals(outroAmigo.idAV) && this.anotacoesAV.equals(outroAmigo.anotacoesAV)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Verifica se o nome e id do objeto correspondem aos recebidos como parametro
	 * @param nome
	 * @param id
	 * @return uma string no formato "id -- nome -- anotacoes" se houver correspondencia, 
	 * caso contrario retorna uma string vazia
	 */
	public String procurarAV(String nome, String id) {
		
		String result = "";
		boolean entra = false;
		
		if (nome.equals("") && id.equals("")) {entra = true;}
			
		if (nome.equals("") && !id.equals("")) { 
			if (idAV.contains(id)) {entra = true;}}
		
		else if (!nome.equals("") && id.equals("")) {
			if (nomeAV.contains(nome)) {entra = true;}}

		else if (idAV.contains(id) && nomeAV.contains(nome)) {entra = true;}

		if (entra) {result = idAV + " -- " + nomeAV + " -- " + anotacoesAV;} 
		
		return result;
	}
		
	//getters
	public int getPosicaoAV() {
		return posicaoAV;
	}
	public String getNomeAV() {
		return nomeAV;
	}
	public String getIdAV() {
		return idAV;
	}
}