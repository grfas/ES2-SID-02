package Administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Admin_Gestao_Users_Others extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Gestao_Users_Others frame = new Admin_Gestao_Users_Others();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin_Gestao_Users_Others() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(46, 24, 75, 24);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(46, 76, 75, 24);
		contentPane.add(lblPassword);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(46, 129, 75, 24);
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(188, 28, 181, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(188, 80, 181, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(188, 133, 181, 20);
		contentPane.add(textField_2);
		
		JLabel lblCategoriaProfissional = new JLabel("Categoria Profissional");
		lblCategoriaProfissional.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCategoriaProfissional.setBounds(46, 182, 128, 24);
		contentPane.add(lblCategoriaProfissional);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(188, 186, 181, 20);
		contentPane.add(textField_3);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(385, 27, 89, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriar.setBounds(162, 302, 128, 51);
		contentPane.add(btnCriar);
	}

}
