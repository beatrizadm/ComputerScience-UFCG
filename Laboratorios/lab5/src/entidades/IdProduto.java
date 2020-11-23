package entidades;

/**
 * Representacao do Id de um Produto. Todo Id precisa ter nome e descricao do produto.
 * 
 * @author Beatriz Miranda - 119210170
 *
 */
public class IdProduto {
	/** nome do produto **/
	private String nome;
	/** descricao do produto **/
	private String descricao;
	
	/**
	 * Constroi o IdProduto
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 */
	public IdProduto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	/**
	 *  Retorna um inteiro que representa um IdProduto.
	 *  @return um inteiro que representa um IdProduto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Metodo que verifica a se dois IdProduto sao iguais. Retorna um valor
	 * booleano verdade caso sejam iguais, caso contrario retorna falso. Para dois
	 * IdProdutos serem iguais eles devem possuir o mesmo nome e descricao.
	 * @return Retorna um valor booleano verdade caso os IdProdutos sejam iguais,
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
		IdProduto other = (IdProduto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}	
}
