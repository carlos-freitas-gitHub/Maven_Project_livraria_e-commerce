package br.com.qintess.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.qintess.livraria.modelo.Genero;
import br.com.qintess.livraria.modelo.Livro;

public class GeneroDao {
// seleciona
	public List<Genero> seleciona() {
		String query = "select idgenero, descricao from genero";
		List<Genero> generos = new ArrayList<Genero>();
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Genero genero = new Genero();
				genero.setIdGenero(rs.getInt("idgenero"));
				genero.setDescricao(rs.getString("descricao"));
				generos.add(genero);
			}

		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
		return generos;
	}

//	selecionaPorId
	public Genero selecionaPorId(int id) {
		String query = "select idgenero, descricao from genero where idgenero = ?";
		Genero genero = new Genero();
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				genero.setIdGenero(rs.getInt("idgenero"));
				genero.setDescricao(rs.getString("descricao"));
			}
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
		return genero;
	}

// selecionaLivrosPorDescricao
	public List<Livro> selecionaLivrosPorGenero(String descricao) {
		String query = "select li.idlivro, li.titulo, li.preco, li.estoque, li.idgenero, ge.idgenero, ge.descricao from genero ge "
				+ "inner join livro li on ge.idgenero=li.idlivro where ge.descricao = ?";
		List<Livro> livros = new ArrayList<Livro>();
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, descricao);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Livro livro = new Livro();
				Genero genero = new Genero();
				livro.setIdLivro(rs.getInt("idlivro"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setPreco(rs.getDouble("preco"));
				livro.setEstoque(rs.getInt("estoque"));
				genero.setIdGenero(rs.getInt("idgenero"));
				genero.setDescricao(rs.getString("descricao"));
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

//	deleta
	public void deleta(int id) {
		String query = "delete from genero where idgenero = ?";
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
	public void atualiza(Genero genero) {
		String query = "update genero set descricao = ? where idgenero = ?";
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, genero.getDescricao());
			pstm.setInt(2, genero.getIdGenero());
			pstm.execute();

		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
	}

//	insere
	public void insere(Genero genero) {
		String query = "insert into genero(descricao) values (?)";
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, genero.getDescricao());
			pstm.execute();

		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
	}
}// fim classe
