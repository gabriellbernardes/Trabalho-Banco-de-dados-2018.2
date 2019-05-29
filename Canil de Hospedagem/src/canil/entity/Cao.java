package canil.entity;

public class Cao {
	private int cao_id;
	private String raca;
	private String cnome;
	private String tamanho;
	private String cor;
	private String temperamento;
	private String dono_cpf;




	public Cao() {
	}

	public int getCao_id() {
		return cao_id;
	}

	public void setCao_id(int cao_id) {
		this.cao_id = cao_id;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public String getCnome() {
		return cnome;
	}
	
	public void setCnome(String cnome) {
		this.cnome = cnome;
	}
	
	public String getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getTemperamento() {
		return temperamento;
	}
	public void setTemperamento(String temperamento) {
		this.temperamento = temperamento;
	}
	
	public String getDono_cpf() {
		return dono_cpf;
	}
	
	public void setDono_cpf(String dono_cpf) {
		this.dono_cpf = dono_cpf;
	}
	
	public Cao(int cao_id, String raca, String cnome, String tamanho, String cor, String temperamento,
			String dono_cpf) {

		this.cao_id = cao_id;
		this.raca = raca;
		this.cnome = cnome;
		this.tamanho = tamanho;
		this.cor = cor;
		this.temperamento = temperamento;
		this.dono_cpf = dono_cpf;

	}

	@Override
	public String toString() {
		return "Cao [cao_id=" + cao_id + ", raca=" + raca + ", cnome=" + cnome + ", tamanho=" + tamanho + ", cor=" + cor
				+ ", temperamento=" + temperamento + ", dono_cpf=" + dono_cpf + "]";
	}

}
