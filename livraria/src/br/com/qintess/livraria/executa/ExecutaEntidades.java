package br.com.qintess.livraria.executa;

import br.com.qintess.livraria.dao.AutorDao;
import br.com.qintess.livraria.dao.ClienteDao;
import br.com.qintess.livraria.dao.EscreveDao;
import br.com.qintess.livraria.dao.GeneroDao;
import br.com.qintess.livraria.dao.ItensDaVendaDao;
import br.com.qintess.livraria.dao.LivroDao;
import br.com.qintess.livraria.dao.VendaDao;
import br.com.qintess.livraria.modelo.Autor;
import br.com.qintess.livraria.modelo.Cliente;
import br.com.qintess.livraria.modelo.Escreve;
import br.com.qintess.livraria.modelo.Genero;
import br.com.qintess.livraria.modelo.ItensDaVenda;
import br.com.qintess.livraria.modelo.Livro;
import br.com.qintess.livraria.modelo.Venda;

public class ExecutaEntidades {
	public static void main(String[] args) {
		Genero genero = new Genero();
//		genero.setDescricao("Autobiografia");
		GeneroDao generoDao = new GeneroDao();
//		generoDao.insere(genero);
//		Genero generoRetornado = generoDao.selecionaPorId(7);
		Livro livro = new Livro();
//		livro.setTitulo("A Cor Da Liberdade - Os Anos De Presidência");
//		livro.setPreco(99.90);
//		livro.setEstoque(2);
//		livro.setGenero(generoRetornado);
		LivroDao livroDao = new LivroDao();
//		livroDao.insere(livro);
		Autor autor = new Autor();
//		autor.setNome("Mandela, Nelson - Langa, Mandla");
//		autor.seteMail("Mandela@gmail.com");
		AutorDao autorDao = new AutorDao();
//		autorDao.insere(autor);
//		Livro livroRetornado = livroDao.selecionaPorId(7);
//		List<Livro> livros = new ArrayList<Livro>();
//		livros.add(livroRetornado); // lista de livros
//		Autor autorRetornado = autorDao.selecionarPorId(6);
//		List<Autor> autores = new ArrayList<Autor>();
//		autores.add(autor);
		Escreve escreve = new Escreve();
//		escreve.setLivros(livros);
//		escreve.setAutores(autores);
//		escreve.setLivro(livroRetornado);
//		escreve.setAutor(autorRetornado);
		EscreveDao escreveDao = new EscreveDao();
//		escreveDao.insere(escreve.getLivro().getIdLivro(), escreve.getAutor().getIdAutor());
		Cliente cliente = new Cliente();
//		cliente.setNome("Saraiva");
//		cliente.setTelefone("Saraiva4@email.com.br");
		ClienteDao clienteDao = new ClienteDao();
//		clienteDao.insere(cliente);
//		Cliente clienteRetornado = clienteDao.selecionaPorId(8);
		Venda venda = new Venda();
//		venda.setTotal(0.0);
//		venda.setClientes(clienteRetornado);
		VendaDao vendaDao = new VendaDao();
//		vendaDao.insere(venda);

// itens da venda		
//		Venda vendaRetornada01 = vendaDao.selecionaPorId(6);
//		Livro livroRetornado01 = livroDao.selecionaPorId(6);
		Venda vendaRetornada02 = vendaDao.selecionaPorId(7);
		Livro livroRetornado02 = livroDao.selecionaPorId(7);
//		ItensDaVenda itens01 = new ItensDaVenda();
//		itens.setVenda(vendaRetornada01);
//		itens.setLivro(livroRetornado01);
//		itens.setQtd(2);
		ItensDaVenda itens02 = new ItensDaVenda();
		itens02.setVenda(vendaRetornada02);
		itens02.setLivro(livroRetornado02);
		itens02.setQtd(5);

		ItensDaVendaDao itensDao = new ItensDaVendaDao();
//		itensDao.insere(itens01);
		itensDao.insere(itens02);

//		venda.adicionaItensVenda(itens01); // adicionando itens na lista de vendas
		venda.adicionaItensVenda(itens02);

//		vendaDao.atualizaTotal(vendaRetornada01); // atualiza o total
		vendaDao.atualizaTotal(vendaRetornada02);

	}
}// fim classe
