package cliente;

import conta.Compra;
import conta.Conta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Classe que representa um cliente, que contém CPF, Nome, Email e uma
 * localização, que é aonde o cliente trabalha.
 * 
 * @author aluno de período anterior 
 *
 */
public class Cliente {
	/**
	 * CPF do cliente
	 */
	private String cpf;

	/**
	 * Nome do cliente
	 */
	private String nome;

	/**
	 * Email do cliente
	 */
	private String email;

	/**
	 * Local onde o cliente trabalha
	 */
	private String localizacao;

	/**
	 * Mapa das contas que um cliente tem para um fornecedor, as chaves são os nomes
	 * dos fornecedores e apontam para uma conta
	 */
	private HashMap<String, Conta> contas;

	/**
	 * Nomes em ordem alfabética dos fornecedores que o cliente tem conta
	 */
	private ArrayList<String> contasCadastradas;

	/**
	 * Constrói um cliente dado seu cpf, nome, email e local onde trabalha
	 * 
	 * @param cpf         Cpf do cliente
	 * @param nome        Nome do cliente
	 * @param email       Email do cliente
	 * @param localizacao Local onde o cliente trabalha
	 */
	public Cliente(String cpf, String nome, String email, String localizacao) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;

		this.contas = new HashMap<String, Conta>();
		this.contasCadastradas = new ArrayList<String>();
	}

	@Override
	public String toString() {
		return this.getNome() + " - " + this.getLocalizacao() + " - " + this.getEmail();
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Cliente) {
			Cliente c = (Cliente) o;

			if (this.getCpf().equals(c.getCpf())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public int hashCode() {
		return this.getCpf().hashCode();
	}

	/**
	 * 
	 * @return Cpf do cliente
	 */
	private String getCpf() {
		return this.cpf;
	}

	/**
	 * 
	 * @return Email do cliente
	 */
	private String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @return Nome do cliente
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * 
	 * @return Localizacao do cliente
	 */
	private String getLocalizacao() {
		return this.localizacao;
	}

	/**
	 * Redefine o email do cliente dado o novo email
	 * 
	 * @param email Novo email do cliente
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Redefine o nome do cliente dado o novo nome
	 * 
	 * @param nome Novo nome do cliente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Redefine a localizacao do cliente dada a nova localizacao
	 * 
	 * @param localizacao Nova localizacao do cliente
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * Adiciona um compra à conta do cliente para um dado fornecedor, caso a conta
	 * com este fornecedor não exista ela é criada, caso já exista a compra é
	 * adicionada na conta.
	 * 
	 * @param fornecedor       Nome do fornecedor do qual se comprou o produto
	 * @param data             Data da compra
	 * @param nomeProduto      Nome do prosuto comprado
	 * @param descricaoProduto Descricao do produto comprado
	 * @param precoProduto     Preco do produto comprado
	 */
	public void adicionaCompra(String fornecedor, String data, String nomeProduto, String descricaoProduto,
			double precoProduto) {

		if (!this.contas.containsKey(fornecedor)) {
			this.contas.put(fornecedor, new Conta(fornecedor));
			this.contasCadastradas.add(fornecedor);

			for (int i = this.contasCadastradas.size() - 1; i > 0; i--) {
				String fornecedor1 = this.contasCadastradas.get(i);
				String fornecedor2 = this.contasCadastradas.get(i - 1);

				int compare = fornecedor1.compareTo(fornecedor2);

				if (compare < 0) {
					Collections.swap(contasCadastradas, i, i - 1);
				}
			}
		}

		this.contas.get(fornecedor).adicionaCompra(fornecedor, this.getNome(), data, nomeProduto, descricaoProduto,
				precoProduto);

	}

	/**
	 * Retorna o débito total que o cliente tem para um dado fornecedor
	 * 
	 * @param fornecedor Nome do fornecedor que se deseja saber o débito
	 * @return Debito total para o dado fornecedor
	 */
	public double getDebito(String fornecedor) {
		if (!this.contas.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		}

		return this.contas.get(fornecedor).totalizaConta();
	}

	/**
	 * Retorna uma representacao textual de uma conta que o cliente tem para um dado
	 * fornecedor
	 * 
	 * @param fornecedor Fornecedor que se deseja exibir a conta
	 * @return Representacao textual da conta do cliente para o dado fornecedor
	 */
	public String exibeConta(String fornecedor) {
		if (!this.contas.containsKey(fornecedor)) {
			throw new IllegalArgumentException(
					"Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}

		return "Cliente: " + this.getNome() + " | " + this.contas.get(fornecedor).toString();
	}

	/**
	 * Retorna um string que é uma lista de todas as contas que o cliente tem em
	 * ordem alfabetica dos fornecedores
	 * 
	 * @return String que representa todas as contas que o cliente tem em ordem
	 *         alfabetica do nome dos fornecedores
	 */
	public String listaContas() {
		if (this.contas.size() == 0) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		}

		String retorno = "Cliente: " + this.getNome();

		for (int i = 0; i < this.contasCadastradas.size(); i++) {
			String fornecedor = this.contasCadastradas.get(i);

			retorno += " | " + this.contas.get(fornecedor).toString();
		}

		return retorno;

	}

	/**
	 * 
	 * @return Array List com todas as compras realizadas pelo cliente.
	 */
	public ArrayList<Compra> getCompras() {
		ArrayList<Compra> retorno = new ArrayList<Compra>();

		for (int i = 0; i < this.contas.size(); i++) {
			retorno.addAll(this.contas.get(this.contasCadastradas.get(i)).getCompras());
		}

		return retorno;
	}
}
