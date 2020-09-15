package prova1;

public class Cliente {

	private int id;
	private String nome;
	private String endereco;


	public Cliente(int id, String nome, String end) {

		this.id = id;
		this.nome = nome;
		this.endereco = end;        
	}

	public int getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

    public String getEndereco() {
        return this.endereco;
    }

}