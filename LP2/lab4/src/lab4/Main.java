package lab4;

import java.util.Scanner;

/**
 * Interface com menu para manipular um controle de alunos.
 * @author Beatriz Miranda
 */
public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Controle controle = new Controle();		
		String escolha = "";
		
		while (true) {
			escolha = menu(scanner);
			comando(escolha, controle, scanner);
		}
	}
	
	/**
	 * Exibe o menu e captura a escolha do usuario.
	 * @param scanner Para captura da opção do usuario.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.print("(C)adastrar Aluno\n" + 
				"(E)xibir Aluno\n" + 
				"(N)ovo Grupo\n" + 
				"(A)locar Aluno no Grupo e Imprimir Grupos\n" + 
				"(R)egistrar Aluno que Respondeu\n" + 
				"(I)mprimir Alunos que Responderam\n" + 
				"(O)ra, vamos fechar o programa!\n\n" + 
				"Opção>");
		return scanner.nextLine().toUpperCase();
	}
	
	/**
	 * Interpreta a opção escolhida pelo usuario.
	 * @param opcao Opcao cogitada.
	 * @param controle O controle que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Controle controle, Scanner scanner) {
		switch (opcao) {
			case "C":
				cadastra(controle,scanner);
				break;
			case "E":
				exibe(controle,scanner);
				break;
			case "N":
				novoGrupo(controle,scanner);
				break;
			case "A":
				aloca(controle,scanner);
				break;
			case "R":
				registra(controle,scanner);
				break;
			case "I":
				/**
				 * Imprime os alunos que responderam no quadro
				 */
				System.out.println(controle.imprimeResponderam());
				break;
			case "O":
				break;
		}
	}
	
	/**
	 * Cadastra um aluno no sistema, a partir da sua matricula, nome e curso.
	 * @param controle O controle que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void cadastra(Controle controle, Scanner scanner) {
		
		System.out.print("\nMatricula: ");
		String matricula = scanner.nextLine();
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Curso: ");
		String curso = scanner.nextLine();
		
		System.out.println(controle.cadastraAluno(matricula, nome, curso));
	}
	
	/**
	 * Exibe o aluno cuja matricula for fornecida.
	 * @param controle O controle que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void exibe(Controle controle, Scanner scanner) {
		System.out.print("\nMatricula: ");
		String matricula = scanner.nextLine();
	
		System.out.println(controle.exibeAluno(matricula) + "\n");
	}
	
	/**
	 * Cria um novo grupo de alunos a partir do nome do grupo.
	 * @param controle O controle que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void novoGrupo(Controle controle, Scanner scanner) {
		System.out.print("Grupo: ");
		String grupo = scanner.nextLine().toLowerCase();
		
		System.out.println(controle.cadastraGrupo(grupo) + "\n");
	}
	
	/**
	 * Aloca um aluno em um grupo, a partir do nome do grupo ou 
	 * imprime os alunos do grupo a partir do nome do grupo.
	 * @param controle O controle que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void aloca(Controle controle, Scanner scanner) {
		System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
		String resposta = scanner.nextLine().toUpperCase();
		
		if (resposta.equals("A")) {
			System.out.print("\nMatricula: ");
			String matricula = scanner.nextLine();
			System.out.print("Grupo: ");
			String grupo = scanner.nextLine().toLowerCase();
			
			System.out.println(controle.alocarAluno(matricula, grupo) + "\n");
			
		} else if (resposta.equals("I")) {
			System.out.print("Grupo: ");
			String grupo = scanner.nextLine().toLowerCase();
			
			System.out.println(controle.imprimirGrupo(grupo) + "\n");
		} 
	}
	
	/**
	 * Registra o aluno que respondeu no quadro, a partir de sua matricula.
	 * @param controle O controle que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void registra(Controle controle, Scanner scanner) {
		System.out.print("\nMatricula: ");
		String matricula = scanner.nextLine();
		
		System.out.println(controle.registraRespostaQuadro(matricula) + "\n");
	}
}
