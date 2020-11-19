package controles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Fornecedor;
import entidades.IdProduto;
import entidades.Produto;

class TesteControleProduto {

	private ControleProduto controle;
	
	@BeforeEach
	public void initControleProduto() {
		this.controle = new ControleProduto();
		controle.cadastra("X-tudo", "Hamburguer com tudo que tem direito", 10.0);
	}
	
	@Test
	public void testCadastraProduto() {
		controle.cadastra("X-bacon", "Hamburguer com bacon", 11.0);
		assertEquals("X-bacon - Hamburguer com bacon - R$11,00",controle.consultaUmProduto("X-bacon", "Hamburguer com bacon"));
	}
	
	@Test
	public void testConsultaUmProduto() {
		assertEquals("X-tudo - Hamburguer com tudo que tem direito - R$10,00",controle.consultaUmProduto("X-tudo", "Hamburguer com tudo que tem direito"));
	}
	
	@Test
	public void testToString() {
		assertEquals("X-tudo - Hamburguer com tudo que tem direito - R$10,00", controle.toString());
	}
	
	@Test
	public void testConsultaProdutos() {
		controle.cadastra("Sanduiche", "Vegano", 13.0);
		assertEquals("Marcos - Sanduiche - Vegano - R$13,00 | Marcos - X-tudo - Hamburguer com tudo que tem direito - R$10,00", controle.consultaProdutos("Marcos"));
		ControleProduto controle3 = new ControleProduto();
		assertEquals("Marcos -", controle3.consultaProdutos("Marcos"));
		
		assertEquals("X-tudo - Hamburguer com tudo que tem direito - R$10,00 | Sanduiche - Vegano - R$13,00", controle.consultaProdutos());
	}
	
	@Test
	public void testEditaProduto() {
		controle.editaProduto("X-tudo", "Hamburguer com tudo que tem direito", 9.0);
		assertEquals("X-tudo - Hamburguer com tudo que tem direito - R$9,00", controle.toString());
	}
	
	@Test
	public void testRemoveProduto() {
		controle.removeProduto("X-tudo", "Hamburguer com tudo que tem direito");
		assertEquals("", controle.toString());
	}
	
	@Test
	public void testGetProduto() {
		assertEquals(10.0, controle.getPrecoProduto("X-tudo", "Hamburguer com tudo que tem direito"));
	}
	
	@Test
	public void testExisteProduto() {
		assertEquals(true, controle.existeProduto("X-tudo", "Hamburguer com tudo que tem direito"));
	}
	
	
}
