package br.com.alura.database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnectionPool {
	private DataSource datasource;

	public ConnectionPool() {
		MysqlDataSource pool = new MysqlDataSource();
        pool.setUrl("jdbc:mysql://localhost:3306/loja_virtual");
        pool.setUser("root");
        pool.setPassword("root");
        this.datasource = pool;
	}

	public Connection getConnection() throws SQLException {
		return datasource.getConnection();
	}
}
