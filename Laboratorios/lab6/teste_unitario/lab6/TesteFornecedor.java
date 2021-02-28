package lab6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fornecedor.Fornecedor;
import produto.Produto;

class TesteFornecedor {
	
	private Fornecedor fornecedor;
	
	@BeforeEach
	public void initFornecedor() {
		this.fornecedor = new Fornecedor("Marcos", "marcos@gmail.com", "33106000");
		this.fornecedor.adicionaProduto("X-burguer", "Hamburguer", 7.0);
		this.fornecedor.adicionaProduto("refri", "refrigerante", 3.0);
		fornecedor.adicionaCombo("X-burguer + refri", "X-burguer com refrigerante", 10, 0.5);
	}
	
	@Test
	public void testConsultaProduto() {
		Produto produto = new Produto("X-burguer", "Hamburguer", 7.0);
		assertEquals(produto, fornecedor.consultaProduto("X-burguer", "Hamburguer"));
	}
	
	@Test
	public void testAdicionaCombo() {
		assertEquals("X-burguer + refri - X-burguer com refrigerante - R$5,00", 
				fornecedor.exibeProduto("X-burguer + refri", "X-burguer com refrigerante"));
		
		try {
			fornecedor.adicionaCombo("X-burguer + refri", "X-burguer com refrigerante", 10, 0.5);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: combo ja existe.", e.getMessage());
		}
		
	}
	
	@Test
	public void testEditaCombo() {
		assertEquals("X-burguer + refri - X-burguer com refrigerante - R$5,00", 
				fornecedor.exibeProduto("X-burguer + refri", "X-burguer com refrigerante"));
		
		fornecedor.editaCombo("X-burguer + refri", "X-burguer com refrigerante", 0.25);
		
		assertEquals("X-burguer + refri - X-burguer com refrigerante - R$7,50", 
				fornecedor.exibeProduto("X-burguer + refri", "X-burguer com refrigerante"));
		
	}
	
	@Test
	public void testEditaComboNome() {
		try {
			fornecedor.editaCombo("", "X-burguer com refrigerante", 0.5);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			fornecedor.editaCombo(null, "X-burguer com refrigerante", 0.5);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao de combo: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaComboDescricao() {
		try {
			fornecedor.editaCombo("X-burguer + refri", "", 0.5);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
		
		try {
			fornecedor.editaCombo("X-burguer + refri", null, 0.5);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao de combo: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaComboNovoFator() {
		try {
			fornecedor.editaCombo("X-burguer + refri", "X-burguer com refrigerante", -1);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: fator invalido.", e.getMessage());
		}
		
		try {
			fornecedor.editaCombo("X-burguer + refri", "X-burguer com refrigerante", 1.1);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: fator invalido.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaComboExisteProduto() {
		try {
			fornecedor.editaCombo("X-tudo + suco", "X-tudo com suco de acerola", 0.3);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: produto nao existe.", e.getMessage());
		}
	}
}
