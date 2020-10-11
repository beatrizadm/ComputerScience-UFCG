package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab3.Contato;

class TestContato {
	
	private Contato contatoIgual1;
	private Contato contatoIgual2;
	private Contato contatoNull;
	private Contato contato1;
	private Contato contato2;
	private Contato contato3;
	
	@BeforeEach
	public void initContato() {
		this.contatoIgual1 = new Contato("Beatriz", "Miranda", "(83) 3310-6000", "(83) 91234-5678", "(83) 98765-4321", "1", "2");
		this.contatoIgual2 = new Contato("Beatriz", "Miranda","(83) 3310-6000", "(83) 91234-5678","", "1", "2");
		this.contatoNull = new Contato(null, null, null, null, null, null, null);
		this.contato1 = new Contato("Ana","Silva", "(81) 99865-1325", "", "", "", "");
		this.contato2 = new Contato("Beatriz","Silva", "(81) 99865-1325", "", "", "", "1");
		this.contato3 = new Contato("Beatriz","Silva", "", "", "", "1", "1");
		
		
	}

	@Test
	void testEqualsObject() {
		String erro = "deveria retornar true ou false caso o nome e sobrenome sejam iguais ou o objeto completo for igual";
		assertEquals(false, contatoIgual1.equals(contatoNull), erro);
		assertEquals(true, contatoIgual1.equals(contatoIgual2), erro);
		assertEquals(true, contatoNull.equals(contatoNull), erro);
		assertEquals(false, contatoNull.equals(contato1), erro);
		assertEquals(false, contatoNull.equals(contato2), erro);
	}

	@Test
	void testExibeContato() {
		String erro = "deveria exibir o contato no formato: nome, sobrenome, contato prioritario e contato whatsapp";
		assertEquals("Beatriz Miranda\n"
					+ "(83) 3310-6000 (prioritario)\n"
				    + "(83) 91234-5678 (zap)\n", contatoIgual2.exibeContato(), erro);
		assertEquals("Beatriz Miranda\n"
				+ "(83) 3310-6000 (prioritario)\n"
			    + "(83) 91234-5678 (zap)\n"
				+ "(83) 98765-4321\n", contatoIgual1.exibeContato(), erro);
		
	}

	@Test
	void testExibeTelefonePrioritario() {
		String erro = "deveria exibir os telefones prioritarios no formato: nome, sobrenome, numero ou nao tem";
		assertEquals("Beatriz Miranda - (83) 3310-6000", contatoIgual1.exibeTelefonePrioritario(), erro);
		assertEquals("Ana Silva - Nao tem", contato1.exibeTelefonePrioritario(), erro);
		assertEquals("Beatriz Silva - Nao tem", contato3.exibeTelefonePrioritario(), erro);
	}

	@Test
	void testExibeZap() {
		String erro = "deveria exibir os numeros do whatsapp no fomato: nome, sobrenome, numero ou nao tem";
		assertEquals("Beatriz Miranda - (83) 91234-5678", contatoIgual1.exibeZap(), erro);
		assertEquals("Ana Silva - Nao tem", contato1.exibeZap(), erro);
		assertEquals("Beatriz Silva - Nao tem", contato3.exibeZap(), erro);
	}

	@Test
	void testToString() {
		String erro = "deveria exibir nome e sobrenome";
		assertEquals("Beatriz Miranda", contatoIgual1.toString(), erro);
	}

}
