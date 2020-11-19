package controles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import entidades.IdProduto;
import entidades.Produto;
import validacao.ValidaProduto;

/**
 * Representacao do controle do produto.
 * 
 * @author Beatriz Miranda - 119210170
 *
 */
public class ControleProduto {
	
	/**
	 * Mapa com todos os produtos,
	 * identificados unicamente pelo nome IdProduto.
	 */
	private HashMap<IdProduto, Produto> produtos;
	
	/**
	 * Constroi o controle do produto
	 */
	public ControleProduto() {
		this.produtos = new HashMap<IdProduto, Produto>();
	}
	
	/**
	 * Metodo que adiciona um produto no sistema
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @param preco: preco do produto
	 */
	public void cadastra(String nome, String descricao, double preco) {
		ValidaProduto.cadastroNome(nome);
		ValidaProduto.cadastroDescricao(descricao);
		ValidaProduto.cadastroPreco(preco);
		IdProduto idProduto = new IdProduto(nome, descricao);
		ValidaProduto.cadastroProduto(idProduto, produtos);
		this.produtos.put(idProduto, new Produto(nome, descricao, preco));
	}
	
	/**
	 * Metodo que exibe um produto
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @return a String do produto
	 */
	public String consultaUmProduto(String nome, String descricao) {
		ValidaProduto.exibeNome(nome);
		ValidaProduto.exibeDescricao(descricao);
		IdProduto idProduto = new IdProduto(nome, descricao);
		ValidaProduto.exibeProduto(idProduto, produtos);
		return this.produtos.get(idProduto).toString();
	}
	
	/**
	 * Metodo que edita o preco de um produto
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @param novoPreco: novo preco a ser atribuido no produto
	 */
	public void editaProduto(String nome, String descricao, double novoPreco) {
		ValidaProduto.editaNome(nome);
		ValidaProduto.editaDescricao(descricao);
		ValidaProduto.editaPreco(novoPreco);
		IdProduto idProduto = new IdProduto(nome, descricao);
		ValidaProduto.editaProduto(idProduto, produtos);
		this.produtos.get(idProduto).editaPreco(novoPreco);
	}
	
	/**
	 * Metodo que remove um produto
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 */
	public void removeProduto(String nome, String descricao) {
		ValidaProduto.removeNome(nome);
		ValidaProduto.removeDescricao(descricao);
		IdProduto idProduto = new IdProduto(nome, descricao);
		ValidaProduto.removeProduto(idProduto, produtos);
		this.produtos.remove(idProduto);
	}
	
	/**
	 * Metodo que exibe os produtos de determinado fornecedor
	 * @param fornecedor: nome do fornecedor
	 * @return a String dos produtos de determinado fornecedor
	 */
	public String consultaProdutos(String fornecedor) {
		
		String retorno = "";
		ArrayList<Produto> values = new ArrayList<Produto>(produtos.values());
		if(values.size() == 0) {
			return fornecedor + " -";
		}
		Collections.sort(values);
		for (int i=0; i < values.size(); i++) {
			if (i == values.size() - 1) {
				retorno += fornecedor + " - " + values.get(i).toString();
			} else {
				retorno += fornecedor + " - " + values.get(i).toString() + " | ";
			}
		}
		return retorno;
	}
	
	/**
	 * Metodo que exibe todos os produtos
	 * @return a String dos produtos
	 */
	public String consultaProdutos() {
		String retorno = "";
		ArrayList<Produto> values = new ArrayList<Produto>(produtos.values());
		for (int i=0; i < values.size(); i++) {
			if (i == values.size() - 1) {
				retorno += values.get(i).toString();
			} else {
				retorno += values.get(i).toString() + " | ";
			}
		}
		return retorno;
	}
	
	/**
	 * Representacao em String dos produtos
	 */
	@Override
	public String toString() {
		ArrayList<String> sortedProdutos = new ArrayList<>();
		for (Produto produto : this.produtos.values()) {
		    sortedProdutos.add(produto.toString());
		}
		Collections.sort(sortedProdutos);
		String msg = String.join(" | ", sortedProdutos);
		return msg;
	}
	
	/**
	 * Metodo que retorna o preco do produto
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @return o double do preco do produto
	 */
	public double getPrecoProduto(String nome, String descricao) {
		IdProduto idProduto = new IdProduto(nome, descricao);
		return produtos.get(idProduto).getPreco();
	}
	
	/**
	 * Metodo que verifica se o produto esta cadastrado
	 * @param nome: nome do produto
	 * @param descricao: descricao do produto
	 * @return true se o produto estiver cadastrado, e false caso contrario
	 */
	public boolean existeProduto(String nome, String descricao) {
		IdProduto idProduto = new IdProduto(nome, descricao);
		return produtos.containsKey(idProduto);
	}
	
	
}
