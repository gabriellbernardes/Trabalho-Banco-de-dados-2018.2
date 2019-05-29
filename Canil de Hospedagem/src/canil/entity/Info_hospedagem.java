package canil.entity;

public class Info_hospedagem {

	private String cliente;
	private String nome_cao;
	private String raca;
	private int dias_hospedados;

	public Info_hospedagem() {

	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getNome_cao() {
		return nome_cao;
	}

	public void setNome_cao(String nome_cao) {
		this.nome_cao = nome_cao;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public int getDias_hospedados() {
		return dias_hospedados;
	}

	public void setDias_hospedados(int dias_hospedados) {
		this.dias_hospedados = dias_hospedados;
	}

	public Info_hospedagem(String cliente, String nome_cao, String raca, int dias_hospedados) {
		this.cliente = cliente;
		this.nome_cao = nome_cao;
		this.raca = raca;
		this.dias_hospedados = dias_hospedados;
	}

	@Override
	public String toString() {
		return "Info_hospedagem [cliente=" + cliente + ", nome_cao=" + nome_cao + ", raca=" + raca
				+ ", dias_hospedados=" + dias_hospedados + "]";
	}

}
