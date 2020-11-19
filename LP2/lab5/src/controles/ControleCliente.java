package controles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import entidades.Cliente;
import validacao.ValidaCliente;

/**
 * Representacao do controle do cliente.
 * 
 * @author Beatriz Miranda - 119210170
 *
 */
public class ControleCliente {
	
	/**
	 * Mapa com todos os clientes,
	 * identificado unicamente pelo cpf do cliente.
	 */
	private HashMap<String, Cliente> clientes;
	
	/**
	 * Constroi o controle do cliente
	 */
	public ControleCliente() {
		this.clientes = new HashMap<String, Cliente>();
	}
	
	/**
	 * Metodo que adiciona um cliente no sistema
	 * @param cpf: cpf do cliente
	 * @param nome: nome do cliente
	 * @param email: email do cliente
	 * @param localizacao: localizacao do cliente
	 * @return a String do cpf do cliente
	 */
	public String cadastraCliente(String cpf, String nome, String email, String localizacao) {
		ValidaCliente.cadastroCPF(cpf, clientes);
		ValidaCliente.cadastroNome(nome);
		ValidaCliente.cadastroEmail(email);
		ValidaCliente.cadastroLocal(localizacao);
		
		this.clientes.put(cpf, new Cliente(nome, email, localizacao));
		return cpf;	
	}
	
	/**
	 * Metodo que retorna um cliente a partir do seu cpf
	 * @param cpf: cpf do cliente
	 * @return a String do cliente
	 */
	public String exibeCliente(String cpf) {
		ValidaCliente.exibe(cpf, clientes);
		return this.clientes.get(cpf).toString();
	}
	
	/**
	 * Metodo que edita o cliente
	 * @param cpf: cpf do cliente
	 * @param atributo: nome do atributo que sera editado 
	 * @param novoValor: novo valor que sera atribuido ao atributo
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		ValidaCliente.editaCPF(cpf, clientes);
		ValidaCliente.editaAtributo(atributo);
		ValidaCliente.editaNovoValor(novoValor);
		this.clientes.get(cpf).edita(atributo, novoValor);;
	}
	
	/**
	 * Metodo que remove o cliente
	 * @param cpf: cpf do cliente
	 */
	public void removeCliente(String cpf) {
		ValidaCliente.remove(cpf, clientes);
		this.clientes.remove(cpf);
	}
	
	/**
	 * Metodo que exibe todos os clientes
	 * @return String dos clientes
	 */
	public String exibeClientes() {
		
		ArrayList<String> sortedClientes = new ArrayList<>();
		
		for (Cliente cliente : clientes.values()) {
			sortedClientes.add(cliente.toString());
		}
		
		Collections.sort(sortedClientes);
		
		String retorno = "";
		for (String cliente : sortedClientes) {
			if (cliente.equals(sortedClientes.get(sortedClientes.size() - 1))) {
				retorno += cliente;
			} else {				
				retorno += cliente + " | ";
			}
		}
		return retorno;
	}
	
	/**
	 * Metodo que retorna o mapa dos clientes
	 * @return o mapa das contas
	 */
	public HashMap getClientes() {
		return this.clientes;
	}	
	
	/**
	 * Metodo que retorna o nome do cliente
	 * @param cpf: cpf do cliente
	 * @return o nome do cliente
	 */
	public String getNomeCliente(String cpf) {
		return this.clientes.get(cpf).getNome();
	}
}
