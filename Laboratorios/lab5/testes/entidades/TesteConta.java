package entidades;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteConta {
	
	private Conta conta1;
	private Conta conta2;
	private Conta cNull;
	
	@BeforeEach
	public void initAluno() {
		this.conta1 = new Conta("123");
		this.conta1.adicionaCompra("Beatriz", "123","Marcos", "X-burguer", "hamburguer com carne e queijo", "13/11/2020", 10.0);
		this.conta2 = new Conta("123");
		this.conta2.adicionaCompra("Beatriz", "123","Marcos", "X-burguer", "hamburguer com carne e queijo", "13/11/2020", 10.0);
		this.cNull = new Conta(null);
		cNull.adicionaCompra(null, null, null, null, null, null, 0);
	}

	@Test
	public void testGetQtdCompras() {
		assertEquals(1, conta1.getQtdCompras());
	}
	
	@Test
	public void testToString() {
		assertEquals("Marcos | X-burguer - 13-11-2020", conta1.toString("Marcos"));
	}
	
	@Test
	public void testExibeDebito() {
		assertEquals("10.00", conta1.exibeDebito());
	}

	@Test
	public void testGetCompras() {
		List<Compra> compras = new ArrayList<Compra>();
		Compra compra = new Compra("Beatriz", "Marcos", "X-burguer", "hamburguer com carne e queijo", "13/11/2020", 10.0);
		compras.add(compra);
		assertEquals(compras, conta1.getCompras());
	}
	
	@Test
	public void testHashCode() {
		assertEquals(conta1.hashCode(), conta2.hashCode());
		assertNotEquals(conta1.hashCode(), cNull.hashCode());
	}
	
	@Test
	public void testEquals() {
		Fornecedor f = new Fornecedor(null, null, null);
		
		assertEquals(true, conta1.equals(conta2));
		assertEquals(false, conta1.equals(f));
		assertEquals(true, cNull.equals(cNull));
		assertEquals(false, cNull.equals(null));
		
		Conta cpf1 = new Conta(null);
		Conta cpf2 = new Conta("33106000957");
		Conta cpf3 = new Conta(null);
		Conta cpf4 = new Conta("33106000369");
		
		assertEquals(false, cpf1.equals(cpf2));
		assertEquals(true, cpf1.equals(cpf3));
		assertEquals(false, cpf2.equals(cpf4));
	}
	
}
