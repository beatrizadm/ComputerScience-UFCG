package prova1;

//Deliveries of the day
public class DoD {
	
	//atributos
	private Delivery clientes[] = new Delivery[50];
	private int entregador = 6; //entregas por dia
	private int entregas;
	
	//constructors
	public DoD(Delivery clientes) {
		entregas = 0;
	}
	
	public DoD(Delivery clientes, int entregador) {
		entregas = 0;
		this.entregador = entregador;
	}
	
	//metodos
	public boolean addDelivery(Delivery d1) {
		if (entregas + 1 <= entregador) {
			//tem mais uma condicao
			entregas ++;
			d1.setStatus("ongoing");
			return true;
		}
		return false;
	}
	
	public String listDoD() {
		for (Delivery pedidos : clientes) {
			if (pedidos != null) {
				return pedidos.toString() + "\n";
			}
		}
		return "";
	}
	
	public boolean finishDelivery(int pos) {
		if (clientes[pos] != null && !clientes[pos].equals("finished")) {
			clientes[pos].setStatus("finished");
			return true;
		}
		return false;
	}

	public String listFinished() {
		
		String formatada = "";
		for (Delivery pedidos : clientes) {
			if (pedidos.getStatus().equals("finished")) {
				formatada += pedidos.toString() + "\n";
			}
		}
		return formatada;
	}
}
