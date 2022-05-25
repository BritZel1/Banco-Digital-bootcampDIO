package com.desafiobanco.conta;

public class ContaPoupanca extends Conta {
	
	private static int SEQUENCIAL = 1; 

	public ContaPoupanca(Cliente donoConta) {
		super.agencia = 13; //padrão agencia poupanca
		super.numero = SEQUENCIAL ++;
		super.saldo = 0;
		super.cliente = donoConta;
	}
	
	
}
