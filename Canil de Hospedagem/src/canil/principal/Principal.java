package canil.principal;

import java.text.ParseException;

import javax.swing.JOptionPane;
import canil.entity.*;
import canil.dao.*;
import canil.principal.Funcoes;;

public class Principal {
	public static void main(String[] args) throws ParseException {
		ClienteJDBCDAO baseCliente = new ClienteJDBCDAO();
		CaoJDBCDAO baseCao = new CaoJDBCDAO();
		PagamentoJDBCDAO basePag = new PagamentoJDBCDAO();
		HospedagemJDBCDAO baseHosp = new HospedagemJDBCDAO();
		ServicosJDBCDAO baseServ = new ServicosJDBCDAO();
		PasseioJDBCDAO basePasseio = new PasseioJDBCDAO();
		AdestramentoJDBCDAO baseAdestramento = new AdestramentoJDBCDAO();
		Funcoes funcao = new Funcoes();

		//JOptionPane.showMessageDialog(null, "---CANIL FBD---\nHospedagem\nAdestramento\nServicos Caninos ");
		String menu = "Escolha uma opção:\n1 - Menu Inserir \n2 - Menu Atualizar \n3 - Menu Remover \n4 - Menu Vizualizar\n5 - Consultas\n6 - Sair";
		char opcao;
		do {
			Cliente cliente;
			Cao cao;
			Pagamento pagamento;
			Servicos serv;
			Hospedagem hosp;
			Adestramento ades;
			Passeio pass;
			String cpf;
			char opcaob;
			String submenu;
			int cao_id, id_pg, hospnr, id_adestramento, id_serv;

			opcao = JOptionPane.showInputDialog(menu).charAt(0);
			switch (opcao) {

			case '1': // Menu inserir
//----------------------------------------------------------------------------------------------------------------
				submenu = "Escolha uma opção:\n1 - Inserir Cliente\n2 - Inserir Cao\n3 - Inserir Servicos\n4 - Inserir Hospedagem\n5 - Inserir Adestramento\n6 - Inserir Passeio  \n7 - Inserir Pagamento\n8 - Sair";

				do {
					opcaob = JOptionPane.showInputDialog(submenu).charAt(0);
					switch (opcaob) {
					// insere cliente
					case '1':

						cpf = JOptionPane.showInputDialog("Digite o CPF para ser verificado");
						cliente = baseCliente.findByCpf(cpf);
						if (cliente == null) {
							cliente = new Cliente();
							cliente.setCpf(cpf);
							funcao.obterCliente(cliente);
							baseCliente.inserir(cliente);
						} else {
							JOptionPane.showMessageDialog(null, "Cpf ja existe!!");
						}
						break;
					// insere cao
					case '2':
						cpf = JOptionPane.showInputDialog("Digite o CPF para ser verificado");
						cliente = baseCliente.findByCpf(cpf);
						if (cliente != null) {
							cao = new Cao();
							cao.setDono_cpf(cpf);
							funcao.obterCao(cao);
							baseCao.inserir(cao);

						} else {
							JOptionPane.showMessageDialog(null, "Cpf nao cadastrado!!");
						}
						break;

					case '3':// inserir servicos

						cpf = JOptionPane.showInputDialog("Digite o CPF para ser verificado");
						cliente = baseCliente.findByCpf(cpf);
						if (cliente != null) {
							serv = new Servicos();
							serv.setScpf(cpf);
							funcao.obterServicos(serv);
							baseServ.inserir(serv);

						} else {
							JOptionPane.showMessageDialog(null, "Cpf nao cadastrado!!");
						}

						break;
					case '4':// inserir hospedagem
						cao_id = Integer.parseInt(JOptionPane.showInputDialog("Digite o cao_id para ser verificado"));
						cao = baseCao.findByCao_id(cao_id);
						if (cao != null) {
							hosp = new Hospedagem();
							hosp.setId_cao(cao_id);
							funcao.obterHospedagem(hosp);
							baseHosp.inserir(hosp);

						} else {
							JOptionPane.showMessageDialog(null, "cao_id nao cadastrado!!");
						}

						break;

					case '5':// inserir adestramento
						hospnr = Integer.parseInt(JOptionPane.showInputDialog("Digite um hospnr para ser verificado"));
						hosp = baseHosp.findByHospnr(hospnr);

						if (hosp != null) {
							ades = null;
							ades = new Adestramento();
							ades.setHospnr(hospnr);
							funcao.obterAdestramento(ades);
							baseAdestramento.inserir(ades);

						} else {
							JOptionPane.showMessageDialog(null, "hospnr nao cadastrado!!");
						}
						break;
					case '6':

						hospnr = Integer.parseInt(JOptionPane.showInputDialog("Digite um hospnr para ser verificado"));
						hosp = baseHosp.findByHospnr(hospnr);
						pass = basePasseio.findByPhospnr(hospnr);
						if (hosp != null && pass == null) {
							pass = null;
							pass = new Passeio();
							pass.setHospnr(hospnr);
							funcao.obterPasseio(pass);
							basePasseio.inserir(pass);
						} else if (hosp == null) {
							JOptionPane.showMessageDialog(null, "hospnr nao cadastrado!!");
						} else {
							JOptionPane.showMessageDialog(null, "hospnr ja cadastrado na tabela Passeio!!");
						}

						break;
					// insere servicos
					case '7':
						cpf = JOptionPane.showInputDialog("Digite o CPF para ser verificado");
						cliente = baseCliente.findByCpf(cpf);
						if (cliente != null) {
							pagamento = new Pagamento();
							pagamento.setCliente_cpf(cpf);
							funcao.obterPagamento(pagamento);
							basePag.inserir(pagamento);

						} else {
							JOptionPane.showMessageDialog(null, "Cpf nao cadastrado!!");
						}
						break;

					case '8':
						break;

					default:
						JOptionPane.showMessageDialog(null, "Opção Inválida");
						break;
					}

				} while (opcaob != '8');
				break;
//--------------------------------------------------------------------------------------------------------------			

			case '2':// Menu atualizacoes
				// ----------------------------------------------------------------------------------------------------------------
				submenu = "Escolha uma opção:\n1 - Atualizar Cliente\n2 - Atualizar Cao\n3 - Atualizar Servicos\n4 - Atualizar Hospedagem\n5 - Atualizar Adestramento\n6 - Atualizar Passeio  \n7 - Atualizar Pagamento\n8 - Sair";

				do {
					opcaob = JOptionPane.showInputDialog(submenu).charAt(0);
					switch (opcaob) {
					// atualiza cliente
					case '1':
						cpf = JOptionPane.showInputDialog("Digite o CPF do Cliente para ser atualizado");
						cliente = baseCliente.findByCpf(cpf);

						if (cliente != null) {
							funcao.obterCliente(cliente);
							baseCliente.atualizar(cliente);
						} else {
							JOptionPane.showMessageDialog(null, "Cpf nao encontrado na Tabela Cliente");
						}

						break;
					// atualiza cao
					case '2':
						cao_id = Integer
								.parseInt(JOptionPane.showInputDialog("Digite o cao_id do Cao para ser atualizado"));
						cao = baseCao.findByCao_id(cao_id);

						if (cao != null) {
							funcao.obterCao(cao);
							baseCao.atualizar(cao);
						} else {
							JOptionPane.showMessageDialog(null, "cao_id nao encontrado na Tabela Cao");
						}

						break;

					case '3':// atualizar servico
						id_serv = Integer.parseInt(
								JOptionPane.showInputDialog("Digite o id_serv do Servico para ser atualizado"));
						serv = baseServ.findById_serv(id_serv);

						if (serv != null) {
							funcao.obterServicos(serv);
							baseServ.atualizar(serv);
						} else {
							JOptionPane.showMessageDialog(null, "id_serv nao encontrado na Tabela Servicos");
						}

						break;

					case '4':// atualizar hospedagem
						hospnr = Integer.parseInt(
								JOptionPane.showInputDialog("Digite o hospnr da Hospedagem para ser atualizado"));
						hosp = baseHosp.findByHospnr(hospnr);

						if (hosp != null) {
							funcao.obterHospedagem(hosp);
							baseHosp.atualizar(hosp);
						} else {
							JOptionPane.showMessageDialog(null, "hospnr nao encontrado na tabela Hospedagem");
						}

						break;

					case '5':// atualizar adestramento
						id_adestramento = Integer.parseInt(JOptionPane
								.showInputDialog("Digite o id_adestramento do Adestramento para ser atualizado"));
						ades = baseAdestramento.findById_adestramento(id_adestramento);

						if (ades != null) {
							funcao.obterAdestramento(ades);
							baseAdestramento.atualizar(ades);

						} else {
							JOptionPane.showMessageDialog(null, "id_adestramento nao encontrado na tabela Adestramento");
						}

						break;

					case '6'://Atualizar passeio
						hospnr = Integer.parseInt(
								JOptionPane.showInputDialog("Digite o hospnr do Passeio para ser atualizado"));
						pass = basePasseio.findByPhospnr(hospnr);

						if (pass != null) {
							funcao.obterPasseio(pass);
							basePasseio.atualizar(pass);
						} else {
							JOptionPane.showMessageDialog(null, "hospnr nao encontrado na tabela Passeio");
						}

					case '7':// atualizar pagamento
						id_pg = Integer.parseInt(
								JOptionPane.showInputDialog("Digite o id_pg do Pagamento para ser atualizado"));
						pagamento = basePag.findById_pg(id_pg);

						if (pagamento != null) {
							
							funcao.obterPagamento(pagamento);
							basePag.atualizar(pagamento);
						} else {
							JOptionPane.showMessageDialog(null, "id_pg nao encontrado na tabela Pagamento");
						}

						break;

					case '8':
						break;

					default:
						JOptionPane.showMessageDialog(null, "Opção Inválida");
						break;
					}

				} while (opcaob != '8');

				break;

// ----------------------------------------------------------------------------------------------------------------

			case '3':// Menu de Remocoes

				submenu = "Escolha uma opção:\n1 - Remover Cliente\n2 - Remover Cao\n3 - Remover Servicos\n4 - Remover Hospedagem\n5 - Remover Adestramento\n6 - Remover Passeio  \n7 - Remover Pagamento\n8 - Sair";
				JOptionPane.showMessageDialog(null, "Essa acao pode remover tudo vinculado !!");
				do {

					opcaob = JOptionPane.showInputDialog(submenu).charAt(0);
					switch (opcaob) {
					// remove cliente
					case '1':

						cpf = JOptionPane.showInputDialog("CPF");
						cliente = baseCliente.findByCpf(cpf);

						if (cliente != null) {
							baseCliente.delete(cliente.getCpf());
							JOptionPane.showMessageDialog(null, "Removido!!.");
						} else {
							JOptionPane.showMessageDialog(null,
									"Não foi possível remover, pois o Cpf não foi encontrado.");
						}

						break;
					// remove cao
					case '2':
						cao_id = Integer.parseInt(JOptionPane.showInputDialog("Cao_id"));
						cao = baseCao.findByCao_id(cao_id);

						if (cao != null) {
							baseCao.delete(cao.getCao_id());
							JOptionPane.showMessageDialog(null, "Removido!!.");
						} else {
							JOptionPane.showMessageDialog(null,
									"Não foi possível remover, pois o cao_id não foi encontrado.");
						}

						break;

					case '3':// remove servico
						id_serv = Integer.parseInt(JOptionPane.showInputDialog("id_serv"));
						serv = baseServ.findById_serv(id_serv);

						if (serv != null) {
							baseServ.delete(serv.getId_serv());
							JOptionPane.showMessageDialog(null, "Removido!!.");
						} else {
							JOptionPane.showMessageDialog(null,
									"Não foi possível remover, pois o id_serv não foi encontrado.");
						}

						break;

					case '4':// remove hospedagem
						hospnr = Integer.parseInt(JOptionPane.showInputDialog("hospnr"));
						hosp = baseHosp.findByHospnr(hospnr);

						if (hosp != null) {
							baseHosp.delete(hosp.getHospnr());
							JOptionPane.showMessageDialog(null, "Removido!!.");
						} else {
							JOptionPane.showMessageDialog(null,
									"Não foi possível remover, pois o hospnr não foi encontrado.");
						}

						break;
					case '5':// remove adestramento
						id_adestramento = Integer.parseInt(JOptionPane.showInputDialog("id_adestramento"));
						ades = baseAdestramento.findById_adestramento(id_adestramento);

						if (ades != null) {
							baseAdestramento.delete(ades.getId_adestramento());
						
							JOptionPane.showMessageDialog(null, "Removido!!.");
						} else {
							JOptionPane.showMessageDialog(null,
									"Não foi possível remover, pois o id_adestramento não foi encontrado.");
						}

						break;
					case '6':// remover passeio
						hospnr = Integer.parseInt(JOptionPane.showInputDialog("hospnr"));
						pass = basePasseio.findByPhospnr(hospnr);

						if (pass != null) {
							basePasseio.delete(pass.getHospnr());
							JOptionPane.showMessageDialog(null, "Removido!!.");
						} else {
							JOptionPane.showMessageDialog(null,
									"Não foi possível remover, pois o hospnr não foi encontrado.");
						}
						break;
					case '7':

						id_pg = Integer.parseInt(JOptionPane.showInputDialog("id_pg"));
						pagamento = basePag.findById_pg(id_pg);

						if (pagamento != null) {
							basePag.delete(pagamento.getId_pg());
							JOptionPane.showMessageDialog(null, "Removido!!.");
						} else {
							JOptionPane.showMessageDialog(null,
									"Não foi possível remover, pois o id_pg não foi encontrado.");
						}

						break;

						
						
					case '8':
						break;

					default:
						JOptionPane.showMessageDialog(null, "Opção Inválida");
						break;
					}

				} while (opcaob != '8');

				break;
//--------------------------------------------------------------------------------------------------------------			

			case '4':
				submenu = "Escolha uma opção:\n1 - Vizualizar todos os  Clientes\n2 - Vizualizar todos os  Caes\n3 - Vizualizar todos os  Servicos\n4 - Vizualizar todos as Hospedagens\n5 - Vizualizar todos os  Adestramentos\n6 - Vizualizar todos os Passeios\n7 - Vizualizar todos os Pagamentos\n8 - Sair";

				do {
					opcaob = JOptionPane.showInputDialog(submenu).charAt(0);
					switch (opcaob) {
					// obter todos os clientes
					case '1':
						funcao.listaCliente(baseCliente.find());
						break;

					case '2':
						funcao.listaCao(baseCao.find());
						break;

					case '3':
						funcao.listaServicos(baseServ.find());

						break;

					case '4':
						funcao.listaHospedagem(baseHosp.find());
						break;
					case '5':
						funcao.listaAdestramento(baseAdestramento.find());
						break;
					case '6':
						funcao.listaPasseio(basePasseio.find());
						break;
					case '7':
						funcao.listaPagamento(basePag.find());
						break;

					case '8':
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opção Inválida");
						break;
					}

				} while (opcaob != '8');
				break;
//--------------------------------------------------------------------------------------------------------------			

			case '5': 
				
				
				submenu = "Escolha uma opção:\n1 - Vizualizar Info_hospedagem\n2 - Vizualizar Informacoes\n3 - Sair";

				do {
					opcaob = JOptionPane.showInputDialog(submenu).charAt(0);
					switch (opcaob) {
				
					case '1':
						Info_hospedagemJDBCDAO lh = new Info_hospedagemJDBCDAO();
						funcao.listaInfo_hospedagem(lh.find());
						break;

						
						
					case '2':
						Visao2JDBCDAO v = new Visao2JDBCDAO();
						funcao.listaVisao2(v.find());
						break;

						
						
					case '3':
						
						break;

					default:
						JOptionPane.showMessageDialog(null, "Opção Inválida");
						break;
					}

				} while (opcaob != '3');
				break;

			case '6': // Sair
				break;
			
			default:
				
				JOptionPane.showMessageDialog(null, "Opção Inválida");
				break;
			}

		} while (opcao != '6');
	
	
	}

}
