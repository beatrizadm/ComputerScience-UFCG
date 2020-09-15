package lab03;

import java.util.Scanner;

public class CLI {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		AmigoVirtualRepositorio repositorio = new AmigoVirtualRepositorio();
		
		while (true) {
		
			System.out.println("-- Amigo Virtual --\n" + 
							   "(C)adastrar\n" + 
					           "(E)xibir\n" + 
					           "(P)rocurar\n" + 
					           "(V)erificar Repeticoes\n" + 
					           "-- Outros --\n" + 
					           "(S)air\n\n" +
					           "Opcao> ");
			String comando = sc.nextLine();
		
			if (comando.equals("S")) { break; }
		
			else if (comando.equals("C")) {

				while (true) {
						
					System.out.println("Posicao: ");
					int pos = Integer.parseInt(sc.nextLine());
		
					System.out.println("Nome: ");
					String nome = sc.nextLine();
					
					System.out.println("ID: ");
					String id = sc.nextLine();
					
					System.out.println("Anotacoes: ");
					String anotacoes = sc.nextLine();
					
					boolean retorno;
					
					if (anotacoes.equals("")) {retorno = repositorio.cadastrar(pos, nome, id);
					
					} else {retorno = repositorio.cadastrar(pos, nome, id, anotacoes);}
					
					if (retorno) {
						System.out.println("CADASTRO REALIZADO!\n");
						break;
					}
					System.out.println("POSICAO INVALIDA");
					break;
				}
			}
			
			else if (comando.equals("E")) {
				System.out.println("Numero> ");
				int posicao = Integer.parseInt(sc.nextLine());
				
				Object objeto = repositorio.pegar(posicao);
				if (objeto == null) {
					System.out.println("POSICAO INVALIDA!");
				} else {
					System.out.println(objeto.toString());
				}
			}
			
			else if (comando.equals("P")) {
				System.out.println("Nome> ");
				String nome = sc.nextLine();
				
				System.out.println("Id> ");
				String id = sc.nextLine();
			
				String retorno = repositorio.procurar(nome, id);
				if (! retorno.equals("")) {System.out.println("\n" + retorno);
				
				} else {System.out.println("\n" + "NENHUM RESULTADO ENCONTRADO" + "\n");}
			}
			
			else if (comando.equals("V")) {
				String retorno = repositorio.verificar();
				if (! retorno.equals("")) {System.out.println("\n" + retorno);
				
				} else {System.out.println("\n" + "NENHUMA REPETICAO ENCONTRADA" + "\n");}
			}
			else {System.out.println("OPCAO INVALIDA!\n");}
		}
	}
}