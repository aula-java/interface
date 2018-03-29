package br.edu.ifrs.canoas.java.banco.entidade;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifrs.canoas.java.banco.entidade.Conta;

public class ContaTest {

	Conta conta;
	
	@Before
	public void setup() {
		conta = new Conta();
	}
	
	@Test
	public void testSaca1000comSaldo50() {
		conta.setSaldo(50);
		assertFalse("Nao eh possivel sacar mais que o saldo",conta.saca(1000));
	}
	
	@Test
	public void testSaca10comSaldo50() {
		conta.setSaldo(100);
		assertTrue("Eh possivel sacar mais que o saldo",conta.saca(50));
		assertEquals("Se tinha 100 e saquei 50, devo ter 50", 50, conta.getSaldo(),0);
	}

}
