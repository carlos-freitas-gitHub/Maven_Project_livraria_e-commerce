package br.com.qintess.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.qintess.livraria.modelo.Autor;
import br.com.qintess.livraria.modelo.Genero;
import br.com.qintess.livraria.modelo.Livro;

public class EscreveDao {
// insere
	public void insere(int idLivro, int idAutor) {
		String query = "insert into escreve(idlivro, idautor) values (?, ?)";
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, idLivro);
			pstm.setInt(2, idAutor);
			pstm.execute();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
	}

//	seleciona autor de livro
	public List<Autor> selecionaAutorLivro(Livro livro) {
		String query = "select au.idautor, au.nome, au.email from autor au \n"
				+ "inner join escreve es on au.idautor=es.idautor\n" + "inner join livro li on li.idlivro=es.idlivro\n"
				+ "where li.idlivro = ?";
		List<Autor> autores = new ArrayList<Autor>();
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, livro.getIdLivro());
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

//	seleciona livro de autor
	public List<Livro> selecionaLivroAutor(Autor autor) {
		String query = "select li.idlivro, li.titulo, li.preco, li.estoque, li.idgenero from livro li\n"
				+ "inner join escreve es on li.idlivro=es.idlivro inner join autor au\n"
				+ "on au.idautor=es.idautor where au.idautor = ?";
		List<Livro> livros = new ArrayList<Livro>();
		try {
			Connection conn = new Conexao().getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, autor.getIdAutor());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Livro livro = new Livro();
				Genero genero = new Genero();
				livro.setIdLivro(rs.getInt("idlivro"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setPreco(rs.getDouble("preco"));
				livro.setEstoque(rs.getInt("estoque"));
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
}
