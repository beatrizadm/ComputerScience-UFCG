package entidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteIdProduto {

	private IdProduto id1;
	private IdProduto id2;
	private IdProduto id3;
	private IdProduto id4;
	private IdProduto idNull;
	private IdProduto id6;
	private IdProduto id7;
	private IdProduto id8;
	private IdProduto id9;
	
	private Cliente cliente1;
	
	@BeforeEach
	public void initAluno() {
		this.id1 = new IdProduto("X-burguer", "hamburguer");
		this.id2 = new IdProduto("X-burguer", "hamburguer");
		this.id3 = new IdProduto("X-tudo", "hamburguer");
		this.id4 = new IdProduto("", "");
		this.idNull = new IdProduto(null, null);
		this.id6 = new IdProduto(null, "hamburguer");
		this.id7 = new IdProduto("X-tudo", null);
		this.id8 = new IdProduto("X-tudo", null);
		this.id9 = new IdProduto(null, "hamburguer");

		this.cliente1 = new Cliente("Beatriz", "beatriz.miranda@ccc.ufcg.edu.br", "Analytics");
	}
	
	@Test
	public void testHashCode() {
		assertEquals(id1.hashCode(), id2.hashCode());
		assertNotEquals(id1.hashCode(), idNull.hashCode());
	}
	
	@Test
	public void testEquals() {
		assertEquals(true, id1.equals(id2));
		assertEquals(false, id1.equals(id3));
		assertEquals(false, id1.equals(null));
		assertEquals(false, id1.equals(id4));
		assertEquals(false, id1.equals(cliente1));
		assertEquals(false, idNull.equals(id1));
		assertEquals(true, idNull.equals(idNull));
		assertEquals(false, id6.equals(id4));
		assertEquals(true, id7.equals(id8));
		assertEquals(true, id6.equals(id9));
		assertEquals(false, id9.equals(id3));
		
	}

}
