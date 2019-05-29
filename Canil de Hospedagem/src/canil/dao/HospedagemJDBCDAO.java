package canil.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	import javax.swing.JOptionPane;
	import canil.entity.Hospedagem;
	import canil.dao.ConnectionFactory;
	import canil.dao.DAOException;

	public class HospedagemJDBCDAO {
		public HospedagemJDBCDAO() {
		}

		public void inserir(Hospedagem hosp) {
			Connection con = null;

			try {
				con = ConnectionFactory.getConnection();
				String insert_sql = "insert into hospedagem (cao_id, qtd_dias) values (?, ?)";
				PreparedStatement pst;

				pst = con.prepareStatement(insert_sql);
				pst.setInt(1, hosp.getId_cao());
				pst.setInt(2, hosp.getQtd_dias());
			
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

		public void atualizar(Hospedagem hosp) {

			Connection con = null;
			try {
				con = ConnectionFactory.getConnection();
				String update_sql = "update hospedagem set cao_id =?, qtd_dias= ? where hospnr = ?";
				PreparedStatement pst;

				pst = con.prepareStatement(update_sql);
				pst.setInt(1, hosp.getId_cao());
				pst.setInt(2, hosp.getQtd_dias());
				pst.setInt(3, hosp.getHospnr());
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
				String sql = "delete from hospedagem where hospnr = ?";
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

		private Hospedagem map(ResultSet rs) throws SQLException {
			Hospedagem hosp = new Hospedagem();
			hosp.setHospnr(rs.getInt("hospnr"));
			hosp.setId_cao(rs.getInt("cao_id"));
			hosp.setQtd_dias(rs.getInt("qtd_dias"));

			return hosp;
		}

		
		public Hospedagem findByHospnr(int hospnr) {
			Connection con = null;
			Hospedagem hosp = null;
			try {
				con = ConnectionFactory.getConnection();
				PreparedStatement pst;
				String sql = "select hospnr, cao_id, qtd_dias from hospedagem where hospnr = ?";
				pst = con.prepareStatement(sql);
				pst.setInt(1, hospnr);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					hosp = map(rs);
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
			return hosp;
		}

		public List<Hospedagem> find() {
			Connection con = null;
			List<Hospedagem> result = null;
			try {
				con = ConnectionFactory.getConnection();
				PreparedStatement pst;
				String sql = "select * from hospedagem";
				pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				result = new ArrayList<Hospedagem>();
				while (rs.next()) {
					Hospedagem hosp = map(rs);
					result.add(hosp);
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
