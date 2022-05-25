package com.desafiobanco.conta;

public class Cliente {
	private String nome;
	private String endereco;
	private String telefone;
	private int cpf;
	
	public Cliente (String nome, String endereco, String telefone, int cpf) {
		setCPF(cpf);
		setTelefone(telefone);
		setNome(nome);
		setEndereco(endereco);
	}
	
	public Cliente () {
		
	}
	
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public int getCPF() {
		return cpf;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setCPF(int cpf) {
		this.cpf = cpf;
	}
	
	

}
