package lab4;

import java.util.HashSet;

/**
 * Representa um grupo do sistema.
 * @author Beatriz Miranda
 */
public class Grupo {
	
	private String nome;
	private HashSet<Aluno> grupo;
	
	/**
	 * Constroi um grupo.
	 * @param nome Nome do grupo.
	 */
	public Grupo(String nome) {
		Validacao.valida(nome);
		this.nome = nome;
		this.grupo = new HashSet<>();
	}
	
	/**
	 * Sobrescreve o hashcode do grupo.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Sobrescreve o equals do grupo, ve se os nomes sao iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * Adiciona um aluno ao grupo.
	 * @param aluno Nome do aluno.
	 * @return true se conseguir adicionar o aluno e false caso contrario.
	 */
	public boolean adicionaAluno(Aluno aluno) {
		return grupo.add(aluno);
	}
	
	/**
	 * Representacao em String do grupo. Sobrescreve o toString do grupo.
	 */
	@Override
	public String toString() {
		String retorno = "\nAlunos do grupo "+ this.nome + ":\n";
		for (Aluno a: grupo) {
			 retorno += "* " + a.toString() + "\n";
		}
		return retorno;
	}
}