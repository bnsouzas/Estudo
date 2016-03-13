package br.com.alura.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

	private Connection con;
	
	public CategoriaDAO(Connection con) {
		this.con = con;
	}
	
	public List<Categoria> lista() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		Categoria categoria = null;
		String sql = "SELECT c.id as c_id, c.nome as c_nome,p.id as p_id, p.nome as p_nome, p.descricao as p_descricao, p.categoria_id as p_categoria_id FROM Categoria c JOIN Produto p ON c.id = p.categoria_id ORDER BY c.id";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int c_id = rs.getInt("c_id");
					String c_nome = rs.getString("c_nome");
					if(categoria == null || c_id != categoria.getId()){
						categoria = new Categoria(c_id, c_nome);
						categorias.add(categoria);
					}
					Produto produto = new Produto(rs.getInt("p_id"), 
							 					  rs.getString("p_nome"), 
							 					  rs.getString("p_descricao"),
							 					  rs.getInt("p_categoria_id"));
					categoria.adiciona(produto);
				}
			}
		}
		return categorias;
	}

}
