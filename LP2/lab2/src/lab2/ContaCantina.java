package lab2;

/**
 * Representação da conta da cantina do aluno, cada conta precisa ter nome da cantina,
 * quantidade de itens e gastos
 * 
 * @author Beatriz Miranda
 */
public class ContaCantina {
	
	/**
	 * Nome da cantina
	 */
	private String nomeDaCantina;
	
	/**
	 * Quantidade de itens comprados na cantina
	 */
	private int qtdItens;
	
	/**
	 * Saldo de quanto o aluno deve na cantina
	 */
	private int saldoDevedor;
	
	/**
	 * Gastos totais realizados na cantina
	 */
	private int gastos;
	
	/**
	 * Constrói uma conta na cantina a partir do nome da cantina
	 * 
	 * @param nomeDaCantina: o nome da cantina
	 */
	public ContaCantina(String nomeDaCantina) {
		this.nomeDaCantina = nomeDaCantina;
	}
	
	/**
	 * Cadastra os lanches da cantina, a partir da quantidade de itens e de um
	 * valor passado em centavos
	 * 
	 * @param qtdItens: quantidade de itens
	 * @param valorCentavos: valor dos itens (em centavos)
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.qtdItens += qtdItens;
		this.saldoDevedor += valorCentavos;
		this.gastos += valorCentavos;
	}
	
	/**
	 * Paga a conta a partir de um valor(em centavos) dado
	 * 
	 * @param valorCentavos: valor em centavos
	 */
	public void pagaConta(int valorCentavos) {
		if (valorCentavos <= this.saldoDevedor) {
			this.saldoDevedor -= valorCentavos;
		}
	}
	
	/**
	 * Retorna o saldo devedor do aluno na cantina
	 * 
	 * @return o saldo devedor do aluno na cantina
	 */
	public int getFaltaPagar() {
		return this.saldoDevedor;
	}
	
	/**
	 * Retorna a string que representa a conta na cantina.
	 * A representação segue o formato "nome_cantina quantidade_itens gastos"
	 * 
	 * @return a representação em String da conta na cantina
	 */
	@Override
	public String toString() {
		return this.nomeDaCantina + " " +  this.qtdItens + " " + this.gastos;
	}
	
}