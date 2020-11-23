package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Representacao de uma conta. Toda conta precisa ter o cpf do cliente que comprou.
 * 
 * @author Beatriz Miranda - 119210170
 *
 */
public class Conta {
	
	/** cpf do cliente **/
	public String cpfCliente;
	
	/** lista de compras do cliente **/
	private List<Compra> compras;
	
	/**
	 * Constroi a conta
	 * @param cpfCliente: cpf do cliente
	 */
	public Conta(String cpfCliente) {
		this.cpfCliente = cpfCliente;
		this.compras = new ArrayList<Compra>();
	}
	
	/**
	 * Metodo que adiciona a compra na lista de compras.
	 * @param nomeCliente: nome do cliente
	 * @param cpfCliente: cpf do cliente
	 * @param fornecedor: nome do fornecedor
	 * @param nomeProduto: nome do produto
	 * @param descricaoProduto: descricao do produto
	 * @param data: data da compra
	 * @param preco: preco da compra
	 */
	public void adicionaCompra(String nomeCliente, String cpfCliente, String fornecedor, String nomeProduto, String descricaoProduto, String data,
			double preco) {
		compras.add(new Compra(nomeCliente, fornecedor, nomeProduto, descricaoProduto, data, preco));
	}
	
	/**
	 * Metodo que retorna o debito do cliente
	 * @return double com o debito do cliente
	 */
	public String exibeDebito() {
		double debito = 0;
		for (Compra compra : compras) {
			debito += compra.getPrecoProduto();
		}
		return String.format("%.2f", debito).replace(",", ".");
	}
	
	/**
	 * Representacao textual da conta
	 * @param fornecedor
	 * @return string com a representacao textual da conta
	 */
	public String toString(String fornecedor) {
		String retorno = fornecedor + " | ";
		List<String> stringCompras = new ArrayList<String>();
		for (int i = 0; i < compras.size(); i++) {
			stringCompras.add(compras.get(i).toString());
		}
		retorno += String.join(" | ", stringCompras);
		return retorno;
	}
	
	/**
	 * Metodo que retorna a quantidade de compras
	 * @return quantidade de compras
	 */
	public int getQtdCompras() {
		return this.compras.size();
	}

	/**
	 * Metodo que retorna a lista com as compras
	 * @return lista com as compras
	 */
	public List<Compra> getCompras() {
		return this.compras;
	}

	/**
	 * Retorna um inteiro que representa uma conta.
	 * @return um inteiro que representa uma conta.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfCliente == null) ? 0 : cpfCliente.hashCode());
		return result;
	}

	/**
	 * Metodo que verifica a se duas contas sao iguais. Retorna um valor
	 * booleano verdade caso sejam iguais, caso contrario retorna falso. Para duas
	 * contas serem iguais elas devem possuir o mesmo cpf.
	 * @return Retorna um valor booleano verdade caso as contas sejam iguais,
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
		Conta other = (Conta) obj;
		if (cpfCliente == null) {
			if (other.cpfCliente != null)
				return false;
		} else if (!cpfCliente.equals(other.cpfCliente))
			return false;
		return true;
	}
	
}
