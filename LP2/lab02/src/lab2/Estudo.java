/*
 
ESTADO:
	Minutos 
	Nome da matéria
 
ACOES:
	Adicionar minutos de estudo 
	Verificar se deve descansar (< 120) 
	Gerar representação textual
  
 */

package lab2;

public class Estudo {
	
	// atributos
	private int total;
	private int minutos;
	private String nomeDaMateria;
	
	//constructor
	public Estudo(String nomeDaMateria) {
		this.nomeDaMateria = nomeDaMateria;
	}
	
	//metodos
	public void adicionaMinutos(int minutos) {
		this.minutos = minutos;
		this.total += this.minutos;
	}
	
	public boolean deveDescansar() {
		return this.total >= 120;
	}
	
	@Override
	public String toString() {
		return this.nomeDaMateria + " (" + this.total + ")";
	}
	
	//getters
	public int getTotal() {
		return this.total;
	}
	public String getNomeDaMateria() {
		return this.nomeDaMateria;
	}
	
}
