package validacao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Fornecedor;

class TesteValidaFornecedor {

	private HashMap<String, Fornecedor> fornecedores;
	
	@BeforeEach
	public void initValidaFornecedor() {
		this.fornecedores = new HashMap<>();
		fornecedores.put("Beatriz", new Fornecedor("Marcos", "marcos@gmail.com", "33158895"));
	}
	
	@Test
	public void testCadastroNome() {
		ValidaFornecedor.cadastroNome("Ana", fornecedores);
		
		try {
			ValidaFornecedor.cadastroNome(" ", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaFornecedor.cadastroNome(null, fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaFornecedor.cadastroNome("Beatriz", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de fornecedor: fornecedor ja existe.", e.getMessage());
		}	
	}
	
	@Test
	public void testCadastroEmail() {
		ValidaFornecedor.cadastroEmail("beatriz@gmail.com");
		
		try {
			ValidaFornecedor.cadastroEmail(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaFornecedor.cadastroEmail(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastroTelefone() {
		ValidaFornecedor.cadastroTelefone("33106000");
		
		try {
			ValidaFornecedor.cadastroTelefone(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaFornecedor.cadastroTelefone(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibe() {
		ValidaFornecedor.exibe("Beatriz", fornecedores);
		
		try {
			ValidaFornecedor.exibe("", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaFornecedor.exibe(null, fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaFornecedor.exibe("Ana", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao do fornecedor: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaNome() {
		ValidaFornecedor.editaNome("Beatriz", fornecedores);
		
		try {
			ValidaFornecedor.editaNome("", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaFornecedor.editaNome(null, fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaFornecedor.editaNome("Ana", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do fornecedor: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaAtributo() {
		ValidaFornecedor.editaAtributo("telefone");
		
		try {
			ValidaFornecedor.editaAtributo(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaFornecedor.editaAtributo(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaFornecedor.editaAtributo("nome");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do fornecedor: nome nao pode ser editado.", e.getMessage());
		}
		
		try {
			ValidaFornecedor.editaAtributo("aksjfdad");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do fornecedor: atributo nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaNovoValor() {
		ValidaFornecedor.editaNovoValor("10.0");
		
		try {
			ValidaFornecedor.editaNovoValor(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaFornecedor.editaNovoValor(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testRemove() {
		ValidaFornecedor.remove("Beatriz", fornecedores);
		
		try {
			ValidaFornecedor.remove("", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaFornecedor.remove(null, fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaFornecedor.remove("Ana", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao do fornecedor: fornecedor nao existe.", e.getMessage());
		}
	}
	
}
