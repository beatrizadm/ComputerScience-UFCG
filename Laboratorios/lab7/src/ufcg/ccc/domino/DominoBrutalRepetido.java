package ufcg.ccc.domino;

import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaCarrocaoPrimeiro;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;
import ufcg.ccc.domino.estrategia.MaisRecorrenteProFinal;

/**
 * Exemplo de como fazer um um main com uma disputa de muuuitos jogos entre duas
 * estrategias.
 */
public class DominoBrutalRepetido {

	public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {
		int jogos = 0,
			
			vitoriasJ1 = 0,
			pontosJ1 = 0,
			
			normalJ1 = 0,
			carrocaoJ1 = 0,
			laloJ1 = 0,
			laloCarrocaoJ1 = 0,
			
			vitoriasJ2 = 0,
			pontosJ2 = 0,
					
			normalJ2 = 0,
			carrocaoJ2 = 0,
			laloJ2 = 0,
			laloCarrocaoJ2 = 0,
			
			empates = 0;

		EstrategiaDeJogo e1 = new JogaCarrocaoPrimeiro(), e2 = new MaisRecorrenteProFinal(); 
		
		for (int i = 0; i < 10000; i++) {
			
			Jogo j = null;
			
			if (i < 5000) {
				j = new Jogo("J1", e1, "J2", e2, 12);
			} else {
				j = new Jogo("J2", e2, "J1", e1, 12);
			}
			
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			
			if (historico.isEmpate()) {
				empates++;
			
			} else if (historico.getVencedor() == "J1") {
				vitoriasJ1 ++;
				pontosJ1 += j.getPontuacao();
				
				if (j.getPontuacao() == 1) {
					normalJ1 ++;
				} else if (j.getPontuacao() == 2) {
					carrocaoJ1 ++;
				} else if (j.getPontuacao() == 3) {
					laloJ1 ++;
				} else if (j.getPontuacao() == 6) {
					laloCarrocaoJ1 ++;
				} 

			} else if (historico.getVencedor() == "J2") {
				vitoriasJ2 ++;
				pontosJ2 += j.getPontuacao();
				
				if (j.getPontuacao() == 1) {
					normalJ2 ++;
				} else if (j.getPontuacao() == 2) {
					carrocaoJ2 ++;
				} else if (j.getPontuacao() == 3) {
					laloJ2 ++;
				} else if (j.getPontuacao() == 6) {
					laloCarrocaoJ2 ++;
				} 
			}
			
			jogos ++;
		}
		
		System.out.println("1) Elas entre si" +
						"\nJOGA CARROCAO PRIMEIRO x MAIS RECORRENTE PRO FINAL" +
						"\nQuantidade de jogos: " + jogos +
						"\nJ1: " + vitoriasJ1 + " vitorias - " + pontosJ1 + " pontos" +
						"\nJ2: " + vitoriasJ2 + " vitorias - " + pontosJ2 + " pontos" +
						"\nEmpates: " + empates +
						"\n\n--------------- jogador 1 -----------------" + 
						"\nBatida normal: " + normalJ1 + " vitorias - " + (normalJ1*1) + " pontos" +
						"\nBatida carrocao: " + carrocaoJ1 + " vitorias - " + (carrocaoJ1*2) + " pontos" +
						"\nLalo normal: " + laloJ1 + " vitorias - " + (laloJ1*3) + " pontos" +
						"\nLalo carrocao: " + laloCarrocaoJ1 + " vitorias - " + (laloCarrocaoJ1*6) + " pontos" +
						"\n\n--------------- jogador 2 -----------------" + 
						"\nBatida normal: " + normalJ2 + " vitorias - " + (normalJ2*1) + " pontos" +
						"\nBatida carrocao: " + carrocaoJ2 + " vitorias - " + (carrocaoJ2*2) + " pontos" +
						"\nLalo normal: " + laloJ2 + " vitorias - " + (laloJ2*3) + " pontos" +
						"\nLalo carrocao: " + laloCarrocaoJ2 + " vitorias - " + (laloCarrocaoJ2*6) + " pontos");
	
		jogos = 0;
				
		vitoriasJ1 = 0;
		pontosJ1 = 0;
					
		normalJ1 = 0;
		carrocaoJ1 = 0;
		laloJ1 = 0;
		laloCarrocaoJ1 = 0;
					
		vitoriasJ2 = 0;
		pontosJ2 = 0;
						
		normalJ2 = 0;
		carrocaoJ2 = 0;
		laloJ2 = 0;
		laloCarrocaoJ2 = 0;
					
		empates = 0;

		EstrategiaDeJogo est1 = new JogaCarrocaoPrimeiro(), est2 = new JogaPrimeiraPossivel(); 
		
		for (int i = 0; i < 10000; i++) {
			Jogo j = null;
			
			if (i < 5000) {
				j = new Jogo("J1", est1, "J2", est2, 12);
			} else {
				j = new Jogo("J2", est2, "J1", est1, 12);
			}
			
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			
			if (historico.isEmpate()) {
				empates++;
			
			} else if (historico.getVencedor() == "J1") {
				vitoriasJ1 ++;
				pontosJ1 += j.getPontuacao();
				
				if (j.getPontuacao() == 1) {
					normalJ1 ++;
				} else if (j.getPontuacao() == 2) {
					carrocaoJ1 ++;
				} else if (j.getPontuacao() == 3) {
					laloJ1 ++;
				} else if (j.getPontuacao() == 6) {
					laloCarrocaoJ1 ++;
				} 

			} else if (historico.getVencedor() == "J2") {
				vitoriasJ2 ++;
				pontosJ2 += j.getPontuacao();
				
				if (j.getPontuacao() == 1) {
					normalJ2 ++;
				} else if (j.getPontuacao() == 2) {
					carrocaoJ2 ++;
				} else if (j.getPontuacao() == 3) {
					laloJ2 ++;
				} else if (j.getPontuacao() == 6) {
					laloCarrocaoJ2 ++;
				} 
			}
			jogos ++;
		}
	
		System.out.println("\n\n\n\n\n2) Elas contra a estratégia JogaPrimeiraPossivel"	+ 		
						"\nJOGA CARROCAO PRIMEIRO x JOGA PRIMEIRA POSSIVEL" +
						"\nQuantidade de jogos: " + jogos +
						"\nJ1: " + vitoriasJ1 + " vitorias - " + pontosJ1 + " pontos" +
						"\nJ2: " + vitoriasJ2 + " vitorias - " + pontosJ2 + " pontos" +
						"\nEmpates: " + empates +
						"\n\n--------------- jogador 1 -----------------" + 
						"\nBatida normal: " + normalJ1 + " vitorias - " + (normalJ1*1) + " pontos" +
						"\nBatida carrocao: " + carrocaoJ1 + " vitorias - " + (carrocaoJ1*2) + " pontos" +
						"\nLalo normal: " + laloJ1 + " vitorias - " + (laloJ1*3) + " pontos" +
						"\nLalo carrocao: " + laloCarrocaoJ1 + " vitorias - " + (laloCarrocaoJ1*6) + " pontos" +
						"\n\n--------------- jogador 2 -----------------" + 
						"\nBatida normal: " + normalJ2 + " vitorias - " + (normalJ2*1) + " pontos" +
						"\nBatida carrocao: " + carrocaoJ2 + " vitorias - " + (carrocaoJ2*2) + " pontos" +
						"\nLalo normal: " + laloJ2 + " vitorias - " + (laloJ2*3) + " pontos" +
						"\nLalo carrocao: " + laloCarrocaoJ2 + " vitorias - " + (laloCarrocaoJ2*6) + " pontos");
	
		jogos = 0;
		
		vitoriasJ1 = 0;
		pontosJ1 = 0;
					
		normalJ1 = 0;
		carrocaoJ1 = 0;
		laloJ1 = 0;
		laloCarrocaoJ1 = 0;
					
		vitoriasJ2 = 0;
		pontosJ2 = 0;
						
		normalJ2 = 0;
		carrocaoJ2 = 0;
		laloJ2 = 0;
		laloCarrocaoJ2 = 0;
					
		empates = 0;


		EstrategiaDeJogo estrat1 = new MaisRecorrenteProFinal(), estrat2 = new JogaPrimeiraPossivel(); 
		
		for (int i = 0; i < 10000; i++) {
			
			Jogo j = null;
			
			if (i < 5000) {
				j = new Jogo("J1", estrat1, "J2", estrat2, 12);
			} else {
				j = new Jogo("J2", estrat2, "J1", estrat1, 12);
			}
			
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			
			if (historico.isEmpate()) {
				empates++;
			
			} else if (historico.getVencedor() == "J1") {
				vitoriasJ1 ++;
				pontosJ1 += j.getPontuacao();
				
				if (j.getPontuacao() == 1) {
					normalJ1 ++;
				} else if (j.getPontuacao() == 2) {
					carrocaoJ1 ++;
				} else if (j.getPontuacao() == 3) {
					laloJ1 ++;
				} else if (j.getPontuacao() == 6) {
					laloCarrocaoJ1 ++;
				} 

			} else if (historico.getVencedor() == "J2") {
				vitoriasJ2 ++;
				pontosJ2 += j.getPontuacao();
				
				if (j.getPontuacao() == 1) {
					normalJ2 ++;
				} else if (j.getPontuacao() == 2) {
					carrocaoJ2 ++;
				} else if (j.getPontuacao() == 3) {
					laloJ2 ++;
				} else if (j.getPontuacao() == 6) {
					laloCarrocaoJ2 ++;
				} 
			}
			jogos ++;
		}
	
		System.out.println("\n\n\n\n\nMAIS RECORRENTE PRO FINAL x JOGA PRIMEIRA POSSIVEL" +
						"\nQuantidade de jogos: " + jogos +
						"\nJ1: " + vitoriasJ1 + " vitorias - " + pontosJ1 + " pontos" +
						"\nJ2: " + vitoriasJ2 + " vitorias - " + pontosJ2 + " pontos" +
						"\nEmpates: " + empates +
						"\n\n--------------- jogador 1 -----------------" + 
						"\nBatida normal: " + normalJ1 + " vitorias - " + (normalJ1*1) + " pontos" +
						"\nBatida carrocao: " + carrocaoJ1 + " vitorias - " + (carrocaoJ1*2) + " pontos" +
						"\nLalo normal: " + laloJ1 + " vitorias - " + (laloJ1*3) + " pontos" +
						"\nLalo carrocao: " + laloCarrocaoJ1 + " vitorias - " + (laloCarrocaoJ1*6) + " pontos" +
						"\n\n--------------- jogador 2 -----------------" + 
						"\nBatida normal: " + normalJ2 + " vitorias - " + (normalJ2*1) + " pontos" +
						"\nBatida carrocao: " + carrocaoJ2 + " vitorias - " + (carrocaoJ2*2) + " pontos" +
						"\nLalo normal: " + laloJ2 + " vitorias - " + (laloJ2*3) + " pontos" +
						"\nLalo carrocao: " + laloCarrocaoJ2 + " vitorias - " + (laloCarrocaoJ2*6) + " pontos");
	}
}
