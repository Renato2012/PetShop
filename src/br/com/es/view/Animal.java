package br.com.es.view;

public class Animal {
	private int id;		
	private String nome;
	private int idade;
	private String tipo;
	private String raca;
	
	/* construtor */
	public Animal(String nome, int idade, String tipo, String raca){	
		this.nome = nome;
		this.idade = idade;
		this.tipo = tipo;
		this.raca = raca;
	}
	
	/* get e set */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}
}
