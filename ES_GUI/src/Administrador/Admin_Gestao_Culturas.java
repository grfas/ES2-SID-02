package Administrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Admin_Gestao_Culturas extends JFrame {

	private JPanel contentPane;
	private Administrador admin;


			public void run() {
				try {
					this.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}



	public Admin_Gestao_Culturas(Administrador admin) {
		this.admin = admin;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGestaoInternaDas = new JButton("Gestao Interna das Culturas");
		btnGestaoInternaDas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestaoInternaDas.setBounds(141, 38, 201, 77);
		contentPane.add(btnGestaoInternaDas);
		
		JButton btnVariaveis = new JButton("Variaveis");
		btnVariaveis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVariaveis.setBounds(141, 167, 201, 77);
		contentPane.add(btnVariaveis);
		
		JButton btnMedicoes = new JButton("Medicoes");
		btnMedicoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMedicoes.setBounds(141, 291, 201, 77);
		contentPane.add(btnMedicoes);
		
		btnGestaoInternaDas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Admin_Gestao_Interna_Cultura agc = new Admin_Gestao_Interna_Cultura(admin);
				agc.run();
			}
		});
		
		btnVariaveis.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Admin_Gestao_Culturas_Variaveis agc = new Admin_Gestao_Culturas_Variaveis(admin);
				agc.run();
			}
		});
		
		btnMedicoes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Admin_Gestao_Culturas_Medicoes agc = new Admin_Gestao_Culturas_Medicoes(admin);
				agc.run();
			}
		});
		
	}

}
