package br.com.alura.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagemAuto {
	public static void main(String[] args) throws SQLException {
		//As classes Connection, Statement e ResultSet implementa AutoCloseable
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja_virtual", "root", "root")) {
			try (Statement statement = connection.createStatement()) {
				if (statement.execute("select * from Produto")) {
					try (ResultSet resultSet = statement.getResultSet()) {
						while (resultSet.next()) {
							int id = resultSet.getInt("id");
							String nome = resultSet.getString("nome");
							String descricao = resultSet.getString("descricao");
							System.out.println("ID: " + id);
							System.out.println("Nome: " + nome);
							System.out.println("Descrição: " + descricao);
						}
					}
				}
			}
		}
	}
}
