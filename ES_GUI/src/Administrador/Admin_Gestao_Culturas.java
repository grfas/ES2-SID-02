package Administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Admin_Gestao_Culturas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Gestao_Culturas frame = new Admin_Gestao_Culturas();
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
	public Admin_Gestao_Culturas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	}

}
