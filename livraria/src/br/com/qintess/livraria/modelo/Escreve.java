package br.com.qintess.livraria.modelo;

import java.util.List;

public class Escreve {
//atributos
	private List<Livro> livros;
	private List<Autor> autores;
	private Livro livro;
	private Autor autor;

//metodos especiais 
	public List<Livro> getLivros() {
		return this.livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<Autor> getAutores() {
		return this.autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}// fim classe
