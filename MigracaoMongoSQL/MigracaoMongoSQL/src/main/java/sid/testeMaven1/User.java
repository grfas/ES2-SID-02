package sid.testeMaven1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class User {

	private  Connection con;
	private  Statement st;
	private ResultSet rs;
	
	private  String username;
	private  String password;
	private String permissao;
	
	public User(String username,String password){  
		this.username = username;
		this.password = password;
	}
	
	private void LogIn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sid?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/London",username,password);
			
			st = con.createStatement();
			String query = "SELECT * FROM sid_user_permissoes WHERE username = '" + this.username + "'";
			ResultSet rs = st.executeQuery(query);
			while (rs.next())
		      {
		        this.permissao = rs.getString("permissao");
		      }
			
			if(permissao == "auditor") {
				System.out.println("antes");
				new Auditor(username, password, permissao, con);
				System.out.println("depois");
			}
			
			else if(permissao == "investigador") {
				
			}
			
			else if(permissao == "inativo") {
				
			}
			
			else if(permissao == "administrador") {
	
			}
			
			 con.close();

		}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
}
