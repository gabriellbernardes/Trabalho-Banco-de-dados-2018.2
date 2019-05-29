package canil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import canil.entity.Passeio;

public class PasseioJDBCDAO {

	public PasseioJDBCDAO() {
	}

	public void inserir(Passeio p) {
		Connection con = null;

		try {
			con = ConnectionFactory.getConnection();
			String insert_sql = "insert into passeio  values (?, ?, ?)";
			PreparedStatement pst;

			pst = con.prepareStatement(insert_sql);
			pst.setInt(1, p.getHospnr());
			pst.setInt(2, p.getQtd_passeio());
			pst.setTime(3, java.sql.Time.valueOf(p.getTempo_passeio()+":00"));
			
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

	public void atualizar(Passeio p) {

		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String update_sql = "update passeio set  qtd_passeio= ?, tempo_passeio = ? where hospnr = ?";
			PreparedStatement pst;

			pst = con.prepareStatement(update_sql);
	
			pst.setInt(1, p.getQtd_passeio());
			pst.setTime(2, java.sql.Time.valueOf(p.getTempo_passeio()));
			pst.setInt(3, p.getHospnr());

			
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

	public void delete(int hospnr) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from passeio where hospnr = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, hospnr);
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

	private Passeio map(ResultSet rs) throws SQLException {
		Passeio p = new Passeio();
		p.setHospnr(rs.getInt("hospnr"));
		p.setQtd_passeio(rs.getInt("qtd_passeio"));
		p.setTempo_passeio(rs.getString("tempo_passeio"));
		
		return p;
	}

	public Passeio findByPhospnr(int hospnr) {
		Connection con = null;
		Passeio p = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from passeio where hospnr = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, hospnr);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				p = map(rs);
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
		return p;
	}

	public List<Passeio> find() {
		Connection con = null;
		List<Passeio> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from passeio";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Passeio>();
			while (rs.next()) {
				Passeio p = map(rs);
				result.add(p);
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
