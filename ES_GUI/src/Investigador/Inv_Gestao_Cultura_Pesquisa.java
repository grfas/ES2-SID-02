package Investigador;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JButton;

public class Inv_Gestao_Cultura_Pesquisa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inv_Gestao_Cultura_Pesquisa frame = new Inv_Gestao_Cultura_Pesquisa();
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
	public Inv_Gestao_Cultura_Pesquisa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCultura = new JLabel("Cultura");
		lblCultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCultura.setBounds(77, 46, 46, 14);
		contentPane.add(lblCultura);
		
		JLabel lblnomecultura = new JLabel("_Nome_Cultura_");
		lblnomecultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnomecultura.setBounds(180, 42, 111, 23);
		contentPane.add(lblnomecultura);
		
		JLabel lblVariavel = new JLabel("Variavel");
		lblVariavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVariavel.setBounds(77, 93, 46, 14);
		contentPane.add(lblVariavel);
		
		JLabel lblnomevariavel = new JLabel("_Nome_Variavel_");
		lblnomevariavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnomevariavel.setBounds(180, 89, 111, 23);
		contentPane.add(lblnomevariavel);
		
		JList list = new JList();
		list.setBounds(62, 145, 375, 224);
		contentPane.add(list);
		
		JLabel lblMedicoes = new JLabel("Medicoes :");
		lblMedicoes.setBounds(62, 129, 61, 14);
		contentPane.add(lblMedicoes);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnApagar.setBounds(43, 380, 89, 23);
		contentPane.add(btnApagar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.setBounds(348, 427, 89, 23);
		contentPane.add(btnSair);
	}
}
