/*
 
 ESTADO:
	Local da organização
	Quantidade de tarefas
	Minutos gasto por tarefa

 ACOES:
 	Cadastrar tarefa
	Calcular tempo médio de cada tarefa
	Pegar duração de uma tarefa
	Gerar representação textual

 */

package lab2;

public class Organizacao {
	
	//atributos
	private String local;
	private int[] arrayMinutos;
	private String[] arrayDescricao;
		
	
	//constructor
	public Organizacao(String local, int totalTarefas) {
		this.local = local;
		this.arrayMinutos = new int[totalTarefas];
		this.arrayDescricao = new String[totalTarefas];
	}
		
	
	//metodos
	public void cadastraTarefa(int idTarefa, int minutos, String descricao) {
		this.arrayDescricao[idTarefa] = descricao;
		this.arrayMinutos[idTarefa] = minutos;
	}
	
	public void cadastraTarefa(int idTarefa, int minutos) {
		this.arrayMinutos[idTarefa] = minutos;	
		this.arrayDescricao[idTarefa] = null;
	}
	
	
	public int mediaTarefa() {
		int soma = 0;
		for (int i = 0; i < this.arrayMinutos.length; i++) {
			soma += this.arrayMinutos[i];
		}
		int media = soma / this.arrayMinutos.length;
		return media;
	}
	
	public String toString( ) {
		return this.local + " ("+ this.arrayMinutos.length + " tarefas, " + mediaTarefa() + " min/tarefa)";
	}
	

	//getters
	public String getLocal() {
		return local;
	}
	public String getDescricao(int idTarefa) {
		return this.arrayDescricao[idTarefa];
	}
}
