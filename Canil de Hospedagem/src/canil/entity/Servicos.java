package canil.entity;

public class Servicos {
	private int id_serv;
	private String scpf;
	private int tosa;
	private int banho;
	
	
	public Servicos() {
		
	}


	public int getId_serv() {
		return id_serv;
	}


	public void setId_serv(int id_serv) {
		this.id_serv = id_serv;
	}


	public String getScpf() {
		return scpf;
	}


	public void setScpf(String scpf) {
		this.scpf = scpf;
	}


	public int getTosa() {
		return tosa;
	}


	public void setTosa(int tosa) {
		this.tosa = tosa;
	}


	public int getBanho() {
		return banho;
	}


	public void setBanho(int banho) {
		this.banho = banho;
	}


	public Servicos(int id_serv, String scpf, int tosa, int banho) {
		super();
		this.id_serv = id_serv;
		this.scpf = scpf;
		this.tosa = tosa;
		this.banho = banho;
	}


	@Override
	public String toString() {
		return "Servicos [id_serv=" + id_serv + ", scpf=" + scpf + ", tosa=" + tosa + ", banho=" + banho + "]";
	}
	
	
}
