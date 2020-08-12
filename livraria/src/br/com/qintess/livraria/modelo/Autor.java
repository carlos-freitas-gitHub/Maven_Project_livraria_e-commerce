package br.com.qintess.livraria.modelo;

public class Autor {
// atrubutos
	private int idAutor;
	private String nome;
	private String eMail;

// metodos especiais
	public int getIdAutor() {
		return this.idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String geteMail() {
		return this.eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

}
