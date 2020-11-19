package saga;

import controles.ControleSistema;
import easyaccept.EasyAccept;

/**
 * Representacao da Facade do sistema.
 * 
 * @author Beatriz Miranda - 119210170
 *
 */
public class Facade {
	public static void main(String[] args) {
		args = new String[] { "saga.Facade", 
				"teste_aceitacao/use_case_1.txt",
				"teste_aceitacao/use_case_2.txt",
				"teste_aceitacao/use_case_3.txt",
				"teste_aceitacao/use_case_4.txt",
				"teste_aceitacao/use_case_5.txt",
				"teste_aceitacao/use_case_6.txt"
		};
		EasyAccept.main(args);
	}
	
	/* controle do sistema */
	private ControleSistema controle;
	
	/**
	 * Constroi a facade.
	 */
	public Facade() {
		this.controle = new ControleSistema();
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
		return controle.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	/**
	 * Metodo que retorna um cliente a partir do seu cpf
	 * @param cpf: cpf do cliente
	 * @return a String do cliente
	 */
	public String exibeCliente(String cpf) {
		return controle.exibeCliente(cpf);
	}
	
	/**
	 * Metodo que edita o cliente
	 * @param cpf: cpf do cliente
	 * @param atributo: nome do atributo que sera editado 
	 * @param novoValor: novo valor que sera atribuido ao atributo
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		controle.editaCliente(cpf, atributo, novoValor);
	}
	
	/**
	 * Metodo que remove o cliente
	 * @param cpf: cpf do cliente
	 */
	public void removeCliente(String cpf) {
		controle.removeCliente(cpf);
	}
	
	/**
	 * Metodo que adiciona um fornecedor no sistema
	 * @param nome: nome do fornecedor
	 * @param email: email do fornecedor
	 * @param telefone: telefone do fornecedor
	 * @return nome do fornecedor
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return controle.adicionaFornecedor(nome, email, telefone);
	}
	
	/**
	 * Metodo que retorna um fornecedor a partir do seu nome
	 * @param nome: nome do fornecedor
	 * @return a String do fornecedor
	 */
	public String exibeFornecedor(String nome) {
		return controle.exibeFornecedor(nome);
	}
	
	/**
	 * Metodo que edita o fornecedor
	 * @param nome: nome do fornecedor
	 * @param atributo: nome do atributo que sera editado 
	 * @param novoValor: novo valor que sera atribuido ao atributo	 
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		controle.editaFornecedor(nome, atributo, novoValor);
	}
	
	/**
	 * Metodo que remove o fornecedor
	 * @param nome: nome do fornecedor
	 */
	public void removeFornecedor(String nome) {
		controle.removeFornecedor(nome);
	}
	
	/**
	 * Metodo que adiciona um produto no sistema
	 * @param fornecedor: nome do fornecedor
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @param preco: preco do produto
	 */
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		controle.adicionaProduto(fornecedor, nome, descricao, preco);
	}
	
	/**
	 * Metodo que exibe um produto
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @param fornecedor: nome do fornecedor
	 * @return a String do produto
	 */
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return controle.exibeProduto(nome, descricao, fornecedor);
	}
	
	/**
	 * Metodo que edita o preco de um produto
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @param fornecedor: nome do fornecedor
	 * @param novoPreco: novo preco a ser atribuido no produto
	 */
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		controle.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
	
	/**
	 * Metodo que remove um produto
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @param fornecedor: nome do fornecedor
	 */
	public void removeProduto(String nome, String descricao, String fornecedor) {
		controle.removeProduto(nome, descricao, fornecedor);
	}
	
	/**
	 * Metodo que exibe todos os clientes
	 * @return String dos clientes
	 */
	public String exibeClientes() {
		return controle.exibeClientes();
	}
	
	/**
	 * Metodo que exibe todos os fornecedores
	 * @return String dos fornecedores
	 */
	public String exibeFornecedores() {
		return controle.exibeFornecedores();
	}
	
	/**
	 * Metodo que exibe todos os produtos
	 * @return String dos produtos
	 */
	public String exibeProdutos() {
		return controle.exibeProdutos();
	}
	
	/**
	 * Metodo que exibe os produtos de determinado fornecedor
	 * @param fornecedor: nome do fornecedor
	 * @return a String dos produtos de determinado fornecedor
	 */
	public String exibeProdutos(String fornecedor) {
		return controle.exibeProdutosFornecedor(fornecedor);
	}
	
	/**
	 * Metodo que exibe os produtos de determinado fornecedor
	 * @param fornecedor: nome do fornecedor
	 * @return a String dos produtos de determinado fornecedor
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		return controle.exibeProdutosFornecedor(fornecedor);
	}
	
	/**
	 * Metodo que exibe todos os produtos de todos os fornecedores
	 * @return a String de todos os produtos de todos os fornecedores
	 */
	public String exibeProdutosFornecedor() {
		return controle.exibeProdutosFornecedor();
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
		controle.adicionaCompra(cpf, fornecedor, data, nomeProduto, descricaoProduto);
	}
	
	/**
	 * Metodo que retorna o debito do cliente
	 * @param cpf: cpf do cliente
	 * @param fornecedor: nome do fornecedor
	 * @return a String do debito do cliente
	 */
	public String getDebito(String cpf, String fornecedor) { 
		return controle.getDebito(cpf, fornecedor);
	}
	
	/**
	 * Metodo que exibe a conta do cliente com determinado fornecedor.
	 * @param cpf: cpf do cliente
	 * @param fornecedor: nome do fornecedor
	 * @return a String da conta do cliente com determinado fornecedor
	 */
	public String exibeContas(String cpf, String fornecedor) {
		return this.controle.exibeContas(cpf, fornecedor);
	}
	
	/**
	 * Metodo que exibe as contas dos clientes
	 * @param cpf: cpf do cliente
	 * @return a String com as contas dos clientes
	 */
	public String exibeContasClientes(String cpf) {
		return this.controle.exibeContasClientes(cpf);
	}

	/**
	 * Metodo que define o criterio de ordenacao da listagem de todas as compras, 
	 * a partir de um criterio que sera usado como base para a ordenacao das compras.
	 * @param criterio: criterio de ordenacao da compras.
	 */
	public void ordenaPor(String criterio) {
		this.controle.ordenaPor(criterio);
	}

	/**
	 * Metodo que retorna a representacao em string da lista de todas as compras
	 * @return a representacao em string da lista de todas as compras
	 */
	public String listarCompras() {
		return controle.listarCompras();
	}
}