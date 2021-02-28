package fornecedor;

import java.util.HashMap;import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import produto.Combo;
import produto.Produto;
import utilidades.ComparatorProduto;
import utilidades.Util;

/**
 * Classe que representa um fornecedor do sistema
 * 
 * @author Beatriz Miranda - 119210170
 *
 */
public class Fornecedor {
	/**
	 * Nome do fornecedor
	 */
	private String nome;

	/**
	 * Email do fornecedor
	 */
	private String email;

	/**
	 * Telefone do fornecedor
	 */
	private String telefone;

	/**
	 * Hash map dos produtos que o fornecedor oferece sendo as chaves a concatena√ß√£o
	 * das String que representam o nome e descri√ß√£o do produto respectivamente, e
	 * os valores s√£o os objetos que representam os produtos
	 */
	private HashMap<String, Produto> produtos;

	/**
	 * ArrayList de Strings que s√£o a concatena√ß√£o do nome e descri√ß√£o dos produtos
	 */
	private ArrayList<String> produtosCadastrados;

	/**
	 * Comparator que compara dois produtos
	 */
	private Comparator<Produto> comparador;

	/**
	 * Constr√≥i um fornecedor dado seu nome, email e telefone
	 * 
	 * @param nome     Nome do fornecedor
	 * @param email    Email do fornecedor
	 * @param telefone Telefone do fornecedor
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;

		this.produtos = new HashMap<String, Produto>();
		this.produtosCadastrados = new ArrayList<String>();

		this.comparador = new ComparatorProduto();
	}

	/**
	 * Retorna a representa√ß√£o textual do fornecedor no formato "Nome" - "Email" -
	 * "Telefone"
	 */
	@Override
	public String toString() {
		return this.getNome() + " - " + this.getEmail() + " - " + this.getTelefone();
	}

