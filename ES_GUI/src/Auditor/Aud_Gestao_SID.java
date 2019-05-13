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
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class Aud_Gestao_SID extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Auditor aud;
	private DefaultListModel<String> listaLogs = new DefaultListModel<>();

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
	public Aud_Gestao_SID(Auditor aud) {
		this.aud = aud;
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

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(267, 53, 122, 30);
		contentPane.add(btnPesquisar);

		JList list = new JList<String>(listaLogs);
		list.setBounds(42, 149, 377, 263);
		ArrayList<Log> listaTemp = aud.servidor1();
		for (Log l : listaTemp) {
			String s = l.getData().toString() + "  " + l.getHora() + "  " + l.getUsername() + "  " + l.getOperacao()
					+ "  " + l.getMensagem();
			listaLogs.addElement(s);
		}
		contentPane.add(list);

		JLabel lblBaseDeDados = new JLabel("Base de Dados : SID");
		lblBaseDeDados.setBounds(42, 11, 140, 14);
		contentPane.add(lblBaseDeDados);
	}
}
