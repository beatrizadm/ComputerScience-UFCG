package controles;

import validacao.ValidaCompra;
import validacao.ValidaOrdenacao;

/**
 * Representacao do controle do sistema.
 * 
 * @author Beatriz Miranda - 119210170
 *
 */
public class ControleSistema {
	
	/* controle do fonrecedor */
	private ControleFornecedor controleFornecedor;
	
	/* controle do cliente */
	private ControleCliente controleCliente;
	
	/**
	 * Constroi o controle do sistema
	 */
	public ControleSistema() {
		controleFornecedor = new ControleFornecedor();
		controleCliente = new ControleCliente();
	}
	
	/**
	 * Metodo que adiciona um cliente no sistema
	 * @param cpf: cpf do cliente
	 * @param nome: nome do cliente
	 * @param email: email do cliente
	 * @param localizacao: localizacao do cliente
	 * @return a String do cpf do cliente
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return controleCliente.cadastraCliente(cpf, nome, email, localizacao);
	}
	
	/**
	 * Metodo que retorna um cliente a partir do seu cpf
	 * @param cpf: cpf do cliente
	 * @return a String do cliente
	 */
	public String exibeCliente(String cpf) {
		return controleCliente.exibeCliente(cpf);
	}
	
	/**
	 * Metodo que edita o cliente
	 * @param cpf: cpf do cliente
	 * @param atributo: nome do atributo que sera editado 
	 * @param novoValor: novo valor que sera atribuido ao atributo
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		controleCliente.editaCliente(cpf, atributo, novoValor);
	}
	
	/**
	 * Metodo que remove o cliente
	 * @param cpf: cpf do cliente
	 */
	public void removeCliente(String cpf) {
		controleCliente.removeCliente(cpf);
	}
	
	/**
	 * Metodo que adiciona um fornecedor no sistema
	 * @param nome: nome do fornecedor
	 * @param email: email do fornecedor
	 * @param telefone: telefone do fornecedor
	 * @return nome do fornecedor
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return controleFornecedor.cadastraFornecedor(nome, email, telefone);
	}
	
	/**
	 * Metodo que retorna um fornecedor a partir do seu nome
	 * @param nome: nome do fornecedor
	 * @return a String do fornecedor
	 */
	public String exibeFornecedor(String nome) {
		return controleFornecedor.exibeFornecedor(nome);
	}
	
	/**
	 * Metodo que edita o fornecedor
	 * @param nome: nome do fornecedor
	 * @param atributo: nome do atributo que sera editado 
	 * @param novoValor: novo valor que sera atribuido ao atributo	 
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		controleFornecedor.editaFornecedor(nome, atributo, novoValor);
	}
	
	/**
	 * Metodo que remove o fornecedor
	 * @param nome: nome do fornecedor
	 */
	public void removeFornecedor(String nome) {
		controleFornecedor.removeFornecedor(nome);
	}
		
