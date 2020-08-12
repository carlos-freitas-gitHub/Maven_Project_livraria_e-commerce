package br.com.qintess.livraria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static Connection conexao;

// abrir conexão
	public static Connection getConexao() {
		try {
			if (conexao == null) {
				conexao = DriverManager.getConnection("jdbc:postgresql://localhost/db_livraria", "postgres", "admin");
			} else {
				return conexao;
			}

		} catch (SQLException e) {
			System.err.println("Erro ao abrir a conexão. " + e.getMessage());
		}
		return conexao;
	}

// fechar conexao
	public static void getFechaConexao() {
		try {
			conexao.close();
			conexao = null;
		} catch (SQLException e) {
			System.err.println("Erro ao fechar a conexão. " + e.getMessage());
		}
	}
}
