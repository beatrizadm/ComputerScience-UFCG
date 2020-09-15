package lab03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AVTest {
	
	AmigoVirtual a0;
	AmigoVirtual a1;
	AmigoVirtual a2;
	AmigoVirtual a99;
	AmigoVirtualRepositorio o1;
	
	@BeforeEach
	public void initAmigo() {
		a0 = new AmigoVirtual(0 , "", "", "");
		a1 = new AmigoVirtual(0 , "ana", "link#222", "show");
		a2 = new AmigoVirtual(0 , "ana", "link#222", "");
		a99 = new AmigoVirtual(0, "" , "", "");
		o1 = new AmigoVirtualRepositorio();
	}
	
	@Test
	public void testGetPosicaoAV(){
		assertEquals(0, a1.getPosicaoAV());
	}
	
	@Test
	public void testGetNomeAV() {
		assertEquals("ana", a1.getNomeAV());
	}
	
	@Test
	public void testGetIDAV() {
		assertEquals("link#222", a1.getIdAV());
	}
	
	@Test
	public void testToStringComAnotacoes() {
		assertEquals("\n0 -- ana -- link#222\nAnotacoes: show\n",a1.toString());
	}
	
	@Test
	public void testToStringSemAnotacoes() {
		assertEquals("\n0 -- ana -- link#222\n",a2.toString());
	}
	
	@Test
	public void testEqualsObjetosIguais() {
		assertTrue(a0.equals(a99));
	}
	
	@Test
	public void testEqualsObjetosDiferentes() {
		assertFalse(a1.equals(a2));
	}
	
	@Test
	public void testEqualsClassesDiferentes() {
		assertEquals(false, a1.equals(o1));
	}
	
	@Test
	public void testEqualsNull() {
		assertEquals(false, a1.equals(null));
	}
	
	@Test
	public void testProcurarVaziaVazia() {
		assertEquals("link#222 -- ana -- show", a1.procurarAV("", ""));
	}
	
	@Test
	public void testProcurarVaziaTrue() {
		assertEquals("link#222 -- ana -- show", a1.procurarAV("", "link#222"));
	}
	
	@Test
	public void testProcurarVaziaFalse() {
		assertEquals("", a1.procurarAV("", "naoentra"));
	}
	
	@Test
	public void testProcurarTrueVazia() {
		assertEquals("link#222 -- ana -- show", a1.procurarAV("ana", ""));
	}
	
	@Test
	public void testProcurarTrueTrue() {
		assertEquals("link#222 -- ana -- show", a1.procurarAV("ana", "link#222"));
	}
	
	@Test
	public void testProcurarTrueFalse() {
		assertEquals("", a1.procurarAV("ana", "naoentra"));
	}
	
	@Test
	public void testProcurarFalseTrue() {
		assertEquals("", a1.procurarAV("naoentra", "link#222"));
	}
	
	@Test
	public void testProcurarFalseVazia() {
		assertEquals("", a1.procurarAV("naoentra", ""));
	}
	
	@Test
	public void testProcurarFalseFalse() {
		assertEquals("", a1.procurarAV("naoentra", "naoentra"));
	}
}