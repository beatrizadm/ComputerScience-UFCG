package validacao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Cliente;

class TesteValidaCliente {

	private HashMap<String, Cliente> clientes;
	
	@BeforeEach
	public void initValidaCliente() {
		this.clientes = new HashMap<>();
		clientes.put("12345678910", new Cliente("Marcos", "marcos@gmail.com", "33158895"));
	}
	
	@Test
	public void testCadastroCPF() {
		ValidaCliente.cadastroCPF("12353894753", clientes);
		
		try {
			ValidaCliente.cadastroCPF(" ", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCliente.cadastroCPF(null, clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCliente.cadastroCPF("123", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: cpf invalido.", e.getMessage());
		}	
		
		try {
			ValidaCliente.cadastroCPF("12345678910", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: cliente ja existe.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastroNome() {
		ValidaCliente.cadastroNome("Beatriz");
		
		try {
			ValidaCliente.cadastroNome(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCliente.cadastroNome(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastroEmail() {
		ValidaCliente.cadastroEmail("beatriz@gmail.com");
		
		try {
			ValidaCliente.cadastroEmail(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCliente.cadastroEmail(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastroLocal() {
		ValidaCliente.cadastroLocal("Analytics");
		
		try {
			ValidaCliente.cadastroLocal(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", e.getMessage());
		}
		
		try {
			ValidaCliente.cadastroLocal(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testExibe() {
		ValidaCliente.exibe("12345678910", clientes);
		
		try {
			ValidaCliente.exibe("", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCliente.exibe(null, clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCliente.exibe("99999999999", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao do cliente: cliente nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaCPF() {
		ValidaCliente.editaCPF("12345678910", clientes);
		
		try {
			ValidaCliente.editaCPF("", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCliente.editaCPF(null, clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCliente.editaCPF("99999999999", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do cliente: cliente nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaAtributo() {
		ValidaCliente.editaAtributo("localizacao");
		
		try {
			ValidaCliente.editaAtributo(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCliente.editaAtributo(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCliente.editaAtributo("cpf");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do cliente: cpf nao pode ser editado.", e.getMessage());
		}
		
		try {
			ValidaCliente.editaAtributo("alfdksn");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do cliente: atributo nao existe.", e.getMessage());
		}	
	}
	
	@Test
	public void testEditaNovoValor() {
		ValidaCliente.editaNovoValor("Analytics");
		
		try {
			ValidaCliente.editaNovoValor(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCliente.editaNovoValor(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testRemove() {
		ValidaCliente.remove("12345678910", clientes);
		
		try {
			ValidaCliente.remove("", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo", e.getMessage());
		}
		
		try {
			ValidaCliente.remove(null, clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo", e.getMessage());
		}
		
		try {
			ValidaCliente.remove("99999999999", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao do cliente: cliente nao existe.", e.getMessage());
		}
	}
	
}
