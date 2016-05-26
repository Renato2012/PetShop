package br.com.es.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.es.jdbc.ConnectionFactory;
import br.com.es.view.Cliente;

public class ClienteDAO {
	private Connection connection;

	/* construtor */
	public ClienteDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void addCliente(Cliente cliente){
		String sql = "insert into cliente (nome,cpf,endereco,telefone,animal) values (?,?,?,?,?)";
		
		try{
			 // prepared statement para insercao
	        PreparedStatement stmt = connection.prepareStatement(sql);

	        // seta os valores
	        stmt.setString(1, cliente.getNome());
	        stmt.setInt(2, cliente.getCpf());
	        stmt.setString(3, cliente.getEndereco());
	        stmt.setString(4, cliente.getTelefone());
	        stmt.setInt(5, cliente.getAnimal().getId());
	        
	        // executa
	        stmt.execute();
	        stmt.close();
	        System.out.println("Inseriu com sucesso em cliente!");
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
}
