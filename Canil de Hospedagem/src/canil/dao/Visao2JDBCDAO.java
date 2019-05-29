package canil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import canil.entity.Visao2;

public class Visao2JDBCDAO {

	public Visao2JDBCDAO() {
		
	}
	
	private Visao2 map(ResultSet rs) throws SQLException {
		Visao2 v = new Visao2();
		v.setNome_cliente(rs.getString("nome_cliente"));
		v.setNome_Cao(rs.getString("nome_cao"));
		v.setRaca(rs.getString("raca"));
		v.setQtd_banho(rs.getInt("qtd_banho"));
		v.setQtd_Tosa(rs.getInt("qtd_tosa"));
		v.setQtd_aula(rs.getInt("qtd_aula"));
		v.setQtd_passeio(rs.getInt("qtd_passeio"));
		v.setQtd_dias(rs.getInt("qtd_dias"));
		v.setCpf(rs.getString("cpf"));

		
		
		return v;
	}
	
	public List<Visao2> find() {
		Connection con = null;
		List<Visao2> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from informacoes";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Visao2>();
			while (rs.next()) {
				Visao2 v= map(rs);
				result.add(v);
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
