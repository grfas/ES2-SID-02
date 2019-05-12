package Investigador;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Color;

public class Inv_Gestao extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inv_Gestao frame = new Inv_Gestao();
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
	public Inv_Gestao() {
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
	}
}
