package br.com.alura.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		Connection conn = Database.getConnection();
		Statement stmt = conn.createStatement();
		stmt.execute("DELETE FROM Produto WHERE id > 4");
		int count = stmt.getUpdateCount();
        System.out.println(count + " linhas atualizadas");
		stmt.close();
		conn.close();
	}

}
