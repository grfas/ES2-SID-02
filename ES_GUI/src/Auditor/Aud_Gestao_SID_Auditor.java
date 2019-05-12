package Auditor;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JList;

public class Aud_Gestao_SID_Auditor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aud_Gestao_SID_Auditor frame = new Aud_Gestao_SID_Auditor();
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
	public Aud_Gestao_SID_Auditor() {
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(42, 49, 183, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxPorData = new JCheckBox("Por Data ");
		chckbxPorData.setBounds(42, 90, 84, 23);
		contentPane.add(chckbxPorData);
		
		JCheckBox chckbxPorUsername = new JCheckBox("Por UserName");
		chckbxPorUsername.setBounds(128, 90, 97, 23);
		contentPane.add(chckbxPorUsername);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(267, 53, 122, 30);
		contentPane.add(btnPesquisar);
		
		JList list = new JList();
		list.setBounds(42, 149, 377, 263);
		contentPane.add(list);
		
		JLabel lblBaseDeDados = new JLabel("Base de Dados : SID 2");
		lblBaseDeDados.setBounds(42, 11, 146, 23);
		contentPane.add(lblBaseDeDados);
	
	}
}
