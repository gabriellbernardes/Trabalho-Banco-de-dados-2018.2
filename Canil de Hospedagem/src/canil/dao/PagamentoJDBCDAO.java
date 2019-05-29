package canil.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import canil.entity.Pagamento;

public class PagamentoJDBCDAO {

	public PagamentoJDBCDAO() {
	}

	public void inserir(Pagamento pg) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String insert_sql = "insert into pagamento(Valor, Data_pg, Cliente_cpf) values (?, ?, ?)";
			PreparedStatement pst;
			pst = con.prepareStatement(insert_sql);
			pst.setBigDecimal(1, new BigDecimal(pg.getValor()));
			pst.setDate(2, new java.sql.Date(pg.getData_pg().getTime()));
			pst.setString(3, pg.getCliente_cpf());
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

	public void atualizar(Pagamento pg) {

		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String update_sql = "update pagamento set  valor= ?, data_pg = ?, cliente_cpf = ? where id_pg = ?";
			PreparedStatement pst;

			pst = con.prepareStatement(update_sql);
			pst.setBigDecimal(1, new BigDecimal(pg.getValor()));
			pst.setDate(2, new java.sql.Date(pg.getData_pg().getTime()));
			pst.setString(3, pg.getCliente_cpf());
			pst.setInt(4, pg.getId_pg());
			
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

	public Pagamento findById_pg(int id_pg) {
		Connection con = null;
		Pagamento pg = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from pagamento where id_pg = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1,id_pg);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				pg = map(rs);
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
		return pg;
	}

	public void delete(int id_pg) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from pagamento where id_pg = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id_pg);
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

	private Pagamento map(ResultSet rs) throws SQLException {
		Pagamento pg = new Pagamento();
		pg.setId_pg(rs.getInt("id_pg"));
		pg.setValor(rs.getBigDecimal("valor").floatValue());
		pg.setData_pg(rs.getDate("data_pg")); 
		pg.setCliente_cpf(rs.getString("cliente_cpf"));
		
		
		return pg;
	}



	
	public List<Pagamento> find() {
		Connection con = null;
		List<Pagamento> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from pagamento";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Pagamento>();
			while (rs.next()) {
				Pagamento pag = map(rs);
				result.add(pag);
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
