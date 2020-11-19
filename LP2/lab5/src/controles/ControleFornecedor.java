package controles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import entidades.Compra;
import entidades.Fornecedor;
import comparadores.CompraCliente;
import comparadores.CompraData;
import comparadores.CompraFornecedor;
import validacao.ValidaCompra;
import validacao.ValidaFornecedor;
import validacao.ValidaOrdenacao;
import validacao.ValidaProduto;

/**
 * Representacao do controle do fornecedor.
 * 
 * @author Beatriz Miranda - 119210170
 *
 */
public class ControleFornecedor {
	
	/**
	 * Mapa com todos os fornecedores,
	 * identificados unicamente pelo nome do fornecedor.
	 */
	private HashMap<String, Fornecedor> fornecedores;
	
	/* criterio para ordenacao */
	private String criterio;
	
	/* Comparador de compra para ordenar corretamente */
	private Comparator<Compra> ordenador;
	
	/**
	 * Constroi o controle do fornecedor
	 */
	public ControleFornecedor() {
		this.fornecedores = new HashMap<String, Fornecedor>();
	}
	
	/**
	 * Metodo que adiciona um fornecedor no sistema
	 * @param nome: nome do fornecedor
	 * @param email: email do fornecedor
	 * @param telefone: telefone do fornecedor
	 * @return nome do fornecedor
	 */
	public String cadastraFornecedor(String nome, String email, String telefone) {
		ValidaFornecedor.cadastroNome(nome, fornecedores);
		ValidaFornecedor.cadastroEmail(email);
		ValidaFornecedor.cadastroTelefone(telefone);
		this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
		return nome;
	}
	
	/**
	 * Metodo que retorna um fornecedor a partir do seu nome
	 * @param nome: nome do fornecedor
	 * @return a String do fornecedor
	 */
	public String exibeFornecedor(String nome) {
		ValidaFornecedor.exibe(nome, fornecedores);
		return this.fornecedores.get(nome).toString();
	}

	/**
	 * Metodo que edita o fornecedor
	 * @param nome: nome do fornecedor
	 * @param atributo: nome do atributo que sera editado 
	 * @param novoValor: novo valor que sera atribuido ao atributo	 
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		ValidaFornecedor.editaNome(nome, fornecedores);
		ValidaFornecedor.editaAtributo(atributo);
		ValidaFornecedor.editaNovoValor(novoValor);
		this.fornecedores.get(nome).editaFornecedor(atributo, novoValor);;
	}
	
	/**
	 * Metodo que remove o fornecedor
	 * @param nome: nome do fornecedor
	 */
	public void removeFornecedor(String nome) {
		ValidaFornecedor.remove(nome, fornecedores);
		this.fornecedores.remove(nome);
	}
		
	/**
	 * Metodo que adiciona um produto no sistema
	 * @param fornecedor: nome do fornecedor
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @param preco: preco do produto
	 */
	public void cadastraProduto(String fornecedor, String nome, String descricao, double preco) {
		ValidaProduto.cadastroFornecedor(fornecedor, fornecedores);
		this.fornecedores.get(fornecedor).cadastraProduto(nome, descricao, preco);
	}
	
	/**
	 * Metodo que exibe um produto
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @param fornecedor: nome do fornecedor
	 * @return a String do produto
	 */
	public String exibeUmProduto(String nome, String descricao, String fornecedor) {
		ValidaProduto.exibeFornecedor(fornecedor, fornecedores);
		return this.fornecedores.get(fornecedor).consultaUmProduto(nome, descricao);
	}
	
