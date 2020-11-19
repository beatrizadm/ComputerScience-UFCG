package entidades;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controles.ControleProduto;

class TesteFornecedor {

	private Fornecedor f1;
	private Fornecedor f2;
	private Fornecedor f3;
	private Fornecedor fNull;
	
	
	private Produto p1;
	
	private ControleProduto cp;
	
	private HashMap<String, Conta> contas;
	
	
	@BeforeEach
	public void initAluno() {
		this.f1 = new Fornecedor("Marcos", "marcos@gmail.com", "33106000");
		this.f2 = new Fornecedor("Marcos", "marcos@gmail.com", "33106000");
		this.f3 = new Fornecedor("Ze", "marcos@gmail.com", "33106000");
		this.fNull = new Fornecedor(null, null, null);
		
		this.p1 = new Produto("X-frango", "Hamburguer de frango com queijo e calabresa", 10.0);
		this.f1.cadastraProduto("X-frango", "Hamburguer de frango com queijo e calabresa", 10.0);
		
		this.cp = new ControleProduto();
		cp.cadastra("X-frango", "Hamburguer de frango com queijo e calabresa", 10.0);
		
		this.contas = new HashMap<>();
		
		f1.adicionaCompra("Beatriz", "12345678910", "13/11/2020" ,"X-frango", "Hamburguer de frango com queijo e calabresa", 10.0);
		
		this.contas.put("12345678910", new Conta("12345678910"));
		this.contas.get("12345678910").adicionaCompra("Beatriz", "12345678910", "Marcos", "X-frango", "Hamburguer de frango com queijo e calabresa", "13/11/2020", 10.0);

	}
	
	@Test
	public void testToString() {
		assertEquals("Marcos - marcos@gmail.com - 33106000", f1.toString());
	}
	
	@Test
	public void testCompareTo() {
		assertEquals(1, f1.compareTo(f2));
		assertEquals(0, f1.compareTo(f3));
	}
	
	@Test
	public void testEditaFornecedor() {
		f1.editaFornecedor("email", "marcos123@gmail.com");
		assertEquals("Marcos - marcos123@gmail.com - 33106000", f1.toString());
		f1.editaFornecedor("telefone", "3322445566");
		assertEquals("Marcos - marcos123@gmail.com - 3322445566", f1.toString());
		f1.editaFornecedor("nome", "Ze");
		assertEquals("Marcos - marcos123@gmail.com - 3322445566", f1.toString());
	}
	
	@Test
	public void testGetNome() {
		assertEquals("Marcos", f1.getNome());
	} 
	
	@Test
	public void testGetProdutos() {
		assertEquals(true, f1.getProdutos().equals(cp));
	} 
	
	@Test
	public void testConsultaUmProduto() {
		assertEquals("X-frango - Hamburguer de frango com queijo e calabresa - R$10,00", f1.consultaUmProduto("X-frango", "Hamburguer de frango com queijo e calabresa"));
	}
	
	@Test
	public void testConsultaProdutos() {
		assertEquals("Marcos - X-frango - Hamburguer de frango com queijo e calabresa - R$10,00", f1.consultaProdutos("Marcos"));
		assertEquals("X-frango - Hamburguer de frango com queijo e calabresa - R$10,00", f1.consultaProdutos());
	}
	
	@Test
	public void testGetPrecoProduto() {
		assertEquals(10.0, f1.getPrecoProduto("X-frango", "Hamburguer de frango com queijo e calabresa"));
	}
	
	@Test
	public void testEditaProduto() {
		f1.editaProduto("X-frango", "Hamburguer de frango com queijo e calabresa", 9.0);
		assertEquals("X-frango - Hamburguer de frango com queijo e calabresa - R$9,00", f1.consultaProdutos());
	}
	
	@Test
	public void testRemoveProduto() {
		f1.removeProduto("X-frango", "Hamburguer de frango com queijo e calabresa");
		assertEquals("", f1.consultaProdutos());
	}
	
	@Test
	public void testExisteProduto() {
		assertEquals(true, f1.existeProduto("X-frango", "Hamburguer de frango com queijo e calabresa"));
	}
	
	
	@Test
	public void testGetDebito() {
		assertEquals("10.00", f1.getDebito("12345678910"));
	}
	
	
	@Test
	public void testExibeContasClientes() {
		assertEquals("Marcos | X-frango - 13-11-2020", f1.exibeContasClientes("Beatriz", "12345678910", "Marcos"));
	}
	
	@Test
	public void testExibeContas() {
		assertEquals("Cliente: Beatriz | Marcos | X-frango - 13-11-2020", f1.exibeContas("Beatriz", "12345678910", "Marcos"));
		assertThrows(IllegalArgumentException.class, ()-> f1.exibeContas("Beatriz", null, "Marcos"));
		
	}
	
	@Test
	public void testGetCompras() {
		List<Compra> compras = new ArrayList<>();
		Compra compra = new Compra("Beatriz", "Marcos","X-frango", "Hamburguer de frango com queijo e calabresa", "13/11/2020", 10.0);
		
		compras.add(compra);
		assertEquals(compras, f1.getCompras());
	}

	@Test
	public void testGetContas() {
		assertEquals(contas, f1.getContas());
	}
	
	
	@Test
	public void testHashCode() {
		assertEquals(f1.hashCode(), f2.hashCode());
		assertNotEquals(f1.hashCode(), fNull.hashCode());
	}
	
	@Test
	public void testEquals() {
		assertEquals(true, f1.equals(f2));
		assertEquals(false, f2.equals(p1));
		assertEquals(true, fNull.equals(fNull));
		assertEquals(false, fNull.equals(null));
		
		Fornecedor email1 = new Fornecedor("Marcos", null, "33106000");
		Fornecedor email2 = new Fornecedor("Marcos", "marcos@gmail.com", "33106000");
		Fornecedor email3 = new Fornecedor("Marcos", null, "33106000");
		Fornecedor email4 = new Fornecedor("Marcos", "marcos123@gmail.com", "33106000");
		
		assertEquals(false, email1.equals(email2));
		assertEquals(true, email1.equals(email3));
		assertEquals(false, email2.equals(email4));
		
		Fornecedor nome1 = new Fornecedor(null, "marcos@gmail.com", "33106000");
		Fornecedor nome2 = new Fornecedor("Marcos", "marcos@gmail.com", "33106000");
		Fornecedor nome3 = new Fornecedor(null, "marcos@gmail.com", "33106000");
		Fornecedor nome4 = new Fornecedor("Joao", "marcos@gmail.com", "33106000");
		
		assertEquals(false, nome1.equals(nome2));
		assertEquals(true, nome1.equals(nome3));
		assertEquals(false, nome2.equals(nome4));
		
		Fornecedor telefone1 = new Fornecedor("Marcos", "marcos@gmail.com", null);
		Fornecedor telefone2 = new Fornecedor("Marcos", "marcos@gmail.com", "33106000");
		Fornecedor telefone3 = new Fornecedor("Marcos", "marcos@gmail.com", null);
		Fornecedor telefone4 = new Fornecedor("Marcos", "marcos@gmail.com", "33100000");
		
		assertEquals(false, telefone1.equals(telefone2));
		assertEquals(true, telefone1.equals(telefone3));
		assertEquals(false, telefone2.equals(telefone4));
	}
	
	
}
