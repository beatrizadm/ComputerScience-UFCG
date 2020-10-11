/*
 
ESTADO:
	Tipo do lazer
	Limite em minutos 
	Atividades de lazer realizadas

ACOES:
	Cadastrar atividade de lazer
	Calcular atividades realizadas
	Calcular tempo total das atividades
	Gerar representação textual
 
 */

package lab2;

import java.util.ArrayList;

public class Lazer {

	//atributos
	private String tipo;
	private int limite;
	ArrayList<Integer> arrayMinutos = new ArrayList<Integer>();
	private int totalMinutos;
	private String[] atividades;
	private int cont = 0;
	
	
	//constructors
	public Lazer(String tipo) {
		this.tipo = tipo;
		this.limite = 60;
		this.atividades = new String[this.limite];
	}
	public Lazer(String tipo, int limite) {
		this.tipo = tipo;
		this.limite = limite;
		this.atividades = new String[this.limite];
	}
	
	//metodos
	public void cadastraAtividade(String nome, int minutos) {
		
		boolean atividadeRepetida = false;
		
		for (int i = 0; i < this.atividades.length; i++) {
			if (nome.equals(this.atividades[i])) {
				atividadeRepetida = true;
			}
		}
		
		if (atividadeRepetida == false) {
			if (this.totalMinutos + minutos <= this.limite) {
				this.totalMinutos += minutos;
				this.atividades[cont] = nome;
				arrayMinutos.add(minutos);
				this.cont ++;
			}
		}
	}
	
	public int totalAtividades() {
		return cont;
	}
	
	public int tempoTotal() {
		return this.totalMinutos;
	}
	
	public String maiorAtividade() {
		int maior = 0;
		int indice = 0;
		for (int i = 0; i < arrayMinutos.size(); i++) {
			if (arrayMinutos.get(i) > maior) {
				maior = arrayMinutos.get(i);
				indice = i;
			}
		}
		return atividades[indice];
	}
	
	public String menorAtividade() {
		int menor = limite;
		int indice = 0;
		for (int i = 0; i < arrayMinutos.size(); i++) {
			if (arrayMinutos.get(i) < menor) {
				menor = arrayMinutos.get(i);
				indice = i;
			}
		}
		return atividades[indice];
	}
	
	public String toString() {
		String resp = "";
		for (int i = 0; i < this.cont; i++) {
			if (i < this.cont - 1) {
				resp += atividades[i] + ", ";
			} else {
				resp += atividades[i];
			}
		}
		return this.tipo + ": " + resp;
	}
	
	//getters e setters
	public String getTipo() {
		return tipo;
	}
}
