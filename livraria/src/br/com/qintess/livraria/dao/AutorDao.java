package br.com.qintess.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.qintess.livraria.modelo.Autor;

public class AutorDao {
//seleciona
	public List<Autor> seleciona() {
		String query = "select idautor, nome, email from autor";
		List<Autor> autores = new ArrayList<Autor>();
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Autor autor = new Autor();
				autor.setIdAutor(rs.getInt("idautor"));
				autor.setNome(rs.getString("nome"));
				autor.seteMail(rs.getString("email"));
				autores.add(autor);
			}

		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
		return autores;
	}

//selecionaPorId
	public Autor selecionarPorId(int id) {
		String query = "select idautor, nome, email from autor where idautor = ?";
		Autor autor = new Autor();
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				autor.setIdAutor(rs.getInt("idautor"));
				autor.setNome(rs.getString("nome"));
				autor.seteMail(rs.getString("email"));
			}
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
		return autor;
	}

//deleta
	public void deleta(int id) {
		String query = "delete from autor where idautro = ?";
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

//atualiza
	public void atualiza(Autor autor) {
		String query = "update autor set nome = ?, email = ? where idautor = ?";
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, autor.getNome());
			pstm.setString(2, autor.geteMail());
			pstm.setInt(3, autor.getIdAutor());
			pstm.execute();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
	}

//insere
	public void insere(Autor autor) {
		String query = "insert into autor(nome, email) values (?, ?)";
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, autor.getNome());
			pstm.setString(2, autor.geteMail());
			pstm.execute();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
	}
}
