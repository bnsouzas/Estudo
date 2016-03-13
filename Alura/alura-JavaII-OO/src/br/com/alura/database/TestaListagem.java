package br.com.alura.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		ConnectionPool connPool = new ConnectionPool();
		Connection connection = connPool.getConnection();
		Statement statement = connection.createStatement();
		if (statement.execute("select * from Produto")) {
			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String descricao = resultSet.getString("descricao");
				System.out.println("ID: " + id);
				System.out.println("Nome: " + nome);
				System.out.println("Descrição: " + descricao);
			}
			
			resultSet.close();
		}
		statement.close();
		connection.close();
	}
}
