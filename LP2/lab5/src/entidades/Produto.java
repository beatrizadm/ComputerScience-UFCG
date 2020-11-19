package entidades;

/**
 * Representacao de um Produto. Todo Produto precisa ter nome, preco e descricao.
 * 
 * @author Beatriz Miranda - 119210170
 *
 */
public class Produto implements Comparable<Object> {
	/** nome do produto **/
	private String nome;
	/** preco do produto **/
	private double preco;
	/** descricao do produto **/
	private String descricao;
	
	/**
	 * Constroi um produto
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @param preco: preco do produto
	 */
	public Produto(String nome, String descricao, double preco) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}
	
	/**
	 * Metodo que edita o preco do produto
	 * @param novoPreco: novo preco do produto
	 */
	public void editaPreco(double novoPreco) {
		this.preco = novoPreco;
	}
	
	/**
	 * Metodo da interface comparable de produto 
	 * @param o um produto que vai ser comparado com o produto atual.
	 */
	public int compareTo(Object obj) {
		Produto pr = (Produto) obj;
		return nome.compareTo(pr.nome);
    }
	
	/**
	 * Representacao em String de um produto
	 */
	@Override
	public String toString() {
		String valor = Double.toString(this.preco);
		valor = valor.replace(".", ",");
		return this.nome + " - " + this.descricao + " - R$" + valor + "0";
	}
	
	/**
	 * Metodo que retorna um double que representa o preco do produto.
	 * @return preco do produto
	 */
	public double getPreco() {
		return this.preco;
	}

	/**
	 *  Retorna um inteiro que representa um Produto.
	 *  @return um inteiro que representa um Produto.
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
	 * Metodo que verifica a se dois Produto sao iguais. Retorna um valor
	 * booleano verdade caso sejam iguais, caso contrario retorna falso. Para dois
	 * Produtos serem iguais eles devem possuir o mesmo nome e descricao.
	 * @return Retorna um valor booleano verdade caso os Produtos sejam iguais,
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
		Produto other = (Produto) obj;
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
