package Administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Admin_Gestao_Users_Perfil extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnGuardar;
	private JLabel lblusername;
	private Administrador admin;

			public void run() {
				try {
				
					this.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	
	public Admin_Gestao_Users_Perfil(Administrador admin) {
		this.setAdmin(admin);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName ");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(59, 63, 75, 24);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(59, 98, 75, 24);
		contentPane.add(lblPassword);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(59, 133, 75, 24);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(160, 102, 210, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(160, 137, 210, 20);
		contentPane.add(textField_2);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(59, 235, 118, 38);
		contentPane.add(btnGuardar);
		
		lblusername = new JLabel("_User_Name_");
		lblusername.setText(admin.getUsername());
		lblusername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblusername.setBounds(160, 67, 210, 21);
		contentPane.add(lblusername);
		
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String password = textField_1.getText().toString();
				String email = textField_2.getText().toString();
			
				String query = "SELECT PASSWORD('" + password + "');";
				String hash = admin.findHash(query, password);
				String query1 = "SET PASSWORD FOR '" + admin.getUsername() + "'@'localhost' = '" + hash + "';";
				admin.executaQueryRoot(query1);
				System.out.println("123email1 "+email+" email addmin"+admin.getEmail());
		if(email.equals("")) {
			email=admin.getEmail();
		}
		String query3 = "UPDATE sid_user SET user_password='" + password + "',email= '" + email
				+ "' WHERE email='" + admin.getEmail() + "';";
		admin.executaUpdateRoot(query3);
		admin.setPassword(password);
		admin.setEmail(email);
			}
		});

	}
	
	public void setAdmin(Administrador admin) {
		this.admin=admin;
	}
}
