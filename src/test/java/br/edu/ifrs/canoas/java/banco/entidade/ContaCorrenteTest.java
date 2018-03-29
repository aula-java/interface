package br.edu.ifrs.canoas.java.banco.entidade;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifrs.canoas.java.banco.entidade.Conta;
import br.edu.ifrs.canoas.java.banco.entidade.ContaCorrente;

public class ContaCorrenteTest {
	
	Conta cc;
	
	@Before
	public void setup(){
		cc = new ContaCorrente();
	}

	@Test
	public void testDeposita() {
		cc.deposita(1000);
		assertEquals("Apos o deposito de 1000, o saldo deve ser 1000 menos 10 centavos", 999.9, cc.getSaldo(),1);
	}

	@Test
	public void testAtualiza() {
		cc.deposita(1000);
		cc.atualiza(0.01);
		assertEquals("Novo saldo eh Saldo original mais dobro da taxa", 1019.898, cc.getSaldo(),3);
	}

}
