package lab6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.Combo;

class TesteCombo {

	private Combo combo;
	
	@BeforeEach
	public void initCombo() {
		this.combo = new Combo("X-burguer + refri", "X-burguer com refrigerante", 10, 0.5);
	}
	
	@Test
	public void testGetPreco() {
		assertEquals(5.0, combo.getPreco());
	}
	
	@Test
	public void testSetFator() {
		combo.setFator(0.25);
		assertEquals(7.5, combo.getPreco());
	}

}
