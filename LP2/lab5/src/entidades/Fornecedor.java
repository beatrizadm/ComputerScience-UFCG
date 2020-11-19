package entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import controles.ControleProduto;
import validacao.ValidaCompra;

/**
 * Representacao de um fornecedor. Todo fornecedor precisa ter um nome, email e telefone.
 * 
 * @author Beatriz Miranda - 119210170
 *
 */
public class Fornecedor implements Comparable<Fornecedor>{
	
	/** nome do fornecedor **/
	private String nome;
	
	/** email do fornecedor **/
	private String email;
	
	/** telefone do fornecedor **/
	private String telefone;
	
	/** controle de produtos **/
	private ControleProduto produtos;
	
	/**
	 * Mapa com todas as contas do fronecedor com determinadoo cliente,
	 * identificadas unicamente pelo cpf do cliente.
	 */
	private HashMap<String, Conta> contas;
	
	/**
	 * Constroi um fornecedor
	 * @param nome: nome do fornecedor
	 * @param email: email do fornecedor
	 * @param telefone: telefone do fornecedor
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new ControleProduto();
		this.contas = new HashMap<String, Conta>();
	}
	
	/**
	 * Metodo que edita o email ou o telefone do fornecedor 
	 * @param atributo: nome do atributo a ser alterado
	 * @param novoValor: novo v para o atributo desejado
	 */
	public void editaFornecedor(String atributo, String novoValor) {
		if (atributo.equals("email")) {
			this.email = novoValor;
		} else if (atributo.equals("telefone")) {
			this.telefone = novoValor;
		}	
	}
	
	/**
	 * Metodo da interface comparable que é utilizado na ordenacao de fornecedores e
	 * utiliza o nome, email e telefone do fornecedor.
	 * @param obj: um fornecedor que vai ser comparado com o fornecedor atual.
	 * @return 1 se for igual e 0 se for diferente
	 */
	public int compareTo(Fornecedor obj) {
        if (nome.equals(obj.nome) && email.equals(obj.email) && telefone.equals(obj.telefone)) {
            return 1;
        } else {
            return 0;
        }
    }
	
	/**
	 * Metodo que retorna a string que representa o nome do fornecedor.
	 * @return nome do fornecedor
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Representacao em String de um fornecedor
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}
	
	/**
	 * Metodo que cadastra um produto
	 * @param nomeProduto: nome do produto
	 * @param descricaoProduto: descricao do produto
	 * @param precoProduto: preco do produto
	 */
	public void cadastraProduto(String nomeProduto, String descricaoProduto, double precoProduto) {
		this.produtos.cadastra(nomeProduto, descricaoProduto, precoProduto);
	}
	
	/**
	 * Metodo que consulta um produto
	 * @param nomeProduto: nome do produto
	 * @param descricaoProduto: descricao do produto
	 * @return a String do produto consultado
	 */
	public String consultaUmProduto(String nomeProduto, String descricaoProduto) {
		return this.produtos.consultaUmProduto(nomeProduto, descricaoProduto);
	}
	
	/**
	 * Metodo que consulta todos os produtos do fornecedor
	 * @param fornecedor: nome do fornecedor
	 * @return a String de todos os produtos do fornecedor
	 */
	public String consultaProdutos(String fornecedor) {
		return this.produtos.consultaProdutos(fornecedor);
	}
	
	/**
	 * Metodo que consulta todos os produtos de todos os fornecedores
	 * @return a String de todos os produtos de todos os fornecedores
	 */
	public String consultaProdutos() {
		return this.produtos.consultaProdutos();
	}
	
	
	/**
	 * Metodo que edita o preco de um produto
	 * @param nomeProduto: nome do produto
	 * @param descricaoProduto: descricao do produto
	 * @param novoPreco: novo preco que sera atribuido ao produto
	 */
	public void editaProduto(String nomeProduto, String descricaoProduto, double novoPreco) {
		this.produtos.editaProduto(nomeProduto, descricaoProduto, novoPreco);
	}
	
	/**
	 * Metodo que remove um produto
	 * @param nomeProduto: nome do produto
	 * @param descricaoProduto: descricao do produto
	 */
	public void removeProduto(String nomeProduto, String descricaoProduto) {
		this.produtos.removeProduto(nomeProduto, descricaoProduto);
	}
	