	/**
	 * Compara dois fornecedores pelo nome
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Fornecedor) {
			Fornecedor f = (Fornecedor) o;

			if (this.getNome().equals(f.getNome())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gera o hashCode do fornecedor baseado no nome
	 */
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}

	/**
	 * Retorna o nome do fornecedor
	 * 
	 * @return String contendo o nome do fornecedor
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Retorna o telefone do fornecedor
	 * 
	 * @return String contendo o telefone do fornecedor
	 */
	private String getTelefone() {
		return this.telefone;
	}

	/**
	 * Retorna o email do fornecedor
	 * 
	 * @return String contendo o email do fornecedor
	 */
	private String getEmail() {
		return this.email;
	}

	/**
	 * Redefine o email do fornecedor dado o novo valor
	 * 
	 * @param email Novo email do fornecedor
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Redefine o telefone do fornecedor dado o novo valor
	 * 
	 * @param telefone Novo numero de telefone do fornecedor
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Adiciona um produto ao forncedor dado o nome, descricao e preco do produto
	 * 
	 * @param nome      Nome do produto
	 * @param descricao Descricao do produto
	 * @param preco     Preco do produto
	 */
	public void adicionaProduto(String nome, String descricao, double preco) {
		String key = nome + descricao;

		if (this.produtos.containsKey(key)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}

		this.produtos.put(key, new Produto(nome, descricao, preco));
		this.produtosCadastrados.add(key);

		for (int i = this.produtosCadastrados.size() - 1; i > 0; i--) {
			String produto1 = this.produtosCadastrados.get(i);
			String produto2 = this.produtosCadastrados.get(i - 1);

			Produto p1 = this.produtos.get(produto1);
			Produto p2 = this.produtos.get(produto2);

			int compare = this.comparador.compare(p1, p2);

			if (compare < 0) {
				Collections.swap(this.produtosCadastrados, i, i - 1);
			}
		}
	}

	/**
	 * Exibe um produto do fornecedor dado o nome e a descricao do produto
	 * 
	 * @param nome      Nome do produto
	 * @param descricao Descricao do produto
	 * @return Representa√ß√£o String do produto
	 */
	public String exibeProduto(String nome, String descricao) {
		if (!this.produtos.containsKey(nome + descricao)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}

		return this.produtos.get(nome + descricao).toString();
	}

	/**
	 * Lista todos os produtos do forncedor em ordem alfab√©tica do nome do produto
	 * 
	 * @return String contendo a lista de todos os produtos do fornecedor
	 */
	public String listaProdutos() {
		String retorno = this.getNome() + " -";

		for (int i = 0; i < this.produtosCadastrados.size(); i++) {
			String produto = this.produtosCadastrados.get(i);

			if (i == 0) {
				retorno += " " + this.produtos.get(produto).toString();
			}

			else {
				retorno += " | " + this.getNome() + " - " + this.produtos.get(produto).toString();
			}
		}

		return retorno;
	}

	/**
	 * Edita o preco de um produto do fornecedor dado o nome e descricao do produto
	 * e o novo preco
	 * 
	 * @param nome      Nome do produto
	 * @param descricao Descricao do produto
	 * @param novoPreco Novo preco do produto
	 */
	public void editaProduto(String nome, String descricao, double novoPreco) {
		String key = nome + descricao;

		if (!this.produtos.containsKey(key)) {
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		}

		this.produtos.get(key).modificaProduto(novoPreco);

	}

	/**
	 * Remove um produto do fornecedor
	 * 
	 * @param nome      Nome do produto
	 * @param descricao Descricao do produto
	 */
	public void removeProduto(String nome, String descricao) {
		String key = nome + descricao;

		if (!this.produtos.containsKey(key)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}

		this.produtos.remove(key);

		this.produtosCadastrados.remove(key);
	}

	/**
	 * Retorna o preco de um produto dado o nome e descricao do produto
	 * 
	 * @param nomeProduto      Nome do produto
	 * @param descricaoProduto Descricao do produto
	 * @return Preco do produto
	 */
	public double getPrecoProduto(String nomeProduto, String descricaoProduto) {
		if (!this.produtos.containsKey(nomeProduto + descricaoProduto)) {
			throw new IllegalArgumentException("Erro ao pegar preco do produto: produto nao existe.");
		}

		return this.produtos.get(nomeProduto + descricaoProduto).getPreco();
	}
	
	/**
	 * Consulta um produto a partir do seu nome e descricao
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @return objeto Produto
	 */
	public Produto consultaProduto(String nome, String descricao) {
		String key = nome + descricao;
		return produtos.get(key);
	}
	
	/**
	 * Adiciona um produto do tipo combo ao fornecedor.
	 * 
	 * @param nome È o nome do combo.
	 * @param descricao È a descriÁ„o do combo
	 * @param fator È o fator de desconto que o combo recebe.
	 * @param produtos s„o os produtos contidos no combo.
	 * 
	 * @return O nome e a descriÁ„o do combo concatenados.
	 */
	public void adicionaCombo(String nome, String descricao, double preco, double fator) {
		
		String key = nome + descricao;
		
		if (produtos.containsKey(key)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
		}
	
		this.produtos.put(key, new Combo(nome, descricao, preco, fator));
		this.produtosCadastrados.add(key);
		
		for (int i = this.produtosCadastrados.size() - 1; i > 0; i--) {
			String produto1 = this.produtosCadastrados.get(i);
			String produto2 = this.produtosCadastrados.get(i - 1);

			Produto p1 = this.produtos.get(produto1);
			Produto p2 = this.produtos.get(produto2);

			int compare = this.comparador.compare(p1, p2);

			if (compare < 0) {
				Collections.swap(this.produtosCadastrados, i, i - 1);
			}
		}
	}
	
	/**
	 * Permite a ediÁ„o de um combo.
	 * 
	 * @param nome È o nome do combo, que serve como identificador.
	 * @param descricao È a descriÁ„o do combo, que serve como identificador. 
	 * @param novoFator È o valor que ser· descontado do valor total do combo.
	 */
	public void editaCombo(String nome, String descricao, double novoFator) {
		
		Util.testaNull(nome, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		Util.testaVazio(nome, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		
		Util.testaNull(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		Util.testaVazio(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		
		if (novoFator <= 0 || novoFator >= 1) {
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
		}
		if (!this.produtos.containsKey(nome + descricao)) {
			throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");
		}
		
		Combo c = (Combo)this.produtos.get(nome +  descricao);
		c.setFator(novoFator);
	}
}
