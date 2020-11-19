package validacao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Cliente;
import entidades.Conta;
import entidades.Fornecedor;

class TesteValidaCompra {

	private HashMap<String, Cliente> clientes;
	private HashMap<String, Fornecedor> fornecedores;
	private HashMap<String, Conta> contas;
	
	@BeforeEach
	public void initValidaCompra() {
		this.clientes = new HashMap<>();
		clientes.put("12345678910", new Cliente("Marcos", "marcos@gmail.com", "33158895"));
		
		this.fornecedores = new HashMap<String, Fornecedor>();
		this.fornecedores.put("Marcos", new Fornecedor("Marcos", "marcos@gmail.com", "33106000"));
		
		this.contas = new HashMap<>();
		this.contas.put("12345678910", new Conta("Beatriz"));
	}
	
	
	@Test
	public void testCadastroCPF() {
		ValidaCompra.cadastroCPF("12345678910", clientes);
		
		try {
			ValidaCompra.cadastroCPF(" ", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCompra.cadastroCPF(null, clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCompra.cadastroCPF("123", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: cpf invalido.", e.getMessage());
		}	
		
		try {
			ValidaCompra.cadastroCPF("12345678919", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: cliente nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testExibe() {
		ValidaCompra.cadastroFornecedor("Marcos", fornecedores);
		
		try {
			ValidaCompra.cadastroFornecedor("", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCompra.cadastroFornecedor(null, fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCompra.cadastroFornecedor("Dona Fran", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: fornecedor nao existe.", e.getMessage());
		}
	}
	
	// cadastro data
	@Test
	public void testCadastroData() {
		ValidaCompra.cadastroData("19/11/2020");
		
		try {
			ValidaCompra.cadastroData(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: data nao pode ser vazia ou nula.", e.getMessage());
		}
		
		try {
			ValidaCompra.cadastroData(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: data nao pode ser vazia ou nula.", e.getMessage());
		}
		
		try {
			ValidaCompra.cadastroData("12345");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: data invalida.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastroNome() {
		ValidaCompra.cadastroNome("X-tudo");
		
		try {
			ValidaCompra.cadastroNome(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCompra.cadastroNome(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastroDescricao() {
		ValidaCompra.cadastroDescricao("Hamburguer completo");
		
		try {
			ValidaCompra.cadastroDescricao(" ");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.", e.getMessage());
		}
		
		try {
			ValidaCompra.cadastroDescricao(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testExisteProduto() {
		ValidaCompra.existeProduto(true);
		
		try {
			ValidaCompra.existeProduto(false);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: produto nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testDebitoFornecedor() {
		ValidaCompra.debitoFornecedor("Marcos", fornecedores);
		
		try {
			ValidaCompra.debitoFornecedor("", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCompra.debitoFornecedor(null, fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCompra.debitoFornecedor("Ze", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao recuperar debito: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testDebitoCPF() {
		ValidaCompra.debitoCPF("12345678910", clientes);
		
		try {
			ValidaCompra.debitoCPF("", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCompra.debitoCPF(null, clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCompra.debitoCPF("78297645", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao recuperar debito: cpf invalido.", e.getMessage());
		}
		
		try {
			ValidaCompra.debitoCPF("09876543212", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao recuperar debito: cliente nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testHasDebito() {
		ValidaCompra.hasDebito("12345678910", contas);
		
		try {
			ValidaCompra.hasDebito("", contas);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao recuperar debito: cliente nao tem debito com fornecedor.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeFornecedor() {
		ValidaCompra.exibeFornecedor("Marcos", fornecedores);
		
		try {
			ValidaCompra.exibeFornecedor("", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCompra.exibeFornecedor(null, fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
				
		try {
			ValidaCompra.exibeFornecedor("Dona Fran", fornecedores);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir conta do cliente: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeCPF() {
		ValidaCompra.exibeCPF("12345678910", clientes);
		
		try {
			ValidaCompra.exibeCPF("", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCompra.exibeCPF(null, clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCompra.exibeCPF("78297645", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir conta do cliente: cpf invalido.", e.getMessage());
		}
		
		try {
			ValidaCompra.exibeCPF("09876543212", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir conta do cliente: cliente nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testHasDebitoExibeTemFornecedor() {
		ValidaCompra.exibeTemFornecedor("12345678910", contas);
		
		try {
			ValidaCompra.exibeTemFornecedor("", contas);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.", e.getMessage());
		}
	}
	
	@Test
	public void testDebitoExibeCPFs() {
		ValidaCompra.exibeCPFs("12345678910", clientes);
		
		try {
			ValidaCompra.exibeCPFs("", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCompra.exibeCPFs(null, clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaCompra.exibeCPFs("78297645", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir contas do cliente: cpf invalido.", e.getMessage());
		}
		
		try {
			ValidaCompra.exibeCPFs("09876543212", clientes);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir contas do cliente: cliente nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testHasConta() {
		ValidaCompra.hasConta(true);
		
		try {
			ValidaCompra.hasConta(false);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.", e.getMessage());
		}
	}
	

}
