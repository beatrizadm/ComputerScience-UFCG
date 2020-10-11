package lab03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AVRTest {

	AmigoVirtualRepositorio rep = new AmigoVirtualRepositorio();
	AmigoVirtual array[] = new AmigoVirtual[1000];
	
	@Test
	public void testIsCadastrarComAnotacoes() {
		assertTrue(rep.cadastrar(999, "", "", ""));
	}
	
	@Test
	public void testIsCadastrarSemAnotacoes() {
		assertTrue(rep.cadastrar(999, "", ""));
	}
	
	@Test
	public void testNotCadastrarAcimaDoLimiteComAnotacoes() {
		assertFalse(rep.cadastrar(1000, "", "", ""));
	}
	
	@Test
	public void testNotCadastrarAcimaDoLimiteSemAnotacoes() {
		assertFalse(rep.cadastrar(1000, "", ""));
	}
	
	@Test
	public void testNotCadastrarAbaixoDoLimiteComAnotacoes() {
		assertFalse(rep.cadastrar(-1, "", "", ""));
	}
	
	@Test
	public void testNotCadastrarAbaixoDoLimiteSemAnotacoes() {
		assertFalse(rep.cadastrar(-1, "", ""));
	}
	
	@Test
	public void testPegarObjeto() {
		rep.cadastrar(0, "", "", "");
		array[0] = new AmigoVirtual(0, "", "", "");
		Object o1 = array[0];
		Object o2 = rep.pegar(0);
		assertEquals(o1, o2);
	}
	
	@Test
	public void testPegarNull() {
		assertEquals(null, rep.pegar(567));
	}
	
	@Test
	public void testProcurarString() {
		rep.cadastrar(33, "beatriz", "link#111");
		rep.cadastrar(44, "beatriz", "link#222");
		rep.cadastrar(55, "beatriz", "link#111");
		assertEquals("link#111 -- beatriz -- \nlink#111 -- beatriz -- \n", rep.procurar("beatriz", "link#111"));
	}
	
	@Test
	public void testProcurarVazia() {
		rep.cadastrar(33, "beatriz", "link#111");
		rep.cadastrar(44, "beatriz", "link#222");
		rep.cadastrar(55, "beatriz", "link#111");
		assertEquals("", rep.procurar("joao", "link#333"));
	}
	
	
	@Test
	public void testVerificarString() {
		rep.cadastrar(12, "beatriz", "link#111");
		rep.cadastrar(34, "beatriz", "link#111");
		rep.cadastrar(56, "miranda", "link#222");
		rep.cadastrar(77, "miranda", "link#222");
	
		assertEquals("12 -- beatriz -- link#111\nDuplicatas: 34\n\n" + "56 -- miranda -- link#222\nDuplicatas: 77\n", rep.verificar());
	}
	
	@Test
	public void testVerificarVazia() {
		rep.cadastrar(34, "beatriz", "link#111");
		rep.cadastrar(56, "miranda", "link#222");
		
		assertEquals("", rep.verificar());
	}
}
