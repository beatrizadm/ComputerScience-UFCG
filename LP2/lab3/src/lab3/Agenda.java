package lab3;

import java.util.Arrays;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author Beatriz Miranda
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	private Contato[] contatos;
	
	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
	}
	
	/**
	 * Sobrescreve o hashCode da Agenda
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contatos);
		return result;
	}

	/**
	 * Sobrescreve o equals da Agenda, ve se os contatos sao iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(contatos, other.contatos))
			return false;
		return true;
	}
	
	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone1, String telefone2, 
								String telefone3, String telefonePrioritario, String cttWhatsapp) {
		Contato contato = new Contato(nome, sobrenome, telefone1,  telefone2,  telefone3,  telefonePrioritario, cttWhatsapp);
		// tira -1 pois a posicao digitada vai de 1 a 100 e o array vai de 0 a 99
		this.contatos[posicao - 1] = contato;
	}
	
	
	
	/**
	 * Retorna a lista de contatos da agenda.
	 * @return uma string com os contatos da agenda.
	 */
	public String listaContatos() {
		String retorno = "\nLista de contatos:\n";
		for (int i = 0; i < this.contatos.length; i++) {
			if (this.contatos[i] != null) {
				// +1 pois o array vai de 0 a 99 e a posicao digitada vai de 1 a 100
				int posicao = i + 1;
				retorno += posicao + " - "+ this.contatos[i].toString() + "\n";
			}
		}
		return retorno;
	}
	
	/**
	 * Retorna um contato da agenda
	 * @param posicao do contato na agenda
	 * @return a String contato
	 */
	public String exibeContato(int posicao) {
		String retorno = "";
		if (posicao >= 1 && posicao <= 100 && !(contatos[posicao - 1] == null)) {
			// tira -1 pois a posicao digitada vai de 1 a 100 e o array vai de 0 a 99
			retorno += contatos[posicao - 1].exibeContato();
		} else {
			retorno += "POSICAO INVALIDA!";
		}
		return retorno;
	}
	
	/**
	 * Retorna os numeros prioritarios dos contatos
	 * @return a String com os contatos prioritarios no formato "nome sobrenome - numero"
	 */
	public String telefonesPreferidos() {
		String retorno = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				retorno += contatos[i].exibeTelefonePrioritario() + "\n";
			}
		}
		return retorno;
	}
	
	/**
	 * Retorna os numeros dos whatsapps dos contatos
	 * @return a String com os contatos de whatsapp no formato "nome sobrenome - numero"
	 */
	public String zaps() {
		String retorno = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				retorno += contatos[i].exibeZap() + "\n";
			}
		}
		return retorno;
	}
}
