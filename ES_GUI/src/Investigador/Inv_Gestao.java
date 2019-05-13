package Investigador;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Auditor.Aud_Gestao_SID;

import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Color;

public class Inv_Gestao extends JFrame {

	private JPanel contentPane;
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
	public Inv_Gestao(Investigador inv) {
		this.inv = inv;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGestaoDePerfil = new JButton("Gestao de Perfil");
		btnGestaoDePerfil.setBounds(134, 46, 123, 57);
		contentPane.add(btnGestaoDePerfil);
		
		JButton btnGestaoDeCultura = new JButton("Gestao de Cultura");
		btnGestaoDeCultura.setBounds(134, 144, 123, 57);
		contentPane.add(btnGestaoDeCultura);
		
		btnGestaoDePerfil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Inv_Gestao_Perfil gestaoInv = new Inv_Gestao_Perfil();
				gestaoInv.run();

			}
		});
		
		btnGestaoDeCultura.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Inv_Gestao_Cultura gestaoInv = new Inv_Gestao_Cultura(inv);
				gestaoInv.run();

			}
		});

		
	}
}
