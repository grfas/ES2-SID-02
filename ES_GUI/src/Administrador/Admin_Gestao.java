package Administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;

public class Admin_Gestao extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Gestao frame = new Admin_Gestao();
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
	public Admin_Gestao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
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
	}
}
