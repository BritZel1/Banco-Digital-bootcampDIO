package com.desafiobanco.conta;

public class ContaCorrente extends Conta{
	
	private static int SEQUENCIAL = 1; 
	
	public ContaCorrente(Cliente cliente) {
		super.agencia = 01; //padrão conta corrente
		super.numero = SEQUENCIAL ++;
		super.saldo = 0;
		super.cliente = cliente;
	}
	
	
	
}
