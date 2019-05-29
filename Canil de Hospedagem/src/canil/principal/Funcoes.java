package canil.principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import canil.entity.*;

public class Funcoes {

	public Funcoes() {

	}

	public void obterCliente(Cliente cl) {

		String cpf = JOptionPane.showInputDialog("cpf", cl.getCpf());
		String nome = JOptionPane.showInputDialog("nome", cl.getNome());
		String endereco = JOptionPane.showInputDialog("endereco", cl.getEndereco());
		String telefone = JOptionPane.showInputDialog("numero", cl.getTelefone());

		cl.setCpf(cpf);
		cl.setNome(nome);
		cl.setEndereco(endereco);
		cl.setTelefone(telefone);

	}

	public void listaCliente(List<Cliente> cliente) {
		StringBuilder listagem = new StringBuilder();
		for (Cliente cl : cliente) {
			listagem.append(cl).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum Cliente encontrado" : listagem);
	}

	public void listaCliente(Cliente cl) {
		JOptionPane.showMessageDialog(null, cl == null ? "Nenhum Cliente encontrado" : cl);
	}
//-----------------------------------------------------------------------------------------------------------------

	public void obterCao(Cao cao) {

		String raca = JOptionPane.showInputDialog("raca", cao.getRaca());
		String cnome = JOptionPane.showInputDialog("nome", cao.getCnome());
		String tamanho = JOptionPane.showInputDialog("tamanho", cao.getTamanho());
		String cor = JOptionPane.showInputDialog("cor", cao.getCor());
		String temperamento = JOptionPane.showInputDialog("temperamento", cao.getTemperamento());
		String dono_cpf = JOptionPane.showInputDialog("dono_cpf", cao.getDono_cpf());

		cao.setRaca(raca);
		cao.setCnome(cnome);
		cao.setTamanho(tamanho);
		cao.setCor(cor);
		cao.setTemperamento(temperamento);
		cao.setDono_cpf(dono_cpf);
	}

	public void listaCao(List<Cao> cao) {
		StringBuilder listagem = new StringBuilder();
		for (Cao ca : cao) {
			listagem.append(ca).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum Cao encontrado" : listagem);
	}

	public void listaCliente(Cao cao) {
		JOptionPane.showMessageDialog(null, cao == null ? "Nenhum Cao encontrado" : cao);
	}

//-----------------------------------------------------------------------------------------------------------------

	public void obterPagamento(Pagamento pg) throws ParseException {

		double valor = Double.parseDouble(JOptionPane.showInputDialog("valor", pg.getValor()));
		String data = JOptionPane.showInputDialog("data_pg", pg.getData_pg());

		Date data_pg = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		// String aux = data;
		// aux.replaceAll("-", "/");
		// String[] s = aux.split("/");
		// String novaData = s[2] + "/" + s[1] + "/" + s[0];
		// if (data.indexOf("-") >= 0) {
		// data_pg = new SimpleDateFormat("dd/MM/yyyy").parse(novaData);
		// pg.setData_pg(data_pg);
		// } else {
		// data_pg = ;
		// }
		String cliente_cpf = JOptionPane.showInputDialog("cliente_cpf", pg.getCliente_cpf());
		pg.setValor(valor);
		pg.setData_pg(data_pg);
		pg.setCliente_cpf(cliente_cpf);

	}

	public void listaPagamento(List<Pagamento> pagamento) {
		StringBuilder listagem = new StringBuilder();
		for (Pagamento pag : pagamento) {
			listagem.append(pag).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum Pagamento encontrado" : listagem);
	}

	public void listaPagamento(Pagamento pg) {
		JOptionPane.showMessageDialog(null, pg == null ? "Nenhum Pagamento encontrado" : pg);
	}

//-----------------------------------------------------------------------------------------------------------------
	public void obterHospedagem(Hospedagem hosp) {

		int cao_id = Integer.parseInt(JOptionPane.showInputDialog("cao_id", hosp.getId_cao()));
		int qtd_dias = Integer.parseInt(JOptionPane.showInputDialog("qtd_dias", hosp.getQtd_dias()));

		hosp.setId_cao(cao_id);
		hosp.setQtd_dias(qtd_dias);
	}

	public void listaHospedagem(List<Hospedagem> hospedagem) {
		StringBuilder listagem = new StringBuilder();
		for (Hospedagem hosp : hospedagem) {
			listagem.append(hosp).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum Cliente encontrado" : listagem);
	}

	public void listaHospedagem(Hospedagem hosp) {
		JOptionPane.showMessageDialog(null, hosp == null ? "Nenhuma Hospedagem  encontrada" : hosp);
	}

//-----------------------------------------------------------------------------------------------------------------

	public void obterAdestramento(Adestramento ad) {

		int hospnr = Integer.parseInt(JOptionPane.showInputDialog("hospnr", ad.getHospnr()));
		String tempo_aula = JOptionPane.showInputDialog("tempo_aula", ad.getTempo_aula());
		int qtd_aula = Integer.parseInt(JOptionPane.showInputDialog("qtd_aula", ad.getQtd_aula()));

		ad.setHospnr(hospnr);
		ad.setTempo_aula(tempo_aula);
		ad.setQtd_aula(qtd_aula);
	}

	public void listaAdestramento(List<Adestramento> adestramento) {
		StringBuilder listagem = new StringBuilder();
		for (Adestramento ad : adestramento) {
			listagem.append(ad).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum Adestramento encontrado" : listagem);
	}

	public void listaAdestramento(Adestramento ad) {
		JOptionPane.showMessageDialog(null, ad == null ? "Nenhum Adestramento encontrado" : ad);
	}

//-----------------------------------------------------------------------------------------------------------------
	public void obterPasseio(Passeio passeio) {

		int qtd_passeio = Integer.parseInt(JOptionPane.showInputDialog("qtd_passeio", passeio.getQtd_passeio()));
		String tempo_passeio = JOptionPane.showInputDialog("tempo_passeio", passeio.getTempo_passeio());

		passeio.setQtd_passeio(qtd_passeio);
		passeio.setTempo_passeio(tempo_passeio);

	}

	public void listaPasseio(List<Passeio> passeio) {
		StringBuilder listagem = new StringBuilder();
		for (Passeio pass : passeio) {
			listagem.append(pass).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum Passeio encontrado" : listagem);
	}

	public void listaPasseio(Passeio pass) {
		JOptionPane.showMessageDialog(null, pass == null ? "Nenhum Passeio encontrado" : pass);
	}
//-----------------------------------------------------------------------------------------------------------------

	public void obterServicos(Servicos servicos) {

		String scpf = JOptionPane.showInputDialog("scpf", servicos.getScpf());
		int banho = Integer.parseInt(JOptionPane.showInputDialog("banho", servicos.getBanho()));
		int tosa = Integer.parseInt(JOptionPane.showInputDialog("tosa", servicos.getTosa()));

		servicos.setScpf(scpf);
		servicos.setBanho(banho);
		servicos.setTosa(tosa);
	}

	public void listaServicos(List<Servicos> servicos) {
		StringBuilder listagem = new StringBuilder();
		for (Servicos serv : servicos) {
			listagem.append(serv).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum Servico encontrado" : listagem);
	}

	public void listaServicos(Servicos serv) {
		JOptionPane.showMessageDialog(null, serv == null ? "Nenhum Servico encontrado" : serv);
	}
//-----------------------------------------------------------------------------------------------------------------

	public void listaInfo_hospedagem(List<Info_hospedagem> ih) {
		StringBuilder listagem = new StringBuilder();
		for (Info_hospedagem inf : ih) {
			listagem.append(inf).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhuma Informacao encontrada" : listagem);
	}
//-----------------------------------------------------------------------------------------------------------------

	public void listaVisao2(List<Visao2> v) {
		StringBuilder listagem = new StringBuilder();
		for (Visao2 visao : v) {
			listagem.append(visao).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhuma Informacao encontrada" : listagem);
	}

}
