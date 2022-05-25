package com.desafiobanco.conta;

import java.time.LocalDate;

public class HistoryTransitions {
	
	private String nameTransition;
	private double valueTransition;
	private LocalDate datatransition;

	public HistoryTransitions(String name, double valor) {
		this.nameTransition = name;
		this.valueTransition = valor;
		this.datatransition = LocalDate.now();
	}

	public String getNameTransition() {
		return nameTransition;
	}

	public double getValueTransition() {
		return valueTransition;
	}

	public void setNameTransition(String nameTransition) {
		this.nameTransition = nameTransition;
	}

	public void setValueTransition(double valueTransition) {
		this.valueTransition = valueTransition;
	}

	public LocalDate getDatatransition() {
		return datatransition;
	}
	
	
}
