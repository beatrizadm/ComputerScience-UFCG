
package lab2;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * A Classe Input tem exemplos de entrada para esta Classe LinhaDeComando
 * 
 * tem um comentario acima de cada if com os dados da entrada desejada
 * que estao separados por tres espacos apenas para facilitar a leitura
 * porem na entrada cada variavel deve ser separada por apenas um espaco (" ")
 * 
 * caso queira inserir mais de um nome para cada variavel, utilize underline como divisor,
 * por exemplo: bojack_horseman
 * 
 * o programa faz distinção de maiusculo e minusculo, 
 * entao se for colocada uma variavel BOJACK_HORSEMAN
 * e outra variavel bojack_horseman
 * serao consideradas duas variaveis distintas
 *  
 */

public class LinhaDeComando {
	
	private static ArrayList<Organizacao> org = new ArrayList<Organizacao>();
	private static ArrayList<Lazer> lazer = new ArrayList<Lazer>();
	private static ArrayList<Estudo> estudo = new ArrayList<Estudo>();
	private static ArrayList<EstudoDirigido> dirigido = new ArrayList<EstudoDirigido>();
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		while (true) {
			
			String comando = sc.nextLine();
			if (comando.equals("SAIR")) {
				break;
			
				
			} else {
				String[] splitado = comando.split(" ");
				
				
// Classe Organizacao		
				
				//CRIAR_TAREFA   NOME_TAREFA   NUMERO_TAREFAS
				if (splitado[0].equals("CRIAR_TAREFA")) {
					String nome = splitado[1];
					int nTarefas = Integer.parseInt(splitado[2]);
					Organizacao objetoOrg = new Organizacao(nome, nTarefas);
					org.add(objetoOrg);
					
					
				} else if (splitado[0].equals("CADASTRAR_TAREFA")) {
					
					//CADASTRAR_TAREFA   NOME_TAREFA   ID   MINUTOS
					if (splitado.length == 4) {
						
						int i = IndiceObjetoOrg(splitado[1]);
						int id = Integer.parseInt(splitado[2]);
						int min = Integer.parseInt(splitado[3]);
						
						org.get(i).cadastraTarefa(id, min);
						
						
					//CADASTRAR_TAREFA   NOME_TAREFA   INDICE   MINUTOS   DESCRICAO	
					} else {
						
						int i = IndiceObjetoOrg(splitado[1]);
						int id = Integer.parseInt(splitado[2]);
						int min = Integer.parseInt(splitado[3]);
						String descricao = splitado[4];
						
						org.get(i).cadastraTarefa(id, min, descricao);
						
					}
					
				// MEDIA_TAREFA   NOME_TAREFA
				} else if (splitado[0].equals("MEDIA_TAREFA")) {
					
					int i = IndiceObjetoOrg(splitado[1]);
					System.out.println(org.get(i).mediaTarefa());
					
					
				//TAREFA_COMPLETA   NOME_TAREFA
				} else if (splitado[0].equals("TAREFA_COMPLETA")) {
					
					int i = IndiceObjetoOrg(splitado[1]);
					System.out.println(org.get(i).toString());
					
					
				// DESCRICAO_TAREFA   NOME_TAREFA   INDICE
				} else if (splitado[0].equals("DESCRICAO_TAREFA")) {
					
					int indiceObjeto = IndiceObjetoOrg(splitado[1]);
					int indiceTarefa = Integer.parseInt(splitado[2]);
					System.out.println(org.get(indiceObjeto).getDescricao(indiceTarefa));
				
					
// Classe Lazer		
				
				} else if (splitado[0].equals("CADASTRAR_LAZER")) {
					
					//CADASTRAR_LAZER   TIPO_LAZER
					if (splitado.length == 2) {
						
						String tipo = splitado[1];
						Lazer objetoLazer = new Lazer(tipo);
						lazer.add(objetoLazer);
					
						
					//CADASTRAR_LAZER   TIPO_LAZER   LIMITE
					} else {
						
						String tipo = splitado[1];
						int limite = Integer.parseInt(splitado[2]);
						Lazer objetoLazer = new Lazer(tipo, limite);
						lazer.add(objetoLazer);
					}
				
				//CADASTRAR_ATIVIDADE   TIPO_LAZER   NOME_ATIVIDADE   MINUTOS
				} else if (splitado[0].equals("CADASTRAR_ATIVIDADE")) {
					
					int indiceLazer = IndiceObjetoLazer(splitado[1]);
					String atividade = splitado[2];
					int minutos = Integer.parseInt(splitado[3]);
					lazer.get(indiceLazer).cadastraAtividade(atividade, minutos);
				
				
				//TOTAL_ATIVIDADES   TIPO_LAZER
				} else if(splitado[0].equals("TOTAL_ATIVIDADES")) {
					
					int indiceLazer = IndiceObjetoLazer(splitado[1]);
					System.out.println(lazer.get(indiceLazer).totalAtividades());
					
				
				//TEMPO_TOTAL_ATIVIDADES   TIPO_LAZER
				} else if (splitado[0].equals("TEMPO_TOTAL_ATIVIDADES")) {
					
					int indiceLazer = IndiceObjetoLazer(splitado[1]);
					System.out.println(lazer.get(indiceLazer).tempoTotal());
				
					
				//MAIOR_ATIVIDADE   TIPO_LAZER
				} else if (splitado[0].equals("MAIOR_ATIVIDADE")) {
					
					int indiceLazer = IndiceObjetoLazer(splitado[1]);
					System.out.println(lazer.get(indiceLazer).maiorAtividade());
				
				
				//MENOR_ATIVIDADE   TIPO_LAZER
				} else if (splitado[0].equals("MENOR_ATIVIDADE")) {
					
					int indiceLazer = IndiceObjetoLazer(splitado[1]);
					System.out.println(lazer.get(indiceLazer).menorAtividade());
				
					
				//ATIVIDADE_COMPLETA   TIPO_LAZER
				} else if (splitado[0].equals("ATIVIDADE_COMPLETA")) {
					
					int indiceLazer = IndiceObjetoLazer(splitado[1]);
					System.out.println(lazer.get(indiceLazer).toString());
				
	
// Classe Estudo
					
				//CRIAR_ESTUDO   NOME_ESTUDO
				} else if (splitado[0].equals("CRIAR_ESTUDO")){
					
					String nome = splitado[1];
					Estudo objetoEstudo = new Estudo(nome);
					estudo.add(objetoEstudo);
					
				
				//ADICIONAR_MINUTOS   NOME_ESTUDO   MINUTOS
				} else if (splitado[0].equals("ADICIONAR_MINUTOS")){
					
					int i = IndiceObjetoEstudo(splitado[1]);
					int min = Integer.parseInt(splitado[2]);
					estudo.get(i).adicionaMinutos(min);
					
					
				//DEVE_DESCANSAR   NOME_ESTUDO	
				} else if (splitado[0].equals("DEVE_DESCANSAR")){
					
					int i = IndiceObjetoEstudo(splitado[1]);
					System.out.println(estudo.get(i).deveDescansar());
					
					
				//ESTUDO_COMPLETO   NOME_ESTUDO
				} else if (splitado[0].equals("ESTUDO_COMPLETO")){
					
					int i = IndiceObjetoEstudo(splitado[1]);
					System.out.println(estudo.get(i).toString());
					
	
// Classe EstudoDirigido
				
				//CRIAR_ESTUDO_DIRIGIDO   NOME_DIRIGIDO
				} else if (splitado[0].equals("CRIAR_ESTUDO_DIRIGIDO")){
					
					String nome = splitado[1];
					EstudoDirigido objetoDirigido = new EstudoDirigido(nome);
					dirigido.add(objetoDirigido);
				
				
				//CADASTRAR_ESTUDO_DIRIGIDO   NOME_DIRIGIDO   NOME_ESTUDO
				} else if (splitado[0].equals("CADASTRAR_ESTUDO_DIRIGIDO")){
					
					int iDirigido = IndiceObjetoDirigido(splitado[1]);
					int iEstudo = IndiceObjetoEstudo(splitado[2]);
					dirigido.get(iDirigido).cadastraEstudo(estudo.get(iEstudo));
					
					
				//DIRIGIDO_TEMPO_TOTAL   NOME_DIRIGIDO	
				} else if (splitado[0].equals("DIRIGIDO_TEMPO_TOTAL")){
					
					int i = IndiceObjetoDirigido(splitado[1]);
					System.out.println(dirigido.get(i).contaTempoTotal());
					
					
				//DIRIGIDO_COMPLETO   NOME_DIRIGIDO
				} else if (splitado[0].equals("DIRIGIDO_COMPLETO")){
					
					int i = IndiceObjetoDirigido(splitado[1]);
					System.out.println(dirigido.get(i).toString());
					
				} 
			}
		}
	}
	
	public static int IndiceObjetoOrg(String nome) {
		int indice = 0;
		for (int i = 0; i < org.size(); i++) {
			if (org.get(i).getLocal().equals(nome)){
				indice = i;
			}
		}
		return indice;
	}
	
	public static int IndiceObjetoLazer(String nome) {
		int indice = 0;
		for (int i = 0; i < lazer.size(); i++) {
			if (lazer.get(i).getTipo().equals(nome)){
				indice = i;
			}
		}
		return indice;
	}
	
	public static int IndiceObjetoEstudo(String nome) {
		int indice = 0;
		for (int i = 0; i < estudo.size(); i++) {
			if (estudo.get(i).getNomeDaMateria().equals(nome)){
				indice = i;
			}
		}
		return indice;
	}
	
	public static int IndiceObjetoDirigido(String nome) {
		int indice = 0;
		for (int i = 0; i < dirigido.size(); i++) {
			if (dirigido.get(i).getNome().equals(nome)){
				indice = i;
			}
		}
		return indice;
	}
}
