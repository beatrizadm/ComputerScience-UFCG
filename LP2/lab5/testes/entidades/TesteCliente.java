package entidades;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteCliente {

	private Cliente cliente1;
	private Cliente cliente2;
	private Cliente cliente3;
	private Cliente cliente4;
	private Cliente cliente5;
	private Cliente cNull;
	
	
	@BeforeEach
	public void initAluno() {
		this.cliente1 = new Cliente("Beatriz", "beatriz.miranda@ccc.ufcg.edu.br", "Analytics");
		this.cliente2 = new Cliente("Beatriz", "beatriz.miranda@ccc.ufcg.edu.br", "Analytics");
		this.cliente3 = new Cliente("Joao", "joao.silva@ccc.ufcg.edu.br", "LSI");
		this.cliente4 = new Cliente("Beatriz", "ana.miranda@ccc.ufcg.edu.br", "Analytics");
		this.cliente5 = new Cliente("Beatriz", "beatriz.miranda@ccc.ufcg.edu.br", "LSD");
		this.cNull = new Cliente(null, null, null);
		
	}
	
	@Test
	public void testToString() {
		assertEquals("Beatriz - Analytics - beatriz.miranda@ccc.ufcg.edu.br", cliente1.toString());
	}
	
	@Test
	public void testGetNome() {
		assertEquals("Beatriz", cliente1.getNome());
	}
	
	@Test
	public void testCompareTo() {
		assertEquals(1, cliente1.compareTo(cliente2));
		assertEquals(0, cliente1.compareTo(cliente3));
		assertEquals(0, cliente1.compareTo(cliente4));
		assertEquals(0, cliente1.compareTo(cliente5));
		
	}
	
	@Test
	public void testEdita() {
		cliente1.edita("localizacao", "SPLab");
		assertEquals("Beatriz - SPLab - beatriz.miranda@ccc.ufcg.edu.br", cliente1.toString());
		
		cliente1.edita("nome", "Ana");
		assertEquals("Ana - SPLab - beatriz.miranda@ccc.ufcg.edu.br", cliente1.toString());
		
		cliente1.edita("email", "ana.silva@ccc.ufcg.edu.br");
		assertEquals("Ana - SPLab - ana.silva@ccc.ufcg.edu.br", cliente1.toString());
		
		cliente1.edita("lalala", "lalala");
	}
	
	@Test
	public void testHashCode() {
		assertEquals(cliente1.hashCode(), cliente2.hashCode());
		assertNotEquals(cliente1.hashCode(), cNull.hashCode());
	}
	
	@Test
	public void testEquals() {
		Fornecedor f = new Fornecedor(null, null, null);
		
		assertEquals(true, cliente1.equals(cliente2));
		assertEquals(false, cliente1.equals(f));
		assertEquals(true, cNull.equals(cNull));
		assertEquals(false, cNull.equals(null));
		
		Cliente email1 = new Cliente("Marcos", null, "33106000");
		Cliente email2 = new Cliente("Marcos", "marcos@gmail.com", "33106000");
		Cliente email3 = new Cliente("Marcos", null, "33106000");
		Cliente email4 = new Cliente("Marcos", "marcos123@gmail.com", "33106000");
		
		assertEquals(false, email1.equals(email2));
		assertEquals(true, email1.equals(email3));
		assertEquals(false, email2.equals(email4));
		
		Cliente nome1 = new Cliente(null, "marcos@gmail.com", "33106000");
		Cliente nome2 = new Cliente("Marcos", "marcos@gmail.com", "33106000");
		Cliente nome3 = new Cliente(null, "marcos@gmail.com", "33106000");
		Cliente nome4 = new Cliente("Joao", "marcos@gmail.com", "33106000");
		
		assertEquals(false, nome1.equals(nome2));
		assertEquals(true, nome1.equals(nome3));
		assertEquals(false, nome2.equals(nome4));
		
		Cliente localizacao1 = new Cliente("Marcos", "marcos@gmail.com", null);
		Cliente localizacao2 = new Cliente("Marcos", "marcos@gmail.com", "Analytics");
		Cliente localizacao3 = new Cliente("Marcos", "marcos@gmail.com", null);
		Cliente localizacao4 = new Cliente("Marcos", "marcos@gmail.com", "SPlab");
		
		assertEquals(false, localizacao1.equals(localizacao2));
		assertEquals(true, localizacao1.equals(localizacao3));
		assertEquals(false, localizacao2.equals(localizacao4));
	}
	
}
