package br.senai.sp.informatica.servlet02.models;

public class Usuario {
	
	private Long id;
	
	private String nome;
	
	private String endereco;
	
	private Sexos sexo;
	
	private boolean temFilhos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Sexos getSexo() {
		return sexo;
	}

	public void setSexo(Sexos sexo) {
		this.sexo = sexo;
	}

	public boolean isTemFilhos() {
		return temFilhos;
	}

	public void setTemFilhos(boolean temFilhos) {
		this.temFilhos = temFilhos;
	}
}
