package produto;

/**
 * Define o combo de produtos
 * @author Beatriz Miranda - 119210170
 */
public class Combo extends Produto {
	
	/** É o fator de desconto que o combo recebera. */
	private double fator;
	
	/**
	 * Contrói um combo. 
	 * 
	 * @param nome é o nome do combo.
	 * @param descricao é a descrição do combo.
	 * @param preco é o preço normal do combo, sem o desconto.
	 * @param fator é o fator de desconto do combo.
	 */
	public Combo(String nome, String descricao, double preco, double fator) {
		super(nome, descricao, preco);
		this.fator = 1 - fator;
	}
	
	/**
	 * Altera o valor do desconto que será dado.
	 * 
	 * @param fator é o novo valor do desconto.
	 */
	public void setFator(double fator) {
		this.fator = 1 - fator;
	}
	
	/**
	 * Metodo que retorna o preco do combo
	 */
	@Override
	public double getPreco() {
		return this.preco * this.fator;
	}
}