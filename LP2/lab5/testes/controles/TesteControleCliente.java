package controles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Cliente;

class TesteControleCliente {

	private ControleCliente controle1;
	
	@BeforeEach
	public void initControleCliente() {
		this.controle1 = new ControleCliente();
		this.controle1.cadastraCliente("12345678910", "Beatriz", "beatriz.miranda@ccc.ufcg.edu.br", "Analytics");
	}
	
	@Test
	public void testCadastraCliente() {
		assertEquals("12345678911", controle1.cadastraCliente("12345678911", "Joao", "joao.silva@ccc.ufcg.edu.br", "LSD"));
	}

	@Test
	public void testEditaCliente() {
		controle1.editaCliente("12345678910", "email", "beatriz@gmail.com");
		assertEquals("Beatriz - Analytics - beatriz@gmail.com", controle1.exibeCliente("12345678910"));
	}
	
	@Test
	public void testRemoveCliente() {
		controle1.removeCliente("12345678910");
		assertEquals("", controle1.exibeClientes());
	}
	
	@Test
	public void testExibeCliente() {
		assertEquals("Beatriz - Analytics - beatriz.miranda@ccc.ufcg.edu.br", controle1.exibeCliente("12345678910"));
	}
	
	@Test
	public void testExibeClientes() {
		controle1.cadastraCliente("12345678911", "Joao", "joao.silva@ccc.ufcg.edu.br", "LSD");
		assertEquals("Beatriz - Analytics - beatriz.miranda@ccc.ufcg.edu.br | Joao - LSD - joao.silva@ccc.ufcg.edu.br", controle1.exibeClientes());
	}
	
	@Test
	public void testGetClientes() {
		HashMap<String, Cliente> map = new HashMap();
		map.put("12345678910", new Cliente("Beatriz", "beatriz.miranda@ccc.ufcg.edu.br", "Analytics"));
		assertEquals(map, controle1.getClientes());
	}
	
	@Test
	public void testGetNomeCliente() {
		assertEquals("Beatriz", controle1.getNomeCliente("12345678910"));
	}
	
}
