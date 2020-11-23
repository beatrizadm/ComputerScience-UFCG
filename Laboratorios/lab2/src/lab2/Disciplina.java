package lab2;

/**
 * Representa��o da disciplina do aluno, cada disciplina precisa ter nome, notas e horas.
 * 
 * @author Beatriz Miranda
 */
public class Disciplina {
	
	/**
	 * Nome da disciplina
	 */
	private String nomeDisciplina;
	
	/**
	 * Horas de estudo da disciplina
	 */
	private int horas;
	
	/**
	 * Array que armazena as notas da disciplina
	 */
	private Double[] notas;
	
	
	
	/**
	 * Constr�i a disciplina, toda disciplina cadastrada recebe um nome e
	 * s� pode receber 4 notas
	 * 
	 * @param nomeDisciplina: representa o nome da disciplina
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new Double[4];
	}
	
	/**
	 * Adiociona horas � quantidade de horas estudadas
	 * 
	 * @param horas: quantidade de horas de estudo da disciplina
	 */
	public void cadastraHoras(int horas) {
		this.horas = horas;
		this.horas += horas;
	}
	
	/**
	 * Cadastra o valor da nota na sua respectiva posi��o,
	 * foi retirado 1 da "nota" para se adequar ao indice do array de notas
	 * 
	 * @param nota: a ordem da prova feita, pode ser um numero de 1(primeira prova) a 4(quarta prova)
	 * @param valorNota: valor da nota
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
	}
	
	/**
	 * Retorna se o aluno foi aprovado ou n�o, para isso ele chama a fun��o calculaMedia,
	 * se a m�dia for superior ou igual a 7, o aluno est� aprovado, caso contr�rio, n�o esta aprovado.
	 * 
	 * @return true(caso o aluno seja approvado) ou false(caso o aluno n�o seja aprovado)
	 */
	public boolean aprovado() {
		if (calculaMedia() >= 7.0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna a m�dia do aluno, checa se existe a nota e ent�o soma todas as existentes,
	 * divide por 4 e obtem a m�dia
	 * 
	 * @return media do aluno
	 */
	public double calculaMedia() {
		double soma = 0.0;
		
		for (int i=0; i<=3; i++) {
			
			if (this.notas[i] != null) {
				soma += this.notas[i];
			}
		}
		double media = soma / 4;
		return media;
	}
	
	/**
	 * Retorna a String que representa a disciplina.
	 * A representa��o segue o formato "nome_disciplina horas media_notas [nota1, nota2, nota3, nota4]"
	 * 
	 * @return a representa��o em String da disciplina
	 */
	@Override
	public String toString() {
		return this.nomeDisciplina + " " + this.horas + " " + calculaMedia() + " [" + this.notas[0] + ", " + this.notas[1] + ", " + this.notas[2] + ", " + this.notas[3] + "]";
		
	}
	
}
