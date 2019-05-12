package sid.testeMaven1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
public class SQLWrite {

	private static Connection con;
	private static Statement st;
	private static Statement st1;
	
	private ResultSet rs;	
	public SQLWrite(){  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sid?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/London","root","");
			
			st = con.createStatement();
			st1 = con.createStatement();

		}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	//nao foi mexida mas tambem nao e preciso
	public void getData() {
		try {
			String query= " select * from names";
			rs = st.executeQuery(query);
			System.out.println("Dados existentes na base de dados");
			while(rs.next()) {
				String first= rs.getString("first");
				String last= rs.getString("last");
				System.out.println("First name: "+first+";  "+"last name: "+last);
				//insertData(first,last);
			}			
			System.out.println("outta here");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
//	
	public static void insertMedicoes(Medicao medicao) throws SQLException {
		
		int a =1;
		int b=0;
//		String query = "INSERT INTO `medicoes` ( `data_hora_medicao`, `valor_medicao`, `id_cultura`, `id_variavel`) VALUES ( '"+medicao.getData()+"','"+medicao.getValorMedicao()+"','"+a+"','"+medicao.getIdVariavel()+"')"; 
			
//		
//		String query1 = " INSERT INTO medicoes (numero_medicao, data_hora_medicao, valor_medicao, id_cultura, id_variavel)"
//		        + " VALUES ( ?, ?, ?, ?)";
//		PreparedStatement preparedStmt = con.prepareStatement(query1);
//	      
//		  preparedStmt.setInt(1, a);
//	      preparedStmt.setTimestamp(2, medicao.getData());   
//	      preparedStmt.setInt(3, medicao.getValorMedicao());
//	      preparedStmt.setInt(4, 1);
//	      preparedStmt.setInt(5, medicao.getIdVariavel());
//	      
//		
		String query = " INSERT INTO medicoes VALUES ('"+b+"', '"+medicao.getData()+"','"+medicao.getValorMedicao()+"','"+a+"','"+medicao.getIdVariavel()+"')";
		st1.executeUpdate(query);
//		
//	      preparedStmt.executeUpdate();
	      System.out.println("inserido");

	}	
}






