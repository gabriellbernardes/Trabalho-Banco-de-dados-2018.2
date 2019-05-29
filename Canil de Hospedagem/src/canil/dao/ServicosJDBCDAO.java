package canil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import canil.entity.Servicos;

public class ServicosJDBCDAO {

	public ServicosJDBCDAO() {
	}

	public void inserir(Servicos serv) {
		Connection con = null;

		try {
			con = ConnectionFactory.getConnection();
			String insert_sql = "insert into servicos(Scpf, Banho, Tosa) values (?, ?, ?)";
			PreparedStatement pst;

			pst = con.prepareStatement(insert_sql);
			pst.setString(1, serv.getScpf());
			pst.setInt(2, serv.getBanho());
			pst.setInt(3, serv.getTosa());
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

	public void atualizar(Servicos serv) {

		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String update_sql = "update servicos set  scpf= ?, banho = ?, tosa = ? where id_serv = ?";
			PreparedStatement pst;

			pst = con.prepareStatement(update_sql);
			pst.setString(1, serv.getScpf());
			pst.setInt(2, serv.getBanho());
			pst.setInt(3, serv.getTosa());
			pst.setInt(4, serv.getId_serv());
			int resultado = pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Linhas afetadas: " + resultado);

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

	public Servicos findById_serv(int id_serv) {
		Connection con = null;
		Servicos serv = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from servicos where id_serv = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id_serv);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				serv = map(rs);
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
		return serv;
	}

	public void delete(int id_serv) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from servicos where id_serv = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id_serv);
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

	private Servicos map(ResultSet rs) throws SQLException {
		Servicos serv = new Servicos();
		serv.setId_serv(rs.getInt("id_serv"));
		serv.setScpf(rs.getString("scpf"));
		serv.setBanho(rs.getInt("banho"));
		serv.setTosa(rs.getInt("tosa"));

		return serv;
	}

	public List<Servicos> find() {
		Connection con = null;
		List<Servicos> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from servicos";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Servicos>();
			while (rs.next()) {
				Servicos serv = map(rs);
				result.add(serv);
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