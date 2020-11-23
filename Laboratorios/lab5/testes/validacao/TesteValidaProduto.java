package validacao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Fornecedor;
import entidades.IdProduto;
import entidades.Produto;


class TesteValidaProduto {

	private HashMap<IdProduto, Produto> produtos;
	private HashMap<String, Fornecedor> fornecedores;
	
	@BeforeEach
	public void initValidaProduto() {
		this.produtos = new HashMap<>();
		IdProduto idProduto = new IdProduto("X-bacon", "Hamburguer com bacon");
		this.produtos.put(idProduto, new Produto("X-bacon", "Hamburguer com bacon", 9.0));
		
		this.fornecedores = new HashMap<String, Fornecedor>();
		this.fornecedores.put("Marcos", new Fornecedor("Marcos", "marcos@gmail.com", "33106000"));
	}
	
	@Test
	public void testCadastraProduto() {
		IdProduto idProduto = new IdProduto("X-franbacon", "Hamburguer com frango e bacon");
		ValidaProduto.cadastroProduto(idProduto, produtos);
		try {
			IdProduto idProduto1 = new IdProduto("X-bacon", "Hamburguer com bacon");
			ValidaProduto.cadastroProduto(idProduto1, produtos);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: produto ja existe.", e.getMessage());
		}
	}
	
	@Test
	public void testExibe() {
		ValidaProduto.cadastroFornecedor("Marcos", fornecedores);
		
		try {
			ValidaProduto.cadastroFornecedor("", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaProduto.cadastroFornecedor(null, fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaProduto.cadastroFornecedor("Dona Fran", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastroNome() {
		ValidaProduto.cadastroNome("X-tudo");
		
		try {
			ValidaProduto.cadastroNome(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaProduto.cadastroNome(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastroDescricao() {
		ValidaProduto.cadastroDescricao("Hamburguer completo");
		
		try {
			ValidaProduto.cadastroDescricao(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
		
		try {
			ValidaProduto.cadastroDescricao(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastroPreco() {
		ValidaProduto.cadastroPreco(0.0);
		
		try {
			ValidaProduto.cadastroPreco(-8);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: preco invalido.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProduto() {
		IdProduto idProduto1 = new IdProduto("X-bacon", "Hamburguer com bacon");
		ValidaProduto.exibeProduto(idProduto1, produtos);
		try {
			IdProduto idProduto = new IdProduto("X-franbacon", "Hamburguer com frango e bacon");
			ValidaProduto.exibeProduto(idProduto, produtos);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: produto nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeFornecedor() {
		ValidaProduto.exibeFornecedor("Marcos", fornecedores);
		
		try {
			ValidaProduto.exibeFornecedor("", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaProduto.exibeFornecedor(null, fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaProduto.exibeFornecedor("Dona Fran", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeNome() {
		ValidaProduto.exibeNome("X-tudo");
		
		try {
			ValidaProduto.exibeNome(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaProduto.exibeNome(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeDescricao() {
		ValidaProduto.exibeDescricao("Hamburguer com tudo que tem direito");
		
		try {
			ValidaProduto.exibeDescricao(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
		
		try {
			ValidaProduto.exibeDescricao(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaProduto() {
		IdProduto idProduto1 = new IdProduto("X-bacon", "Hamburguer com bacon");
		ValidaProduto.editaProduto(idProduto1, produtos);
		try {
			IdProduto idProduto = new IdProduto("X-franbacon", "Hamburguer com frango e bacon");
			ValidaProduto.editaProduto(idProduto, produtos);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: produto nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaFornecedor() {
		ValidaProduto.editaFornecedor("Marcos", fornecedores);
		
		try {
			ValidaProduto.editaFornecedor("", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaProduto.editaFornecedor(null, fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaProduto.editaFornecedor("Dona Fran", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaNome() {
		ValidaProduto.editaNome("X-tudo");
		
		try {
			ValidaProduto.editaNome(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaProduto.editaNome(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaDescricao() {
		ValidaProduto.editaDescricao("Hamburguer com tudo que tem direito");
		
		try {
			ValidaProduto.editaDescricao(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
		
		try {
			ValidaProduto.editaDescricao(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaPreco() {
		ValidaProduto.editaPreco(0.0);
		
		try {
			ValidaProduto.editaPreco(-8);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: preco invalido.", e.getMessage());
		}
	}

	@Test
	public void testRemoveProduto() {
		IdProduto idProduto1 = new IdProduto("X-bacon", "Hamburguer com bacon");
		ValidaProduto.removeProduto(idProduto1, produtos);
		try {
			IdProduto idProduto = new IdProduto("X-franbacon", "Hamburguer com frango e bacon");
			ValidaProduto.removeProduto(idProduto, produtos);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao de produto: produto nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveFornecedor() {
		ValidaProduto.removeFornecedor("Marcos", fornecedores);
		
		try {
			ValidaProduto.removeFornecedor("", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaProduto.removeFornecedor(null, fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaProduto.removeFornecedor("Dona Fran", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao de produto: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveNome() {
		ValidaProduto.removeNome("X-tudo");
		
		try {
			ValidaProduto.removeNome(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaProduto.removeNome(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveDescricao() {
		ValidaProduto.removeDescricao("Hamburguer com tudo que tem direito");
		
		try {
			ValidaProduto.removeDescricao(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
		
		try {
			ValidaProduto.removeDescricao(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}

}
