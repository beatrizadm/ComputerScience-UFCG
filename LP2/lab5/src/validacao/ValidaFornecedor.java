package validacao;

import java.util.HashMap;

public class ValidaFornecedor {

	/**
	 * Metodo que verifica o nome no cadastro do fornecedor
	 * @param nome: nome do fornecedor
	 * @param fornecedores: mapa de fornecedores
	 */
	public static void cadastroNome(String nome, HashMap fornecedores) {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if (fornecedores.get(nome) != null) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
	}
	
	/**
	 * Metodo que verifica o email no cadastro do fornecedor
	 * @param email: email do fornecedor
	 */
	public static void cadastroEmail(String email) {
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	 * Metodo que verifica o telefone no cadastro do fornecedor
	 * @param telefone: telefone do fornecedor
	 */
	public static void cadastroTelefone(String telefone) {
		if (telefone == null || telefone.isBlank()) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	 * Metodo que verifica a exibicao do fornecedor
	 * @param nome: nome do fornecedor
	 * @param fornecedores: mapa de fornecedores
	 */
	public static void exibe(String nome, HashMap fornecedores) {
				
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
		}
				
		if (fornecedores.get(nome) == null) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
	}
	
	/**
	 * Metodo que verifica a edicao do nome do fornecedor
	 * @param nome: nome do fornecedor
	 * @param fornecedores: mapa de fornecedores
	 */
	public static void editaNome(String nome, HashMap fornecedores) {
		
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		
		if (fornecedores.get(nome) == null) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
	}
		
	/**
	 * Metodo que verifica a edicao do atributo do fornecedor
	 * @param atributo: nome do atributo que sera editado
	 */
	public static void editaAtributo(String atributo) {
		
		if (atributo == null || atributo.isBlank()) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}
			
		if (atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
		
		if (!atributo.equals("email") && !atributo.equals("telefone")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
			
	}
	
	/**
	 * Metodo que verifica a edicao do novo valor do fornecedor
	 * @param novoValor: novo valor a ser atribuido
	 */
	public static void editaNovoValor(String novoValor) {
		if (novoValor == null || novoValor.isBlank()) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	 * Metodo que verifica a remocao do fornecedor
	 * @param nome: nome do fornecedor
	 * @param fornecedores: mapa de fornecedores
	 */
	public static void remove(String nome, HashMap fornecedores) {
			
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		}
			
		if (fornecedores.get(nome) == null) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
	}	
}
