package br.com.es.view;

public class Cliente {
	private int id;
	private String nome;
	private int cpf;
	private String endereco;
	private String telefone;
	private Animal animal;
	
	/* construtor */
	public Cliente(String nome, int cpf, String endereco, String telefone, Animal animal){
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.animal = animal;
	}
	
	/* get e set */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}	
}
