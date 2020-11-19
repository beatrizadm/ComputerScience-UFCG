package entidades;

/**
 * Representacao de uma compra. Toda compra precisa ter um nome do cliente, 
 * nome do fornecedor, data da compra, nome, descricao e preco do produto.
 * 
 * @author Beatriz Miranda - 119210170
 *
 */
public class Compra {

	/** nome do cliente **/
	private String nomeCliente;
	
	/** nome do cliente **/
	private String fornecedor;
	
	/** nome do cliente **/
	private String data;
	
	/** nome do cliente **/
	private String nomeProduto;
	
	/** nome do cliente **/
	private String descricaoProduto;
	
	/** nome do cliente **/
	private double precoProduto;
	
	/**
	 * Constroi uma compra
	 * @param nomeCliente: nome do cliente
	 * @param fornecedor: nome do fornecedor
	 * @param nomeProduto: nome do produto
	 * @param descricaoProduto: descricao do produto
	 * @param data: data da compra
	 * @param precoProduto: preco do produto
	 */
	public Compra(String nomeCliente, String fornecedor, String nomeProduto, String descricaoProduto, String data, double precoProduto) {
		this.nomeCliente = nomeCliente;
		this.fornecedor = fornecedor;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.precoProduto = precoProduto;
		this.data = data;
		
	}

	/**
	 * Representacao textual de uma compra.
	 */
	@Override
	public String toString() {
		return this.nomeProduto + " - " + this.data.replace("/", "-");
	}
	
	/**
	 * Metodo que exibe a ordenacao por cliente
	 * @return String com a odenacao por cliente
	 */
	public String exibeOrdenaCliente() {
		return this.nomeCliente + ", " + this.fornecedor + ", " + this.descricaoProduto + ", " + this.data;
	}

	/**
	 * Metodo que exibe a ordenacao por fornecedor
	 * @return String com a odenacao por fornecedor
	 */
	public String exibeOrdenaFornecedor() {
		return this.fornecedor + ", " + this.nomeCliente + ", " + this.descricaoProduto + ", " + this.data;
	}

	/**
	 * Metodo que exibe a ordenacao por data
	 * @return String com a odenacao por data
	 */
	public String exibeOrdenaData() {
		return this.data + ", " + this.nomeCliente + ", " + this.fornecedor + ", " + this.descricaoProduto;
	}
	
	/**
	 * Metodo que retorna o double que representa o preco do produto.
	 * @return representacao em double do preco do produto.
	 */
	public Double getPrecoProduto() {
		return this.precoProduto;
	}

	/**
	 * Metodo que retorna a string que representa o nome do cliente.
	 * @return a string que representa o nome do cliente.
	 */
	public String getCliente() {
		return this.nomeCliente;
	}

	/**
	 * Metodo que retorna a string que representa o nome do fornecedor.
	 * @return a string que representa o nome do fornecedor.
	 */
	public String getFornecedor() {
		return this.fornecedor;
	}

	/**
	 * Metodo que retorna a string que representa a data.
	 * @return a string que representa a data.
	 */
	public String getData() {
		return this.data;
	}

	/**
	 * Metodo que retorna a string que representa o nome do cliente.
	 * @return a string que representa o nome do cliente.
	 */
	public String getDescricaoProduto() {
		return this.descricaoProduto;
	}

	/**
	 * Retorna um inteiro que representa uma compra.
	 * @return um inteiro que representa uma compra.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricaoProduto == null) ? 0 : descricaoProduto.hashCode());
		result = prime * result + ((nomeProduto == null) ? 0 : nomeProduto.hashCode());
		return result;
	}

	/**
	 * Metodo que verifica a se duas compras sao iguais. Retorna um valor
	 * booleano verdade caso sejam iguais, caso contrario retorna falso. Para duas
	 * compras serem iguais elas devem possuir o mesmo nome, descricao e data.
	 * @return Retorna um valor booleano verdade caso as compras sejam iguais,
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
		Compra other = (Compra) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricaoProduto == null) {
			if (other.descricaoProduto != null)
				return false;
		} else if (!descricaoProduto.equals(other.descricaoProduto))
			return false;
		if (nomeProduto == null) {
			if (other.nomeProduto != null)
				return false;
		} else if (!nomeProduto.equals(other.nomeProduto))
			return false;
		return true;
	}	
}
