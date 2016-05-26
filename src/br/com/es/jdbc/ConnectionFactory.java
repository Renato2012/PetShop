package br.com.es.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
        try {																			// user, password
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/petshop", "postgres", "admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
