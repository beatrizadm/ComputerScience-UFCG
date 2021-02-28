package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;

class JogaCarrocaoPrimeiroTest {

	private Mesa mesa;

	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 3));
		mesa.jogaNaEsquerda(new Peca(1, 4));
	}

	@Test
	void testPassa() {
		JogaCarrocaoPrimeiro estrategia = new JogaCarrocaoPrimeiro();
		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(2, 5), new Peca(0, 6)));
		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}

	@Test
	void testCarrocaoDireita() {
		JogaCarrocaoPrimeiro estrategia = new JogaCarrocaoPrimeiro();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(3, 3), new Peca(0, 2), new Peca(2, 6)));

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(3, j1.getPeca().getNumEsquerdo());
		assertEquals(3, j1.getPeca().getNumDireito());
	}

	@Test
	void testCarrocaoEsquerda() {
		JogaCarrocaoPrimeiro estrategia = new JogaCarrocaoPrimeiro();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(4, 4), new Peca(0, 2), new Peca(2, 6)));

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(4, j1.getPeca().getNumEsquerdo());
		assertEquals(4, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testCarrocaoNaoEncaixa() {
		JogaCarrocaoPrimeiro estrategia = new JogaCarrocaoPrimeiro();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(6, 6), new Peca(0, 2), new Peca(2, 6)));

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}
	
	
	@Test
	void testNormalDireita() {
		JogaCarrocaoPrimeiro estrategia = new JogaCarrocaoPrimeiro();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(3, 1), new Peca(0, 2), new Peca(2, 6)));

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(3, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testNormalEsquerda() {
		JogaCarrocaoPrimeiro estrategia = new JogaCarrocaoPrimeiro();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(4, 1), new Peca(0, 2), new Peca(2, 6)));

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(4, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testMesaVaziaCarrocao() {
		JogaCarrocaoPrimeiro estrategia = new JogaCarrocaoPrimeiro();

		Mesa mesa1 = new Mesa();
		
		Jogada j1 = estrategia.decideJogada(mesa1, List.of(new Peca(4, 4), new Peca(0, 2), new Peca(2, 6)));

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(4, j1.getPeca().getNumEsquerdo());
		assertEquals(4, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testMesaVaziaSemCarrocao() {
		JogaCarrocaoPrimeiro estrategia = new JogaCarrocaoPrimeiro();

		Mesa mesa1 = new Mesa();
		
		Jogada j1 = estrategia.decideJogada(mesa1, List.of(new Peca(4, 1), new Peca(0, 2), new Peca(2, 6)));

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(4, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito());
	}

}
