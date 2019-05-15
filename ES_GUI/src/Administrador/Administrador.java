package Administrador;

import java.sql.Connection;
import java.sql.SQLException;

import Investigador.Inv_Gestao;

public class Administrador {
	private String username;
	private String password;
	
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
	
	
	
	

}
