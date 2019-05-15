package Administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Admin_Gestao_Culturas_Variaveis extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private Administrador admin;


			public void run() {
				try {
					this.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	public Admin_Gestao_Culturas_Variaveis(Administrador admin) {
		this.admin = admin;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdVariavel = new JLabel("Id Variavel");
		lblIdVariavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdVariavel.setBounds(76, 42, 97, 23);
		contentPane.add(lblIdVariavel);
		
		textField = new JTextField();
		textField.setBounds(183, 45, 162, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNomeVariavel = new JLabel("Nome Variavel");
		lblNomeVariavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeVariavel.setBounds(76, 81, 97, 23);
		contentPane.add(lblNomeVariavel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 81, 162, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLimiteSuperior = new JLabel("Limite Superior");
		lblLimiteSuperior.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLimiteSuperior.setBounds(76, 115, 97, 23);
		contentPane.add(lblLimiteSuperior);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 115, 162, 23);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblLimiteInferior = new JLabel("Limite Inferior");
		lblLimiteInferior.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLimiteInferior.setBounds(76, 149, 97, 23);
		contentPane.add(lblLimiteInferior);
		
		textField_3 = new JTextField();
		textField_3.setBounds(183, 149, 162, 23);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(355, 43, 104, 25);
		contentPane.add(btnPesquisar);
		
		textField_4 = new JTextField();
		textField_4.setBounds(183, 183, 162, 23);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNomeCultura = new JLabel("Nome Cultura");
		lblNomeCultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeCultura.setBounds(76, 183, 84, 23);
		contentPane.add(lblNomeCultura);
		
		JButton btnCriarVariavel = new JButton("Criar Variavel");
		btnCriarVariavel.setBounds(194, 228, 112, 31);
		contentPane.add(btnCriarVariavel);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(34, 427, 89, 23);
		contentPane.add(btnGuardar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(44, 270, 396, 149);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.setBounds(256, 427, 89, 23);
		contentPane.add(btnApagar);
	}

}
