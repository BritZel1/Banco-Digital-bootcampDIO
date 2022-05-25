package com.desafiobanco.conta;

import java.util.List;
import java.util.Scanner;

//classe com os métodos do menu
public class Menu {
	
	
	Scanner ler = new Scanner(System.in);
	
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
	
	public void imprimirMenu() {
		
		System.out.println("==============================================================");
		System.out.println("DIGITE O NÚMERO DA OPÇÃO                                     |");
		System.out.println("==============================================================");
		System.out.println("1 - Criar Nova Conta                                         |");
		System.out.println("2 - Registrar novo Cliente                                   |");
		System.out.println("3 - Utilidades da conta-> Deposito - Transferencia - Extrato |");
		System.out.println("4 - Imprimir Extrato TODAS as contas                         |");
		System.out.println("0 - SAIR/EXIT                                                |");
		System.out.println("==============================================================");
		System.out.print("Opção: ");
	}
	
	public void criarNovoCliente(List <Cliente> listaCliente) {
		Cliente cliente = new Cliente();
		System.out.println("=============================================");
		System.out.print("Digite o nome do cliente: ");
		cliente.setNome(ler.nextLine());
		System.out.print("Digite o CPF do cliente: ");
		cliente.setCPF(ler.nextInt());
		System.out.print("Digite o Endereço do cliente: ");
		cliente.setEndereco(ler.nextLine());
		clearBuffer(ler);
		System.out.print("Digite o telefone do cliente: ");
		cliente.setTelefone(ler.nextLine());
		
		listaCliente.add(cliente);
		System.out.println("=============================================");
		System.out.println("Cliente adicionado ao banco                 |");
		System.out.println("=============================================");
	}
	
	public void criarNovaConta(List <Conta> contas, List <Cliente> client) {
		int opcao = 0;
		int cpf = 0;
		boolean existe = false;
		
		System.out.println("=============================================");
		System.out.println("CRIAÇÃO DE CONTA                              |");
		System.out.println("=============================================");

		System.out.print("DIGITE O CPF DO CLIENTE EXISTENTE: ");
		cpf = ler.nextInt();
		
		for(Cliente clientes : client) {
			if(clientes.getCPF() == cpf) {
				
				existe = true;
				
				System.out.println("=============================================");
				System.out.println("DIGITE O NÚMERO DA OPÇÃO                    |");
				System.out.println("=============================================");
				System.out.println("1 - Criar Nova Conta *POUPANÇA* para o cliente "+ clientes.getNome());
				System.out.println("2 - Criar Nova Conta *CORRENTE* para o cliente "+ clientes.getNome());		
				System.out.println("=============================================");
				System.out.print("Opção: ");
				
				opcao = ler.nextInt();
				
				System.out.println("\n=============================================");
				if(opcao == 1) {
					contas.add(new ContaPoupanca(clientes));
					System.out.println("Nova Conta *POUPANÇA* para o cliente "+ clientes.getNome() + " CRIADO COM SUCESSO");
				} else if(opcao == 2) {
					contas.add(new ContaCorrente(clientes));
					System.out.println("Nova Conta *CORRENTE* para o cliente "+ clientes.getNome() + " CRIADO COM SUCESSO");
					
				}else {
					System.out.println("***OPÇÃO INVÁLIDA, VOLTANDO AO MENU PRINCIPAL***");
				}
				
			}
		}
		if(existe == false) {
			System.out.println("***CPF INVÁLIDO, VOLTANDO AO MENU PRINCIPAL***");
		}
		
	}
	
	public void utilidadesConta(List <Conta> contas, List <Cliente> client) {
		int opcao = 0;
		int numero = 0;
		int ag = 0;
		Conta account = null;
		double valor = 0;
		
		System.out.println("==============================================================");
		System.out.println("DIGITE O NÚMERO DA OPÇÃO                                     |");
		System.out.println("==============================================================");
		System.out.println("1 - Deposito                                                 |");
		System.out.println("2 - Transferência                                            |");
		System.out.println("3 - Saque                                                    |");
		System.out.println("4 - Extrato                                                  |");
		System.out.println("==============================================================");
		System.out.print("Opção: ");
		
		opcao = ler.nextInt();
		clearBuffer(ler);
		
		System.out.println("=============================================");
		System.out.print("DIGITE O NUMERO DA CONTA: ");
		numero = ler.nextInt();
		System.out.print("DIGITE A AGENCIA DA CONTA: ");
		ag = ler.nextInt();
		System.out.println("=============================================");
		
		for(Conta conta : contas) {
			if(conta.getAgencia() == ag && conta.getNumero() == numero) {
				account = conta;
				System.out.println("Conta existente!");
			}
		}
		
		clearBuffer(ler);
		
		switch(opcao) {
		case 1 :
			System.out.println("=============================================");
			System.out.print("DIGITE O VALOR DO DEPOSITO: ");
			valor = ler.nextDouble();
			account.depositar(valor);
			break;
		case 2 :
			System.out.println("=============================================");
			System.out.print("DIGITE O NUMERO DA CONTA PARA TRANSFERIR: ");
			numero = ler.nextInt();
			System.out.print("DIGITE A AGENCIA DA CONTA PARA TRANSFERIR: ");
			ag = ler.nextInt();
			System.out.print("DIGITE O VALOR DA TRANSFERENCIA: ");
			valor = ler.nextDouble();
			System.out.println("=============================================");
			
			for(Conta conta : contas) {
				if(conta.getAgencia() == ag && conta.getNumero() == numero) {
					
					account.transferir(conta, valor);
				}else {
					System.out.println("Conta Inválida!!!!");
				}
				
			}
			break;
		case 3 :
			System.out.println("=============================================");
			System.out.print("DIGITE O VALOR DO SAQUE: ");
			valor = ler.nextDouble();
			account.sacar(valor);
			break;
		case 4 :
			account.visualizarExtrato();
			break;
			
		default:
			System.out.println("==============================================================");
			System.out.println("Opção inválida, voltando ao menu!                            |");
			System.out.println("==============================================================");
		}
		
	}
	
	public void imprimirExtratoTudo(List <Conta> contas) {
		for(Conta conta : contas) {
			conta.visualizarExtrato();
		}
	}
	
}
