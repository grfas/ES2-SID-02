package Investigador;

public class Cultura {
	
	
	
	private int id_cultura;
	private String nome_cultura;
	private String descricao_cultura;
	private int id_investigador;
	
	public Cultura(int id_cultura, String nome_cultura, String descricao_cultura, int responsavel) {
		this.id_cultura = id_cultura;
		this.nome_cultura = nome_cultura;
		this.descricao_cultura = descricao_cultura;
		this.id_investigador = responsavel;
	}
	
	public int getId_cultura() {
		return id_cultura;
	}
	public void setId_cultura(int id_cultura) {
		this.id_cultura = id_cultura;
	}
	public String getNome_cultura() {
		return nome_cultura;
	}
	public void setNome_cultura(String nome_cultura) {
		this.nome_cultura = nome_cultura;
	}
	public String getDescricao_cultura() {
		return descricao_cultura;
	}
	public void setDescricao_cultura(String descricao_cultura) {
		this.descricao_cultura = descricao_cultura;
	}
	public int getUsername() {
		return id_investigador;
	}
	public void setUsername(int id_investigador) {
		this.id_investigador = id_investigador;
	}
}