	/**
	 * Metodo que retorna o double do preco do produto
	 * @param nomeProduto: nome do produto
	 * @param descricaoProduto: descricao do produto
	 * @return o double do preco do produto
	 */
	public double getPrecoProduto(String nomeProduto, String descricaoProduto) {
		return produtos.getPrecoProduto(nomeProduto, descricaoProduto);
	}
	
	/**
	 * Metodo que verifica se o produto esta cadastrado
	 * @param nomeProduto: nome do produto
	 * @param descricaoProduto: descricao do produto
	 * @return true se o produto estiver cadastrado, e false caso contrario
	 */
	public boolean existeProduto(String nomeProduto, String descricaoProduto) {
		return produtos.existeProduto(nomeProduto, descricaoProduto);
	}
	
	/**
	 * Metodo que retorna os produtos do fornecedor.
	 * @return produtos do fornecedor
	 */
	public ControleProduto getProdutos() {
		return this.produtos;
	}
	
	/**
	 * Metodo que adiciona uma compra
	 * @param nomeCliente: nome do cliente
	 * @param cpf: cpf do cliente
	 * @param data: data da compra
	 * @param nomeProduto: nome do produto
	 * @param descricaoProduto: descricao do produto
	 * @param preco: preco do produto
	 */
	public void adicionaCompra(String nomeCliente, String cpf, String data, String nomeProduto, String descricaoProduto, double preco) {
		if (!contas.containsKey(cpf)) {
			contas.put(cpf, new Conta(cpf));			
		}
		contas.get(cpf).adicionaCompra(nomeCliente, cpf, nome, nomeProduto, descricaoProduto, data, preco);
	}

	/**
	 * Metodo que retorna o debito do cliente
	 * @param cpf: cpf do cliente
	 * @return o debito do cliente
	 */
	public String getDebito(String cpf) {
		return contas.get(cpf).exibeDebito();
	}
	
	/**
	 * Metodo que exibe as contas dos clientes
	 * @param nomeCliente: nome do cliente
	 * @param cpf: cpf do cliente
	 * @param fornecedor: nome do fornecedor
	 * @return a String com as contas dos clientes
	 */
	public String exibeContasClientes(String nomeCliente, String cpf, String fornecedor) {
		List<Conta> listaContas = new ArrayList<>(contas.values());
		
		List<String> toStringDasContas = new ArrayList<String>();
		for (Conta conta : listaContas) {
			if (conta.getQtdCompras() != 0 && contas.containsKey(cpf) && contas.get(cpf).equals(conta)) {
				toStringDasContas.add(conta.toString(fornecedor));				
			}
		}
		String msg = String.join(" | ", toStringDasContas);
		return msg;
	}
	
	/**
	 * Metodo que exibe a conta do cliente com determinado fornecedor.
	 * @param nomeCliente: nome do cliente
	 * @param cpf: cpf do cliente
	 * @param fornecedor: nome do fornecedor
	 * @return a String da conta do cliente com determinado fornecedor
	 */
	public String exibeContas(String nomeCliente, String cpf, String fornecedor) {
		ValidaCompra.exibeTemFornecedor(cpf, contas);
		
		String retorno = "Cliente: " + nomeCliente + " | ";
		retorno += contas.get(cpf).toString(fornecedor);
		return retorno;
	}
	
	/**
	 * Metodo que retorna a lista de todas as compras
	 * @return a lista de todas as compras
	 */
	public List<Compra> getCompras() {
		List<Compra> compras = new ArrayList<>();
		for (Conta e : contas.values()) {
			for (Compra compra : e.getCompras()) {
				compras.add(compra);
			}
		}
		return compras;
	}
	
	/**
	 * Metodo que retorna o mapa das contas
	 * @return o mapa das contas
	 */
	public HashMap<String, Conta> getContas() {
		return this.contas;
	}

	/**
	 * Retorna um inteiro que representa um fornecedor.
	 * @return um inteiro que representa um fornecedor.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/**
	 * Metodo que verifica a se dois fornecedores sao iguais. Retorna um valor
	 * booleano verdade caso sejam iguais, caso contrario retorna falso. Para dois
	 * fornecedores serem iguais eles devem possuir o mesmo nome, email e telefone.
	 * @return Retorna um valor booleano verdade caso os fornecedores sejam iguais,
	 *         caso contrario retorna falso.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}	
}
