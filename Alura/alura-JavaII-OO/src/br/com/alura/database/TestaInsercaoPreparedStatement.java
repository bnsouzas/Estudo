package br.com.alura.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoPreparedStatement {

	public static void main(String[] args) throws SQLException {
		try (Connection conn = Database.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Produto (NOME, DESCRICAO) VALUES (?,?)";
			try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				adiciona(stmt, "TV LCD", "32 Polegadas");
				adiciona(stmt, "Blueray", "Full HD");
				conn.commit();
				System.out.println("Produtos adicionados com sucesso!");
			} catch (Exception ex) {
				ex.printStackTrace();
				conn.rollback();
				System.out.println("Rollback Efetuado!");
			}
		}
	}

	private static void adiciona(PreparedStatement stmt, String nome, String descricao) throws SQLException {
		if (nome.equals("Blueray")) {
			throw new IllegalArgumentException("Problema ocorrido");
		}

		stmt.setString(1, nome);
		stmt.setString(2, descricao);
		stmt.execute();

		try (ResultSet rs = stmt.getGeneratedKeys()) {
			while (rs.next()) {
				String id = rs.getString(1);
				System.out.println("Produto "+id+" gerado.");
			}
		}
	}

}
