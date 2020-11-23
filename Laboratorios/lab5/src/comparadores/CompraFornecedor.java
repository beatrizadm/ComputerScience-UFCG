package comparadores;

import java.util.Comparator;

import entidades.Compra;

/**
* Representacao de um ordenador de compras utilizando o fornecedor como criterio.
* 
* @author Beatriz Miranda - 119210170
*
*/
public class CompraFornecedor implements Comparator<Compra> {
	
	/**
	 * Metodo que faz a comparacao entre duas contas utilizando o fornecedor como
	 * criterio de ordenacao.
	 */
	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getFornecedor().equals(o2.getFornecedor())) {
			String retorno1 = o1.getCliente() + ", " + o1.getDescricaoProduto() + ", " + o1.getData();
			String retorno2 = o2.getCliente() + ", " + o2.getDescricaoProduto() + ", " + o2.getData();
			return retorno1.compareTo(retorno2);
		}
		return o1.getFornecedor().compareTo(o2.getFornecedor());
	}
}
