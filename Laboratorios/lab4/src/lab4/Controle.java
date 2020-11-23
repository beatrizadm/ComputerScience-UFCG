package lab4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Controla os Alunos, os Grupos e as respostas no quadro.
 * @author Beatriz Miranda
 */
public class Controle {
	
	private HashMap<String, Aluno> alunos; 
	private HashMap<String, Grupo> grupos;
	private ArrayList<Aluno> respondeNoQuadro;
	
	/**
	 * Constroi o controle
	 */
	public Controle() {
		this.alunos = new HashMap<String, Aluno>();
		this.grupos = new HashMap<String, Grupo>();
		this.respondeNoQuadro = new ArrayList<>();
	}
 	
	/**
	 * Cadastra um aluno no sistema.
	 * @param matricula Matricula do aluno.
	 * @param nome Nome do aluno.
	 * @param curso Nome do curso do aluno.
	 * @return String dizendo se o cadastro foi realizado ou se a matricula ja foi cadastrada.
	 */
	public String cadastraAluno(String matricula, String nome, String curso) {
		Validacao.valida(matricula);
		Validacao.valida(nome);
		Validacao.valida(curso);
		
		if (existeAluno(matricula)) {
			return "MATRICULA JA CADASTRADA!";
		}
		this.alunos.put(matricula, new Aluno(matricula, nome, curso));
		return "CADASTRO REALIZADO!\n\n";			
	}
	
	/**
	 * Checa se o aluno esta cadastrado no sistema.
	 * @param matricula Matricula do aluno.
	 * @return true se o aluno estiver cadastrado e false caso contrario.
	 */
	private boolean existeAluno(String matricula) {
		Validacao.valida(matricula);
		return this.alunos.containsKey(matricula);
	}
	
	/**
	 * Retorna um aluno, caso ele esteja cadastrado no sistema.
	 * @param matricula Matricula do aluno.
	 * @return String dizendo o cadastro do aluno, caso contrario diz que ele nao esta cadastrado.
	 */
	public String exibeAluno(String matricula) {
		Validacao.valida(matricula);
		if (!existeAluno(matricula)) {
			return "Aluno nao cadastrado.";
		} 
		return "Aluno: " + this.alunos.get(matricula).toString();			
	}

	/**
	 * Checa se o grupo esta cadastrado no sistema.
	 * @param nomeGrupo Nome do grupo.
	 * @return true se o grupo estiver cadastrado e false caso contrario.
	 */
	private boolean existeGrupo(String nomeGrupo) {
		Validacao.valida(nomeGrupo);
		return this.grupos.containsKey(nomeGrupo);
	}
	
	/**
	 * Retorna uma String com a situacao do cadastro do grupo. Caso o grupo ja esteja cadastrado
	 * ou se o grupo foi cadastrado no sistema.
	 * @param nomeGrupo Nome do grupo.
	 * @return String com a situacao do cadastro do grupo.
	 */
	public String cadastraGrupo(String nomeGrupo) {
		Validacao.valida(nomeGrupo);
		if (existeGrupo(nomeGrupo)) {
			return "GRUPO JA CADASTRADO!";
		} 
		this.grupos.put(nomeGrupo, new Grupo(nomeGrupo));
		return "CADASTRADO COM SUCESSO!";			
	}
	
	/**
	 * Retorna uma String com a situacao da alocacao do aluno. Caso o aluno nao esteja cadastrado no sistema
	 * ou se o grupo nao foi cadastrado ou se o aluno foi alocado no grupo.
	 * @param matricula Matricula do aluno.
	 * @param nomeGrupo Nome do grupo.
	 * @return String com a situacao da alocacao do aluno.
	 */
	public String alocarAluno(String matricula, String nomeGrupo) {
		Validacao.valida(matricula);
		Validacao.valida(nomeGrupo);
		
		if (!existeAluno(matricula)) {
			return "Aluno nao cadastrado.";
		} else if (!existeGrupo(nomeGrupo)) {
			return "Grupo nao cadastrado.";
		}
		Grupo grupo = grupos.get(nomeGrupo);
		Aluno aluno = alunos.get(matricula);
		grupo.adicionaAluno(aluno);
		return "ALUNO ALOCADO!";			
	}
	
	/**
	 * Retorna uma String com os alunos cadastrados no grupo. Retorna caso o grupo nao esteja cadastrado 
	 * ou nenhum aluno esteja cadastrado no grupo.
	 * @param nomeGrupo Nome do grupo.
	 * @return String com os alunos cadastrados no grupo.
	 */
	public String imprimirGrupo(String nomeGrupo) {
		Validacao.valida(nomeGrupo);
		
		if (!existeGrupo(nomeGrupo)) {
			return "Grupo nao cadastrado.";
		}  else if (grupos.get(nomeGrupo).toString().equals("\nAlunos do grupo "+ nomeGrupo + ":\n")) {
			return "Nenhum aluno cadastrado no grupo.";
		}
			return grupos.get(nomeGrupo).toString();
	}
	
	/**
	 * Registra o aluno que respondeu no quadro.
	 * @param matricula Matricula do aluno.
	 * @return String dizendo que o aluno foi cadastrado, ou diz que o aluno nao esta cadastrado no sistema.
	 */
	public String registraRespostaQuadro(String matricula) {
		Validacao.valida(matricula);
		
		if (!existeAluno(matricula)) {
			return "Aluno nao cadastrado.";
		} 
		respondeNoQuadro.add(alunos.get(matricula));
		return "ALUNO CADASTRADO!";
		
	}
	
	/**
	 * Retorna os alunos que responderam no quadro.
	 * @return Alunos que responderam no quadro.
	 */
	public String imprimeResponderam() {
		String retorno = "Alunos:\n";
		for (int i=0; i < respondeNoQuadro.size();i++) {
			int posicao = i + 1;
			retorno += posicao + ". " + respondeNoQuadro.get(i).toString() + "\n";
		}
		if (retorno.equals("Alunos:\n")) {
			return "Nenhum aluno respondeu no quadro.\n";
		} 
		return retorno;
	}	
}
