package br.com.fill.samples.balancedbrackets;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BalancedBracketsApplicationTests {

	private static final String MSG_ERR_CENARIO_VALIDO = "Cenario %s não é válido";
	private static final String MSG_ERR_CENARIO_INVALIDO = "Cenario %s  não é inválido";

	private static final int TEMPO_LIMITE = 100;

	@Autowired
	private BracketsValidator validator;

	@Test
	public void contextLoads() {
	}

	@Test(timeout=TEMPO_LIMITE)
	public void testaCenariosBraviSucesso() {
		String cenario1 = "(){}[]";
		String cenario2 = "[{()}](){}";

		assertTrue(String.format(MSG_ERR_CENARIO_VALIDO, cenario1), validator.isValid(cenario1));
		assertTrue(String.format(MSG_ERR_CENARIO_VALIDO, cenario2), validator.isValid(cenario2));
	}

	@Test(timeout=TEMPO_LIMITE)
	public void testaCenariosBraviFalha() {
		String cenario1 = "[]{()";
		String cenario2 = "[{)]";
		
		assertFalse(String.format(MSG_ERR_CENARIO_INVALIDO, cenario1), validator.isValid(cenario1));
		assertFalse(String.format(MSG_ERR_CENARIO_INVALIDO, cenario2), validator.isValid(cenario2));
	}

	@Test(timeout=TEMPO_LIMITE)
	public void testaCenarioVazio() {
		assertFalse(String.format(MSG_ERR_CENARIO_INVALIDO, "STRING VAZIA"), validator.isValid(""));
	}

	@Test(timeout=TEMPO_LIMITE)
	public void testaCaracteresInvalidos() {
		String cenario1 = "a[{)]";
		String cenario2 = "['{()}'](){}";
		assertFalse(String.format(MSG_ERR_CENARIO_INVALIDO, cenario1), validator.isValid(cenario1));
		assertFalse(String.format(MSG_ERR_CENARIO_INVALIDO, cenario2), validator.isValid(cenario2));
	}
}
