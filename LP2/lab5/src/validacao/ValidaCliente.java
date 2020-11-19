package validacao;

import java.util.HashMap;

public class ValidaCliente {
	
	/**
	 * Metodo que verifica o cpf do cadastro de clientes
	 * @param cpf: cpf do cliente
	 * @param clientes: mapa de clientes
	 */
	public static void cadastroCPF(String cpf, HashMap clientes) {
		if (cpf == null || cpf.isBlank()) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}
		
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
	
		if (clientes.get(cpf) != null) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
	}
	
	/**
	 * Metodo que verifica o nome do cadastro de clientes
	 * @param nome: nome do cliente
	 */
	public static void cadastroNome(String nome) {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	 * Metodo que verifica o email do cadastro de clientes
	 * @param email: email do cliente
	 */
	public static void cadastroEmail(String email) {
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	 * Metodo que verifica a localizacao do cadastro de clientes
	 * @param local: localizacao do cliente
	 */
	public static void cadastroLocal(String localizacao) {
		if (localizacao == null || localizacao.isBlank()) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
	}
	
	/**
	 * Metodo que verifica a exibicao de clientes 
	 * @param cpf: cpf do cliente
	 * @param clientes: mapa de clientes
	 */
	public static void exibe(String cpf, HashMap clientes) {
			
		if (cpf == null || cpf.isBlank()) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		}
			
		if (clientes.get(cpf) == null) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
	}
	
	/**
	 * Metodo que verifica o cpf na edicao de clientes
	 * @param cpf: cpf do cliente
	 * @param clientes: mapa de clientes
	 */
	public static void editaCPF(String cpf, HashMap clientes) {
		
		if (cpf == null || cpf.isBlank()) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		}
		
		if (clientes.get(cpf) == null) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
	}
	
	/**
	 * Metodo que verifica o atributo na edicao de clientes
	 * @param atributo: nome do atributo que sera editado
	 */
	public static void editaAtributo(String atributo) {
		
		if (atributo == null || atributo.isBlank()) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
		
		if (atributo.equals("cpf")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
		}
		
		if (!atributo.equals("nome") && !atributo.equals("email") && !atributo.equals("localizacao")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
		
	}
	
	/**
	 * Metodo que verifica o novo valor na edicao de clientes
	 * @param novoValor: novo valor que sera atribuido na edicao
	 */
	public static void editaNovoValor(String novoValor) {
		if (novoValor == null || novoValor.isBlank()) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	 * Metodo que verifica a remocao de clientes
	 * @param cpf: cpf do cliente
	 * @param clientes: mapa de clientes
	 */
	public static void remove(String cpf, HashMap clientes) {
		
		if (cpf == null || cpf.isBlank()) {
			throw new IllegalArgumentException("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		}
		
		if (clientes.get(cpf) == null) {
			throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		}
	}	
}
