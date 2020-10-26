package lab4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testeGrupo {

	private Aluno aluno1;
	private Aluno aluno2;
	
	private Grupo grupo;
	private Grupo grupo1;
	private Grupo grupo2;
	private Grupo grupoNull;
	
	@BeforeEach
	public void initGrupo() {
		assertThrows(IllegalArgumentException.class, () -> this.grupo = new Grupo(" "));
		assertThrows(NullPointerException.class, () -> this.grupo = new Grupo(null));
		this.aluno1 = new Aluno("123","Beatriz","cc");
		this.aluno2 = new Aluno("789", "Ana", "ee");

		this.grupo = new Grupo("estudos");
		this.grupo1 = new Grupo("lp2");
		this.grupo2 = new Grupo("lp2");
	}

	@Test
	public void testEquals() {
		assertEquals(false, grupo.equals(grupo1));
		assertEquals(true, grupo1.equals(grupo2));
		assertEquals(true, grupo1.equals(grupo1));
		assertEquals(false, grupo1.equals(grupoNull));
		assertEquals(false, grupo1.equals(grupoNull));
		
	}
	
	@Test
	public void testHashCode() {
		assertEquals(grupo2.hashCode(), grupo1.hashCode());
		assertNotEquals(grupo.hashCode(), grupo1.hashCode());
	}
	
	@Test
	public void testAdicionaAmigo() {
		assertEquals(true, grupo.adicionaAluno(aluno1));
	}
	
	@Test
	public void testToString() {
		grupo.adicionaAluno(aluno1);
		grupo.adicionaAluno(aluno2);
		assertEquals("\nAlunos do grupo estudos:\n" + 
					 "* 123 - Beatriz - cc\n" +
					 "* 789 - Ana - ee\n", grupo.toString());
	}

}
 