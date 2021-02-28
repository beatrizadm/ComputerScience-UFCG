package ufcg.ccc.domino.estrategia;

import java.util.ArrayList;
import java.util.Scanner;

import ufcg.ccc.domino.HistoricoDeJogo;
import ufcg.ccc.domino.JogadaInvalidaException;
import ufcg.ccc.domino.Jogo;

/**
 * Campeonato brutal, as duas estratégias que o usuario escolher jogam 10 mil vezes 
 * contra a estrategia remanescente.
 * 
 * @author Beatriz Miranda - 119210170
 *
 */
public class CampeonatoBrutal {
	public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {
		Scanner sc = new Scanner(System.in);
		String[] estrategia = new String[2];
		
		System.out.print("BEM VINDO AO CAMPEONATO BRUTAL :)" +
						 "\nAs opcoes possiveis de estrategias sao:" + 
						 "\n1) Jogar a primeira possivel" +
						 "\n2) Jogar carrocao primeiro" +
						 "\n3) Deixar as pecas mais recorrentes pro final" +
						 "\n\nEscolha as duas estrategias que entraram no campeonato:" +
						 "\nPrimeira estrategia: "
						 );
		estrategia[0] = sc.nextLine();
		System.out.print("Segunda estrategia: ");
		estrategia[1] = sc.nextLine();
		
		// checando se alguma das opcoes ficou vazia
		ArrayList<String> estrategias = new ArrayList<String>();
		for (String e : estrategia) {
			if (!e.isBlank()) {
				estrategias.add(e);
			}
		}
		
		if (estrategias.size() == 0 || estrategias.size() == 1) {
			throw new IllegalArgumentException("Erro na escolha das estrategias: "
					+ "precisa ser escolhido no minimo duas estrategias para ocorrer o campeonato brutal");
		}
		
		for (String e : estrategias) {
			if (!e.equals("1") && !e.equals("2") && !e.equals("3")) {
				throw new IllegalArgumentException("Erro na escolha das estrategias: "
						+ "os numeros escolhidos precisam ser 1, 2 ou 3");
			}
		}
		
		if (estrategias.get(0).equals(estrategias.get(1))) {
			throw new IllegalArgumentException("Erro na escolha das estrategias: "
					+ "nao podem ser escolhidas estrategias iguais");
		}
		
		if (estrategias.size() == 2) {
			System.out.print(campeonato(estrategias));
		}
	}
	
	/**
	 * Metodo que inicializa a estrategia de acordo com seu numero
	 * @param numEstrategia string com o numero da estrategia
	 * @return inicializa a estrategia
	 */
	static EstrategiaDeJogo checaEstrategia(String numEstrategia) {
		EstrategiaDeJogo e = null;
		
		if (numEstrategia.equals("1")) {
			e = new JogaPrimeiraPossivel();
		} else if (numEstrategia.equals("2")) {
			e = new JogaCarrocaoPrimeiro();
		} else if (numEstrategia.equals("3")) {
			e = new MaisRecorrenteProFinal();
		}
		return e;
	}
	
	/**
	 * Metodo que retorna o nome da estrategia escolhida
	 * @param numEstrategia String com o numero da estrategia
	 * @return nome da estrategia
	 */
	static String getNomeEstrategia(String numEstrategia) {
		String nome = "";
		if (numEstrategia.equals("1")) {
			nome = "JogaPrimeiraPossivel";
		} else if (numEstrategia.equals("2")) {
			nome = "JogaCarrocaoPrimeiro";
		} else if (numEstrategia.equals("3")) {
			nome = "MaisRecorrenteProFinal";
		}
		return nome;
	}
	
	/**
	 * Metodo que inicializa a estrategia remanescente
	 * @param estrategias arraylist com todas as estrategias escolhidas pelo usuario
	 * @return inicializa a estrategia remanescente
	 */
	static EstrategiaDeJogo estrategiaRemanescente(ArrayList<String> estrategias) {
		EstrategiaDeJogo e = null;
		
		if (!estrategias.contains("1")) {
			e = new JogaPrimeiraPossivel();
		} else if (!estrategias.contains("2")) {
			e = new JogaCarrocaoPrimeiro();
		} else if (!estrategias.contains("3")) {
			e = new MaisRecorrenteProFinal();
		}
		return e;
	}
	
