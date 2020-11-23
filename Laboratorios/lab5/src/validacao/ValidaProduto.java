package validacao;

import java.util.HashMap;

import entidades.IdProduto;

public class ValidaProduto {
	
	/**
	 * Metodo que verifica o cadastro do produto
	 * @param idProduto: id do produto
	 * @param produtos: mapa de produtos
	 */
	public static void cadastroProduto(IdProduto idProduto, HashMap produtos) {
		if (produtos.containsKey(idProduto)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
	}
	
	/**
	 * Metodo que verifica o cadastro do fornecedor
	 * @param fornecedor: nome do fonecedor
	 * @param fornecedores: mapa de fornecedores
	 */
	public static void cadastroFornecedor(String fornecedor, HashMap fornecedores) {
		if (fornecedor == null || fornecedor.isBlank()) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if (fornecedores.get(fornecedor) == null) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
	}
	
	/**
	 * Metodo que verifica o cadastro do nome do produto
	 * @param nome: nome do produto
	 */
	public static void cadastroNome(String nome) {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	 * MetoMetodo que verifica o cadastro da descricao do produto
	 * @param descricao: descricao do produto
	 */
	public static void cadastroDescricao(String descricao) {
		if (descricao == null || descricao.isBlank()) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
	}
	
	/**
	 * Metodo que verifica o cadastro do preco do produto
	 * @param preco: preco do produto
	 */
	public static void cadastroPreco(double preco) {
		if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
	}
	
	/**
	 * Metodo que verifica a exibicao do produto
	 * @param idProduto: id do produto
	 * @param produtos: mapa de produtos
	 */
	public static void exibeProduto(IdProduto idProduto, HashMap produtos) {
		if (!produtos.containsKey(idProduto)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
	}
	
	/**
	 * Metodo que verifica a exibicao do fornecedor
	 * @param fornecedor: nome do fonecedor
	 * @param fornecedores: mapa de fornecedores
	 */
	public static void exibeFornecedor(String fornecedor, HashMap fornecedores) {
		if (fornecedor == null || fornecedor.isBlank()) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if (fornecedores.get(fornecedor) == null) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
	}
	
	/**
	 * Metodo que verifica a exibicao do nome do produto
	 * @param nome: nome do produto
	 */
	public static void exibeNome(String nome) {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	 * Metodo que verifica a exibicao da descricao do produto
	 * @param descricao: descricao do produto
	 */
	public static void exibeDescricao(String descricao) {
		if (descricao == null || descricao.isBlank()) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}
	}
	
	/**
	 * Metodo que verifica se o do produto existe na edicao
	 * @param idProduto: id do produto
	 * @param produtos: mapa de produtos
	 */
	public static void editaProduto(IdProduto idProduto, HashMap produtos) {
		if (!produtos.containsKey(idProduto)) {
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		}
	}
	
	/**
	 * Metodo que verifica se o fornecedor existe na edicao do produto
	 * @param fornecedor: nome do fonecedor
	 * @param fornecedores: mapa de fornecedores
	 */
	public static void editaFornecedor(String fornecedor, HashMap fornecedores) {
		if (fornecedor == null || fornecedor.isBlank()) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if (fornecedores.get(fornecedor) == null) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
	}
	
	/**
	 * Metodo que verifica a edicao do nome do produto
	 * @param nome: nome do produto
	 */
	public static void editaNome(String nome) {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	 * Metodo que verifica a edicao da descricao do produto
	 * @param descricao: descricao do produto
	 */
	public static void editaDescricao(String descricao) {
		if (descricao == null || descricao.isBlank()) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}
	}
	
	/**
	 * Metodo que verifica a edicao do preco do produto
	 * @param preco: preco do produto
	 */
	public static void editaPreco(double preco) {
		if (preco < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
	}
	
	/**
	 * Metodo que verifica a remocao do produto
	 * @param idProduto: id do produto
	 * @param produtos: mapa de produtos
	 */
	public static void removeProduto(IdProduto idProduto, HashMap produtos) {
		if (!produtos.containsKey(idProduto)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
	}
	
	/**
	 * Metodo que verifica a remocao do fornecedor
	 * @param fornecedor: nome do fonecedor
	 * @param fornecedores: mapa de fornecedores
	 */
	public static void removeFornecedor(String fornecedor, HashMap fornecedores) {
		if (fornecedor == null || fornecedor.isBlank()) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if (fornecedores.get(fornecedor) == null) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}
	}
	
	/**
	 * Metodo que verifica o nome na remocao do produto
	 * @param nome: nome do produto
	 */
	public static void removeNome(String nome) {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	 * Metodo que verifica a descricao na remocao do produto
	 * @param descricao: descricao do produto
	 */
	public static void removeDescricao(String descricao) {
		if (descricao == null || descricao.isBlank()) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
	}
}
