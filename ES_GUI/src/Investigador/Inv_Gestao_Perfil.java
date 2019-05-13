package Investigador;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class Inv_Gestao_Perfil extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					Inv_Gestao_Perfil frame = new Inv_Gestao_Perfil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the frame.
	 */
	public Inv_Gestao_Perfil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBounds(26, 32, 63, 25);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setBounds(26, 59, 66, 25);
		contentPane.add(lblPassword);
		
		JLabel lblEmail = new JLabel("E-mail : ");
		lblEmail.setBounds(26, 89, 63, 19);
		contentPane.add(lblEmail);
		
		JLabel lblCategoriaProfissional = new JLabel("Categoria Profissional :");
		lblCategoriaProfissional.setBounds(26, 114, 121, 19);
		contentPane.add(lblCategoriaProfissional);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(58, 172, 104, 31);
		contentPane.add(btnGuardar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(324, 227, 89, 23);
		contentPane.add(btnSair);
		
		textField = new JTextField();
		textField.setBounds(146, 34, 223, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 61, 223, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 88, 223, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(146, 113, 223, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}
}
