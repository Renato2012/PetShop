package br.com.es.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.es.jdbc.ConnectionFactory;
import br.com.es.view.Funcionario;

public class FuncionarioDAO {
	private Connection connection;

	/* construtor */
	public FuncionarioDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void addFuncionario(Funcionario funcionario){
		String sql = "insert into funcionario (nome,login,senha) values (?,?,?)";
		
		try{
			// prepared statement para insercao
	        PreparedStatement stmt = connection.prepareStatement(sql);

	        // seta os valores
	        stmt.setString(1, funcionario.getNome());
	        stmt.setString(2, funcionario.getLogin());
	        stmt.setString(3, funcionario.getSenha());
	        
	        // executa
	        stmt.execute();
	        stmt.close();
	        System.out.println("Inseriu com sucesso em Funcionário!");
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
}
