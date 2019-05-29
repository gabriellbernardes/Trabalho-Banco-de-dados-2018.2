package canil.entity;

public class Visao2 {
	private String Nome_cliente;
	private String Nome_Cao;
	private String raca;
	private int  qtd_banho;
	private int qtd_Tosa;
	private int qtd_aula;
	private int qtd_passeio;
	private int qtd_dias;
	private String cpf;
	
	
	public Visao2() {
		
	}


	public String getNome_cliente() {
		return Nome_cliente;
	}


	public void setNome_cliente(String nome_cliente) {
		Nome_cliente = nome_cliente;
	}


	public String getNome_Cao() {
		return Nome_Cao;
	}


	public void setNome_Cao(String nome_Cao) {
		Nome_Cao = nome_Cao;
	}


	public String getRaca() {
		return raca;
	}


	public void setRaca(String raca) {
		this.raca = raca;
	}


	public int getQtd_banho() {
		return qtd_banho;
	}


	public void setQtd_banho(int qtd_banho) {
		this.qtd_banho = qtd_banho;
	}


	public int getQtd_Tosa() {
		return qtd_Tosa;
	}


	public void setQtd_Tosa(int qtd_Tosa) {
		this.qtd_Tosa = qtd_Tosa;
	}


	public int getQtd_aula() {
		return qtd_aula;
	}


	public void setQtd_aula(int qtd_aula) {
		this.qtd_aula = qtd_aula;
	}


	public int getQtd_passeio() {
		return qtd_passeio;
	}


	public void setQtd_passeio(int qtd_passeio) {
		this.qtd_passeio = qtd_passeio;
	}


	public int getQtd_dias() {
		return qtd_dias;
	}


	public void setQtd_dias(int qtd_dias) {
		this.qtd_dias = qtd_dias;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Visao2(String nome_cliente, String nome_Cao, String raca, int qtd_banho, int qtd_Tosa, int qtd_aula,
			int qtd_passeio, int qtd_dias, String cpf) {
		
		Nome_cliente = nome_cliente;
		Nome_Cao = nome_Cao;
		this.raca = raca;
		this.qtd_banho = qtd_banho;
		this.qtd_Tosa = qtd_Tosa;
		this.qtd_aula = qtd_aula;
		this.qtd_passeio = qtd_passeio;
		this.qtd_dias = qtd_dias;
		this.cpf = cpf;
	}


	@Override
	public String toString() {
		return "INFORMACOES_GERAIS [Nome_cliente=" + Nome_cliente + ", Nome_Cao=" + Nome_Cao + ", raca=" + raca + ", qtd_banho="
				+ qtd_banho + ", qtd_Tosa=" + qtd_Tosa + ", qtd_aula=" + qtd_aula + ", qtd_passeio=" + qtd_passeio
				+ ", qtd_dias=" + qtd_dias + ", cpf=" + cpf + "]";
	}
	
	
}
