package Investigador;

import java.sql.Time;
import java.util.Date;

public class Medicoes {
	public Medicoes(int numero_medicao, Time tempo, Date data, int id_cultura, int id_variavel) {
		this.numero_medicao = numero_medicao;
		this.tempo = tempo;
		this.data = data;
		this.id_cultura = id_cultura;
		this.id_variavel = id_variavel;
	}
	private int numero_medicao;
	private Time tempo;
	private Date data;
	private int id_cultura;
	private int id_variavel;
	public int getNumero_medicao() {
		return numero_medicao;
	}
	public void setNumero_medicao(int numero_medicao) {
		this.numero_medicao = numero_medicao;
	}
	public Time getTempo() {
		return tempo;
	}
	public void setTempo(Time tempo) {
		this.tempo = tempo;
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