	/**
	 * Metodo que retorna o numero da estrategia remanescente
	 * @param estrategias arraylist com todas as estrategias escolhidas pelo usuario
	 * @return numero da estrategia remanescente
	 */
	static String getNumRemanescente(ArrayList<String> estrategias) {
		String num = "";
		
		if (!estrategias.contains("1")) {
			num = "1";
		} else if (!estrategias.contains("2")) {
			num = "2";
		} else if (!estrategias.contains("3")) {
			num = "3";
		}
		
		return num;
	}
	
	/**
	 * Metodo que realiza as disputas entre as estrategias
	 * @param estrategias arraylist com todas as estrategias escolhidas pelo usuario
	 * @return resultado do campeonato
	 * @throws EstrategiaInvalidaException
	 * @throws JogadaInvalidaException
	 */
	static String campeonato(ArrayList<String> estrategias) throws EstrategiaInvalidaException, JogadaInvalidaException {
		
		EstrategiaDeJogo e1 = checaEstrategia(estrategias.get(0));
		EstrategiaDeJogo remanescente = estrategiaRemanescente(estrategias);
		String numRemanescente = getNumRemanescente(estrategias);
		
		int vitoriasEstrategia1 = 0, 
			vitoriasRemanescente = 0, 
			empates = 0;
			
		for (int i = 0; i < 5000; i++) {
			Jogo j = new Jogo("J1", e1, "J2", remanescente, 12);
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.isEmpate()) {
				empates++;
			} else if (historico.getVencedor() == "J1") {
				vitoriasEstrategia1 ++;
				
			} else if (historico.getVencedor() == "J2") {
				vitoriasRemanescente ++;
			}
		}
		
		for (int i = 0; i < 5000; i++) {
			Jogo j = new Jogo("J2", remanescente, "J1", e1, 12);
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.isEmpate()) {
				empates++;
			} else if (historico.getVencedor() == "J1") {
				vitoriasEstrategia1 ++;
				
			} else if (historico.getVencedor() == "J2") {
				vitoriasRemanescente ++;
			}
		}

		String mensagem = "\n\nRESULTADO DO CAMPEONATO" +
							"\nVitorias " + getNomeEstrategia(estrategias.get(0)) + ": " + vitoriasEstrategia1 + 
							"\nVitorias " + getNomeEstrategia(numRemanescente) + ": " + vitoriasRemanescente + 
							"\nEmpates: " + empates;
		
		EstrategiaDeJogo est2 = checaEstrategia(estrategias.get(1));
			
		vitoriasRemanescente = 0;
		int vitoriasEstrategia2 = 0; 
		empates = 0;
				
		for (int i = 0; i < 5000; i++) {
			Jogo j = new Jogo("J1", remanescente, "J2", est2, 12);
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.isEmpate()) {
				empates++;
			} else if (historico.getVencedor() == "J1") {
				vitoriasRemanescente ++;
			} else if (historico.getVencedor() == "J2") {
				vitoriasEstrategia2 ++;
			}
		}
				
		for (int i = 0; i < 5000; i++) {
			Jogo j = new Jogo("J2", est2, "J1", remanescente, 12);
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.isEmpate()) {
				empates++;
			} else if (historico.getVencedor() == "J1") {
				vitoriasRemanescente ++;
			} else if (historico.getVencedor() == "J2") {
				vitoriasEstrategia2 ++;
			}
		}

		mensagem += "\n\nRESULTADO DO CAMPEONATO" +
					"\nVitorias " + getNomeEstrategia(numRemanescente) + ": " + vitoriasRemanescente + 
					"\nVitorias " + getNomeEstrategia(estrategias.get(1)) + ": " + vitoriasEstrategia2 + 
					"\nEmpates: " + empates;
		
		return mensagem;
	}

}
