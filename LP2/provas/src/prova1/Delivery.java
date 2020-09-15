package prova1;

public class Delivery {
	//atributos
    private String produto;
	private String fornecedor;
	private String idCliente;
	private String status;
	private Delivery pedidos[];
	
	//constructor
	public Delivery() {
		status = "ready";
		pedidos = new Delivery[1000];
	}
	
	@Override
	public String toString() {
		return "Delivery [idCliente= "+ this.idCliente +
				", pedido= " + this.pedidos +
				", fornecedor = " + this.fornecedor +
				", status=" + this.status + "]";
	}
	
	public void criarEntrega() {
		this.status = "ready";
	}
	
	public void listaEntrega() {
		this.status = "ongoing";
	}
	
	public void entregaRealizada() {
		this.status = "finished";
	}
	
	public boolean verificarIgualdade(Delivery d1, Delivery d2) {
		if (d1.fornecedor.equals(d2.fornecedor) && d1.idCliente.equals(d2.idCliente) && d1.produto.equals(d2.produto)) {
			return true;
		} return false;
	}
	
	
	//getters e setters
	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Delivery[] getPedidos() {
		return pedidos;
	}

	public void setPedidos(Delivery[] pedidos) {
		this.pedidos = pedidos;
	}
	
}
