package br.com.qintess.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.qintess.livraria.modelo.Cliente;
import br.com.qintess.livraria.modelo.ItensDaVenda;
import br.com.qintess.livraria.modelo.Livro;
import br.com.qintess.livraria.modelo.Venda;

public class ItensDaVendaDao {
// seleciona
	public List<ItensDaVenda> seleciona() {
		String query = "select idvenda, idlivro, qtd, subtotal from itensdavenda";
		List<ItensDaVenda> itensDaVendas = new ArrayList<ItensDaVenda>();
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				ItensDaVenda itensDaVenda = new ItensDaVenda();
				Venda venda = new Venda();
				Livro livro = new Livro();
				venda.setIdVenda(rs.getInt("idvenda"));
				livro.setIdLivro(rs.getInt("idlivro"));
				itensDaVenda.setVenda(venda);
				itensDaVenda.setLivro(livro);
				itensDaVenda.setQtd(rs.getInt("qtd"));
				itensDaVenda.setSubTotal(rs.getDouble("subtotal"));
				itensDaVendas.add(itensDaVenda);
			}
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}

		return itensDaVendas;
	}

// insere
	public void insere(ItensDaVenda itensDaVenda) {
		String query = "insert into itensdavenda(idvenda, idlivro, qtd, subtotal)\n" + "values(?, ?, ?, ?);";
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, itensDaVenda.getVenda().getIdVenda());
			pstm.setInt(2, itensDaVenda.getLivro().getIdLivro());
			pstm.setInt(3, itensDaVenda.getQtd());
			pstm.setDouble(4, itensDaVenda.getSubTotal());
			pstm.execute();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}

	}

//	seleciona por cliente
	public ItensDaVenda selecionaPorCliente(String nome) {
		String query = "select cli.idcliente, cli.nome, cli.telefone from cliente cli\n"
				+ "inner join venda ve on cli.idcliente=ve.idvenda inner join itensdavenda it\n"
				+ "on ve.idvenda=it.idvenda where cli.nome = ?";
		ItensDaVenda itensDaVenda = new ItensDaVenda();
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, nome);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idcliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefone(rs.getString("telefone"));
				Venda venda = new Venda();
				venda.setClientes(cliente); // setando o cliente em venda
				itensDaVenda.setVenda(venda); // setando venda em itens da venda
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
		return itensDaVenda;
	}
}
