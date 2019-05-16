package Administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Admin_Gestao_Users extends JFrame {

	private JPanel contentPane;
	private Administrador admin;


			public void run() {
				try {
					this.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	public Admin_Gestao_Users(Administrador admin) {
		this.admin = admin;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGestaoDePerfil = new JButton("Gestao de Perfil");
		btnGestaoDePerfil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestaoDePerfil.setBounds(124, 113, 164, 56);
		contentPane.add(btnGestaoDePerfil);
		
		JButton btnGestaoDeUsers = new JButton("Gestao de Users");
		btnGestaoDeUsers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestaoDeUsers.setBounds(124, 224, 164, 56);
		contentPane.add(btnGestaoDeUsers);
		
		btnGestaoDePerfil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Admin_Gestao_Users_Perfil igup = new Admin_Gestao_Users_Perfil(admin);
				igup.run();
			}
		});
		
		btnGestaoDeUsers.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Admin_Gestao_Users_Others aguo= new Admin_Gestao_Users_Others(admin);
				aguo.run();
				
			}
		});
	}

}