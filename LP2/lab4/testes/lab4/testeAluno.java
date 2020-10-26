package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testeAluno {

	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	private Aluno aluno4;
	

	@BeforeEach
	public void initAluno() {
		assertThrows(IllegalArgumentException.class, () -> this.aluno1 = new Aluno(" ","Beatriz","cc"));
		assertThrows(IllegalArgumentException.class, () -> this.aluno2 = new Aluno("12345","","cc"));
		assertThrows(IllegalArgumentException.class, () -> this.aluno3 = new Aluno("12345","Beatriz","      "));
		assertThrows(NullPointerException.class, () -> this.aluno1 = new Aluno(null,"Beatriz","cc"));
		assertThrows(NullPointerException.class, () -> this.aluno2 = new Aluno("12345",null,"cc"));
		assertThrows(NullPointerException.class, () -> this.aluno3 = new Aluno("12345","Beatriz",null));
		
		this.aluno1 = new Aluno("12345","Beatriz","cc");
		this.aluno2 = new Aluno("12345","Beatriz","cc");
		this.aluno3 = new Aluno("6789","Beatriz","cc");
		
	}
	
	@Test
	public void testEquals() {
		assertEquals(true, aluno1.equals(aluno2));
		assertEquals(true, aluno1.equals(aluno1));
		assertEquals(false, aluno2.equals(aluno3));
		assertEquals(false, aluno3.equals(aluno4));
		
	}
	
	@Test
	public void testHashCode() {
		assertEquals(aluno1.hashCode(), aluno2.hashCode());
		assertNotEquals(aluno2.hashCode(), aluno3.hashCode());
	}
	
	@Test
	public void testToString() {
		assertEquals("12345 - Beatriz - cc", aluno1.toString());
	}

}
