package br.com.qintess.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.qintess.livraria.modelo.Cliente;

public class ClienteDao {
// seleciona
	public List<Cliente> seleciona() {
		String query = "select idcliente, nome, telefone from cliente";
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idcliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefone(rs.getString("telefone"));
				clientes.add(cliente);
			}
		} catch (Exception e) {
			System.err.println("Ocoreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
		return clientes;
	}

// seleciona por id
	public Cliente selecionaPorId(int id) {
		String query = "select idcliente, nome, telefone from cliente where idcliente = ?";
		Cliente cliente = new Cliente();
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				cliente.setIdCliente(rs.getInt("idcliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefone(rs.getString("telefone"));
			}
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
		return cliente;
	}

// deleta
	public void deleta(int id) {
		String query = "delete from cliente where idcliente = ?";
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.execute();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
	}

// atualiza
	public void atualiza(Cliente cliente) {
		String query = "update cliente set nome = ?, telefone = ? where idcliente = ?";
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getTelefone());
			pstm.setInt(3, cliente.getIdCliente());
			pstm.execute();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getConexao();
		}
	}

// insere
	public void insere(Cliente cliente) {
		String query = "insert into cliente(nome, telefone) values (?, ?)";
		try {
			Connection conn = Conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getTelefone());
			pstm.execute();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		} finally {
			Conexao.getFechaConexao();
		}
	}
}
