package canil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import canil.entity.Info_hospedagem;


public class Info_hospedagemJDBCDAO {
	
	
	public Info_hospedagemJDBCDAO() {
		
	}
	
	private Info_hospedagem map(ResultSet rs) throws SQLException {
		Info_hospedagem ih = new Info_hospedagem();
		ih.setCliente(rs.getString("cliente"));
		ih.setNome_cao(rs.getString("nome_cao"));
		ih.setRaca(rs.getString("raca"));
		ih.setDias_hospedados(rs.getInt("dias_hospedado"));
		
		
		return ih;
	}
	
	public List<Info_hospedagem> find() {
		Connection con = null;
		List<Info_hospedagem> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select c.nome as Cliente, ca.cnome as Nome_cao, ca.raca as Raca, Qtd_dias as Dias_Hospedado      \n" + 
					"from cliente c, cao ca , Hospedagem h \n" + 
					"where c.cpf = ca.Dono_cpf and ca.cao_id = h.Cao_id";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Info_hospedagem>();
			while (rs.next()) {
				Info_hospedagem ih = map(rs);
				result.add(ih);
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
