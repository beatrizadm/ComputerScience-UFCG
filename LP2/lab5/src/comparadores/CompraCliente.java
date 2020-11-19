package comparadores;

import java.util.Comparator;

import entidades.Compra;

/**
 * Representacao de um ordenador de compras utilizando o cliente como criterio.
 * 
 * @author Beatriz Miranda - 119210170
 *
 */
public class CompraCliente implements Comparator<Compra> {
	
	/**
	 * Metodo que faz a comparacao entre duas contas utilizando o cliente como
	 * criterio de ordenacao.
	 */
	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getCliente().equals(o2.getCliente())) {
			String retorno1 = o1.getFornecedor() + ", " + o1.getDescricaoProduto() + ", " + o1.getData();
			String retorno2 = o2.getFornecedor() + ", " + o2.getDescricaoProduto() + ", " + o2.getData();
			return retorno1.compareTo(retorno2);
		}
		return o1.getCliente().compareTo(o2.getCliente());
	}
}
