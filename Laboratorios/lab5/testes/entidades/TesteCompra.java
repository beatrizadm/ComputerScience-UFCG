package entidades;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteCompra {

	private Compra c1;
	private Compra c1igual;
	private Compra cNull;
	
	private Compra data1;
	private Compra data2;
	private Compra data3;
	
	private Compra descricao1;
	private Compra descricao2;
	private Compra descricao3;
	private Compra descricao4;
	
	private Compra nome1;
	private Compra nome2;
	private Compra nome3;
	private Compra nome4;
	
	private Cliente cliente;
	
	@BeforeEach
	public void initAluno() {
		this.c1 = new Compra("Beatriz", "Marcos", "X-burguer", "hamburguer com carne e queijo", "13/11/2020", 10.0);
		this.c1igual = new Compra("Beatriz", "Marcos", "X-burguer", "hamburguer com carne e queijo", "13/11/2020", 10.0);
		this.cNull = new Compra(null, null, null, null, null, 0);
		
		this.data1 = new Compra("Beatriz", "Marcos", "X-burguer", "hamburguer com carne e queijo", null, 10.0);
		this.data2 = new Compra("Beatriz", "Marcos", "X-burguer", "hamburguer com carne e queijo", "13/11/2020", 10.0);
		this.data3 = new Compra("Beatriz", "Marcos", "X-burguer", "hamburguer com carne e queijo", null, 10.0);
		
		this.descricao1 = new Compra("Beatriz", "Marcos", "X-burguer", null, "13/11/2020", 10.0);
		this.descricao2 = new Compra("Beatriz", "Marcos", "X-burguer", "hamburguer com carne e queijo", "13/11/2020", 10.0);
		this.descricao3 = new Compra("Beatriz", "Marcos", "X-burguer", null, "13/11/2020", 10.0);
		this.descricao4 = new Compra("Beatriz", "Marcos", "X-burguer", "hamburguer com carne", "13/11/2020", 10.0);
		
		this.nome1 = new Compra("Beatriz", "Marcos", null, "hamburguer com carne e queijo", "13/11/2020", 10.0);
		this.nome2 = new Compra("Beatriz", "Marcos", "X-burguer", "hamburguer com carne e queijo", "13/11/2020", 10.0);
		this.nome3 = new Compra("Beatriz", "Marcos", null, "hamburguer com carne e queijo", "13/11/2020", 10.0);
		this.nome4 = new Compra("Beatriz", "Marcos", "X-tudo", "hamburguer com carne e queijo", "13/11/2020", 10.0);
		
	
		this.cliente = new Cliente("Beatriz", "beatriz.miranda@ccc.ufcg.edu.br", "Analytics");
	}
	
	@Test
	public void testToString() {
		assertEquals("X-burguer - 13-11-2020", c1.toString());
	}
	
	@Test
	public void testExibeOrdenaCliente() {
		assertEquals("Beatriz, Marcos, hamburguer com carne e queijo, 13/11/2020", c1.exibeOrdenaCliente());
	}
	
	@Test
	public void testExibeOrdenaData() {
		assertEquals("13/11/2020, Beatriz, Marcos, hamburguer com carne e queijo", c1.exibeOrdenaData());
	}
	
	@Test
	public void testExibeOrdenaFornecedor() {
		assertEquals("Marcos, Beatriz, hamburguer com carne e queijo, 13/11/2020", c1.exibeOrdenaFornecedor());
	}
	
	@Test
	public void testGetCliente() {
		assertEquals("Beatriz", c1.getCliente());
	}
	
	@Test
	public void testGetPrecoProduto() {
		assertEquals(10.0, c1.getPrecoProduto());
	}
	
	@Test
	public void testGetFornecedor() {
		assertEquals("Marcos", c1.getFornecedor());
	}
	
	@Test
	public void testGetData() {
		assertEquals("13/11/2020", c1.getData());
	}
	
	@Test
	public void testGetDescricaoProduto() {
		assertEquals("hamburguer com carne e queijo", c1.getDescricaoProduto());
	}
	
	@Test
	public void testHashCode() {
		assertEquals(c1.hashCode(), c1igual.hashCode());
		assertNotEquals(c1.hashCode(), cNull.hashCode());
	}
	
	@Test
	public void testEquals() {
		assertEquals(true, c1.equals(c1igual));
		assertEquals(false, c1.equals(cNull));
		assertEquals(true, cNull.equals(cNull));
		assertEquals(false, c1.equals(null));
		assertEquals(false, c1.equals(cliente));
		
		assertEquals(false, data1.equals(data2));
		assertEquals(true, data1.equals(data3));
		
		assertEquals(false, descricao1.equals(descricao2));
		assertEquals(true, descricao1.equals(descricao3));
		assertEquals(false, descricao2.equals(descricao4));
		
		assertEquals(false, nome1.equals(nome2));
		assertEquals(true, nome1.equals(nome3));
		assertEquals(false, nome2.equals(nome4));
	}
	
}
