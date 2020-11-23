package bonus;

import java.util.Arrays;

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
	 * Nome da disciplina
	 */
	private int horas;
	
	/**
	 * Array que armazena as notas da disciplina
	 */
	private Double[] arrayNotas;
	
	/**
	 * Array que armazena o peso de cada nota da disciplina
	 */
	private Double[] arrayPesos;
	
	
	/**
	 * Constrói a disciplina, toda disciplina cadastrada recebe um nome e 
	 * só pode receber 4 notas
	 * 
	 * @param nomeDisciplina: representa o nome da disciplina
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.arrayNotas = new Double[4];
		this.arrayPesos = new Double[4];
		Arrays.fill(this.arrayPesos, 1.0);
	}
	
	/**
	 * Constrói a disciplina, toda disciplina cadastrada recebe um nome e
	 * uma quantidade de notas, o peso de todas as notas é 1
	 * 
	 * @param nomeDisciplina: representa o nome da disciplina
	 * @param quantidadeNotas: quantidade de notas para cadastrar
	 */
	public Disciplina(String nomeDisciplina, int quantidadeNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.arrayNotas = new Double[quantidadeNotas];
		this.arrayPesos = new Double[quantidadeNotas];
		Arrays.fill(this.arrayPesos, 1.0);
	}
	
	/**
	 * Constrói a disciplina, toda disciplina cadastrada recebe um nome e
	 * uma quantidade de notas e um array com os pesos de cada nota
	 * 
	 * @param nomeDisciplina: representa o nome da disciplina
	 * @param quantidadeNotas: quantidade de notas para cadastrar
	 */
	public Disciplina(String nomeDisciplina, int quantidadeNotas, Double[] arrayPesos) {
		this.nomeDisciplina = nomeDisciplina;
		this.arrayNotas = new Double[quantidadeNotas];
		this.arrayPesos = arrayPesos;
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
		this.arrayNotas[nota-1] = valorNota;
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
	 * Retorna a média do aluno, checa se existe nota, e então soma todas as existentes,
	 * divide pela soma dos pesos e obtem a média
	 * 
	 * @return media do aluno
	 */
	public double calculaMedia() {
		double soma = 0.0;
		int denominador = 0;
		for (int i = 0; i <= this.arrayNotas.length - 1; i++) {
			if (this.arrayNotas[i] != null) {
				soma += this.arrayNotas[i] * this.arrayPesos[i];
				denominador += this.arrayPesos[i];
			}
		}
		double media = soma / denominador;
		return media;
	}
	
	/**
	 * Retorna a formatação correta das notas do aluno
	 * 
	 * @return uma String das notas formatas
	 */
	public String notasFormatadas() {
		String formatado = "[";
		for (int i=0; i<= this.arrayNotas.length - 1;i++) {
			if (i < this.arrayNotas.length - 1) {
				formatado += this.arrayNotas[i] + ", ";
			} else {
				formatado += this.arrayNotas[i] + "]";
			}
		}
		return formatado;
	}
	
	/**
	 * Retorna a String que representa a disciplina.
	 * A representação segue o formato "nome_disciplina horas media_notas [nota1, nota2, nota3, nota4...]"
	 * 
	 * @return a representação em String da disciplina
	 */
	@Override
	public String toString() {
		return this.nomeDisciplina + " " + this.horas + " " + calculaMedia() + " " + notasFormatadas();
	}
}
