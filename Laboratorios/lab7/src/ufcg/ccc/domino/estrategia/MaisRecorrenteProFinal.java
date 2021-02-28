/**
 * 
 */
package ufcg.ccc.domino.estrategia;

import java.util.Arrays;
import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Peca;

/**
 * Deixa as pecas com o numero mais recorrente na mao pra ser jogado por ultimo. 
 * Tenta primeiro no lado direito e depois esquerdo, se encaixar em ambas.
 */
public class MaisRecorrenteProFinal implements EstrategiaDeJogo {

	@Override
	public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao) {

		int maior = numeroMaisRecorrente(mao);
		
		if (mesa.getNumPecas() == 0) {
			for (Peca peca : mao) {
				if (peca.getNumDireito() != maior && peca.getNumEsquerdo() != maior) {
					return new Jogada(peca, TipoJogada.NA_DIREITA);
				}				
			}
		}
		
		// tenta jogar primeiro as pecas que nao tem o numero mais recorrente
		for (Peca peca : mao) {
			if (peca.getNumDireito() != maior && peca.getNumEsquerdo() != maior) {
				if (peca.encaixa(mesa.getNumNaDireita())) {
					return new Jogada(peca, TipoJogada.NA_DIREITA);
				}
				if (peca.encaixa(mesa.getNumNaEsquerda())) {
					return new Jogada(peca, TipoJogada.NA_ESQUERDA);
				}
			}
		}
		
		// se nao nao puder poupar as mais recorrentes, joga a primeira que encaixar
		for (Peca peca : mao) {
			if (peca.encaixa(mesa.getNumNaDireita())) {
				return new Jogada(peca, TipoJogada.NA_DIREITA);
			}
			if (peca.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca, TipoJogada.NA_ESQUERDA);
			}
		}
		return new Jogada();
	}
	
	private int numeroMaisRecorrente(List<Peca> mao) {
		
		int zero = 0,
			um = 0,
			dois = 0,
			tres = 0,
			quatro = 0,
			cinco = 0,
			seis = 0;
		
		for (Peca peca : mao) {
			
			if (peca.getNumDireito() == 0) {
				zero ++;
			} else if (peca.getNumDireito() == 1) {
				um ++;
			} else if (peca.getNumDireito() == 2) {
				dois ++;
			} else if(peca.getNumDireito() == 3) {
				tres ++;
			} else if(peca.getNumDireito() == 4) {
				quatro ++;
			} else if(peca.getNumDireito() == 5) {
				cinco ++;
			} else if(peca.getNumDireito() == 6) {
				seis ++;
			} 
			
			if (peca.getNumEsquerdo() == 0) {
				zero ++;
			}else if (peca.getNumEsquerdo() == 1) {
				um ++;
			} else if (peca.getNumDireito() == 2) {
				dois ++;
			} else if(peca.getNumDireito() == 3) {
				tres ++;
			} else if(peca.getNumDireito() == 4) {
				quatro ++;
			} else if(peca.getNumDireito() == 5) {
				cinco ++;
			} else if(peca.getNumDireito() == 6) {
				seis ++;
			}
		}
		
		int lista[] = {zero, um, dois, tres, quatro, cinco, seis};
		int maior = Arrays.stream(lista).max().getAsInt();
		
		return maior;
	}

}
