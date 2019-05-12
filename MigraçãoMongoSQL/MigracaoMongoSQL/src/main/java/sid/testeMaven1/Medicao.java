package sid.testeMaven1;

import java.sql.Timestamp;

public class Medicao {

	private int valorMedicao;
	private Timestamp data;
	private String tipoVariavel;
	private String idMedicao;
	private int idVariavel;
	
	public Medicao(int valor, Timestamp time, String tipo, String id, int idVar) {
		this.valorMedicao=valor;
		this.data=time;
		this.tipoVariavel=tipo;
		this.idMedicao=id;
		this.idVariavel=idVar;
		
	}

	public int getValorMedicao() {
		return valorMedicao;
	}

	public void setValorMedicao(int valorMedicao) {
		this.valorMedicao = valorMedicao;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public String getTipoVariavel() {
		return tipoVariavel;
	}

	public void setTipoVariavel(String tipoVariavel) {
		this.tipoVariavel = tipoVariavel;
	}

	public String getIdMedicao() {
		return idMedicao;
	}

	public void setIdMedicao(String idMedicao) {
		this.idMedicao = idMedicao;
	}
	
	public int getIdVariavel() {
		return idVariavel;
	}

	public void setIdVariavel(int idVar) {
		this.idVariavel = idVar;
	}

	
	
}
