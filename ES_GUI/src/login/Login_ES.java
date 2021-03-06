package login;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Login_ES {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	/**
	 * Create the application.
	 */
	public Login_ES() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame("Login Base de Dados");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 440, 275);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblUsername = new JLabel("USERNAME : ");

		JLabel lblPassword = new JLabel("PASSWORD :");
 
		textField = new JTextField();
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JButton btnLogin = new JButton("Login");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(37)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblPassword).addGap(18)
								.addComponent(textField_1))
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblUsername).addGap(18)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(84, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addContainerGap(179, Short.MAX_VALUE)
								.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(158)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(97)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblUsername).addComponent(
						textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblPassword).addComponent(
						textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(40).addComponent(btnLogin).addContainerGap(43, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				User utilizador = new User(textField.getText(), textField_1.getText(), frame);
				try {
					utilizador.LogIn();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_ES window = new Login_ES();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
