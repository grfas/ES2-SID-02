package Administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class Admin_Gestao_Interna_Cultura extends JFrame {

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
					Admin_Gestao_Interna_Cultura frame = new Admin_Gestao_Interna_Cultura();
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
	public Admin_Gestao_Interna_Cultura() {
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdCultura = new JLabel("ID Cultura");
		lblIdCultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdCultura.setBounds(65, 37, 81, 14);
		contentPane.add(lblIdCultura);
		
		JLabel lblNome = new JLabel("Nome ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(75, 57, 46, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(155, 31, 157, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(155, 56, 157, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCriarCultura = new JButton("Criar Cultura");
		btnCriarCultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriarCultura.setBounds(347, 24, 115, 40);
		contentPane.add(btnCriarCultura);
		
		JList list = new JList();
		list.setBounds(49, 134, 365, 237);
		contentPane.add(list);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(329, 100, 89, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(49, 382, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.setBounds(325, 403, 89, 23);
		contentPane.add(btnApagar);
	}
}
