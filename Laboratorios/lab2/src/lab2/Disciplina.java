package lab2;

/**
 * Representação da disciplina do aluno, cada disciplina precisa ter nome, notas e horas.
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
	 * Constrói a disciplina, toda disciplina cadastrada recebe um nome e
	 * só pode receber 4 notas
	 * 
	 * @param nomeDisciplina: representa o nome da disciplina
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new Double[4];
	}
	
	/**
	 * Adiociona horas à quantidade de horas estudadas
	 * 
	 * @param horas: quantidade de horas de estudo da disciplina
	 */
	public void cadastraHoras(int horas) {
		this.horas = horas;
		this.horas += horas;
	}
	
	/**
	 * Cadastra o valor da nota na sua respectiva posição,
	 * foi retirado 1 da "nota" para se adequar ao indice do array de notas
	 * 
	 * @param nota: a ordem da prova feita, pode ser um numero de 1(primeira prova) a 4(quarta prova)
	 * @param valorNota: valor da nota
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
	}
	
	/**
	 * Retorna se o aluno foi aprovado ou não, para isso ele chama a função calculaMedia,
	 * se a média for superior ou igual a 7, o aluno está aprovado, caso contrário, não esta aprovado.
	 * 
	 * @return true(caso o aluno seja approvado) ou false(caso o aluno não seja aprovado)
	 */
	public boolean aprovado() {
		if (calculaMedia() >= 7.0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna a média do aluno, checa se existe a nota e então soma todas as existentes,
	 * divide por 4 e obtem a média
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
	 * A representação segue o formato "nome_disciplina horas media_notas [nota1, nota2, nota3, nota4]"
	 * 
	 * @return a representação em String da disciplina
	 */
	@Override
	public String toString() {
		return this.nomeDisciplina + " " + this.horas + " " + calculaMedia() + " [" + this.notas[0] + ", " + this.notas[1] + ", " + this.notas[2] + ", " + this.notas[3] + "]";
		
	}
	
}
