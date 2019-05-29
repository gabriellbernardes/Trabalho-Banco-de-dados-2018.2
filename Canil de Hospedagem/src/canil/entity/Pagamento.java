package canil.entity;

import java.util.Date;

public class Pagamento {
	private int id_pg;
	private double valor; 
	private Date data_pg;
	private String cliente_cpf;
	
	

	public Pagamento() {
		
	}

	public int getId_pg() {
		return id_pg;
	}

	public void setId_pg(int id_pg) {
		this.id_pg = id_pg;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData_pg() {
		return data_pg;
	}

	public void setData_pg(Date data) {
		this.data_pg = data;
	}

	public String getCliente_cpf() {
		return cliente_cpf;
	}

	public void setCliente_cpf(String cliente_cpf) {
		this.cliente_cpf = cliente_cpf;
	}

	public Pagamento(int id_pg, double valor,Date data_pg, String cliente_cpf) {
		super();
		this.id_pg = id_pg;
		this.valor = valor;
		this.data_pg = data_pg;
		this.cliente_cpf = cliente_cpf;
	}

	@Override
	public String toString() {
		return "Pagamento [id_pg=" + id_pg + ", valor=" + valor + ", data_pg=" + data_pg + ", cliente_cpf="
				+ cliente_cpf + "]";
	}

	
}
