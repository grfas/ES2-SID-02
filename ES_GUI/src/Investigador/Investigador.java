package Investigador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
			if (!lista.isEmpty()) {
				lista.clear();
			}
			Statement st2 = con.createStatement();
			for (Cultura c : culturas) {
				String query = "SELECT * FROM medicoes WHERE id_cultura = " + c.getId_cultura();
				ResultSet rs2 = st2.executeQuery(query);
				while (rs2.next()) {
					if (!rs2.wasNull()) {
						int numero = rs2.getInt("numero_medicao");
						Date data = rs2.getDate("data_hora_medicao");
						int valor_medicao = rs2.getInt("valor_medicao");
						int idcultura = rs2.getInt("id_cultura");
						int idvariavel = rs2.getInt("id_variavel");
						

						lista.add(new Medicoes(numero, data, valor_medicao, idcultura, idvariavel));
					}
				}
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> procuraIdCultura(String s) {
		ArrayList<String> listaProcurada = new ArrayList<String>();
		int idProcura = Integer.parseInt(s);
		for (Medicoes m : lista) {
			if (m.getId_cultura() == idProcura) {
				listaProcurada.add(Integer.toString(m.getNumero_medicao()) + "    " + m.getData().toString() + "    " + Integer.toString(m.getId_cultura()) + "    "
						+ Integer.toString(m.getId_variavel()));
			}
		}
		return listaProcurada;
	}

	public ArrayList<String> procura(String i, String v) {
		ArrayList<String> listaProcurada = new ArrayList<String>();
		int idProcura = Integer.parseInt(i);
		int variavelProcura = Integer.parseInt(v);
		for (Medicoes m : lista) {
			if (m.getId_cultura() == idProcura && m.getId_variavel() == variavelProcura) {
				listaProcurada.add(Integer.toString(m.getNumero_medicao()) + "    " + m.getData().toString() + "    " + Integer.toString(m.getId_cultura()) + "    "
						+ Integer.toString(m.getId_variavel()));
			}
		}
		return listaProcurada;
	}

	public ArrayList<String> procuraVariavel(String i) {
		ArrayList<String> listaProcurada = new ArrayList<String>();
		int idProcura = Integer.parseInt(i);
		for (Medicoes m : lista) {
			if (m.getId_variavel() == idProcura) {
				listaProcurada.add(Integer.toString(m.getNumero_medicao()) + "    " + m.getData().toString() + "    " + Integer.toString(m.getId_cultura()) + "    "
						+ Integer.toString(m.getId_variavel()));
			}
		}
		return listaProcurada;
	}

	public void apagaMedicao(int i) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con2 = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sid?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/London",
					this.username, this.password);

			Statement st2 = con2.createStatement();

			String query = "DELETE FROM medicoes WHERE numero_medicao = '" + lista.get(i).getNumero_medicao() + "'";
			st2.executeUpdate(query);
			lista.clear();
			procuraMedicoes(con2);
			con2.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insereMedicao(Medicoes m) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con2 = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sid?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/London",
					this.username, this.password);
			Statement st2 = con2.createStatement();
			
			String text = new SimpleDateFormat("yyyy,MM,dd HH,mm,dd").format(m.getData());
			String query = "INSERT INTO `medicoes`(`numero_medicao`, `data_hora_medicao`, `valor_medicao`, `id_cultura`, `id_variavel`) "
					+ " VALUES (" + m.getNumero_medicao() + " , str_to_date('" + text  + "', '%Y,%m,%d %H,%i,%S') , " + m.getValor_medicao()  + " , " + m.getId_cultura()  + " , " + m.getId_variavel() + ")";
			st2.executeUpdate(query);
			lista.clear();
			procuraMedicoes(con2);
			con2.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
