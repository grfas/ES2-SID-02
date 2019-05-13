package sid.testeMaven1;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class Auditor extends User{

	private  Connection con;
	private  Statement st;
	private ResultSet rs;
	private  Connection con2;
	private  Statement st2;
	private ResultSet rs2;
	
	private  String username;
	private  String password;
	private String permissao;
	
	public Auditor(String username,String password,String permissao, Connection con){  
		super(username, password);
		this.permissao = permissao; 
		this.con = con;
	}
	
	public void servidor1() {
		try {
			st = con.createStatement();
			String query2 = "SELECT * FROM sid_user_permissoes WHERE username = '" + this.username + "'";
			ResultSet rs2 = st.executeQuery(query2);
			while (rs2.next())
		      {
		        this.permissao = rs2.getString("permissao");
		      }
			
			System.out.println(permissao);
			
			st = con.createStatement();
			String query = "SELECT * FROM sid_log";
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next())
		      {
				Date dateCreated = rs.getDate("momento_criacao");
		        Time hora = rs.getTime("momento_criacao");
		        String mensagem = rs.getString("mensagem");
		        String operacao = rs.getString("operacao");
		        String username = rs.getString("username");
		        int migracao = rs.getInt("migracao");		        
		        
		        
		        System.out.format("%s,%s, %s, %s, %s, %s\n", dateCreated,hora, mensagem, operacao, username, migracao);
		        
		      }
			 con.close();

		}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void servidor2() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sid2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/London",username,password);
			
			st2 = con2.createStatement();
			
			String query = "SELECT * FROM sid_log";
			ResultSet rs2 = st2.executeQuery(query);
			
			while (rs2.next())
		      {
				Date dateCreated = rs2.getDate("momento_criacao");
		        Time hora = rs2.getTime("momento_criacao");
		        String mensagem = rs2.getString("mensagem");
		        String operacao = rs2.getString("operacao");
		        String username = rs2.getString("username");
		        int migracao = rs2.getInt("migracao");		        
		        
		        
		        System.out.format("%s,%s, %s, %s, %s, %s\n", dateCreated,hora, mensagem, operacao, username, migracao);
		        
		      }
			 con2.close();
			
		}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void procura(String s) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sid?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/London",username,password);

			Statement st3 = con3.createStatement();
			String query = "SELECT * FROM sid_log WHERE mensagem LIKE '%" + s + "%' OR "
					+ "momento_criacao LIKE '%" + s + "%' OR operacao LIKE '%" + s +"%' OR " 
					+ "username LIKE '%" + s + "%' OR migracao LIKE '%" + s +"%'" ;

			ResultSet rs3 = st3.executeQuery(query);

			while (rs3.next())
		      {
				Date dateCreated = rs3.getDate("momento_criacao");
		        Time hora = rs3.getTime("momento_criacao");
		        String mensagem = rs3.getString("mensagem");
		        String operacao = rs3.getString("operacao");
		        String username = rs3.getString("username");
		        int migracao = rs3.getInt("migracao");		        
		        
		        
		        System.out.format("%s,%s, %s, %s, %s, %s\n", dateCreated,hora, mensagem, operacao, username, migracao);
		        
		      }
			con3.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
