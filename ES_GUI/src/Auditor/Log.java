package Auditor;

import java.sql.Date;
import java.sql.Time;

public class Log {
	
	private Date data;
	private Time hora;
	private String mensagem;
	private String operacao;
	private String username; 
	private int migracao;
	
	
	public Log(Date data, Time hora,String mensagem, String operacao, String username, int migracao) {
		this.data = data;
		this.hora = hora;
		this.mensagem=mensagem;
		this.operacao=operacao;
		this.username=username; 
		this.migracao=migracao;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public Time getHora() {
		return hora;
	}


	public void setHora(Time hora) {
		this.hora = hora;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public String getOperacao() {
		return operacao;
	}


	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getMigracao() {
		return migracao;
	}


	public void setMigracao(int migracao) {
		this.migracao = migracao;
	}

}
