package br.senai.sp.informatica.servlet02.models;

public enum Sexos {
	MASCULINO("Masculino"), 
	FEMININO("Feminino");
	
	String label;
	
	private Sexos(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
