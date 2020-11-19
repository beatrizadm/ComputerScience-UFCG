package controles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Fornecedor;

class TesteControleFornecedor {

	private ControleFornecedor controle;
	
	@BeforeEach
	public void initControleFornecedor() {
		this.controle = new ControleFornecedor();
		this.controle.cadastraFornecedor("Dona Fran", "fran@gmail.com", "33106089");
		this.controle.cadastraProduto("Dona Fran", "X-tudo", "Hamburguer com tudo que tem direito", 10.0);
		this.controle.cadastraCompra("Beatriz", "12345678910", "Dona Fran", "18/11/2020", "X-tudo", "Hamburguer com tudo que tem direito", 10.0);
	}
	
	@Test
	public void testCadastraFornecedor() {
		assertEquals("Marcos", controle.cadastraFornecedor("Marcos", "marcos@gmail.com", "33106000"));
	}
	
	@Test
	public void testEditaFornecedor() {
		controle.editaFornecedor("Dona Fran", "email", "fran123@gmail.com");
		assertEquals("Dona Fran - fran123@gmail.com - 33106089", controle.exibeFornecedor("Dona Fran"));
	}
	
	@Test
	public void testRemoveFornecedor() {
		controle.removeFornecedor("Dona Fran");
		assertEquals("", controle.exibeFornecedores());
	}
	
	@Test
	public void testExibeFornecedor() {
		assertEquals("Dona Fran - fran@gmail.com - 33106089", controle.exibeFornecedor("Dona Fran"));
	}
	
	@Test
	public void testExibeFornecedores() {
		controle.cadastraFornecedor("Marcos", "marcos@gmail.com", "33106000");
		assertEquals("Dona Fran - fran@gmail.com - 33106089 | Marcos - marcos@gmail.com - 33106000", controle.exibeFornecedores());
	}
	
	@Test
	public void testGetClientFornecedores() {
		HashMap<String, Fornecedor> map = new HashMap();
		map.put("Dona Fran", new Fornecedor("Dona Fran", "fran@gmail.com", "33106089"));
		assertEquals(map, controle.getFornecedores());
	}
	
	@Test
	public void testGetPrecoProdutoFornecedor() {
		assertEquals(10.0, controle.getPrecoProdutoFornecedor("Dona Fran", "X-tudo", "Hamburguer com tudo que tem direito"));
	}
	
	@Test
	public void testCadastraProduto() {
		controle.cadastraProduto("Dona Fran", "X-frango", "Hamburguer de frango", 9.0);
		assertEquals("X-frango - Hamburguer de frango - R$9,00", controle.exibeUmProduto("X-frango", "Hamburguer de frango", "Dona Fran"));
	}
	
	@Test
	public void testExibeUmProduto() {
		assertEquals("X-tudo - Hamburguer com tudo que tem direito - R$10,00", controle.exibeUmProduto("X-tudo", "Hamburguer com tudo que tem direito", "Dona Fran"));
	}
	
	@Test
	public void testExibeProdutosFornecedor() {
		assertEquals("Dona Fran - X-tudo - Hamburguer com tudo que tem direito - R$10,00", controle.exibeProdutosFornecedor("Dona Fran"));
	}
	
	@Test
	public void testExibeProdutosFornecedores() {
		this.controle.cadastraFornecedor("Marcos", "marcos@gmail.com", "33106000");
		controle.cadastraProduto("Marcos", "X-frango", "Hamburguer de frango", 9.0);
		assertEquals("Dona Fran - X-tudo - Hamburguer com tudo que tem direito - R$10,00 | Marcos - X-frango - Hamburguer de frango - R$9,00", controle.exibeProdutosFornecedores());
	}
	
	@Test
	public void testEditaProduto() {
		controle.editaProduto("X-tudo", "Hamburguer com tudo que tem direito", "Dona Fran", 9.0);
		assertEquals("X-tudo - Hamburguer com tudo que tem direito - R$9,00", controle.exibeUmProduto("X-tudo", "Hamburguer com tudo que tem direito", "Dona Fran"));
	}
	
	@Test
	public void testRemoveProduto() {
		controle.removeProduto("X-tudo", "Hamburguer com tudo que tem direito", "Dona Fran");
		assertEquals("Dona Fran -", controle.exibeProdutosFornecedores());
	}
	
	@Test
	public void testExisteProduto() {
		assertEquals(true, controle.existeProduto("Dona Fran", "X-tudo", "Hamburguer com tudo que tem direito"));
	}
	
	@Test
	public void testCadastraCompra() {
		controle.cadastraCompra("Joao", "12345678912", "Dona Fran", "18/11/2020", "X-bacon", "Hamburguer com bacon", 11.0);
		assertEquals("Cliente: Joao | Dona Fran | X-bacon - 18-11-2020", controle.exibeContasClientes("Joao", "12345678912"));
	}
	
	@Test
	public void testGetDebito() {
		assertEquals("10.00", controle.getDebito("12345678910", "Dona Fran"));
	}
	
	@Test
	public void testExibeContas() {
		assertEquals("Cliente: Beatriz | Dona Fran | X-tudo - 18-11-2020", controle.exibeContas("Beatriz", "12345678910", "Dona Fran"));
	}

	@Test
	public void testExibeContasClientes() {
		assertEquals("Cliente: Beatriz | Dona Fran | X-tudo - 18-11-2020", controle.exibeContasClientes("Beatriz", "12345678910"));
	}
	
	@Test
	public void testGetContas() {
		assertEquals(true, controle.hasContas("12345678910"));
		assertEquals(false, controle.hasContas("12345678911"));
	}
	
	@Test
	public void testOrdenaELista() {
		controle.ordenaPor("Data");
		assertEquals("18/11/2020, Beatriz, Dona Fran, Hamburguer com tudo que tem direito", controle.listarCompras());
		
		controle.ordenaPor("Fornecedor");
		assertEquals("Dona Fran, Beatriz, Hamburguer com tudo que tem direito, 18/11/2020", controle.listarCompras());
		
		controle.ordenaPor("Cliente");
		assertEquals("Beatriz, Dona Fran, Hamburguer com tudo que tem direito, 18/11/2020", controle.listarCompras());
		
		try {
			controle.ordenaPor("");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na listagem de compras: criterio nao oferecido pelo sistema.", e.getMessage());
		}
		
		try {
			controle.ordenaPor("dgsdfgsdfh");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na listagem de compras: criterio nao oferecido pelo sistema.", e.getMessage());
		}
		
	}
	
}
