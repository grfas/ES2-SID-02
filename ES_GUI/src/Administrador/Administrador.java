package Administrador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import Investigador.Cultura;
import Investigador.Medicoes;

public class Administrador {
	private String username;
	private String password;
	private String email;
	public ArrayList<Medicoes> lista = new ArrayList<Medicoes>();

	public Administrador(String username, String password, Connection con) {
		this.username = username;
		this.password = password;
		Admin_Gestao inv = new Admin_Gestao(this);
		inv.run();
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<VariaveisMedidas> pesquisaVariaveisMedidas(int i) {
		ArrayList<VariaveisMedidas> culturas = new ArrayList<VariaveisMedidas>();
		try {
			Connection con = criacon();
			Statement st = con.createStatement();
			String query = "SELECT * FROM variaveis_medidas WHERE id_variavel = '" + i + "'";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				if (!rs.wasNull()) {
					int id_cultura = rs.getInt("id_cultura");
					int id_variavel = rs.getInt("id_variavel");
					int limite_inferior = rs.getInt("id_cultura");
					int limite_superior = rs.getInt("id_variavel");
					culturas.add(new VariaveisMedidas(id_cultura, id_variavel, limite_inferior, limite_superior));
				}
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return culturas;
	}

	public ArrayList<VariaveisMedidas> pesquisaTodasVariaveisMedidas() {
		ArrayList<VariaveisMedidas> culturas = new ArrayList<VariaveisMedidas>();
		try {
			Connection con = criacon();
			Statement st = con.createStatement();
			String query = "SELECT * FROM variaveis_medidas";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				if (!rs.wasNull()) {
					int id_cultura = rs.getInt("id_cultura");
					int id_variavel = rs.getInt("id_variavel");
					int limite_inferior = rs.getInt("limite_inferior");
					int limite_superior = rs.getInt("limite_superior");
					culturas.add(new VariaveisMedidas(id_cultura, id_variavel, limite_inferior, limite_superior));
				}
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return culturas;
	}

	public ArrayList<Cultura> pesquisaNomeCultura(String i) {
		ArrayList<Cultura> culturas = new ArrayList<Cultura>();
		try {
			Connection con = criacon();
			Statement st = con.createStatement();
			String query = "SELECT * FROM cultura WHERE nome_cultura = '" + i + "'";
			ResultSet rs2 = st.executeQuery(query);
			while (rs2.next()) {
				if (!rs2.wasNull()) {
					int id_cultura = rs2.getInt("id_cultura");
					String nome_cultura = rs2.getString("nome_cultura");
					String descricao_cultura = rs2.getString("descricao_cultura");
					int responsavel = rs2.getInt("responsavel");
					culturas.add(new Cultura(id_cultura, nome_cultura, descricao_cultura, responsavel));
				}
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return culturas;
	}

	public ArrayList<Cultura> pesquisaNomeIdCultura(String id, String nome) {
		ArrayList<Cultura> culturas = new ArrayList<Cultura>();
		try {
			Connection con = criacon();
			Statement st = con.createStatement();
			String query = "SELECT * FROM cultura WHERE nome_cultura = '" + nome + "' AND id_cultura = " + id;
			ResultSet rs2 = st.executeQuery(query);
			while (rs2.next()) {
				if (!rs2.wasNull()) {
					int id_cultura = rs2.getInt("id_cultura");
					String nome_cultura = rs2.getString("nome_cultura");
					String descricao_cultura = rs2.getString("descricao_cultura");
					int responsavel = rs2.getInt("responsavel");
					culturas.add(new Cultura(id_cultura, nome_cultura, descricao_cultura, responsavel));
				}
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return culturas;
	}

	public ArrayList<Cultura> pesquisaIdCultura(int i) {
		ArrayList<Cultura> culturas = new ArrayList<Cultura>();
		try {
			Connection con = criacon();
			Statement st = con.createStatement();
			String query = "SELECT * FROM cultura WHERE id_cultura = " + i;
			ResultSet rs2 = st.executeQuery(query);
			while (rs2.next()) {
				if (!rs2.wasNull()) {
					int id_cultura = rs2.getInt("id_cultura");
					String nome_cultura = rs2.getString("nome_cultura");
					String descricao_cultura = rs2.getString("descricao_cultura");
					int responsavel = rs2.getInt("responsavel");
					culturas.add(new Cultura(id_cultura, nome_cultura, descricao_cultura, responsavel));
				}
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return culturas;
	}

	public Connection criacon() throws SQLException, ClassNotFoundException {
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/sid?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/London",
				this.username, this.password);
		return con;
	}

	public Connection criaconRoot() throws SQLException, ClassNotFoundException {
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/sid?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/London",
				"root", "");
		return con;
	}

	public void executaUpdate(String query) {
		try {
			Connection con = criacon();
			Statement st = con.createStatement();
			st.executeUpdate(query);
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void executaUpdateRoot(String query) {
		try {
			Connection con = criaconRoot();
			Statement st = con.createStatement();
			st.executeUpdate(query);
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void executaQuery(String query) {
		try {
			Connection con = criacon();
			Statement st = con.createStatement();
			st.executeQuery(query);
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void executaQueryRoot(String query) {
		try {
			Connection con = criaconRoot();
			Statement st = con.createStatement();
			st.executeQuery(query);
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Cultura> culturas() {
		ArrayList<Cultura> culturas = new ArrayList<Cultura>();
		try {
			Connection con = criacon();
			Statement st = con.createStatement();
			String query = "SELECT * FROM cultura";
			ResultSet rs2 = st.executeQuery(query);
			while (rs2.next()) {
				if (!rs2.wasNull()) {
					int id_cultura = rs2.getInt("id_cultura");
					String nome_cultura = rs2.getString("nome_cultura");
					String descricao_cultura = rs2.getString("descricao_cultura");
					int responsavel = rs2.getInt("responsavel");
					culturas.add(new Cultura(id_cultura, nome_cultura, descricao_cultura, responsavel));
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return culturas;
	}

	public ArrayList<Variavel> variaveis() {
		ArrayList<Variavel> variaveis = new ArrayList<Variavel>();
		try {
			Connection con = criacon();
			Statement st = con.createStatement();
			String query = "SELECT * FROM variaveis";
			ResultSet rs2 = st.executeQuery(query);
			while (rs2.next()) {
				if (!rs2.wasNull()) {
					int id_variavel = rs2.getInt("id_variavel");
					String nome = rs2.getString("nome");
					variaveis.add(new Variavel(id_variavel, nome));
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return variaveis;
	}

	public String findHash(String query, String password) {
		String hash = null;
		try {
			Connection con2 = criaconRoot();
			Statement st2 = con2.createStatement();
			ResultSet rs2 = st2.executeQuery(query);

			while (rs2.next()) {
				if (!rs2.wasNull()) {
					hash = rs2.getString("PASSWORD('" + password + "')");
				}
			}
			con2.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hash;

	}

	public ArrayList<String> procuraIdCultura(String s) {
		ArrayList<String> listaProcurada = new ArrayList<String>();
		int idProcura = Integer.parseInt(s);
		for (Medicoes m : lista) {
			if (m.getId_cultura() == idProcura) {
				listaProcurada.add(Integer.toString(m.getNumero_medicao()) + "    " + m.getData().toString() + "    "
						+ Integer.toString(m.getId_cultura()) + "    " + Integer.toString(m.getId_variavel()));
			}
		}
		return listaProcurada;
	}

	public void apagaMedicao(int i) {
		try {
			Connection con2 = criacon();
			String query = "DELETE FROM medicoes WHERE numero_medicao = '" + lista.get(i).getNumero_medicao() + "'";
			executaUpdate(query);
			lista.clear();
			procuraMedicoes(con2);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> procura(String i, String v) {
		ArrayList<String> listaProcurada = new ArrayList<String>();
		int idProcura = Integer.parseInt(i);
		int variavelProcura = Integer.parseInt(v);
		for (Medicoes m : lista) {
			if (m.getId_cultura() == idProcura && m.getId_variavel() == variavelProcura) {
				listaProcurada.add(Integer.toString(m.getNumero_medicao()) + "    " + m.getData().toString() + "    "
						+ Integer.toString(m.getId_cultura()) + "    " + Integer.toString(m.getId_variavel()));
			}
		}
		return listaProcurada;
	}

	public ArrayList<String> procuraVariavel(String i) {
		ArrayList<String> listaProcurada = new ArrayList<String>();
		int idProcura = Integer.parseInt(i);
		for (Medicoes m : lista) {
			if (m.getId_variavel() == idProcura) {
				listaProcurada.add(Integer.toString(m.getNumero_medicao()) + "    " + m.getData().toString() + "    "
						+ Integer.toString(m.getId_cultura()) + "    " + Integer.toString(m.getId_variavel()));
			}
		}
		return listaProcurada;
	}

	public int procuraNomeCultura(String i) {
		int id_cultura = 0;
		Connection con3;
		try {
			con3 = criacon();
			Statement st2 = con3.createStatement();
			String query = "SELECT * FROM cultura WHERE nome_cultura = '" + i + "'";
			ResultSet rs2 = st2.executeQuery(query);
			while (rs2.next()) {
				if (!rs2.wasNull()) {
					id_cultura = rs2.getInt("id_cultura");
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return id_cultura;

	}

	public int devolveUltimaCultura() {
		String query = "SELECT id_cultura FROM cultura ORDER BY id_cultura DESC LIMIT 1";
		int id_cultura = 0;
		try {
			Connection con3 = criacon();
			Statement st2 = con3.createStatement();
			ResultSet rs2 = st2.executeQuery(query);
			while (rs2.next()) {
				if (!rs2.wasNull()) {
					id_cultura = rs2.getInt("id_cultura");
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return id_cultura;
	}

	public void insereMedicao(Medicoes m) {
		try {
			Connection con2 = criacon();
			String text = new SimpleDateFormat("yyyy,MM,dd HH,mm,dd").format(m.getData());
			String query = "INSERT INTO `medicoes`(`numero_medicao`, `data_hora_medicao`, `valor_medicao`, `id_cultura`, `id_variavel`) "
					+ " VALUES (" + m.getNumero_medicao() + " , str_to_date('" + text + "', '%Y,%m,%d %H,%i,%S') , "
					+ m.getValor_medicao() + " , " + m.getId_cultura() + " , " + m.getId_variavel() + ")";
			executaUpdate(query);
			lista.clear();
			procuraMedicoes(con2);
			con2.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void procuraMedicoes(Connection con) {
		try {
			if (!lista.isEmpty()) {
				lista.clear();
			}
			Statement st2 = con.createStatement();
			for (Cultura c : culturas()) {
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

}
