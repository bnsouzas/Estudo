package br.com.alura.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaDAO {

	public static void main(String[] args) throws SQLException {
		Produto mesa = new Produto("Mesa Azul", "Mesa 4 pernas");
		try(Connection con = new ConnectionPool().getConnection()){
			ProdutoDAO produtoDAO = new ProdutoDAO(con);
			produtoDAO.salva(mesa);
			TestaRemocao.main(args);
			
			List<Produto> produtos = produtoDAO.lista();
			
			for(Produto produto : produtos){
				System.out.println(produto);
			}
			
			List<Categoria> categorias = new CategoriaDAO(con).lista();
			for (Categoria categoria : categorias){
				for (Produto produto : categoria.getProdutos()){
					System.out.println(categoria.getNome() + " - " + produto.getNome());
				}
			}
		}
	}
}