	/**
	 * Metodo que edita o preco de um produto
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @param fornecedor: nome do fornecedor
	 * @param novoPreco: novo preco a ser atribuido no produto
	 */
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		ValidaProduto.editaFornecedor(fornecedor, fornecedores);
		this.fornecedores.get(fornecedor).editaProduto(nome, descricao, novoPreco);
	}
	
	/**
	 * Metodo que remove um produto
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @param fornecedor: nome do fornecedor
	 */
	public void removeProduto(String nome, String descricao, String fornecedor) {
		ValidaProduto.removeFornecedor(fornecedor, fornecedores);
		this.fornecedores.get(fornecedor).removeProduto(nome, descricao);
	}
	
	/**
	 * Metodo que exibe todos os fornecedores
	 * @return String dos fornecedores
	 */
	public String exibeFornecedores() {
		ArrayList<String> sortedFornecedores = new ArrayList<>(this.fornecedores.keySet());
		Collections.sort(sortedFornecedores);
		
		String retorno = "";
		for (String fornecedor : sortedFornecedores) {
			if (fornecedor.equals(sortedFornecedores.get(sortedFornecedores.size() - 1))) {
				retorno += fornecedores.get(fornecedor).toString();
			} else {
				retorno += fornecedores.get(fornecedor).toString() + " | ";				
			}
		}
		return retorno;
	}
	
	/**
	 * Metodo que exibe todos os produtos de todos os fornecedores
	 * @return String dos produtos de todos os fornecedores
	 */
	public String exibeProdutosFornecedores() {
		
		ArrayList<String> sortedFornecedores = new ArrayList<>();
		
		for (Fornecedor fornecedor : fornecedores.values()) {
			sortedFornecedores.add(fornecedor.consultaProdutos(fornecedor.getNome()));
		}
		
		Collections.sort(sortedFornecedores);
		
		String retorno = "";
		for (String fornecedor : sortedFornecedores) {
			if (fornecedor.equals(sortedFornecedores.get(sortedFornecedores.size() - 1))) {
				retorno += fornecedor;
			} else {				
				retorno += fornecedor + " | ";
			}
		}
		return retorno;
	}
	
	/**
	 * Metodo que exibe os produtos de determinado fornecedor
	 * @param fornecedor: nome do fornecedor
	 * @return a String dos produtos de determinado fornecedor
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		ValidaProduto.exibeFornecedor(fornecedor, fornecedores);
		return this.fornecedores.get(fornecedor).consultaProdutos(fornecedor);
	}
	
	/**
	 * Metodo que verifica se o produto esta cadastrado
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @return true se o produto estiver cadastrado, e false caso contrario
	 */
	public boolean existeProduto(String fornecedor, String nome, String descricao) {
		return fornecedores.get(fornecedor).existeProduto(nome, descricao);
	}
	
	/**
	 * Metodo que retorna o preco do produto
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @return o double do preco do produto
	 */
	public double getPrecoProdutoFornecedor(String fornecedor, String nome, String descricao) {
		return fornecedores.get(fornecedor).getPrecoProduto(nome, descricao);
	}
	/**
	 * Metodo que retorna o mapa dos fornecedores
	 * @return o mapa dos fornecedores
	 */
	public HashMap<String, Fornecedor> getFornecedores() {
		return this.fornecedores;
	}
	
	/**
	 * Metodo que adiciona uma compra
	 * @param nomeCliente: nome do cliente
	 * @param cpf: cpf do cliente
	 * @param fornecedor: nome do fornecedor
	 * @param data: data da compra
	 * @param nomeProduto: nome do produto
	 * @param descricaoProduto: descricao do produto
	 * @param preco: preco do produto
	 */
	public void cadastraCompra(String nomeCliente, String cpf, String fornecedor, String data, String nomeProduto, String descricaoProduto, double preco) {		
		this.fornecedores.get(fornecedor).adicionaCompra(nomeCliente, cpf, data, nomeProduto, descricaoProduto, preco);
	}
			
	/**
	 * Metodo que retorna o debito do cliente
	 * @param cpf: cpf do cliente
	 * @param fornecedor: nome do fornecedor
	 * @return a String do debito do cliente
	 */
	public String getDebito(String cpf, String fornecedor) {
		ValidaCompra.hasDebito(cpf, fornecedores.get(fornecedor).getContas());
		return this.fornecedores.get(fornecedor).getDebito(cpf);
	}
		
	/**
	 * Metodo que exibe a conta do cliente com determinado fornecedor.
	 * @param nomeCliente: nome do cliente
	 * @param cpf: cpf do cliente
	 * @param fornecedor: nome do fornecedor
	 * @return a String da conta do cliente com determinado fornecedor
	 */
	public String exibeContas(String nomeCliente, String cpf, String fornecedor) {
		return this.fornecedores.get(fornecedor).exibeContas(nomeCliente, cpf, fornecedor);
	}
		
	/**
	 * Metodo que exibe as contas dos clientes
	 * @param nomeCliente: nome do cliente
	 * @param cpf: cpf do cliente
	 * @return a String com as contas dos clientes
	 */
	public String exibeContasClientes(String nomeCliente, String cpf) {
		
		List<String> listaContas = new ArrayList<>();
		for (Fornecedor f: fornecedores.values()) {
			if (f.getContas().containsKey(cpf)) {
				listaContas.add(f.exibeContasClientes(nomeCliente, cpf, f.getNome()));				
			}
		}
		
		Collections.sort(listaContas);
		String msg = "Cliente: " + nomeCliente + " | " + String.join(" | ", listaContas);
		return msg;
	}
	
	/**
	 * Metodo que checa se o cliente tem conta 
	 * @param cpf: cpf do cliente
	 * @return true se tiver conta, false caso contrario
	 */
	public boolean hasContas(String cpf) {
		for (Fornecedor f: this.fornecedores.values()) {
			if (f.getContas().containsKey(cpf)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que define o criterio de ordenacao da listagem de todas as compras, 
	 * a partir de um criterio que sera usado como base para a ordenacao das compras.
	 * @param criterio: criterio de ordenacao da compras.
	 */
	public void ordenaPor(String criterio) {

		this.criterio = criterio;
		switch (criterio) {
		case "Cliente":
			ordenador = new CompraCliente();
			break;
		case "Fornecedor":
			ordenador = new CompraFornecedor();
			break;
		case "Data":
			ordenador = new CompraData();
			break;
		default:
			ValidaOrdenacao.defaultOutput();
		}
	}

	/**
	 * Metodo que retorna a representacao em string da lista de todas as compras
	 * @return a representacao em string da lista de todas as compras
	 */
	public String listarCompras() {
		ValidaOrdenacao.criterioNull(criterio);
		
		List<Compra> listaCompras = new ArrayList<>();
		for (Fornecedor c : fornecedores.values()) {
			for (Compra compra : c.getCompras()) {
				listaCompras.add(compra);
			}
		}
		Collections.sort(listaCompras, ordenador);
		
		List<String> stringCompras = new ArrayList<>();
		switch (this.criterio) {
		case "Cliente":
			for (Compra e : listaCompras) {
				stringCompras.add(e.exibeOrdenaCliente());
			}
			break;
		case "Fornecedor":
			for (Compra e : listaCompras) {
				stringCompras.add(e.exibeOrdenaFornecedor());
			}
			break;
		case "Data":
			for (Compra e : listaCompras) {
				stringCompras.add(e.exibeOrdenaData());
			}
			break;
		}
		String retorno = String.join(" | ", stringCompras);
		return retorno;
	}
	
}
