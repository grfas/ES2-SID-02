package Administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class Admin_Gestao_Culturas_Medicoes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Gestao_Culturas_Medicoes frame = new Admin_Gestao_Culturas_Medicoes();
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
	public Admin_Gestao_Culturas_Medicoes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCultura = new JLabel("Cultura");
		lblCultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCultura.setBounds(78, 45, 66, 25);
		contentPane.add(lblCultura);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(185, 45, 96, 29);
		contentPane.add(comboBox);
		
		JLabel lblVariavel = new JLabel("Variavel");
		lblVariavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVariavel.setBounds(78, 81, 66, 25);
		contentPane.add(lblVariavel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(185, 85, 96, 29);
		contentPane.add(comboBox_1);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(348, 59, 96, 31);
		contentPane.add(btnPesquisar);
		
		JLabel lblMedicao = new JLabel("Medicao");
		lblMedicao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedicao.setBounds(61, 222, 66, 25);
		contentPane.add(lblMedicao);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(61, 253, 160, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(299, 227, 46, 14);
		contentPane.add(lblData);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(299, 253, 160, 31);
		contentPane.add(textField_1);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInserir.setBounds(199, 312, 112, 31);
		contentPane.add(btnInserir);
		
		JLabel lblaammddHhmmss = new JLabel("(AA-MM-DD HH:MM:SS)");
		lblaammddHhmmss.setBounds(299, 287, 145, 14);
		contentPane.add(lblaammddHhmmss);
	}
}
