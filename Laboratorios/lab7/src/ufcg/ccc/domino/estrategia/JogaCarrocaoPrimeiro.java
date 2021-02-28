/**
 * 
 */
package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Peca;

/**
 * Joga sempre o primeiro carrocao encaixa, e dps se a peca encaixa. 
 * Tenta primeiro no lado direito e depois esquerdo, se encaixar em ambas.
 */
public class JogaCarrocaoPrimeiro implements EstrategiaDeJogo {

	@Override
	public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao) {

		// se a mesa estiver vazia ve se tem carrocao na mao para jogar primeiro
		if (mesa.getNumPecas() == 0) {
			for (Peca peca : mao) {
				if (peca.getNumDireito() == peca.getNumEsquerdo()) {
					return new Jogada(peca, TipoJogada.NA_DIREITA);
				}
			}
			return new Jogada(mao.get(0), TipoJogada.NA_DIREITA);
		}

		for (Peca peca : mao) {
			
			if (peca.getNumDireito() == peca.getNumEsquerdo()) {
				if (peca.encaixa(mesa.getNumNaDireita())) {
					return new Jogada(peca, TipoJogada.NA_DIREITA);
				}
				if (peca.encaixa(mesa.getNumNaEsquerda())) {
					return new Jogada(peca, TipoJogada.NA_ESQUERDA);
				}
			}
			
			if (peca.encaixa(mesa.getNumNaDireita())) {
				return new Jogada(peca, TipoJogada.NA_DIREITA);
			}
			if (peca.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca, TipoJogada.NA_ESQUERDA);
			}
		}

		return new Jogada();
	}

}

