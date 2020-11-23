package lab4;

/**
 * Representa um aluno do sistema.
 * @author Beatriz Miranda
 */
public class Aluno {
	private String matricula;
	private String nome;
	private String curso;
	
	/**
	 * Constroi um aluno.
	 * @param matricula Matricula do aluno.
	 * @param nome Nome do aluno.
	 * @param curso Nome do curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		Validacao.valida(matricula);
		Validacao.valida(nome);
		Validacao.valida(curso);
		
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	/**
	 * Sobrescreve o hashcode do aluno.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Sobrescreve o equals do aluno, ve se as matriculas sao iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/**
	 * Representacao em String do aluno. Sobrescreve o toString do aluno.
	 */
	@Override
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}	
}