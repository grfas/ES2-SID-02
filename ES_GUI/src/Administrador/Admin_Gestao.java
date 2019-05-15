package Administrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

@SuppressWarnings("serial")
public class Admin_Gestao extends JFrame {

	private JPanel contentPane;
	private Administrador admin;
	
	public void run() {
		try {
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Admin_Gestao(Administrador admin) {
		this.setAdmin(admin);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnGestaoDeCulturas = new JButton("Gestao de Culturas");
		btnGestaoDeCulturas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestaoDeCulturas.setBounds(162, 110, 165, 83);
		contentPane.add(btnGestaoDeCulturas);

		JButton btnGestaoDeUtilizadores = new JButton("Gestao de Utilizadores");
		btnGestaoDeUtilizadores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestaoDeUtilizadores.setBounds(162, 270, 165, 83);
		contentPane.add(btnGestaoDeUtilizadores);
		
		btnGestaoDeCulturas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Admin_Gestao_Culturas agc = new Admin_Gestao_Culturas(admin);
				agc.run();
			}
		});
		
		btnGestaoDeUtilizadores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Admin_Gestao_Users agc = new Admin_Gestao_Users(admin);
				agc.run();
			}
		});
		
	}

	public Administrador getAdmin() {
		return admin;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}
}
