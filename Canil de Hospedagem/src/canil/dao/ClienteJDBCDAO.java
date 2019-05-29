package canil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import canil.entity.Cliente;
import canil.dao.ConnectionFactory;
import canil.dao.DAOException;

public class ClienteJDBCDAO {

	public ClienteJDBCDAO() {
	}

	public void inserir(Cliente cliente) {
		Connection con = null;

		try {
			con = ConnectionFactory.getConnection();
			String insert_sql = "insert into cliente(cpf, nome, endereco, telefone) values (?, ?, ?, ?)";
			PreparedStatement pst;

			pst = con.prepareStatement(insert_sql);
			pst.setString(1, cliente.getCpf());
			pst.setString(2, cliente.getNome());
			pst.setString(3, cliente.getEndereco());
			pst.setString(4, cliente.getTelefone());
			int resultado = pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Linhas afetadas: " + resultado);

		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.", e);
			}
		}
	}

	public void atualizar(Cliente cliente) {

		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String update_sql = "update cliente set  nome= ?, endereco = ?, telefone = ? where cpf = ?";
			PreparedStatement pst;

			pst = con.prepareStatement(update_sql);
			pst.setString(4, cliente.getCpf());
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getEndereco());
			pst.setString(3, cliente.getTelefone());
			int resultado = pst.executeUpdate();

			if(resultado==0) {
				JOptionPane.showMessageDialog(null, "Operação não realizada com sucesso.");
			}
			else {
			JOptionPane.showMessageDialog(null, "Linhas afetadas: " + resultado);
			}
			
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.", e);
			}
		}
	}

	public Cliente findByCpf(String cpf) {
		Connection con = null;
		Cliente cliente = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select cpf, nome, endereco, telefone from cliente where cpf = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, cpf);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				cliente = map(rs);
			}

		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.", e);
			}
		}
		return cliente;
	}

	public void delete(String cpf) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from cliente where cpf = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cpf);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.", e);
			}
		}
	}

	private Cliente map(ResultSet rs) throws SQLException {
		Cliente cl = new Cliente();
		cl.setCpf(rs.getString("cpf"));
		cl.setNome(rs.getString("nome"));
		cl.setEndereco(rs.getString("endereco"));
		cl.setTelefone(rs.getString("Telefone"));
		return cl;
	}

	public List<Cliente> find() {
		Connection con = null;
		List<Cliente> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from cliente";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Cliente>();
			while (rs.next()) {
				Cliente cliente = map(rs);
				result.add(cliente);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.", e);
			}
		}
		return result;
	}
	
	
	
}
