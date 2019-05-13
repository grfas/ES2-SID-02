package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

public class User {

	private Connection con;
	private Statement st;
	private ResultSet rs;

	private String username;
	private String password;
	private String permissao;
	protected JFrame login;

	public User(String username, String password, JFrame login) {
		this.username = username;
		this.password = password;
		this.login = login;
	}

	public void LogIn() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sid?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/London",
					"root", "");
			login.dispose();
			st = con.createStatement();
			String query = "SELECT * FROM sid_user_permissoes WHERE username = '" + this.username + "'";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				this.permissao = rs.getString("permissao");
			}

			if (this.permissao.equals("auditor")) {
				new Auditor.Auditor(username, password, permissao, login, con);
			}

			else if (this.permissao.equals("investigador")) {

			}

			else if (this.permissao.equals("inativo")) {

			}

			else if (this.permissao.equals("administrador")) {

			}

		} catch (Exception e) {
			e.printStackTrace();
			con.close();
		}
	}

}
