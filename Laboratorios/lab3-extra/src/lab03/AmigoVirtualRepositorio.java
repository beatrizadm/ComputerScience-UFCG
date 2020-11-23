package lab03;

public class AmigoVirtualRepositorio {
	
	//atributos
	public AmigoVirtual arrayAmigos[];
	
	//constructor
	public AmigoVirtualRepositorio() {this.arrayAmigos = new AmigoVirtual[1000];}
	
	//metodos
	/**
	 * Realiza o cadastro de um novo amigo
	 * @param posicao
	 * @param nome
	 * @param id
	 * @param anotacoes
	 * @return true caso consiga cadastrar e false caso nao consiga cadastrar
	 */
	public boolean cadastrar(int posicao, String nome, String id, String anotacoes) {
		if (posicao < 0 || posicao > 999) {return false;} 
		
		arrayAmigos[posicao] = new AmigoVirtual(posicao, nome, id, anotacoes);
		return true;
	}
	
	/**
	 * Realiza o cadastro de um novo amigo, sem anotacoes
	 * @param posicao
	 * @param nome
	 * @param id
	 * @return true caso consiga cadastrar e false caso nao consiga cadastrar
	 */
	public boolean cadastrar(int posicao, String nome, String id) {
		if (posicao < 0 || posicao > 999) {return false;}
		
		arrayAmigos[posicao] = new AmigoVirtual(posicao, nome, id, "");
		return true;
	}
	
	/**
	 * Busca um objeto no array, pela posicao
	 * @param posicao
	 * @return o objeto (se ele existir), caso contrario retorna null
	 */
	public AmigoVirtual pegar(int posicao) {
		
		if (arrayAmigos[posicao] != null) {
			return arrayAmigos[posicao];
		}
		return null;
	}
	
	/**
	 * Procura no array verificando se o nome e id de cada objeto correspondem aos recebidos como parametro.
	 * Para isso, é chamado o metodo procurar da classe AmigoVirtual que trabalha com os objetos.
	 * @param nome
	 * @param id
	 * @return uma string formatada com todos os objetos correspondentes, 
	 * caso contrario retorna uma string vazia
	 */
	public String procurar(String nome, String id) {
		String formatada = "";
		for (AmigoVirtual objeto : arrayAmigos) {
			
			if (objeto == null) {continue;}
			
			String linha = objeto.procurarAV(nome, id);
			
			if (! linha.equals("")) {formatada += linha + "\n";}
		}
		return formatada;
	}
	
	/**
	 * Verifica no array se existe um objeto igual a outro (sera igual se tiver mesmo nome e id)
	 * @return uma string formatada com todos os objetos correspondentes, 
	 * caso contrario retorna uma string vazia
	 */
	public String verificar() {
		
		String linhas = "";
		
		for (AmigoVirtual objeto : arrayAmigos) {
			
			if (objeto == null) {continue;}
			
			String duplicata = "";
			
			for(int i = objeto.getPosicaoAV() + 1; i <= 999; i++) {
				
				AmigoVirtual objeto2 = arrayAmigos[i];
			
				if (objeto2 == null) {continue;}
				
				if (objeto.getIdAV().equals(objeto2.getIdAV()) && objeto.getNomeAV().equals(objeto2.getNomeAV())) {
					duplicata += objeto2.getPosicaoAV() + ", ";
				}
			}
			
			if (! duplicata.equals("")) {
				
				String li = objeto.getPosicaoAV() + " -- " + objeto.getNomeAV()  + " -- " + objeto.getIdAV() + "\n" + "Duplicatas: " + duplicata;
				
				String retorno = li.substring(0, li.length() - 2);
				
				linhas += retorno + "\n\n";
			}
		}
		
		if (linhas.equals("")) { return ""; }
		
		String formatada = linhas.substring(0, linhas.length() - 1);
		return formatada;
	}
}