package conta;

/**
 * Classe que representa uma compra de um produto realizada por um cliente em um
 * dado fornecedor.
 * 
 * @author Aluno de período anterior
 *
 */
public class Compra {
	/**
	 * Data que a compra foi realizada
	 */
	private String data;

	/**
	 * Fornecedor de quem foi comprado o produto
	 */
	private String fornecedor;

	/**
	 * Cliente que realizou a compra
	 */
	private String cliente;

	/**
	 * Nome do produto comprado
	 */
	private String nomeProduto;

	/**
	 * Descrição do produto comprado
	 */
	private String descricaoProduto;

	/**
	 * Preço do produto comprado
	 */
	private double preco;

	/**
	 * Contrói uma compra dado o nome do fornecedor, nome do cliente, data da
	 * compra, nome, descricao e preco do produto
	 * 
	 * @param fornecedor       Fornecedor de quem se comprou o produto
	 * @param cliente          Cliente que realizou a compra
	 * @param data             Data da compra
	 * @param nomeProduto      Nome do produto comprado
	 * @param descricaoProduto Descricao do produto comprado
	 * @param preco            Preco do produto comprado
	 */
	public Compra(String fornecedor, String cliente, String data, String nomeProduto, String descricaoProduto,
			double preco) {
		this.fornecedor = fornecedor;
		this.cliente = cliente;
		this.data = data;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.preco = preco;
	}

	/**
	 * Retorna a representação textual de uma compra com "Nome do produto" - "Data
	 * da compra"
	 */
	@Override
	public String toString() {
		String[] data = this.getData().split("/");

		return this.getNomeProduto() + " - " + data[0] + "-" + data[1] + "-" + data[2];
	}

	/**
	 * Compara duas compras pelo nome do produto, descricao do produto, nome do
	 * fornecedor, nome do cliente e data da compra.
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Compra) {
			Compra c = (Compra) o;

			if ((this.getNomeProduto() + this.getDescricaoProduto() + this.getCliente() + this.getFornecedor()
					+ this.getData())
							.equals(c.getNomeProduto() + c.getDescricaoProduto() + c.getCliente() + c.getFornecedor()
									+ c.getData())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gera o hashCode pelo nome do produto, descricao do produto, nome do
	 * fornecedor, nome do cliente e data da compra.
	 */
	@Override
	public int hashCode() {
		return (this.getNomeProduto() + this.getDescricaoProduto() + this.getCliente() + this.getFornecedor()
				+ this.getData()).hashCode();
	}

	/**
	 * 
	 * @return Descricao do produto que foi comprado
	 */
	public String getDescricaoProduto() {
		return this.descricaoProduto;
	}

	/**
	 * 
	 * @return Nome do produto que foi comprado
	 */
	private String getNomeProduto() {
		return this.nomeProduto;
	}

	/**
	 * 
	 * @return Data que foi realizada a compra
	 */
	public String getData() {
		return this.data;
	}

	/**
	 * 
	 * @return Preco do produto que foi comprado
	 */
	public double getPreco() {
		return this.preco;
	}

	/**
	 * 
	 * @return Nome do cliente que realizou a compra
	 */
	public String getCliente() {
		return this.cliente;
	}

	/**
	 * 
	 * @return Nome do fornecedor do qual foi realizada a compra
	 */
	public String getFornecedor() {
		return this.fornecedor;
	}

}
