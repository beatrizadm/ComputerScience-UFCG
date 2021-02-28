package cliente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import conta.Compra;
import java.util.Comparator;
import utilidades.ComparatorCliente;
import utilidades.ComparatorData;
import utilidades.ComparatorFornecedor;
import utilidades.Util;

/**
 * Classe que controla vários clientes e tem metodos para cadastrar, excluir,
 * modificar e fazer operacoes com esses clientes
 * 
 * @author aluno de período anterior
 *
 */
public class ControlerCliente {
	/**
	 * Mapa com os clientes cadastrados no controlador, as chaves sao os cpf's e
	 * apontam para os clientes
	 */
	private HashMap<String, Cliente> clientes;

	/**
	 * Lista com todos os cpf's cadastrados ordenados em ordem alfabetica pelo nome
	 * dos clientes a quem eles pertencem
	 */
	private ArrayList<String> cpfsCadastrados;

	/**
	 * Comparator para comparar as compras cadastradas no sistema
	 */
	private Comparator<Compra> comparator;

	/**
	 * Compras realizadas por todos os clientes cadastrados no sistema
	 */
	private ArrayList<Compra> compras;

	/**
	 * Constroi o controlador, nao recebe nenhum parametro, somente inicializa as
	 * variaveis da classe.
	 */
	public ControlerCliente() {
		this.clientes = new HashMap<String, Cliente>();
		this.cpfsCadastrados = new ArrayList<String>();
		this.comparator = null;
		this.compras = new ArrayList<Compra>();
	}

