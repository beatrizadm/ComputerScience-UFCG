package utilidades;

import conta.Compra;
import java.util.Comparator;

public class ComparatorFornecedor implements Comparator<Compra>{

	@Override
	public int compare(Compra o1, Compra o2) {
		if(o1.getFornecedor().compareTo(o2.getFornecedor()) != 0) {
			return o1.getFornecedor().compareTo(o2.getFornecedor());
		}
		
		if((o1.getCliente()+o1.getDescricaoProduto()).compareTo(o2.getCliente()+o2.getDescricaoProduto()) != 0) {
			return (o1.getCliente()+o1.getDescricaoProduto()).compareTo(o2.getCliente()+o2.getDescricaoProduto());
		}
		
		String[] data1 = o1.getData().split("/");
		String[] data2 = o2.getData().split("/");

		if (Integer.valueOf(data1[2]) > Integer.valueOf(data2[2])) {
			return 1;
		}
		
		if (Integer.valueOf(data1[2]) < Integer.valueOf(data2[2])) {
			return -1;
		}

		if (Integer.valueOf(data1[1]) > Integer.valueOf(data2[1])) {
			return 1;
		}
		
		if (Integer.valueOf(data1[1]) < Integer.valueOf(data2[1])) {
			return -1;
		}

		if (Integer.valueOf(data1[0]) > Integer.valueOf(data2[0])) {
			return 1;
		}

		if (Integer.valueOf(data1[0]) < Integer.valueOf(data2[0])) {
			return -1;
		}
		
		return 0;
		
	}

}
