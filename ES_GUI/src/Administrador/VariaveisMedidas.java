package Administrador;

public class VariaveisMedidas {

	private int id_cultura;
	private int id_variavel;
	private int limite_inferior;
	private int limite_superior;
	
	
	public VariaveisMedidas(int id_cultura, int id_variavel, int limite_inferior, int limite_superior) {
		this.id_cultura = id_cultura;
		this.id_variavel = id_variavel;
		this.limite_inferior = limite_inferior;
		this.limite_superior = limite_superior;
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
	public int getLimite_inferior() {
		return limite_inferior;
	}
	public void setLimite_inferior(int limite_inferior) {
		this.limite_inferior = limite_inferior;
	}
	public int getLimite_superior() {
		return limite_superior;
	}
	public void setLimite_superior(int limite_superior) {
		this.limite_superior = limite_superior;
	}
}
