package comparadores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import entidades.Compra;

/**
* Representacao de um ordenador de compras utilizando a data como criterio.
* 
* @author Beatriz Miranda - 119210170
*
*/
public class CompraData implements Comparator<Compra> {
	
	/** primeira data **/
	private Date data1;
	/** segunda data **/
	private Date data2;
	/** primeira data formatada **/
	private SimpleDateFormat sdf1 = new SimpleDateFormat("dd/mm/yyyy");
	/** segunda data formatada **/
	private SimpleDateFormat sdf2 = new SimpleDateFormat("dd/mm/yyyy");
	
	/**
	 * Metodo que faz a comparacao entre duas contas utilizando a data como criterio
	 * de ordenacao.
	 */
	@Override
	public int compare(Compra o1, Compra o2) {
		try {
			this.data1 = this.sdf1.parse(o1.getData());
			this.data2 = this.sdf2.parse(o2.getData());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if (this.data1.equals(this.data2)) {
			String s1 = o1.getCliente() + " " + o1.getFornecedor() + " " + o1.getDescricaoProduto();
			String s2 = o2.getCliente() + " " + o2.getFornecedor() + " " + o2.getDescricaoProduto();
			return s1.compareTo(s2);
		}
		
		return this.data1.compareTo(this.data2);
	}	
}
