package br.com.alura.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
	private final Connection con;

	public ProdutoDAO(Connection con) {
		this.con = con;
	}

	public void salva(Produto produto) {
		String sql = "INSERT INTO Produto (NOME, DESCRICAO) VALUES (?,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getDescricao());
			stmt.execute();

			try (ResultSet rs = stmt.getGeneratedKeys()) {
				while (rs.next()) {
					int id = rs.getInt(1);
					produto.setId(id);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public List<Produto> lista() throws SQLException {
		List<Produto> produtos = new ArrayList<>();
		String sql = "SELECT * FROM Produto";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();

			percorreResultSet(produtos, stmt);
		}
		return produtos;
	}
	
	public List<Produto> lista(Categoria categoria) throws SQLException {
		List<Produto> produtos = new ArrayList<>();
		String sql = "SELECT * FROM Produto WHERE Categoria_id = " + categoria.getId();
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();

			percorreResultSet(produtos, stmt);
		}
		return produtos;
	}

	private void percorreResultSet(List<Produto> produtos, PreparedStatement stmt) throws SQLException {
		try (ResultSet rs = stmt.getResultSet()) {
			while (rs.next()) {
				produtos.add(new Produto(rs.getInt("id"), 
										 rs.getString("nome"), 
										 rs.getString("descricao")));
			}
		}
	}
}
