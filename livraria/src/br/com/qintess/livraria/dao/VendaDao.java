package br.com.qintess.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.qintess.livraria.modelo.Cliente;
import br.com.qintess.livraria.modelo.Venda;

public class VendaDao {
// seleciona
	public List<Venda> seleciona() {
		String query = "select idvenda, data, total, idcliente from venda";
		List<Venda> vendas = new ArrayList<Venda>();
		try {
			Connection conn = new Conexao().getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Venda venda = new Venda();
				Cliente cliente = new Cliente();
				venda.setIdVenda(rs.getInt("idvenda"));
				String data = rs.getString("data");
				venda.setData(LocalDate.parse(data));
				venda.setTotal(rs.getInt("total"));
				cliente.setIdCliente(rs.getInt("idcliente"));
				venda.setClientes(cliente);
				vendas.add(venda);

			}
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
		return vendas;
	}

// seleciona por id
	public Venda selecionaPorId(int id) {
		String query = "select idvenda, data, total, idcliente from venda where idvenda = ?";
		Venda venda = new Venda();
		try {
			Connection conn = new Conexao().getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				venda.setIdVenda(rs.getInt("idvenda"));
				String data = rs.getString("data");
				venda.setData(LocalDate.parse(data));
				venda.setTotal(rs.getDouble("total"));
				cliente.setIdCliente(rs.getInt("idcliente"));
				venda.setClientes(cliente);
			}
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
		return venda;
	}

// deletar
	public void deleta(int id) {
		String query = "delete from venda where idvenda = ?";
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

// atualizar
	public void atualiza(Venda venda) {
		String query = "update venda set data = ?, total = ?, idcliente = ? where idvenda = ?";
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setObject(1, venda.getData());
			pstm.setDouble(2, venda.getTotal());
			pstm.setInt(3, venda.getClientes().getIdCliente());
			pstm.setInt(4, venda.getIdVenda());
			pstm.execute();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
	}

// inserir
	public void insere(Venda venda) {
		String query = "insert into venda(data, total, idcliente) values (?, ?, ?)";
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setObject(1, venda.getData());
			pstm.setDouble(2, venda.getTotal());
			pstm.setInt(3, venda.getClientes().getIdCliente());
			pstm.execute();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
	}

//	seleciona cliente por nome
	public Venda selecionaClientePorNome(String nome) {
		String query = "select cli.idcliente, cli.nome, cli.telefone from cliente cli\n"
				+ "inner join venda ve on cli.idcliente=ve.idcliente where cli.nome = ?";
		Venda venda = new Venda();
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
				venda.setClientes(cliente);
			}
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
		return venda;
	}

//	atualiza o total
	public void atualizaTotal(Venda venda) {
		String query = "update venda set total = ? where idvenda = ?";
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setDouble(1, venda.getTotal());
			pstm.setInt(2, venda.getIdVenda());
			pstm.execute();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
	}
}
