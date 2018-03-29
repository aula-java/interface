package br.edu.ifrs.canoas.java.banco.entidade;

public class ContaPoupanca extends Conta{

	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa * 3;
	}

}
