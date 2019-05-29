package canil.entity;




public class Adestramento {
	private int id_adestramento;
	private int hospnr;
	private String tempo_aula;
	private int qtd_aula;
	public Adestramento() {

	}

	public int getId_adestramento() {
		return id_adestramento;
	}

	public void setId_destramento(int id_adestramento) {
		this.id_adestramento = id_adestramento;
	}

	public int getHospnr() {
		return hospnr;
	}

	public void setHospnr(int hospnr) {
		this.hospnr = hospnr;
	}

	public String getTempo_aula() {
		return tempo_aula;
	}

	public void setTempo_aula(String tempo_aula) {
		this.tempo_aula = tempo_aula;
	}
	
	

	public int getQtd_aula() {
		return qtd_aula;
	}

	public void setQtd_aula(int qtd_aula) {
		this.qtd_aula = qtd_aula;
	}

	public Adestramento(int id_adestramento, int hospnr, String tempo_aula) {
		super();
		this.id_adestramento = id_adestramento;
		this.hospnr = hospnr;
		this.tempo_aula = tempo_aula;
	}

	@Override
	public String toString() {
		return "Adestramento [id_destramento=" + id_adestramento + ", hospnr=" + hospnr + ", tempo_aula=" + tempo_aula
				+ ", qtd_aula=" + qtd_aula + "]";
	}



}

