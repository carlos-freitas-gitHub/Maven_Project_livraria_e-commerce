package br.com.qintess.livraria.modelo;

import java.util.List;

public class Genero {
// atributos
	private int idGenero;
	private String descricao;
	private List<Livro> livros;

// metodos especiais
	public int getIdGenero() {
		return this.idGenero;
	}

	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Livro> getLivros() {
		return this.livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

}// fim classe
