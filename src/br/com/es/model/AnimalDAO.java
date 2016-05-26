package br.com.es.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.es.jdbc.ConnectionFactory;
import br.com.es.view.Animal;

public class AnimalDAO {
	private Connection connection;

	/* construtor */
	public AnimalDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}

	public void addAnimal(Animal animal){
		String sql = "insert into animal (nome,idade,tipo,raca) values (?,?,?,?)";

		try{
			// prepared statement para insercao
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, animal.getNome());
			stmt.setInt(2, animal.getIdade());
			stmt.setString(3, animal.getTipo());
			stmt.setString(4, animal.getRaca());

			// executa
			stmt.execute();
			stmt.close();
			System.out.println("Inseriu com sucesso em animal!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Animal getAnimal(int idAnimal){	
		String sql = "select * from animal where id=?";
		try{
			Animal animal = null;
			// prepared statement para insercao
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1, idAnimal);
			// executa um select
			ResultSet rs = stmt.executeQuery();
			
			// itera no ResultSet
			while(rs.next()){
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				int idade = rs.getInt("idade");
				String tipo = rs.getString("tipo");
				String raca = rs.getString("raca");
			
				animal = new Animal(nome, idade, tipo, raca);
				animal.setId(id);
			}
			
			rs.close();
			stmt.close();
			System.out.println("getAnimal com sucesso em animal!");
			return animal;
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void updateAnimal(Animal animal){
		String sql = "update animal set nome=?, idade=?, tipo=?, raca=? where id=?";

		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, animal.getNome());
			stmt.setInt(2, animal.getIdade());
			stmt.setString(3, animal.getTipo());
			stmt.setString(4, animal.getRaca());
			stmt.setInt(5, animal.getId());

			stmt.execute();
			stmt.close();
			System.out.println("updateAnimal com sucesso em animal!");
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void removeAnimal(int idAnimal){
		String sql = "delete from animal where id=?";

		try{
			// prepared statement para insercao
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setInt(1, idAnimal);

			// executa
			stmt.execute();
			stmt.close();
			System.out.println("removido com sucesso em animal!");
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
}
