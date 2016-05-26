package br.com.es.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.es.jdbc.ConnectionFactory;
import br.com.es.view.Fornecedor;

public class FornecedorDAO {
	private Connection connection;

	/* construtor */
	public FornecedorDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	/* adiciona um novo fornecedor */
	public void addFornecedor(Fornecedor fornecedor) {
		String sql = "insert into fornecedor (nome,cnpj,endereco) values (?,?,?)";

		try {
			// prepared statement para insercao
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getCnpj());
			stmt.setString(3, fornecedor.getEndereco());

			// executa
			stmt.execute();
			stmt.close();
			System.out.println("Inseriu com sucesso em cliente!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/* retorna um fornecedor */
	public Fornecedor getFornecedor(int idFornecedor){
		String sql = "select * from fornecedor where id= (?)";

		try{
			Fornecedor fornecedor = null;
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1, idFornecedor);
			ResultSet rs = stmt.executeQuery();

			// itera no ResultSet
			while(rs.next()){
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cnpj = rs.getString("cnpj");
				String endereco = rs.getString("endereco");

				fornecedor = new Fornecedor(nome, cnpj, endereco);
				fornecedor.setId(id);
			}

			rs.close();
			stmt.close();
			System.out.println("getFornecedor com sucesso em fornecedor!");
			return fornecedor;

		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	/* retorna todos os fornecedores cadastrados no banco */
	public List<Fornecedor> getListaFornecedor(){
		String sql = "select * from fornecedor";

		try{
			List<Fornecedor> fornecedores = new ArrayList<Fornecedor>(); 

			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			// itera no ResultSet
			while(rs.next()){
				String nome = rs.getString("nome");
				String cnpj = rs.getString("cnpj");
				String endereco = rs.getString("endereco");

				Fornecedor f = new Fornecedor(nome, cnpj, endereco);
				f.setId(rs.getInt("id"));

				fornecedores.add(f);
			}
			rs.close();
			stmt.close();
			System.out.println("getListaFornecedor com sucesso em fornecedor!");
			return fornecedores;

		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	/* atualiza um fornecedor */
	public void updateFornecedor(Fornecedor fornecedor){
		String sql = "update fornecedor set nome=?, cnpj=?, endereco=? where id=?";

		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getCnpj());
			stmt.setString(3, fornecedor.getEndereco());
			stmt.setInt(4, fornecedor.getId());

			stmt.execute();
			stmt.close();
			System.out.println("removido com sucesso em fornecedor!");
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	/* remove um fornecedor */
	public void removeFornecedor(int idFornecedor){
		String sql = "delete from fornecedor where id= (?)";
		try{
			// prepared statement para insercao
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setInt(1, idFornecedor);

			// executa
			stmt.execute();
			stmt.close();
			System.out.println("removido com sucesso em fornecedor!");
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
}
