package conta;

import java.util.ArrayList;

/**
 * 
 * Classe que representa uma conta que um cliente tem para um dado fornecedor
 * 
 * @author Aluno de período anterior
 *
 */
public class Conta {

	/**
	 * Fornecedor detentor da conta
	 */
	private String fornecedor;

	/**
	 * Compra realizadas nessa conta
	 */
	private ArrayList<Compra> compras;

	/**
	 * Constrói uma conta dado o nome do fornecedor do qual pertence a conta
	 * 
	 * @param fornecedor Fornecedor detentor da conta
	 */
	public Conta(String fornecedor) {
		this.fornecedor = fornecedor;

		this.compras = new ArrayList<Compra>();
	}

	/**
	 * Retorna a representação String da conta, com todas as compras listadas na
	 * ordem em que foram realizadas
	 */
	@Override
	public String toString() {
		String retorno = this.getFornecedor();

		for (int i = 0; i < this.compras.size(); i++) {
			retorno += " | " + this.compras.get(i).toString();
		}

		return retorno;
	}

	/**
	 * Compara duas contas pelo nome do fornecedor
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Conta) {
			Conta c = (Conta) o;

			if (this.getFornecedor().equals(c.getFornecedor())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Gera o hashCOde da conta baseado no nome do fornecedor
	 */
	@Override
	public int hashCode() {
		return this.getFornecedor().hashCode();
	}

	/**
	 * 
	 * @return Retorna o noem do fornecedor a quem a conta se refere
	 */
	private String getFornecedor() {
		return this.fornecedor;
	}

	/**
	 * Adiciona uma compra na conta, dado o nome do fornecedor, nome do cliente,
	 * data da compra, nome, descricao e preco do produto comrpado
	 * 
	 * @param fornecedor       Nome do fornecedor do qual se realizou a compra
	 * @param cliente          Nome do cliente que realizou a compra
	 * @param data             Data da compra
	 * @param nomeProduto      Nome do produto comprado
	 * @param descricaoProduto Descricao do produto comprado
	 * @param preco            Preco do produto comprado
	 */
	public void adicionaCompra(String fornecedor, String cliente, String data, String nomeProduto,
			String descricaoProduto, double preco) {

		this.compras.add(new Compra(fornecedor, cliente, data, nomeProduto, descricaoProduto, preco));
	}

	/**
	 * Retorna o valor total da conta, somando o preco de todas as compras
	 * realizadas nela
	 * 
	 * @return Double, que é o valor total da soma das compras realizadas na conta
	 */
	public double totalizaConta() {
		double total = 0;

		for (int i = 0; i < this.compras.size(); i++) {
			total += this.compras.get(i).getPreco();
		}

		return total;
	}

	/**
	 * Retorna um ArrayList de todas as compras realizadas na conta
	 * 
	 * @return ArrayList de todas as compras realizadas na conta
	 */
	public ArrayList<Compra> getCompras() {
		return this.compras;
	}
}
