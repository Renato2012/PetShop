package br.com.es.view;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Servico {
	private Funcionario funcionario;
	private Cliente cliente;
	private String dataDeAtendimento;
	 	
	/* construtor */
	public Servico(){
		this.dataDeAtendimento = geraDataAtendimento();
	}
	/* metodo de acesso interno, (private) */
	private String geraDataAtendimento(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date data = new Date();
		//System.out.println("DATA: " + sdf.format(data));
		return sdf.format(data);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDataDeAtendimento() {
		return dataDeAtendimento;
	}

	/*public void setDataDeAtendimento(String dataDeAtendimento) {
		this.dataDeAtendimento = dataDeAtendimento;
	}*/
}
