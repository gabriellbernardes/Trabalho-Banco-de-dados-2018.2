package canil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import canil.entity.Adestramento;

public class AdestramentoJDBCDAO {

	public AdestramentoJDBCDAO() {

	}

	public void inserir(Adestramento ad) {
		Connection con = null;

		try {
			con = ConnectionFactory.getConnection();
			String insert_sql = "insert into adestramento(hospnr, tempo_aula, qtd_aula) values ( ?, ?, ?)";
			PreparedStatement pst;

			pst = con.prepareStatement(insert_sql);
			pst.setInt(1, ad.getHospnr());
			pst.setTime(2, java.sql.Time.valueOf(ad.getTempo_aula()+":00"));
			pst.setInt(3, ad.getQtd_aula());
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

	public void atualizar(Adestramento ad) {

		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String update_sql = "update adestramento set  hospnr= ?, tempo_aula = ?, qtd_aula = ? where id_adestramento = ?";
			PreparedStatement pst;

			pst = con.prepareStatement(update_sql);
			pst.setInt(4, ad.getId_adestramento());
			pst.setInt(1, ad.getHospnr());
			pst.setTime(2, java.sql.Time.valueOf(ad.getTempo_aula()));
			pst.setInt(3, ad.getQtd_aula());

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

	public Adestramento findById_adestramento(int id_adestramento) {
		Connection con = null;
		Adestramento ad = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select id_adestramento, hospnr, tempo_aula, qtd_aula from adestramento where id_adestramento = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id_adestramento);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				ad = map(rs);
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
		return ad;
	}

	public void delete(int id_adestramento) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from adestramento where id_adestramento = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id_adestramento);
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

	private Adestramento map(ResultSet rs) throws SQLException {
		Adestramento ad = new Adestramento();
		ad.setId_destramento(rs.getInt("id_adestramento"));
		ad.setHospnr(rs.getInt("hospnr"));
		ad.setTempo_aula(rs.getTime("tempo_aula").toString());
		ad.setQtd_aula(rs.getInt("qtd_aula"));
		return ad;
	}

	public List<Adestramento> find() {
		Connection con = null;
		List<Adestramento> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from adestramento";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Adestramento>();
			while (rs.next()) {
				Adestramento ad = map(rs);
				result.add(ad);
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
