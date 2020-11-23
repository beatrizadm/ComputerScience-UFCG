package comparadores;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Compra;

class TesteCompraFornecedor {

	private CompraFornecedor compra;
	private Compra c1;
	private Compra c2;
	private Compra c3;
	
	
	@BeforeEach
	public void initAluno() {
		this.compra = new CompraFornecedor();
		this.c1 = new Compra("Beatriz", "Marcos", "X-burguer", "hamburguer com carne e queijo", "13/11/2020", 10.0);
		this.c2 = new Compra("Beatriz", "Marcos", "X-burguer", "hamburguer com carne e queijo", "13/11/2020", 10.0);
		this.c3 = new Compra("Beatriz", "Ze", "X-burguer", "hamburguer com carne e queijo", "13/11/2020", 10.0);
	}
	
	@Test
	void testCompare() {
		assertEquals(0, compra.compare(c1, c2));
		assertEquals(-13, compra.compare(c1, c3));
	}

}
