package Administrador;

public class Variavel {
	private int id_variavel;
	private String nome;

	public Variavel(int id_variavel, String nome) {
		this.id_variavel = id_variavel;
		this.nome = nome;
	}
	
	public int getId_variavel() {
		return id_variavel;
	}
	public void setId_variavel(int id_variavel) {
		this.id_variavel = id_variavel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
