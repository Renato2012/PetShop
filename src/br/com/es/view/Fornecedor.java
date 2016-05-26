package br.com.es.view;

public class Fornecedor {
	private int id;
	private String nome;
	private String cnpj;
	private String endereco;
	
	public Fornecedor(String nome, String cnpj, String endereco){
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}	
}
