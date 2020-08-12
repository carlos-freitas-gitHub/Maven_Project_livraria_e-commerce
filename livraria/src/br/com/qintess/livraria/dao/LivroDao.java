package br.com.qintess.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.qintess.livraria.modelo.Genero;
import br.com.qintess.livraria.modelo.Livro;

public class LivroDao {
// seleciona
	public List<Livro> seleciona() {
		String query = "select idlivro, titulo, preco, estoque, idgenero from livro";
		List<Livro> livros = new ArrayList<Livro>();
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Livro livro = new Livro();
				Genero genero = new Genero();
				livro.setIdLivro(rs.getInt("idlivro"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setPreco(rs.getDouble("preco"));
				genero.setIdGenero(rs.getInt("idgenero"));
				livro.setGenero(genero);
				livros.add(livro);
			}

		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
		return livros;
	}

// selecionaPorId
	public Livro selecionaPorId(int id) {
		String query = "select idlivro, titulo, preco, estoque, idgenero from livro where idlivro = ?";
		Livro livro = new Livro();
		Genero genero = new Genero();
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				livro.setIdLivro(rs.getInt("idlivro"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setPreco(rs.getDouble("preco"));
				livro.setEstoque(rs.getInt("estoque"));
				genero.setIdGenero(rs.getInt("idgenero"));
				livro.setGenero(genero);

			}
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
		return livro;
	}

//	deleta
	public void deleta(int id) {
		String query = "delete from livro where idlivro = ?";
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.execute();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
	}

//	atualiza
	public void atualiza(Livro livro) {
		String query = "update livro set titulo = ?, preco = ?, estoque = ?, idgenero = ? where idlivro = ?";
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, livro.getTitulo());
			pstm.setDouble(2, livro.getPreco());
			pstm.setInt(3, livro.getEstoque());
			pstm.setInt(4, livro.getGenero().getIdGenero());
			pstm.setInt(5, livro.getIdLivro());
			pstm.execute();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getConexao();
		}
	}

//	insere
	public void insere(Livro livro) {
		String query = "insert into livro(titulo, preco, estoque, idgenero) values (?, ?, ?, ?)";
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, livro.getTitulo());
			pstm.setDouble(2, livro.getPreco());
			pstm.setInt(3, livro.getEstoque());
			pstm.setInt(4, livro.getGenero().getIdGenero());
			pstm.execute();

		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getConexao();
		}
	}

}// fim classe
