package lab3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author Beatriz Miranda
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa e a maneira de lidar com possiveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo nao encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}
	}

	/**
	 * Exibe o menu e captura a escolha do/a usuario/a.
	 * 
	 * @param scanner Para captura da opção do usuario.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" +
						"(T)elefones preferidos\n" +
						"(Z)aps\n" +
						"(S)air\n" +
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastra(agenda, scanner);
			break;
		case "L":
			System.out.println(agenda.listaContatos());
			break;
		case "E":
			exibe(agenda, scanner);
			break;
		case "T":
			System.out.println(agenda.telefonesPreferidos());
			break;
		case "Z":
			System.out.println(agenda.zaps());
			break;	
		case "S":
			sai();
			break;
		default:
			System.out.println("OPCAO INVALIDA!");
		}
	}
	

	/**
	 * Cadastra um contato na agenda. Caso não cadastre algum dos telefones, ele tera valor -1
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastra(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosicao: ");
		int posicao = scanner.nextInt();
		scanner.nextLine();
		
		if (posicao < 1 || posicao > 100) {
			System.out.println("\nPOSICAO INVALIDA");
			
		} else {
			System.out.print("Nome: ");
			String nome = scanner.nextLine();
			System.out.print("Sobrenome: ");
			String sobrenome = scanner.nextLine();
			System.out.print("Telefone1: ");
			String telefone1 = scanner.nextLine();
			System.out.print("Telefone2: ");
			String telefone2 = scanner.nextLine();
			System.out.print("Telefone3: ");
			String telefone3 = scanner.nextLine();
			System.out.print("Telefone prioritario: ");
			String telefonePrioritario = scanner.nextLine();
			System.out.print("Contato Whatsapp: ");
			String cttWhatsapp = scanner.nextLine();
			
			System.out.println("\nCADASTRO REALIZADO");
			agenda.cadastraContato(posicao, nome, sobrenome, telefone1, telefone2, telefone3, telefonePrioritario, cttWhatsapp);		
		}
	}
	

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibe(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int posicao = scanner.nextInt();
		System.out.println(agenda.exibeContato(posicao));
	}
	

	/**
	 * Sai da aplicacao.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo nao exista ou nao possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
