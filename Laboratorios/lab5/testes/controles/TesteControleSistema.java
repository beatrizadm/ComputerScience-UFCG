package controles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteControleSistema {

	private ControleSistema controle;
	
	@BeforeEach
	public void initControleSistema() {
		this.controle = new ControleSistema();
		controle.adicionaCliente("12345678910", "Beatriz", "beatriz@gmail.com", "Analytics");
		controle.adicionaCliente("12345678988", "Joao", "joao@gmail.com", "LSD");
		controle.adicionaFornecedor("Marcos", "marcos@gmail.com", "33221090");
		controle.adicionaFornecedor("Dona Fran", "fran@gmail.com", "33221999");
		controle.adicionaProduto("Marcos", "X-tudo", "Hamburguer a moda da casa", 12.0);
		controle.adicionaProduto("Dona Fran", "X-frango", "Hamburguer de frango", 9.0);
		controle.adicionaCompra("12345678910", "Marcos", "18/11/2020", "X-tudo", "Hamburguer a moda da casa");
		controle.adicionaCompra("12345678988", "Dona Fran", "18/11/2020", "X-frango", "Hamburguer de frango");
	}

	@Test
	public void testAdicionaCliente() {
		assertEquals("12345678912", controle.adicionaCliente("12345678912", "Joao", "joao@gmail.com", "LSD"));
	}
	
	@Test
	public void testExibeCliente() {
		assertEquals("Beatriz - Analytics - beatriz@gmail.com", controle.exibeCliente("12345678910"));
	}
	
	@Test
	public void testEditaCliente() {
		controle.editaCliente("12345678910", "email", "beatriz123@gmail.com");
		assertEquals("Beatriz - Analytics - beatriz123@gmail.com", controle.exibeCliente("12345678910"));
	}
	
	@Test
	public void testRemoveCliente() {
		controle.removeCliente("12345678910");
		try {
			controle.exibeCliente("12345678910");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao do cliente: cliente nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaFornecedor() {
		assertEquals("Joao", controle.adicionaFornecedor("Joao", "joao@gmail.com", "33991033"));
	}

	@Test
	public void testEditaFornecedor() {
		controle.editaFornecedor("Marcos", "telefone", "33221000");
		assertEquals("Marcos - marcos@gmail.com - 33221000", controle.exibeFornecedor("Marcos"));
	}
	
	@Test
	public void testExibeFornecedor() {
		assertEquals("Marcos - marcos@gmail.com - 33221090", controle.exibeFornecedor("Marcos"));
	}
	
	@Test
	public void testRemoveFornecedor() {
		controle.removeFornecedor("Marcos");
		try {
			controle.exibeFornecedor("Marcos");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao do fornecedor: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaProduto() {
		controle.adicionaProduto("Marcos", "X-frango", "Hamburguer de frango", 9.0);
		assertEquals("X-frango - Hamburguer de frango - R$9,00", controle.exibeProduto("X-frango", "Hamburguer de frango", "Marcos"));
	}
	
	@Test
	public void testExibeProduto() {
		assertEquals("X-tudo - Hamburguer a moda da casa - R$12,00", controle.exibeProduto("X-tudo", "Hamburguer a moda da casa", "Marcos"));
	}
	
	@Test
	public void testEditaProduto() {
		controle.editaProduto("X-tudo", "Hamburguer a moda da casa", "Marcos", 9.0);
		assertEquals("X-tudo - Hamburguer a moda da casa - R$9,00", controle.exibeProduto("X-tudo", "Hamburguer a moda da casa", "Marcos"));
	}
	
	@Test
	public void testRemoveProduto() {
		controle.removeProduto("X-tudo", "Hamburguer a moda da casa", "Marcos");
		try {
			controle.exibeProduto("X-tudo", "Hamburguer a moda da casa", "Marcos");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: produto nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeClientes() {
		assertEquals("Beatriz - Analytics - beatriz@gmail.com | Joao - LSD - joao@gmail.com", controle.exibeClientes());
	}
	
	@Test
	public void testExibeFornecedores() {
		assertEquals("Dona Fran - fran@gmail.com - 33221999 | Marcos - marcos@gmail.com - 33221090", controle.exibeFornecedores());
	}
	
	@Test
	public void testExibeProdutos1() {
		assertEquals("Dona Fran - X-frango - Hamburguer de frango - R$9,00 | Marcos - X-tudo - Hamburguer a moda da casa - R$12,00", controle.exibeProdutos());
	}
	
	@Test
	public void testExibeProdutos2() {
		assertEquals("Marcos - X-tudo - Hamburguer a moda da casa - R$12,00", controle.exibeProdutos("Marcos"));
	}
	
	@Test
	public void testExibeProdutosFornecedor1() {
		assertEquals("Marcos - X-tudo - Hamburguer a moda da casa - R$12,00", controle.exibeProdutosFornecedor("Marcos"));
	}
	
	@Test
	public void testExibeProdutosFornecedor2() {
		assertEquals("Dona Fran - X-frango - Hamburguer de frango - R$9,00 | Marcos - X-tudo - Hamburguer a moda da casa - R$12,00", controle.exibeProdutosFornecedor());
	}
	
	@Test
	public void testAdicionaCompra() {
		controle.adicionaCompra("12345678988", "Marcos", "18/11/2020", "X-tudo", "Hamburguer a moda da casa");
		assertEquals("Cliente: Joao | Marcos | X-tudo - 18-11-2020", controle.exibeContas("12345678988", "Marcos"));
	}
	
	@Test
	public void testGetDebito() {
		assertEquals("12.00", controle.getDebito("12345678910", "Marcos"));
	}
	
	@Test
	public void testExibeContas() {
		assertEquals("Cliente: Beatriz | Marcos | X-tudo - 18-11-2020", controle.exibeContas("12345678910", "Marcos"));
	}
	
	@Test
	public void testExibeContasClientes() {
		assertEquals("Cliente: Beatriz | Marcos | X-tudo - 18-11-2020", controle.exibeContasClientes("12345678910"));
	}
	
	
	@Test
	public void testOrdenaELista() {
		controle.ordenaPor("Data");
		assertEquals("18/11/2020, Beatriz, Marcos, Hamburguer a moda da casa | 18/11/2020, Joao, Dona Fran, Hamburguer de frango", controle.listarCompras());
	}
	
	
}
