package bonus;

import java.util.ArrayList;

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
	 * Array que armazena os detalhes da conta da cantina
	 */
	private ArrayList<String> detalhes;
	
	/**
	 * Constrói uma conta na cantina a partir do nome da cantina
	 * 
	 * @param nomeDaCantina: o nome da cantina
	 */
	public ContaCantina(String nomeDaCantina) {
		this.nomeDaCantina = nomeDaCantina;
		this.detalhes = new ArrayList<String>();
	}
	
	/**
	 * Cadastra os lanches da cantina, a partir da quantidade de itens e de um
	 * valor passado em centavos
	 * 
	 * @param qtdItens: quantidade de itens
	 * @param valorCentavos: valor do item(em centavos)
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.qtdItens += qtdItens;
		this.saldoDevedor += valorCentavos;
		this.gastos += valorCentavos;
	}
	
	/**
	 * Cadastra os lanches da cantina, a partir da quantidade de itens, um
	 * valor passado em centavos e os detalhes da conta
	 * 
	 * @param qtdItens: quantidade de itens
	 * @param valorCentavos: valor em centavos 
	 * @param detalhes: detalhes da conta na cantina
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos, String detalhes) {
		this.qtdItens += qtdItens;
		this.saldoDevedor += valorCentavos;
		this.gastos += valorCentavos;
		this.detalhes.add(detalhes);
	}

	
	/**
	 * Lista os ultimos 5 detalhes da compra 
	 * 
	 * @return String que representa a listagem dos detalhes passados
	 */
	public String listarDetalhes() {
		String listaDetalhes = "";
		int cont = 0;
		for (int i=this.detalhes.size()-1; i>=0; i--) {
			if (cont<=3) {
				listaDetalhes += this.detalhes.get(i) + "\n";
				cont ++;
			} else {
				listaDetalhes += this.detalhes.get(i);
				break;
			}
		}
		return listaDetalhes.trim();
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