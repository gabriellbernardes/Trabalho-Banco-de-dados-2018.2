package canil.entity;

public class Passeio {
	private int hospnr;
	private int qtd_passeio;
	private String tempo_passeio;

	public Passeio() {

	}

	public int getHospnr() {
		return hospnr;
	}

	public void setHospnr(int hospnr) {
		this.hospnr = hospnr;
	}

	public int getQtd_passeio() {
		return qtd_passeio;
	}

	public void setQtd_passeio(int qtd_passeio) {
		this.qtd_passeio = qtd_passeio;
	}

	public String getTempo_passeio() {
		return tempo_passeio;
	}

	public void setTempo_passeio(String tempo_passeio) {
		this.tempo_passeio = tempo_passeio;
	}

	public Passeio(int hospnr, int qtd_passeio, String tempo_passeio) {
		super();
		this.hospnr = hospnr;
		this.qtd_passeio = qtd_passeio;
		this.tempo_passeio = tempo_passeio;
	}

	@Override
	public String toString() {
		return "Passeio [hospnr=" + hospnr + ", qtd_passeio=" + qtd_passeio + ", tempo_passeio=" + tempo_passeio + "]";
	}

}
