package entidades;

/**
 * Representacao de um cliente. Todo cliente precisa ter um nome, email e localizacao.
 * 
 * @author Beatriz Miranda - 119210170
 *
 */
public class Cliente{
	
	/** nome do cliente **/
	private String nome;
	
	/** email do cliente **/
	private String email;
	
	/** localizacao do cliente **/
	private String localizacao;
	
	/**
	 * Constroi um cliente.
	 * @param nome: nome do cliente
	 * @param email: email do cliente
	 * @param localizacao: localizacao do cliente
	 */
	public Cliente(String nome, String email, String localizacao) {
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}
	
	/**
	 * Edita o nome, email ou localizacao do cliente.
	 * @param atributo: atributo a ser editado
	 * @param novoValor: novo atributo que sera atribuido
	 */
	public void edita(String atributo, String novoValor) {
		if (atributo.equals("nome")) {
			this.nome = novoValor;
		} else if (atributo.equals("email")) {
			this.email = novoValor;
		} else if (atributo.equals("localizacao")) {
			this.localizacao = novoValor;
		}	
	}
	
	/**
	 * Metodo da interface comparable que é utilizado na ordenacao de clientes e
	 * utiliza o nome, email e localizacao do cliente.
	 * @param obj: um cliente que vai ser comparado com o cliente atual.
	 * @return 1 se for igual e 0 se for diferente
	 */
	public int compareTo(Cliente obj) {
        if (nome.equals(obj.nome) && email.equals(obj.email) && localizacao.equals(obj.localizacao)) {
            return 1;
        } 
        return 0;
    }
	
	/**
	 * Metodo que retorna a string que representa o nome do cliente.
	 * @return nome do cliente
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Representacao textual de um cliente
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

	/**
	 * Retorna um inteiro que representa um cliente.
	 * @return um inteiro que representa um cliente.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((localizacao == null) ? 0 : localizacao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Metodo que verifica a se dois clientes sao iguais. Retorna um valor
	 * booleano verdade caso sejam iguais, caso contrario retorna falso. Para dois
	 * clientes serem iguais eles devem possuir o mesmo nome, email e localizacao.
	 * @return Retorna um valor booleano verdade caso os clientes sejam iguais,
	 *         caso contrario retorna falso.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (localizacao == null) {
			if (other.localizacao != null)
				return false;
		} else if (!localizacao.equals(other.localizacao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
