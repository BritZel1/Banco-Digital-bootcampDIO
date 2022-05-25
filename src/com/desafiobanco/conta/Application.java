package com.desafiobanco.conta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application{

	public static void main(String[] args) {
		
		//Configurando Banco
		List <Conta> contas = new ArrayList<Conta>();
		List <Cliente> clientes = new ArrayList <Cliente>();
		
		// adicionando alguns clientes e contas
		Cliente cliente = new Cliente ("Josue Sousa", "Pernambuco", "40028922", 12345678);
		clientes.add(cliente);
		Cliente cliente1 = new Cliente ("Maria alice", "malvinas", "15245455", 456456564);
		clientes.add(cliente1);
		
		Conta cc = new ContaCorrente(cliente);
		contas.add(cc);
		Conta cp = new ContaPoupanca(cliente);
		contas.add(cp);
		Conta cc1 = new ContaCorrente(cliente1);
		contas.add(cc1);
		Conta cp1 = new ContaPoupanca(cliente1);
		contas.add(cp1);
		
		//transações para ficar no histórico dos clientes criados
		cc.depositar(100);
		cc.transferir(cp, 50);
		cp.depositar(2.50);
		cp1.depositar(4.50);
		
		cc1.depositar(20);
		cc1.sacar(2);
		
		//criação do menu
		
		Menu menu = new Menu();
		int numMenu = 0;
		Scanner ler = new Scanner(System.in);
		
		do {
			menu.imprimirMenu();
			numMenu = ler.nextInt();
			
			switch(numMenu) {
			case 0 :
				System.out.println("==============================================================");
				System.out.println("Desligando sistema...                                        |");
				System.out.println("==============================================================");
				break;
			case 1 :
				menu.criarNovaConta(contas, clientes);
				break;
			case 2 :
				menu.criarNovoCliente(clientes);
				break;
			case 3 :
				menu.utilidadesConta(contas, clientes);
				break;
			case 4 :
				menu.imprimirExtratoTudo(contas);
				break;
			default:
				System.out.println("==============================================================");
				System.out.println("Digite uma opção válida!!                                    |");
				System.out.println("==============================================================");
				break;
			}
			
		}while(numMenu != 0);
	}

}