	/**
	 * Metodo que adiciona um produto no sistema
	 * @param fornecedor: nome do fornecedor
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @param preco: preco do produto
	 */
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		controleFornecedor.cadastraProduto(fornecedor, nome, descricao, preco);
	}
	
	/**
	 * Metodo que exibe um produto
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @param fornecedor: nome do fornecedor
	 * @return a String do produto
	 */
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return controleFornecedor.exibeUmProduto(nome, descricao, fornecedor);
	}
	
	/**
	 * Metodo que edita o preco de um produto
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @param fornecedor: nome do fornecedor
	 * @param novoPreco: novo preco a ser atribuido no produto
	 */
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		controleFornecedor.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
	
	/**
	 * Metodo que remove um produto
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @param fornecedor: nome do fornecedor
	 */
	public void removeProduto(String nome, String descricao, String fornecedor) {
		controleFornecedor.removeProduto(nome, descricao, fornecedor);
	}
		
	/**
	 * Metodo que exibe todos os clientes
	 * @return String dos clientes
	 */
	public String exibeClientes() {
		return controleCliente.exibeClientes();
	}
	
	/**
	 * Metodo que exibe todos os fornecedores
	 * @return String dos fornecedores
	 */
	public String exibeFornecedores() {
		return controleFornecedor.exibeFornecedores();
	}
	
	/**
	 * Metodo que exibe todos os produtos
	 * @return String dos produtos
	 */
	public String exibeProdutos() {
		return controleFornecedor.exibeProdutosFornecedores();
	}
	
	/**
	 * Metodo que exibe os produtos de determinado fornecedor
	 * @param fornecedor: nome do fornecedor
	 * @return a String dos produtos de determinado fornecedor
	 */
	public String exibeProdutos(String fornecedor) {
		return controleFornecedor.exibeProdutosFornecedor(fornecedor);
	}
		
	/**
	 * Metodo que exibe os produtos de determinado fornecedor
	 * @param fornecedor: nome do fornecedor
	 * @return a String dos produtos de determinado fornecedor
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		return controleFornecedor.exibeProdutosFornecedor(fornecedor);
	}
		
	/**
	 * Metodo que exibe todos os produtos de todos os fornecedores
	 * @return a String de todos os produtos de todos os fornecedores
	 */
	public String exibeProdutosFornecedor() {
		return controleFornecedor.exibeProdutosFornecedores();
	}
	
	/**
	 * Metodo que adiciona uma compra
	 * @param cpf: cpf do cliente
	 * @param fornecedor: nome do fornecedor
	 * @param data: data da compra
	 * @param nomeProduto: nome do produto
	 * @param descricaoProduto: descricao do produto
	 */
	public void adicionaCompra(String cpf, String fornecedor, String data, String nomeProduto, String descricaoProduto) {
		ValidaCompra.cadastroCPF(cpf, controleCliente.getClientes());
		ValidaCompra.cadastroFornecedor(fornecedor, controleFornecedor.getFornecedores());
		ValidaCompra.cadastroData(data);
		ValidaCompra.cadastroNome(nomeProduto);
		ValidaCompra.cadastroDescricao(descricaoProduto);
		ValidaCompra.existeProduto(controleFornecedor.existeProduto(fornecedor, nomeProduto, descricaoProduto));
		
		String nomeCliente = controleCliente.getNomeCliente(cpf);
		double preco = controleFornecedor.getPrecoProdutoFornecedor(fornecedor, nomeProduto, descricaoProduto);
		this.controleFornecedor.cadastraCompra(nomeCliente, cpf, fornecedor, data, nomeProduto, descricaoProduto, preco);
	}
	
	/**
	 * Metodo que retorna o debito do cliente
	 * @param cpf: cpf do cliente
	 * @param fornecedor: nome do fornecedor
	 * @return a String do debito do cliente
	 */
	public String getDebito(String cpf, String fornecedor) {
		ValidaCompra.debitoCPF(cpf, controleCliente.getClientes());
		ValidaCompra.debitoFornecedor(fornecedor, controleFornecedor.getFornecedores());
		return this.controleFornecedor.getDebito(cpf, fornecedor);
	}
	
	/**
	 * Metodo que exibe a conta do cliente com determinado fornecedor.
	 * @param cpf: cpf do cliente
	 * @param fornecedor: nome do fornecedor
	 * @return a String da conta do cliente com determinado fornecedor
	 */
	public String exibeContas(String cpf, String fornecedor) {
		ValidaCompra.exibeCPF(cpf, controleCliente.getClientes());
		ValidaCompra.exibeFornecedor(fornecedor, controleFornecedor.getFornecedores());
		String nomeCliente = controleCliente.getNomeCliente(cpf);
		return this.controleFornecedor.exibeContas(nomeCliente, cpf, fornecedor);
	}
	
	/**
	 * Metodo que exibe as contas dos clientes
	 * @param cpf: cpf do cliente
	 * @return a String com as contas dos clientes
	 */
	public String exibeContasClientes(String cpf) {
		ValidaCompra.exibeCPFs(cpf, controleCliente.getClientes());
		ValidaCompra.hasConta(controleFornecedor.hasContas(cpf));
		String nomeCliente = controleCliente.getNomeCliente(cpf);
		return this.controleFornecedor.exibeContasClientes(nomeCliente, cpf);
	}
	
	/**
	 * Metodo que define o criterio de ordenacao da listagem de todas as compras, 
	 * a partir de um criterio que sera usado como base para a ordenacao das compras.
	 * @param criterio: criterio de ordenacao da compras.
	 */
	public void ordenaPor(String criterio) {
		ValidaOrdenacao.criterio(criterio);
		controleFornecedor.ordenaPor(criterio);
	}

	/**
	 * Metodo que retorna a representacao em string da lista de todas as compras
	 * @return a representacao em string da lista de todas as compras
	 */
	public String listarCompras() {
		return controleFornecedor.listarCompras();
	}
}
