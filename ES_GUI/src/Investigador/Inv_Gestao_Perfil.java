package Investigador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

@SuppressWarnings("serial")
public class Inv_Gestao_Perfil extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Investigador inv;

	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Inv_Gestao_Perfil(Investigador inv) {
		this.setInv(inv);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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

		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String password = textField_1.getText().toString();
				String email = textField_2.getText().toString();
				String categoria_profissional = textField_3.getText().toString();
				String query = "SELECT PASSWORD('" + password + "');";
				String hash = inv.findHash(query, password);
				String query1 = "SET PASSWORD FOR '" + inv.getUsername() + "'@'localhost' = '" + hash + "';";
				inv.executaQuery(query1);
				String query2 = "UPDATE investigador SET categoria_profissional='" + categoria_profissional
						+ "' WHERE email='" + inv.getEmail() + "';";
				inv.executaUpdate(query2);
				String query3 = "UPDATE sid_user SET user_password='" + password + "',email= '" + email
						+ "' WHERE email='" + inv.getEmail() + "';";
				inv.executaUpdate(query3);
				inv.setPassword(password);
				inv.setEmail(email);

			}
		});

	}

	public Investigador getInv() {
		return inv;
	}

	public void setInv(Investigador inv) {
		this.inv = inv;
	}
}
