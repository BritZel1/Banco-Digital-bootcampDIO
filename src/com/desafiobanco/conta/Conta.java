package com.desafiobanco.conta;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements FuncionalidadesConta{
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected List <HistoryTransitions> extrato = new ArrayList<HistoryTransitions>();
	protected Cliente cliente;
	
	
	public int getAgencia() {
		return agencia;
	}
	public int getNumero() {
		return numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public Cliente getCliente() {
		return cliente;
	}

	//implementa��o da interface
	
	public void depositar(double valor) {
		this.saldo += valor;
		extrato.add(new HistoryTransitions("deposito", valor));
	}

	public void transferir(Conta contaDestino, double valor) {
		this.saldo -= valor;
		contaDestino.depositar(valor);
		extrato.add(new HistoryTransitions("transfer�ncia", valor));
	}

	public void sacar(double valor) {
		
		if(saldo<valor) {
			System.out.println("N�o foi poss�vel sacar, saldo menor que o valor desejado!");
		}
		else {
			this.saldo -= valor;
			extrato.add(new HistoryTransitions("saque", valor));
		}
		
	}
	
	public void visualizarExtrato () {
		
		System.out.println("==============================================================");
		System.out.println("Nome: " + this.cliente.getNome());
		System.out.println("CPF: " + this.cliente.getCPF());
		System.out.println("Agencia: " + this.agencia);
		System.out.println("Conta: " + this.numero);
		
		for(HistoryTransitions historico : extrato) {
			System.out.println("\n\nTipo da transa��o: "+ historico.getNameTransition());
			System.out.println("Valor: "+ historico.getValueTransition());
			System.out.println("Data: " + historico.getDatatransition());
		}
		System.out.println("==============================================================");
		
	}
	
	
	
}
