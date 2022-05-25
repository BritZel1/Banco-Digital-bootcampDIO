package com.desafiobanco.conta;

public interface FuncionalidadesConta {
	
	public void depositar(double valor);
	public void transferir(Conta contaDestino, double valor);
	public void sacar(double valor);
	public void visualizarExtrato();
	
}
