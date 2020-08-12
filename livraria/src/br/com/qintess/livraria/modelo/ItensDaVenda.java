package br.com.qintess.livraria.modelo;

import java.util.List;

public class ItensDaVenda {
// atributos
	private List<Venda> vendas;
	private List<Livro> livros;
	private Venda venda;
	private Livro livro;
	private int qtd;
	private double subTotal;

// metodos especiais
	public List<Venda> getVendas() {
		return this.vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public List<Livro> getLivros() {
		return this.livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Venda getVenda() {
		return this.venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Livro getLivro() {
		return this.livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getQtd() {
		return this.qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getSubTotal() {
		this.subTotal = (this.qtd * this.livro.getPreco()); // calcula qtd * preco
		return this.subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

}// fim classe
