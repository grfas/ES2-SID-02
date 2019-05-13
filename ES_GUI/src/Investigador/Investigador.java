package Investigador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public class Investigador {

	private int id_investigador;
	private String email;
	private String username;
	private String password;
	private Inv_Gestao inv;
	public ArrayList<Cultura> culturas = new ArrayList<Cultura>();
	public ArrayList<Medicoes> lista = new ArrayList<Medicoes>();

	public Investigador(String username, String password, Connection con) {
		this.username = username;
		this.password = password;
		this.inv = new Inv_Gestao(this);
		inv.run();
		try {
			findID(con);
			adicionaCulturas(con);
			procuraMedicoes(con);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void findID(Connection con3) throws SQLException {
		
		Statement st2 = con3.createStatement();
		String query = "SELECT * FROM sid_user WHERE user_name = '" + this.username + "'";
		ResultSet rs2 = st2.executeQuery(query);

		while (rs2.next()) {
			if (!rs2.wasNull()) {
				this.email = rs2.getString("email");
			}
		}
		
		Statement st = con3.createStatement();
		query = "SELECT * FROM investigador WHERE email = '" + this.email + "'";
		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			if (!rs.wasNull()) {
				this.id_investigador = rs.getInt("id_investigador");
			}
		}
		
	}
	
	private void adicionaCulturas(Connection con3) throws SQLException {
		
		Statement st2 = con3.createStatement();
		String query = "SELECT * FROM cultura WHERE responsavel = '" + this.id_investigador + "'";
		ResultSet rs2 = st2.executeQuery(query);
		while (rs2.next()) {
			if (!rs2.wasNull()) {
				int id_cultura = rs2.getInt("id_cultura");
				String nome_cultura = rs2.getString("nome_cultura");
				String descricao_cultura = rs2.getString("descricao_cultura");
				int responsavel = rs2.getInt("responsavel");
				culturas.add(new Cultura(id_cultura, nome_cultura, descricao_cultura, responsavel));
			}
		}
		
	}

	public void procuraMedicoes(Connection con) {
		try {
			if(!lista.isEmpty()) {
				lista.clear();
			}
			Statement st2 = con.createStatement();
			for(Cultura c : culturas) {
				String query = "SELECT * FROM medicoes WHERE id_cultura = " + c.getId_cultura();
				ResultSet rs2 = st2.executeQuery(query);
				while (rs2.next()) {
					if (!rs2.wasNull()) {
						int numero = rs2.getInt("numero_medicao");
						Time hora = rs2.getTime("data_hora_medicao");
						Date data = rs2.getDate("data_hora_medicao");
						int idcultura = rs2.getInt("id_cultura");
						int idvariavel = rs2.getInt("id_variavel");
						
						lista.add(new Medicoes(numero, hora, data, idcultura, idvariavel));						
					}
				}
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> procura(String s) {
		ArrayList<String> listaProcurada = new ArrayList<String>();
		int idProcura = Integer.parseInt(s);
		for(Medicoes m : lista) {
			if(m.getId_cultura() == idProcura || m.getId_variavel() == idProcura) {
				listaProcurada.add(Integer.toString(m.getNumero_medicao()) + "    " + m.getTempo().toString() + "  " + m.getData().toString() + "    " + Integer.toString(m.getId_cultura()) + "    " + Integer.toString(m.getId_variavel()) );
			}
		}	
		return listaProcurada;
	}

}
