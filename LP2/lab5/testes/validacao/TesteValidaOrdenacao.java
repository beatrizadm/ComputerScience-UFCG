package validacao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteValidaOrdenacao {

	@Test
	public void testCriterio() {
		ValidaOrdenacao.criterio("Data");
		
		try {
			ValidaOrdenacao.criterio("");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na listagem de compras: criterio nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try {
			ValidaOrdenacao.criterio(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na listagem de compras: criterio nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCriterioNull() {
		ValidaOrdenacao.criterioNull("Data");
		try {
			ValidaOrdenacao.criterioNull(null);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na listagem de compras: criterio ainda nao definido pelo sistema.", e.getMessage());
		}
	}
	
	@Test
	public void testDefaultOutput() {
		try {
			ValidaOrdenacao.defaultOutput();
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na listagem de compras: criterio nao oferecido pelo sistema.", e.getMessage());
		}
	}

}
