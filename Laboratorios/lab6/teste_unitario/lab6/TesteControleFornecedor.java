package lab6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fornecedor.ControlerFornecedor;

public class TesteControleFornecedor {
	
	private ControlerFornecedor cf;
	
	@BeforeEach
	public void initFornecedor() {
		this.cf = new ControlerFornecedor();
		this.cf.adicionaFornecedor("Marcos", "marcos@gmail.com", "33106000");
		
		this.cf.adicionaProduto("Marcos", "X-burguer", "Hamburguer", 7.0);
		this.cf.adicionaProduto("Marcos", "refri", "refrigerante", 3.0);
		this.cf.adicionaProduto("Marcos", "suco", "suco de acerola", 4.0);
		
		this.cf.adicionaCombo("Marcos", "X-burguer + suco", "X-tudo com suco de acerola", 0.3, 
				"X-burguer - Hamburguer, suco - suco de acerola");
	}
	
	@Test
	public void testAdicionaCombo() {

		cf.adicionaCombo("Marcos", "X-burguer + refri", "X-burguer com refrigerante", 0.5, 
				"X-burguer - Hamburguer, refri - refrigerante");

		assertEquals("X-burguer + refri - X-burguer com refrigerante - R$5,00", 
				cf.exibeProduto("X-burguer + refri", "X-burguer com refrigerante", "Marcos"));
	}
	
	@Test
	public void testAdicionaComboFornecedor() {
		try {
			cf.adicionaCombo("", "X-burguer + refri", "X-burguer com refrigerante", 0.5, 
					"X-burguer - Hamburguer, refri - refrigerante");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			cf.adicionaCombo(null, "X-burguer + refri", "X-burguer com refrigerante", 0.5, 
					"X-burguer - Hamburguer, refri - refrigerante");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaComboNome() {
		try {
			cf.adicionaCombo("Marcos", "", "X-burguer com refrigerante", 0.5, 
					"X-burguer - Hamburguer, refri - refrigerante");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			cf.adicionaCombo("Marcos", null, "X-burguer com refrigerante", 0.5, 
					"X-burguer - Hamburguer, refri - refrigerante");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
		
	@Test
	public void testAdicionaComboDescricao() {
		try {
			cf.adicionaCombo("Marcos", "X-burguer + refri", "", 0.5, 
					"X-burguer - Hamburguer, refri - refrigerante");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
		
		try {
			cf.adicionaCombo("Marcos", "X-burguer + refri", null, 0.5, 
					"X-burguer - Hamburguer, refri - refrigerante");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaComboProdutos() {		
		try {
			cf.adicionaCombo("Marcos", "X-burguer + refri", "X-burguer com refrigerante", 0.5, "");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: combo deve ter produtos.", e.getMessage());
		}
		
		try {
			cf.adicionaCombo("Marcos", "X-burguer + refri", "X-burguer com refrigerante", 0.5, null);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de combo: combo deve ter produtos.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaComboFator() {		
		try {
			cf.adicionaCombo("Marcos", "X-burguer + refri", "X-burguer com refrigerante", 
					-1, "X-burguer - Hamburguer, refri - refrigerante");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: fator invalido.", e.getMessage());
		}
		
		try {
			cf.adicionaCombo("Marcos", "X-burguer + refri", "X-burguer com refrigerante", 
					1.5, "X-burguer - Hamburguer, refri - refrigerante");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: fator invalido.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaComboContemFornecedor() {		
		try {
			cf.adicionaCombo("Ze", "X-burguer + refri", "X-burguer com refrigerante", 
					0.5, "X-burguer - Hamburguer, refri - refrigerante");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaComboNoCombo() {		
		try {
			cf.adicionaCombo("Marcos", "X-burguer + refri", "X-burguer com refrigerante", 
					0.5, "X-burguer + refri - X-burguer com refrigerante");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.", e.getMessage());
		}
	}
	
	
	@Test
	public void testEditaCombo() {
		
		assertEquals("X-burguer + suco - X-tudo com suco de acerola - R$7,70", 
				cf.exibeProduto("X-burguer + suco", "X-tudo com suco de acerola", "Marcos"));
		
		cf.editaCombo("X-burguer + suco", "X-tudo com suco de acerola", "Marcos", 0.2);
		
		assertEquals("X-burguer + suco - X-tudo com suco de acerola - R$8,80", 
				cf.exibeProduto("X-burguer + suco", "X-tudo com suco de acerola", "Marcos"));
	}
	
	@Test
	public void testEditaComboFornecedor() {
		try {
			cf.editaCombo("X-burguer + suco", "X-tudo com suco de acerola", "", 0.2);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			cf.editaCombo("X-burguer + suco", "X-tudo com suco de acerola", null, 0.2);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaComboContemFornecedor() {		
		try {
			cf.editaCombo("X-burguer + suco", "X-tudo com suco de acerola", "Ze", 0.2);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: fornecedor nao existe.", e.getMessage());
		}
	}
	
}
