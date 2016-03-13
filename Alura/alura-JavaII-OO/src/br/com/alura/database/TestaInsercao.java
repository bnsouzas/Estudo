package br.com.alura.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		Connection conn = Database.getConnection();
		Statement stmt = conn.createStatement();
		stmt.execute("INSERT INTO Produto (NOME, DESCRICAO) VALUES ('Notebook','Notebook I5')",
						Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rs = stmt.getGeneratedKeys();
		while(rs.next()){
			String id = rs.getString(1);
			System.out.println(id);
		}		
		rs.close();
		
		stmt.close();
		conn.close();
	}

}
