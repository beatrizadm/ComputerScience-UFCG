package produto;

/**
 * Define o combo de produtos
 * @author Beatriz Miranda - 119210170
 */
public class Combo extends Produto {
	
	/** � o fator de desconto que o combo recebera. */
	private double fator;
	
	/**
	 * Contr�i um combo. 
	 * 
	 * @param nome � o nome do combo.
	 * @param descricao � a descri��o do combo.
	 * @param preco � o pre�o normal do combo, sem o desconto.
	 * @param fator � o fator de desconto do combo.
	 */
	public Combo(String nome, String descricao, double preco, double fator) {
		super(nome, descricao, preco);
		this.fator = 1 - fator;
	}
	
	/**
	 * Altera o valor do desconto que ser� dado.
	 * 
	 * @param fator � o novo valor do desconto.
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