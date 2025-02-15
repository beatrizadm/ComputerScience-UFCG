package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;

class JogoTest {

	@Test
	void testRodadaInicial() throws JogadaInvalidaException, EstrategiaInvalidaException {
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), 14);

		assertEquals(0, j.getNumRodadas());
		assertEquals(14, j.getNumPecasJ1());
		assertEquals(14, j.getNumPecasJ2());

		j.rodada();

		assertEquals(1, j.getNumRodadas());
		assertEquals(13, j.getNumPecasJ1());
		assertEquals(13, j.getNumPecasJ2());
	}
	
	@Test
	void testJogoAleatorio() throws JogadaInvalidaException, EstrategiaInvalidaException {
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), 10, new Random(1));

		HistoricoDeJogo historico = j.jogaJogoCompleto();

		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		
		System.out.println(historico.toString());
	}

	@Test
	void testVencedorJ1Simples() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(0, 1));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		assertFalse(j.isFinalizado());
		assertEquals(null, j.getVencedor());

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
	}
	
	@Test
	void testEmpateNull() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		
		assertEquals(10,j.getJogador1().getPontuacao());
		assertEquals(10,j.getJogador2().getPontuacao());
		
		assertEquals(null,j.getVencedor());
	}
	
	@Test
	void testEmpateNumPecasIgualJ1() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 4));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		
		assertEquals(8,j.getJogador1().getPontuacao());
		assertEquals(10,j.getJogador2().getPontuacao());
		
		assertEquals("J1",j.getVencedor());
	}
	
	@Test
	void testEmpateNumPecasIgualJ2() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 5));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(3, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		
		assertEquals(9,j.getJogador1().getPontuacao());
		assertEquals(6,j.getJogador2().getPontuacao());
		
		assertEquals("J2",j.getVencedor());
	}
	
	@Test
	void testEmpateNumPecasDiferenteJ1() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 5));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(3, 3), new Peca(6,6));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		
		assertEquals(9,j.getJogador1().getPontuacao());
		assertEquals(18,j.getJogador2().getPontuacao());
		
		assertEquals("J1",j.getVencedor());
	}
	
	@Test
	void testEmpateNumPecasDiferenteJ2() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 5), new Peca(3,4));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(3, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		
		assertEquals(16,j.getJogador1().getPontuacao());
		assertEquals(6,j.getJogador2().getPontuacao());
		
		assertEquals("J2",j.getVencedor());
	}
	
	@Test
	void testContaPontuacaoLaloCarrocao() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(3, 3), new Peca(3, 2), new Peca(2, 2));
		List<Peca> mao2 = List.of(new Peca(0, 3), new Peca(0, 2), new Peca(6, 6), new Peca(5, 4));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		assertTrue(j.isFinalizado());
		assertEquals(6,j.getPontuacao());
	}
	
	@Test
	void testContaPontuacaoCarrocao() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(3, 3), new Peca(2, 2));
		List<Peca> mao2 = List.of(new Peca(0, 3), new Peca(0, 2), new Peca(6, 6), new Peca(5, 4));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		assertTrue(j.isFinalizado());
		assertEquals(2,j.getPontuacao());
	}
	
	@Test
	void testContaPontuacaoLaloNormal() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(3, 3), new Peca(2, 3));
		List<Peca> mao2 = List.of(new Peca(0, 3), new Peca(0, 2), new Peca(6, 6), new Peca(5, 4));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		assertTrue(j.isFinalizado());
		assertEquals(3,j.getPontuacao());
	}
	
	@Test
	void testContaPontuacaoNormal() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(3, 3), new Peca(2, 0));
		List<Peca> mao2 = List.of(new Peca(0, 3), new Peca(0, 2), new Peca(6, 6), new Peca(5, 4));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		assertTrue(j.isFinalizado());
		assertEquals(1,j.getPontuacao());
	}
	
	@Test
	void testVitoriaJ2() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(6, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(1, 2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
	}
}
