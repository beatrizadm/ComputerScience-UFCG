package entidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteProduto {

	private Produto produto1;
	private Produto produto2;
	private Produto produto3;
	private Produto pNull;
	
	
	
	@BeforeEach
	public void initAluno() {
		this.produto1 = new Produto("X-frango", "Hamburguer de frango com queijo e calabresa", 10.0);
		this.produto2 = new Produto("X-frango", "Hamburguer de frango com queijo e calabresa", 10.0);
		this.produto3 = new Produto("X-bacon", "Hamburguer de frango com queijo e bacon", 9.0);
		this.pNull = new Produto(null, null, 0);
	}

	@Test
	public void testToString() {
		assertEquals("X-frango - Hamburguer de frango com queijo e calabresa - R$10,00", produto1.toString());
	}
	
	@Test
	public void testGetPreco() {
		assertEquals(10.0, produto1.getPreco());
	}
	
	@Test
	public void testCompareTo() {
		assertEquals(0, produto1.compareTo(produto2));
		assertEquals(4, produto1.compareTo(produto3));
		
		
	}
	
	@Test
	public void testEdita() {
		produto1.editaPreco(15);
		assertEquals("X-frango - Hamburguer de frango com queijo e calabresa - R$15,00", produto1.toString());
	}

	@Test
	public void testHashCode() {
		assertEquals(produto1.hashCode(), produto2.hashCode());
		assertNotEquals(produto1.hashCode(), pNull.hashCode());
	}
	
	@Test
	public void testEquals() {
		Fornecedor f = new Fornecedor(null, null, null);
		
		assertEquals(true, produto1.equals(produto2));
		assertEquals(false, produto1.equals(f));
		assertEquals(true, pNull.equals(pNull));
		assertEquals(false, pNull.equals(null));
		
		Produto descricao1 = new Produto("X-tudo", null, 10.0);
		Produto descricao2 = new Produto("X-tudo", "Hamburguer com tudo de melhor", 10.0);
		Produto descricao3 = new Produto("X-tudo", null, 10.0);
		Produto descricao4 = new Produto("X-tudo", "Hamburguer a moda da casa", 10.0);
		
		assertEquals(false, descricao1.equals(descricao2));
		assertEquals(true, descricao1.equals(descricao3));
		assertEquals(false, descricao2.equals(descricao4));
		
		Produto nome1 = new Produto(null, "Hamburguer a moda da casa", 10.0);
		Produto nome2 = new Produto("X-tudo", "Hamburguer a moda da casa", 10.0);
		Produto nome3 = new Produto(null, "Hamburguer a moda da casa", 10.0);
		Produto nome4 = new Produto("X-carne", "Hamburguer a moda da casa", 10.0);
		
		assertEquals(false, nome1.equals(nome2));
		assertEquals(true, nome1.equals(nome3));
		assertEquals(false, nome2.equals(nome4));
	}
	
	
}
