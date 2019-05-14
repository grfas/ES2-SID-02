package Investigador;

import java.util.Date;

public class Medicoes {
	private int valor_medicao;
	private int numero_medicao;
	private Date data;
	private int id_cultura;
	private int id_variavel;

	public Medicoes(int numero_medicao, Date data, int valor_medicao, int id_cultura, int id_variavel) {
		this.numero_medicao = numero_medicao;
		this.data = data;
		this.id_cultura = id_cultura;
		this.id_variavel = id_variavel;
		this.valor_medicao = valor_medicao;
	}

	public int getValor_medicao() {
		return valor_medicao;
	}

	public void setValor_medicao(int valor_medicao) {
		this.valor_medicao = valor_medicao;
	}

	public int getNumero_medicao() {
		return numero_medicao;
	}

	public void setNumero_medicao(int numero_medicao) {
		this.numero_medicao = numero_medicao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getId_cultura() {
		return id_cultura;
	}

	public void setId_cultura(int id_cultura) {
		this.id_cultura = id_cultura;
	}

	public int getId_variavel() {
		return id_variavel;
	}

	public void setId_variavel(int id_variavel) {
		this.id_variavel = id_variavel;
	}
}
