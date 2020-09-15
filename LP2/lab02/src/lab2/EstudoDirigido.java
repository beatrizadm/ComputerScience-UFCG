package lab2;

public class EstudoDirigido {
	
	//atributos
	private Estudo[] arrayDirigido = new Estudo[5];
	private String nome;
	private int cont = 0;
	
	//constructor
	public EstudoDirigido(String nome) {
		this.nome = nome;
	}
	
	//metodos
	public void cadastraEstudo(Estudo estudo) {
		
		boolean repetido = false;
		String nome = estudo.getNomeDaMateria();
		
		for (int i = 0; i < cont; i++) {
			Estudo objetoEstudo = this.arrayDirigido[i];
			if (nome.equals(objetoEstudo.getNomeDaMateria())) {
				repetido = true;
			}
		}
		
		if (repetido == false && cont <= 4) {
			this.arrayDirigido[cont] = estudo;
			this.cont ++;
		}
	}
	
	
	public int contaTempoTotal() {
		int tempo = 0;
		for (int i = 0; i < cont; i++) {
		    Estudo estudo = this.arrayDirigido[i];
		    tempo += estudo.getTotal();
		}
		return tempo;
	}
	
	
	public String toString() {
		String formatado = "";
		for (int i = 0; i < cont; i++) {
			Estudo estudo = this.arrayDirigido[i];
			formatado += estudo.toString() + "\n";
		}
		return formatado.trim();
	}

	//getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
