package canil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import canil.entity.Cao;
import canil.dao.ConnectionFactory;
import canil.dao.DAOException;

public class CaoJDBCDAO {
	public CaoJDBCDAO() {
	}

	public void inserir(Cao cao) {
		Connection con = null;

		try {
			con = ConnectionFactory.getConnection();
			String insert_sql = "insert into cao (raca, cnome, tamanho, cor, temperamento, dono_cpf) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement pst;

			pst = con.prepareStatement(insert_sql);
			pst.setString(1, cao.getRaca());
			pst.setString(2, cao.getCnome());
			pst.setString(3, cao.getTamanho());
			pst.setString(4, cao.getCor());
			pst.setString(5, cao.getTemperamento());
			pst.setString(6, cao.getDono_cpf());
			
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

	public void atualizar(Cao cao) {

		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String update_sql = "update cao set raca =?, cnome= ?, tamanho = ?, cor = ?, temperamento =?, dono_cpf =? where cao_id = ?";
			PreparedStatement pst;

			pst = con.prepareStatement(update_sql);
			pst.setString(1, cao.getRaca());
			pst.setString(2, cao.getCnome());
			pst.setString(3, cao.getTamanho());
			pst.setString(4, cao.getCor());
			pst.setString(5, cao.getTemperamento());
			pst.setString(6, cao.getDono_cpf());
			pst.setInt(7, cao.getCao_id());
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

	public void delete(int cao_id) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from cao where cao_id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, cao_id);
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

	private Cao map(ResultSet rs) throws SQLException {
		Cao cao = new Cao();
		cao.setCao_id(rs.getInt("cao_id"));
		cao.setRaca(rs.getString("raca"));
		cao.setCnome(rs.getString("cnome"));
		cao.setTamanho(rs.getString("tamanho"));
		cao.setCor(rs.getString("cor"));
		cao.setTemperamento(rs.getString("temperamento"));
		cao.setDono_cpf(rs.getString("dono_cpf"));

		return cao;
	}

	public Cao findByCao_id(int cao_id) {
		Connection con = null;
		Cao cao = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select cao_id, raca, cnome, tamanho, cor, temperamento, dono_cpf from cao where cao_id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, cao_id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				cao = map(rs);
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
		return cao;
	}

	public List<Cao> find() {
		Connection con = null;
		List<Cao> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from cao";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Cao>();
			while (rs.next()) {
				Cao cao = map(rs);
				result.add(cao);
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
	




	/*public List<Cao> naoHospedado() {
		Connection con = null;
		List<Cao> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "	select	Ca.cnome as Cao_Nao_Hospedado, ca.raca  		\n" + 
					"	from	cao ca 		\n" + 
					"	where	not exists (select * from hospedagem h where ca.cao_id = h.cao_id);	";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Cao>();
			while (rs.next()) {
				Cao cao = map(rs);
				result.add(cao);
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

	}*/





}
