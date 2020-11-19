package validacao;

import java.util.HashMap;

public class ValidaCompra {
	
	/**
	 * Metodo que verifica o cpf no cadastro da compra
	 * @param cpf: cpf do cliente
	 * @param clientes: mapa de clientes
	 */
	public static void cadastroCPF(String cpf, HashMap clientes) {
		if (cpf == null || cpf.isBlank()) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		}
		
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		}
	
		if (clientes.get(cpf) == null) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}
	}
	
	/**
	 * Metodo que verifica o fornecedor no cadastro da compra
	 * @param fornecedor: nome do fornecedor
	 * @param fornecedores: mapa de fornecedores
	 */
	public static void cadastroFornecedor(String fornecedor, HashMap fornecedores) {
		if (fornecedor == null || fornecedor.isBlank()) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		}
		if (fornecedores.get(fornecedor) == null) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
		}
	}
	
	/**
	 * Metodo que verifica a data no cadastro da compra
	 * @param data: data da compra
	 */
	public static void cadastroData(String data) {
		if (data == null || data.isBlank()) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		}
		
		if (data.length() != 10) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}
	}

	/**
	 * Metodo que verifica o nome do produto no cadastro da compra
	 * @param nomeProduto: nome do produto
	 */
	public static void cadastroNome(String nomeProduto) {
		if (nomeProduto == null || nomeProduto.isBlank()) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		}
	}

	/**
	 * Metodo que verifica a descricao no cadastro da compra
	 * @param descricaoProduto: descricao do produto
	 */
	public static void cadastroDescricao(String descricaoProduto) {
		if (descricaoProduto == null || descricaoProduto.isBlank()) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		}
	}
	
	/**
	 * Metodo que verifica se existe o produto no cadastro da compra
	 * @param resposta: resposta recebida, pode ser true ou false
	 */
	public static void existeProduto(boolean resposta) { 
		if (resposta == false) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
		}
	}
	
	/**
	 * Metodo que verificao o fornecedor no debito da compra
	 * @param fornecedor: nome do fornecedor
	 * @param fornecedores: mapa de fornecedores
	 */
	public static void debitoFornecedor(String fornecedor, HashMap fornecedores) {
		if (fornecedor == null || fornecedor.isBlank()) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		}
		if (fornecedores.get(fornecedor) == null) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		}
	}
	
	/**
	 * Metodo que verificao o cpf do cliente no debito da compra
	 * @param cpf: cpf do cliente
	 * @param clientes: mapa de clientes
	 */
	public static void debitoCPF(String cpf, HashMap clientes) {
		if (cpf == null || cpf.isBlank()) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		}
		
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");
		}
	
		if (clientes.get(cpf) == null) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		}
	}
	
	/**
	 * Metodo que verificao se o cliente tem debito
	 * @param cpf: cpf do cliente
	 * @param contas: mapa de contas
	 */
	public static void hasDebito(String cpf, HashMap contas) {
		if (!contas.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		}
	}

	/**
	 * Metodo que verificao o fornecedor na exibicao da compra
	 * @param fornecedor: nome do fornecedor
	 * @param fornecedores: mapa de fornecedores
	 */
	public static void exibeFornecedor(String fornecedor, HashMap fornecedores) {
		if (fornecedor == null || fornecedor.isBlank()) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		}
		if (fornecedores.get(fornecedor) == null) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		}
	}
	
	/**
	 * Metodo que verificao o cpf na exibicao da compra
	 * @param cpf: cpf do cliente
	 * @param clientes: mapa de clientes
	 */
	public static void exibeCPF(String cpf, HashMap clientes) {
		
		if (cpf == null || cpf.isBlank()) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		}
		
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf invalido.");
		}
	
		if (clientes.get(cpf) == null) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		}
	}
	
	/**
	 * Metodo que verificao se existe conta do cliente com o fornecedor na exibicao da compra
	 * @param cpf: cpf do cliente
	 * @param contas: mapa de contas
	 */
	public static void exibeTemFornecedor(String cpf, HashMap contas) {
		if(!contas.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}
	}

	/**
	 * Metodo que verificao os cpfs dos clientes na exibicao da compra
	 * @param cpf: cpf do cliente
	 * @param clientes: mapa de clientes
	 */
	public static void exibeCPFs(String cpf, HashMap clientes) {
		
		if (cpf == null || cpf.isBlank()) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		}
		
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf invalido.");
		}
		
		if (clientes.get(cpf) == null) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
		}
	}
	
	/**
	 * Metodo que verificao se existe a conta na exibicao da compra
	 * @param resposta: resposta recebida, pode ser true ou false
	 */
	public static void hasConta(boolean resposta) {
		if (resposta == false) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		}
	}
}
