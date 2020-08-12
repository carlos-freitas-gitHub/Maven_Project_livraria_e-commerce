package br.com.qintess.livraria.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda {
// atributos
	private int idVenda;
	private LocalDate data;
	private double total;
	private Cliente cliente;
	private Livro livro;
	private List<ItensDaVenda> itensDaVendas = new ArrayList<ItensDaVenda>();

//construtor
	public Venda() {
		this.data = LocalDate.now();
		this.total = 0;
	}

//metodos especiais
	public int getIdVenda() {
		return this.idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public LocalDate getData() {
		return this.data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getTotal() {
		for (ItensDaVenda itens : itensDaVendas) {
			this.total += itens.getSubTotal();
		}
		this.setTotal(this.total);
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cliente getClientes() {
		return this.cliente;
	}

	public void setClientes(Cliente cliente) {
		this.cliente = cliente;
	}

	public Livro getLivro() {
		return this.livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<ItensDaVenda> getItensDaVendas() {
		return this.itensDaVendas;
	}

	public void setItensDaVendas(List<ItensDaVenda> itensDaVendas) {
		this.itensDaVendas = itensDaVendas;
	}

// metodos de diferenca adiciona itens da venda em lista
	public void adicionaItensVenda(ItensDaVenda itensDaVenda) {
		this.itensDaVendas.add(itensDaVenda);
	}

}// fim classe
