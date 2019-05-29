package canil.entity;

public class Hospedagem {
	private int hospnr;
	private int id_cao;
	private int qtd_dias;
	
	public Hospedagem() {
		
	}
	
	public int getHospnr() {
		return hospnr;
	}
	public void setHospnr(int hospnr) {
		this.hospnr = hospnr;
	}
	public int getId_cao() {
		return id_cao;
	}
	public void setId_cao(int id_cao) {
		this.id_cao = id_cao;
	}
	public int getQtd_dias() {
		return qtd_dias;
	}
	public void setQtd_dias(int qtd_dias) {
		this.qtd_dias = qtd_dias;
	}
	public Hospedagem(int hospnr, int id_cao, int qtd_dias) {
		super();
		this.hospnr = hospnr;
		this.id_cao = id_cao;
		this.qtd_dias = qtd_dias;
	}
	@Override
	public String toString() {
		return "Hospedagem [hospnr=" + hospnr + ", id_cao=" + id_cao + ", qtd_dias=" + qtd_dias + "]";
	}
	

}
