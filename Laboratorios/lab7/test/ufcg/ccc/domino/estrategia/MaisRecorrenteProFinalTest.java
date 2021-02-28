package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;

class MaisRecorrenteProFinalTest {

	private Mesa mesa;

	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 3));
		mesa.jogaNaEsquerda(new Peca(1, 4));
	}

	@Test
	void testPassa() {
		MaisRecorrenteProFinal estrategia = new MaisRecorrenteProFinal();
		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(2, 5), new Peca(0, 6)));
		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}

	@Test
	void testNaoRecorrenteDireita() {
		MaisRecorrenteProFinal estrategia = new MaisRecorrenteProFinal();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(0, 2), new Peca(2, 4), new Peca(3, 3)));

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(3, j1.getPeca().getNumEsquerdo());
		assertEquals(3, j1.getPeca().getNumDireito());
	}

	@Test
	void testNaoRecorrenteEsquerda() {
		MaisRecorrenteProFinal estrategia = new MaisRecorrenteProFinal();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(3, 2), new Peca(2, 6), new Peca(4, 1)));

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(4, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testQualquerPecaDireita() {
		MaisRecorrenteProFinal estrategia = new MaisRecorrenteProFinal();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(0, 5), new Peca(2, 5), new Peca(3, 5)));

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(3, j1.getPeca().getNumEsquerdo());
		assertEquals(5, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testQualquerPecaEsquerda() {
		MaisRecorrenteProFinal estrategia = new MaisRecorrenteProFinal();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(1, 0), new Peca(2, 6), new Peca(4, 6)));

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(4, j1.getPeca().getNumEsquerdo());
		assertEquals(6, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testMesaVazia() {
		MaisRecorrenteProFinal estrategia = new MaisRecorrenteProFinal();

		Mesa mesa1 = new Mesa();
		
		Jogada j1 = estrategia.decideJogada(mesa1, List.of(new Peca(4, 4), new Peca(0, 2), new Peca(2, 6)));

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(4, j1.getPeca().getNumEsquerdo());
		assertEquals(4, j1.getPeca().getNumDireito());
	}

}
