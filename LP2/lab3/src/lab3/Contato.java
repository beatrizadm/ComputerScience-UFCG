package lab3;

public class Contato {
	
	private String nome;
	private String sobrenome;
	private String[] telefones;
	private String telefonePrioritario; 
	private String cttWhatsapp;

	/**
	 * Controi o Contato
	 * @param nome: nome do contato
	 * @param sobrenome: sobrenome do contato
	 * @param telefone1: primeiro telefone do contato
	 * @param telefone2: segundo telefone do contato
	 * @param telefone3: terceiro telefone do contato
	 * @param telefonePrioritario: diz qual eh o telefone prioritario do contato
	 * @param cttWhatsapp: diz qual eh o whatsapp do contato
	 */
	public Contato(String nome, String sobrenome, String telefone1, String telefone2, 
			       String telefone3, String telefonePrioritario, String cttWhatsapp) {
	this.nome = nome;
	this.sobrenome = sobrenome;
	this.telefones = new String[]{telefone1, telefone2, telefone3};
	this.telefonePrioritario = telefonePrioritario;
	this.cttWhatsapp = cttWhatsapp;
	}
	
	/**
	 * Sobrescreve o hashCode do Contato
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

	/**
	 * Sobrescreve o equals do Contato, todo contato será igual se tiver nome e sobrenome iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}
	
	/**
	 * Retorna os telefones do contato, com o indicador ao lado se eh prioritario ou zap
	 * @return uma String com os telefones
	 */
	public String exibeContato() {
		
		String formatado = "";
		
		for (int i=0; i<=2 ; i++) {
			
			if (!this.telefones[i].trim().equals("") && !telefones[i].trim().equals("\"\"")) {
				
				int prioritario = Integer.parseInt(this.telefonePrioritario);
				int zap = Integer.parseInt(this.cttWhatsapp);
				
				if (this.telefones[i].equals(this.telefones[prioritario - 1])) {
					formatado += this.telefones[i] + " (prioritario)\n";
				}
				
				else if (this.telefones[i].equals(this.telefones[zap - 1])) {
					formatado += this.telefones[i] + " (zap)\n";
				}
				
				else {
					formatado += this.telefones[i] + "\n";
				}
			}
		}
		return this.nome + " " + this.sobrenome + "\n" + formatado;
	}
	
	/**
	 * Retorna o numero de prioritario do contato, se ele não tiver, retorna "Nao tem"
	 * @return a String do numero prioritario
	 */
	public String exibeTelefonePrioritario() {
		
		if (this.telefonePrioritario.trim().equals("")) {
			return this.nome + " " + this.sobrenome + " - Nao tem";
			
		} else {
			int prioritario = Integer.parseInt(this.telefonePrioritario);

			if  (this.telefones[prioritario - 1].trim().equals("")) {
				return this.nome + " " + this.sobrenome + " - Nao tem";
			} else {
				return this.nome + " " + this.sobrenome + " - " + this.telefones[prioritario - 1];
			}
		}
	}
	
	/**
	 * Retorna o numero de whatsapp do contato, se ele não tiver, retorna "Nao tem"
	 * @return a String do numero do whatsapp
	 */
	public String exibeZap() {
		
		if (this.cttWhatsapp.trim().equals("")) {
			return this.nome + " " + this.sobrenome + " - Nao tem";
		
		} else {
			int zap = Integer.parseInt(cttWhatsapp);
			
			if (this.telefones[zap - 1].trim().equals("")) {
				return this.nome + " " + this.sobrenome + " - Nao tem";
			} else {
				return this.nome + " " + this.sobrenome + " - " + this.telefones[zap - 1];
			}
		}
	}
	
	/**
	 * Sobrescreve o toString do Contato
	 */
	@Override
	public String toString() {
		return this.nome + " " + this.sobrenome;
	}	
}