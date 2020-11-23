package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab3.Agenda;
import lab3.Contato;

class TestAgenda {

	private Contato contatoIgual1;
	private Contato contatoIgual2;
	private Contato[] array;
	public Agenda agenda;
	public Agenda agenda2;
	
	
	@BeforeEach
	public void initContato() {
		this.contatoIgual1 = new Contato("Beatriz", "Miranda", "(83) 3310-6000", "(83) 91234-5678", "(83) 98765-4321", "1", "2");
		this.contatoIgual2 = new Contato("Ana", "Silva", "(11) 97845-3218", "(11) 97464-6548", "(11) 94328-6843", "2", "1");
		this.array = new Contato[100];
		this.array[0] = contatoIgual1;
		this.array[1] = contatoIgual2;
		this.agenda = new Agenda();
		this.agenda2 = new Agenda();
		this.agenda.cadastraContato(1, "Beatriz", "Miranda", "(83) 3310-6000", "(83) 91234-5678", "(83) 98765-4321", "1", "2");
		this.agenda.cadastraContato(2, "Ana", "Silva", "(11) 97845-3218", "(11) 97464-6548", "(11) 94328-6843", "2", "1");
	}
	
	@Test
	void testListaContato() {
		assertEquals("\nLista de contatos:\n" + 
					"1 - Beatriz Miranda\n" + 
					"2 - Ana Silva\n", agenda.listaContatos());
		assertEquals("\nLista de contatos:\n",agenda2.listaContatos());
	}
	
	@Test
	void testExibeContato() {
		assertEquals("Beatriz Miranda\n" + 
				"(83) 3310-6000 (prioritario)\n" + 
				"(83) 91234-5678 (zap)\n" + 
				"(83) 98765-4321\n", agenda.exibeContato(1));
		assertEquals("POSICAO INVALIDA!",agenda.exibeContato(101));
		assertEquals("POSICAO INVALIDA!",agenda2.exibeContato(1));
	}
	
	@Test
	void testTelefonesPreferidos() {
		assertEquals("Beatriz Miranda - (83) 3310-6000\n"
					+ "Ana Silva - (11) 97464-6548\n", agenda.telefonesPreferidos());
		assertEquals("", agenda2.telefonesPreferidos());
	}
	
	@Test
	void testZaps() {
		assertEquals("Beatriz Miranda - (83) 91234-5678\n"
				+ "Ana Silva - (11) 97845-3218\n", agenda.zaps());
		assertEquals("", agenda2.zaps());
	}

}
