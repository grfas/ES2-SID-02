package Auditor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public class Auditor {

	private ArrayList<Log> lista = new ArrayList<Log>();
	private String username;
	private String password;
	private Aud_Gestao aud;

	public Auditor(String username, String password, Connection con) {
		this.username = username;
		this.password = password;
		this.aud = new Aud_Gestao(this);
		aud.run();
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Log> servidor1() {
		ArrayList<Log> listaCompleta2 = new ArrayList<Log>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con2 = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sid?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/London",
					this.username, this.password);

			Statement st2 = con2.createStatement();

			String query = "SELECT * FROM sid_log";
			ResultSet rs2 = st2.executeQuery(query);

			while (rs2.next()) {
				if (!rs2.wasNull()) {
					Date dateCreated = rs2.getDate("momento_criacao");
					Time hora = rs2.getTime("momento_criacao");
					String mensagem = rs2.getString("mensagem");
					String operacao = rs2.getString("operacao");
					String username = rs2.getString("username");
					int migracao = rs2.getInt("migracao");
					listaCompleta2.add(new Log(dateCreated, hora, mensagem, operacao, username, migracao));
				}
			}
			con2.close();
			return listaCompleta2;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaCompleta2;
	}

	public ArrayList<Log> servidor2() {
		ArrayList<Log> listaCompleta2 = new ArrayList<Log>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con2 = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sid2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/London",
					"root", "");

			Statement st2 = con2.createStatement();

			String query = "SELECT * FROM sid_log";
			ResultSet rs2 = st2.executeQuery(query);

			while (rs2.next()) {
				if (!rs2.wasNull()) {
					Date dateCreated = rs2.getDate("momento_criacao");
					Time hora = rs2.getTime("momento_criacao");
					String mensagem = rs2.getString("mensagem");
					String operacao = rs2.getString("operacao");
					String username = rs2.getString("username");
					int migracao = rs2.getInt("migracao");
					listaCompleta2.add(new Log(dateCreated, hora, mensagem, operacao, username, migracao));
				}
			}
			con2.close();
			return listaCompleta2;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaCompleta2;
	}

	public ArrayList<Log> procura(String s, boolean servidor) throws ClassNotFoundException {
		try {
			if (!lista.isEmpty()) {
				lista.clear();
			}
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con3;
			if (servidor == true) {
				con3 = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/sid?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/London",
						username, password);
			} else {
				con3 = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/sid2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/London",
						"root", "");

			}

			Statement st3 = con3.createStatement();
			String query = "SELECT * FROM sid_log WHERE mensagem LIKE '%" + s + "%' OR " + "momento_criacao LIKE '%" + s
					+ "%' OR operacao LIKE '%" + s + "%' OR " + "username LIKE '%" + s + "%' OR migracao LIKE '%" + s
					+ "%'";

			ResultSet rs3 = st3.executeQuery(query);

			while (rs3.next()) {
				Date dateCreated = rs3.getDate("momento_criacao");
				Time hora = rs3.getTime("momento_criacao");
				String mensagem = rs3.getString("mensagem");
				String operacao = rs3.getString("operacao");
				String username = rs3.getString("username");
				int migracao = rs3.getInt("migracao");

				lista.add(new Log(dateCreated, hora, mensagem, operacao, username, migracao));

			}
			con3.close();
			return lista;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("fds");
		return lista;
	}

}