	/**
	 * Adiciona um cliente no controlador
	 * 
	 * @param cpf         Cpf do cliente
	 * @param nome        Nome do cliente
	 * @param email       Email do cliente
	 * @param localizacao Localizacao do cliente
	 * @return CPF do cliente se ele for cadastrado com sucesso
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		Util.testaNull(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		Util.testaVazio(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");

		Util.testaNull(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		Util.testaVazio(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");

		Util.testaNull(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		Util.testaVazio(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");

		Util.testaNull(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		Util.testaVazio(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}

		if (this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}

		this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
		this.cpfsCadastrados.add(cpf);

		for (int i = this.cpfsCadastrados.size() - 1; i > 0; i--) {
			String cpf1 = this.cpfsCadastrados.get(i);
			String cpf2 = this.cpfsCadastrados.get((i - 1));

			String nome1 = this.clientes.get(cpf1).getNome();
			String nome2 = this.clientes.get(cpf2).getNome();

			int compare = nome1.compareTo(nome2);

			if (compare < 0) {
				Collections.swap(this.cpfsCadastrados, i, i - 1);
			}
		}

		return cpf;
	}

	/**
	 * Retorna a representacao textual de um cliente dado o seu cpf
	 * 
	 * @param cpf Cpf do cliente que se deseja obter a representacao textual
	 * @return Representacao textual do cliente
	 */
	public String exibeCliente(String cpf) {
		Util.testaNull(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		Util.testaVazio(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");

		if (!this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}

		return this.clientes.get(cpf).toString();
	}

	/**
	 * Lista todos os clientes cadastrados no controlador, em ordem alfabetica do
	 * nome
	 * 
	 * @return String que é a lista das representacoes textuais de todos os clientes
	 *         cadastrados no controlador
	 */
	public String listaClientes() {
		String retorno = "";

		for (int i = 0; i < this.cpfsCadastrados.size(); i++) {
			String cpf = this.cpfsCadastrados.get(i);

			if (i == 0)
				retorno += this.clientes.get(cpf).toString();

			else
				retorno += " | " + this.clientes.get(cpf).toString();
		}

		return retorno;
	}

	/**
	 * Edita o cadastro de um cliente dado o cpf, o atributo que se deseja mudar e o
	 * novo valor que sera atribuido a ele.
	 * 
	 * @param cpf       CPF do cliente
	 * @param atributo  Atributo a ser modificado
	 * @param novoValor Novo valor do atributo
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		Util.testaNull(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		Util.testaVazio(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");

		Util.testaNull(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		Util.testaVazio(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");

		Util.testaNull(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		Util.testaVazio(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");

		if (atributo.equals("cpf")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
		}

		if (!atributo.equals("nome") && !atributo.equals("email") && !atributo.equals("localizacao")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}

		if (!this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}

		if (atributo.equals("nome")) {
			this.clientes.get(cpf).setNome(novoValor);
		}

		if (atributo.equals("email")) {
			this.clientes.get(cpf).setEmail(novoValor);
		}

		if (atributo.equals("localizacao")) {
			this.clientes.get(cpf).setLocalizacao(novoValor);
		}
	}

	/**
	 * Remove um cliente do cadastro dado seu cpf.
	 * 
	 * @param cpf Cpf do cliente a ser removido.
	 */
	public void removeCliente(String cpf) {
		Util.testaNull(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		Util.testaVazio(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");

		if (!this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		}

		this.clientes.remove(cpf);

		for (int i = 0; i < this.cpfsCadastrados.size(); i++) {
			if (this.cpfsCadastrados.get(i).equals(cpf)) {
				this.cpfsCadastrados.remove(i);
				break;
			}
		}
	}

	/**
	 * Adiciona uma compra de um produto feita por um cliente em um dado fornecedor,
	 * dado o cpf do cliente, nome do fornecedor, data da compra, nome, descrição e
	 * preço do produto.
	 * 
	 * @param cpf              Cpf do cliente que realizou a compra
	 * @param fornecedor       Nome do fornecedor de quem o cliente comprou o
	 *                         produto
	 * @param data             Data da compra
	 * @param nomeProduto      Nome do produto comprado
	 * @param descricaoProduto Descrição do produto comprado.
	 * @param precoProduto     Preço do produto comprado
	 */
	public void adicionaCompra(String cpf, String fornecedor, String data, String nomeProduto, String descricaoProduto,
			double precoProduto) {
		Util.testaNull(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		Util.testaVazio(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");

		Util.testaNull(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		Util.testaVazio(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");

		Util.testaNull(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		Util.testaVazio(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");

		Util.testaNull(nomeProduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		Util.testaVazio(nomeProduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");

		Util.testaNull(descricaoProduto, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		Util.testaVazio(descricaoProduto, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		}

		String[] dataTest = data.split("/");

		if (dataTest.length != 3 || dataTest[0].length() != 2 || dataTest[1].length() != 2
				|| dataTest[2].length() != 4) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}

		if (!this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}

		this.clientes.get(cpf).adicionaCompra(fornecedor, data, nomeProduto, descricaoProduto, precoProduto);
	}

	/**
	 * Pega o débito que um cliente tem para um dado fornecedor dado o cpf do
	 * cliente e o nome do fornecedor. Retorna um double que é o débito total
	 * daquela conta, caso exista.
	 * 
	 * @param cpf        CPF do cliente
	 * @param fornecedor Fornecedor que o cliente tem a conta e que se deseja saber
	 *                   o débito total.
	 * @return Double que é o valor total das compras realizadas pelo cliente
	 *         naquele dado fornecedor.
	 */
	public double getDebito(String cpf, String fornecedor) {
		Util.testaNull(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		Util.testaVazio(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");

		Util.testaNull(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		Util.testaVazio(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");
		}

		if (!this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		}

		return this.clientes.get(cpf).getDebito(fornecedor);
	}

	/**
	 * Exibe uma conta de um cliente para um dado fornecedor.
	 * 
	 * @param cpf        Cpf do cliente
	 * @param fornecedor Fornecedor no qual o cliente tem uma conta.
	 * @return Representação textual da conta do cliente para o dado fornecedor
	 */
	public String exibeContas(String cpf, String fornecedor) {
		Util.testaNull(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		Util.testaVazio(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf invalido.");
		}

		if (!this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		}

		return this.clientes.get(cpf).exibeConta(fornecedor);
	}

	/**
	 * Retorna uma representação String de todas as contas de um dado cliente
	 * Organizadas em oredem alfabética do nome dos fornecedores
	 * 
	 * @param cpf CPF do cliente que se deseja ver as contas.
	 * @return Representação textual de todas as contas de um cliente
	 */
	public String exibeContasClientes(String cpf) {
		Util.testaNull(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		Util.testaVazio(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf invalido.");
		}

		if (!this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
		}

		return this.clientes.get(cpf).listaContas();
	}

	/**
	 * Define o critério de ordenação das compras do sistema, por ordem alfabética
	 * do nome do cliente, do nome do fornecedor, ou pela data das compras
	 * 
	 * @param criterio Critério de ordenação
	 */
	public void ordenaComprasPor(String criterio) {
		Util.testaNull(criterio, "Erro na listagem de compras: criterio nao pode ser vazio ou nulo.");
		Util.testaVazio(criterio, "Erro na listagem de compras: criterio nao pode ser vazio ou nulo.");

		if (!criterio.equals("Cliente") && !criterio.equals("Data") && !criterio.equals("Fornecedor")) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio nao oferecido pelo sistema.");
		}

		if (criterio.equals("Cliente")) {
			this.comparator = new ComparatorCliente();
		}

		if (criterio.equals("Data")) {
			this.comparator = new ComparatorData();
		}

		if (criterio.equals("Fornecedor")) {
			this.comparator = new ComparatorFornecedor();
		}
	}

	/**
	 * Retorna a representação String de todas as compras realizadas no sistema
	 * ordenadas pelo critério pré definido anteriormente
	 * 
	 * @return Representação String de todas as compras realizadas no sistema.
	 */
	public String listarCompras() {
		if (this.comparator == null) {
			throw new IllegalArgumentException(
					"Erro na listagem de compras: criterio ainda nao definido pelo sistema.");
		}

		String retorno = "";

		this.compras.clear();

		for (int i = 0; i < this.clientes.size(); i++) {
			this.compras.addAll(this.clientes.get(this.cpfsCadastrados.get(i)).getCompras());
		}

		Collections.sort(this.compras, this.comparator);

		if (this.comparator instanceof ComparatorCliente) {
			for (int i = 0; i < this.compras.size(); i++) {
				Compra c = this.compras.get(i);

				if (i == 0) {
					retorno += c.getCliente() + ", " + c.getFornecedor() + ", " + c.getDescricaoProduto() + ", "
							+ c.getData();
				}

				else {
					retorno += " | " + c.getCliente() + ", " + c.getFornecedor() + ", " + c.getDescricaoProduto() + ", "
							+ c.getData();
				}
			}
		}

		if (this.comparator instanceof ComparatorFornecedor) {
			for (int i = 0; i < this.compras.size(); i++) {
				Compra c = this.compras.get(i);

				if (i == 0) {
					retorno += c.getFornecedor() + ", " + c.getCliente() + ", " + c.getDescricaoProduto() + ", "
							+ c.getData();
				}

				else {
					retorno += " | " + c.getFornecedor() + ", " + c.getCliente() + ", " + c.getDescricaoProduto() + ", "
							+ c.getData();
				}

			}
		}

		if (this.comparator instanceof ComparatorData) {
			for (int i = 0; i < this.compras.size(); i++) {
				Compra c = this.compras.get(i);

				if (i == 0) {
					retorno += c.getData() + ", " + c.getCliente() + ", " + c.getFornecedor() + ", "
							+ c.getDescricaoProduto();
				}

				else {
					retorno += " | " + c.getData() + ", " + c.getCliente() + ", " + c.getFornecedor() + ", "
							+ c.getDescricaoProduto();
				}
			}
		}

		return retorno;
	}
}
