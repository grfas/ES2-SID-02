package Administrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

@SuppressWarnings("serial")
public class Admin_Gestao_Interna_Cultura_Criar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblResponsavel;
	private JTextField textField_2;
	private JButton btnCriar;
	private JButton btnGuardar;


			public void run() {
				try {
					this.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	public Admin_Gestao_Interna_Cultura_Criar(int i, String nome, String descricao, int responsavel, Administrador admin) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDaCultura = new JLabel("Nome da Cultura");
		lblNomeDaCultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDaCultura.setBounds(61, 44, 134, 24);
		contentPane.add(lblNomeDaCultura);
		
		textField = new JTextField();
		textField.setBounds(231, 44, 161, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(61, 85, 134, 24);
		contentPane.add(lblDescricao);
		
		textField_1 = new JTextField();
		textField_1.setBounds(231, 87, 161, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblResponsavel = new JLabel("Responsavel");
		lblResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResponsavel.setBounds(61, 125, 134, 24);
		contentPane.add(lblResponsavel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(231, 129, 161, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		btnCriar = new JButton("Criar");
		btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriar.setBounds(61, 221, 112, 38);
		contentPane.add(btnCriar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.setBounds(303, 264, 89, 23);
		contentPane.add(btnGuardar);
	}

}
