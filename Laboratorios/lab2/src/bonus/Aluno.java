package bonus;

import java.util.HashMap;
import java.util.Map;

/**
 * Representação do Aluno, aqui podem ser cadastrados varios alunos, cada um com:
 * contas em laboratorios, disciplinas, saude e contas nas cantinas.
 * 
 * @author Beatriz Miranda
 */
public class Aluno {
	
	/**
	 * HashMap com as contas nos laboratorios
	 */
	private Map<String, ContaLaboratorio> laboratorios;
	
	/**
	 * HashMap com as disciplinas
	 */
	private Map<String, Disciplina> disciplinas;
	
	/**
	 * HashMap com as contas nas cantinas
	 */
	private Map<String, ContaCantina> cantinas;
	
	/**
	 * Objeto saude na classe saude
	 */
	private Saude saude;

	/**
	 * Constrói o aluno
	 */
	public Aluno() {
		this.laboratorios = new HashMap<String, ContaLaboratorio>();
		this.disciplinas = new HashMap<String, Disciplina>();
		this.cantinas = new HashMap<String, ContaCantina>();
		this.saude = new Saude();
	}
	
	/**
	 * Cadastra laboratorios
	 * @param nomeLaboratorio: nome do laboratorio
	 */
	public void cadastraLaboratorio(String nomeLaboratorio) {
		this.laboratorios.put(nomeLaboratorio, new ContaLaboratorio(nomeLaboratorio));
	}
	
	/**
	 * Cadastra laboratorios
	 * @param nomeLaboratorio: nome do laboratorio
	 * @param cota: Cota disponivel no do sistema de armazenamento
	 */
	public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
		this.laboratorios.put(nomeLaboratorio, new ContaLaboratorio(nomeLaboratorio, cota));
	}
	
	/**
	 * Consumir esoaço no sistema de armazenamento
	 * @param nomeLaboratorio: nome do laboratorio
	 * @param mbytes: 
	 */
	public void consomeEspaco(String nomeLaboratorio, int mbytes) {
		this.laboratorios.get(nomeLaboratorio).consomeEspaco(mbytes);;
	}
	
	/**
	 * Liberar espaco do sistema de armazenamento
	 * @param nomeLaboratorio: nome do laboratorio
	 * @param mbytes
	 */
	public void liberaEspaco(String nomeLaboratorio, int mbytes) {
		this.laboratorios.get(nomeLaboratorio).liberaEspaco(mbytes);;
	}
	
	/**
	 * Se o aluno atingiu a cota ou não
	 * @param nomeLaboratorio: nome do laboratorio
	 * @return
	 */
	public boolean atingiuCota(String nomeLaboratorio) {
		return this.laboratorios.get(nomeLaboratorio).atingiuCota();
	}
	
	/**
	 * Representacao textual dos laboratorios do aluno
	 * @param nomeLaboratorio: nome do laboratorio
	 * @return
	 */
	public String laboratorioToString(String nomeLaboratorio) {
		return this.laboratorios.get(nomeLaboratorio).toString();
	}
	
	/**
	 * Cadastra as disciplinas do aluno
	 * @param nomeDisciplina: representa o nome da disciplina
	 */
	public void cadastraDisciplina(String nomeDisciplina) {
		this.disciplinas.put(nomeDisciplina, new Disciplina(nomeDisciplina));
	}
	
	/**
	 * Cadastra as horas do aluno em cada disciplina
	 * @param nomeDisciplina: representa o nome da disciplina
	 * @param horas: quantidade de horas de estudo da disciplina
	 */
	public void cadastraHoras(String nomeDisciplina, int horas) {
		this.disciplinas.get(nomeDisciplina).cadastraHoras(horas);;
	}
	
	/**
	 * Cadastra a nota do aluno em cada disciplina
	 * @param nomeDisciplina: representa o nome da disciplina
	 * @param nota: a ordem da prova feita
	 * @param valorNota
	 */
	public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
		this.disciplinas.get(nomeDisciplina).cadastraNota(nota, valorNota);;
	}
	
	/**
	 * Se o aluno foi aprovado ou nao
	 * @param nomeDisciplina: representa o nome da disciplina
	 * @return
	 */
	public boolean aprovado(String nomeDisciplina) {
		return this.disciplinas.get(nomeDisciplina).aprovado();
	}
	
	/**
	 * Representação escrita da disciplina do aluno
	 * 
	 * @param nomeDisciplina: representa o nome da disciplina
	 * @return 
	 */
	public String disciplinaToString(String nomeDisciplina) {
		return this.disciplinas.get(nomeDisciplina).toString();
	}
	
	/**
	 * Cadastra a cantina que o aluno pretende consumir, a partir do nome dela
	 * 
	 * @param nomeCantina: nome da cantina
	 */
	public void cadastraCantina(String nomeCantina) {
		this.cantinas.put(nomeCantina, new ContaCantina(nomeCantina));
	}
	
	/**
	 * Cadastra o lanches da cantina que o aluno consumiu
	 * 
	 * @param nomeCantina: nome da cantina
	 * @param qtdItens: quantidade de itens comprados
	 * @param valorCentavos: valor do item (em centavos)
	 */
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
		this.cantinas.get(nomeCantina).cadastraLanche(qtdItens, valorCentavos);
	}
	
	/**
	 * Paga a conta da cantina do aluno
	 * 
	 * @param nomeCantina: nome da cantina
	 * @param valorCentavos: valor do item (em centavos)
	 */
	public void pagarConta(String nomeCantina, int valorCentavos) {
		this.cantinas.get(nomeCantina).pagaConta(valorCentavos);
	}
	
	/**
	 * Retorna o saldo devedor do aluno na cantina
	 * 
	 * @param nomeCantina: nome da cantina
	 * @return o saldo devedor do aluno na cantina
	 */
	public int getFaltaPagar(String nomeCantina) {
		return this.cantinas.get(nomeCantina).getFaltaPagar();
	}
	
	/**
	 * Retorna a string que representa a conta na cantina do aluno
	 * 
	 * @param nomeCantina: nome da cantina
	 * @return
	 */
	public String cantinaToString(String nomeCantina) {
		return this.cantinas.get(nomeCantina).toString();
	}
	
	/**
	 * Define a saude mental do aluno
	 * 
	 * @param valor: saude mental do aluno
	 */
	public void defineSaudeMental(String valor) {
		this.saude.defineSaudeMental(valor);
	}
	
	/**
	 * Define a saude fisica do aluno
	 * 
	 * @param valor: saude fisica do aluno
	 */
	public void defineSaudeFisica(String valor) {
		this.saude.defineSaudeFisica(valor);
	}
	
	/**
	 * Retorna em String o status geral do aluno
	 * 
	 * @return uma String com o status geral do aluno
	 */
	public String getStatusGeral() {
		return this.saude.getStatusGeral();
	}
	
}