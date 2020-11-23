package lab4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testeControle {

	private String nome1;
	private Aluno aluno1;
	private Aluno aluno2;
	private Controle controle;
	
	@BeforeEach
	public void initControle() {
		this.aluno1 = new Aluno("789","Ana","ee");
		this.aluno2 = new Aluno("456","Joao","adm");
		this.controle = new Controle();
		controle.cadastraAluno("789", "Ana", "ee");
		controle.cadastraAluno("456", "Joao", "adm");
		controle.cadastraGrupo("estudo");
		controle.alocarAluno("789", "estudo");
		controle.alocarAluno("456", "estudo");
		controle.cadastraGrupo("p2");
	}

	@Test
	public void testCadastraAluno() {
		assertThrows(IllegalArgumentException.class, () -> controle.cadastraAluno("  ", "Beatriz", "cc"));
		assertThrows(IllegalArgumentException.class, () -> controle.cadastraAluno("123", "", "cc"));
		assertThrows(IllegalArgumentException.class, () -> controle.cadastraAluno("123", "Beatriz", "            "));
		assertThrows(NullPointerException.class, () -> controle.cadastraAluno(null,"Beatriz","cc"));
		assertThrows(NullPointerException.class, () -> controle.cadastraAluno("12345",null,"cc"));
		assertThrows(NullPointerException.class, () -> controle.cadastraAluno("12345","Beatriz",null));
		assertEquals("CADASTRO REALIZADO!\n\n", controle.cadastraAluno("123", "Beatriz", "cc"));
		assertEquals("MATRICULA JA CADASTRADA!", controle.cadastraAluno("789", "Ana", "ee"));
	}
	
	@Test
	public void testExibeAluno() {
		assertThrows(NullPointerException.class, () -> controle.exibeAluno(null));
		assertThrows(IllegalArgumentException.class, () -> controle.exibeAluno("   "));
		assertEquals("Aluno: 789 - Ana - ee", controle.exibeAluno("789"));
		assertEquals("Aluno nao cadastrado.", controle.exibeAluno("123"));
	}

	@Test
	public void testCadastraGrupo() {
		assertThrows(NullPointerException.class, () -> controle.cadastraGrupo(null));
		assertThrows(IllegalArgumentException.class, () -> controle.cadastraGrupo("   "));
		assertEquals("CADASTRADO COM SUCESSO!", controle.cadastraGrupo("show"));
		assertEquals("GRUPO JA CADASTRADO!", controle.cadastraGrupo("estudo"));
	}
	
	@Test
	public void testAlocarAluno() {
		assertThrows(NullPointerException.class, () -> controle.alocarAluno(null, "lp2"));
		assertThrows(IllegalArgumentException.class, () -> controle.alocarAluno("123", "  "));
		assertThrows(NullPointerException.class, () -> controle.alocarAluno("123", null));
		assertThrows(IllegalArgumentException.class, () -> controle.alocarAluno("  ", "p2"));
		assertEquals("ALUNO ALOCADO!", controle.alocarAluno("789", "estudo"));
		assertEquals("Aluno nao cadastrado.", controle.alocarAluno("123", "estudo"));
		assertEquals("Grupo nao cadastrado.", controle.alocarAluno("789", "lp2"));
	}
	
	@Test
	public void testImprimirGrupo() {
		assertThrows(NullPointerException.class, () -> controle.imprimirGrupo(null));
		assertThrows(IllegalArgumentException.class, () -> controle.imprimirGrupo("   "));
		assertEquals("Grupo nao cadastrado.", controle.imprimirGrupo("lp2"));
		assertEquals("Nenhum aluno cadastrado no grupo.", controle.imprimirGrupo("p2"));
		assertEquals("\nAlunos do grupo estudo:\n" + 
					 "* 456 - Joao - adm\n" + 
					 "* 789 - Ana - ee\n", controle.imprimirGrupo("estudo"));
	}
	
	@Test
	public void testRegistrarespostaQuadro() {
		assertThrows(NullPointerException.class, () -> controle.registraRespostaQuadro(null));
		assertThrows(IllegalArgumentException.class, () -> controle.registraRespostaQuadro("   "));
		assertEquals("ALUNO CADASTRADO!", controle.registraRespostaQuadro("789"));
		assertEquals("Aluno nao cadastrado.", controle.registraRespostaQuadro("999"));
	}
	
	@Test
	public void testImprimeResponderam() {
		assertEquals("Nenhum aluno respondeu no quadro.\n", controle.imprimeResponderam());
		
		controle.registraRespostaQuadro("789");
		controle.registraRespostaQuadro("456");
		assertEquals("Alunos:\n" + 
					"1. 789 - Ana - ee\n" +
					"2. 456 - Joao - adm\n", controle.imprimeResponderam());
	}
	
}
