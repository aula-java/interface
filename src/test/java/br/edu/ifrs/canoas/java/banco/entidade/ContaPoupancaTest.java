package br.edu.ifrs.canoas.java.banco.entidade;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifrs.canoas.java.banco.entidade.Conta;
import br.edu.ifrs.canoas.java.banco.entidade.ContaPoupanca;

public class ContaPoupancaTest {

	Conta cp;
	
	@Before
	public void setup(){
		cp = new ContaPoupanca();
	}
	
	@Test
	public void testAtualiza() {
		cp.deposita(1000);
		cp.atualiza(0.01);
		assertEquals("Novo saldo eh Saldo original (999.9) mais triplo da taxa (3x.01)", 1030, cp.getSaldo(),0);
	}
}
